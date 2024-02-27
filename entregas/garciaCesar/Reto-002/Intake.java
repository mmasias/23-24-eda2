import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Intake {
    private List<Food> foods;
    private String name;

    public Intake(String name) {
        this.name = name;
        foods = new ArrayList<>();
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public void printFoodListing() {
        System.out.println(this.toString());
    }

    public void createIntake() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("Nombre del alimento (-1 para terminar)");
            String foodName = userInput.nextLine();
            if (foodName.equals("-1")) {
                creating = false;
            } else {
                Food food = new Food(foodName);
                addFood(food);
            }
        }
    }
    
    public void deleteIntake() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del alimento que quieres eliminar");
        String foodNameToRemove = userInput.nextLine();
        foods.removeIf(food -> food.getName().equals(foodNameToRemove));
    }

    public void updateIntake() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del alimento que quieres modificar");
        String foodNameToUpdate = userInput.nextLine();
        for (Food food : foods) {
            if (food.getName().equals(foodNameToUpdate)) {
                System.out.println("Nuevo nombre del alimento");
                String newFoodName = userInput.nextLine();
                food.setName(newFoodName);
                return;
            }
        }
        System.out.println("No se encontró el alimento para modificar.");
    }

    public void menu() {
        Scanner userInput = new Scanner(System.in);
        boolean running = true;
        System.out.println(">>>BIENVENIDO AL MENU<<< \n");
        while (running) {
            System.out.println("1. Agregar alimento");
            System.out.println("2. Eliminar alimento");
            System.out.println("3. Modificar alimento");
            System.out.println("4. Mostrar alimentos");
            System.out.println("5. Salir");
            int option = userInput.nextInt();
            switch (option) {
                case 1:
                    createIntake();
                    break;
                case 2:
                    deleteIntake();
                    break;
                case 3:
                    updateIntake();
                    break;
                case 4:
                    printFoodListing();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder foodListing = new StringBuilder();
        for (Food food : foods) {
            foodListing.append(food.toString()).append("\n");
        }
        return "Ingesta: " + name + "\n" + foodListing.toString();
    }

    public static void main(String[] args) {
        Intake breakfast = new Intake("Desayuno");
        breakfast.menu();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}