package perezPablo.reto002;
import java.util.Scanner;
import java.util.LinkedList;

class Intake {
    private String name;
    private LinkedList<Food> foodList;

    public Intake(String name) {
        this.name = name;
        foodList = new LinkedList<>();
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void addFood(Food food) {
        foodList.add(food);
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
                creating = !creating;
            } else {
                Food food = new Food(foodName);
                addFood(food);
            }
        }
    }

    public void editFood(String foodName) {
        Scanner userInput = new Scanner(System.in);
        for (Food food : foodList) {
            if (food.getName().equals(foodName)) {
                System.out.println("Nuevo nombre de [" + foodName + "]");
                String newFoodName = userInput.nextLine();
                food.setName(newFoodName);
                return;
            }
        }
        System.out.println("Alimento no encontrado.");
    }

    public void editIntake() {
        boolean editing = true;
        Scanner userInput = new Scanner(System.in);
        while (editing) {
            System.out.println("Ingrese el nombre del alimento a editar (-1 para terminar):");
            String food = userInput.nextLine();
            if (food.equals("-1")) {
                editing = !editing;
            } else {
                editFood(food);
            }
        }
    }

    public void deleteAll() {
        foodList.clear();
    }

    public void deleteFood(String food) {
        boolean removed = foodList.removeIf(f -> f.getName().equals(food));
        if (!removed) {
            System.out.println("Alimento no encontrado.");
        }
    }

    public void deleteIntake() {
        Scanner userInput = new Scanner(System.in);
        boolean deleting = true;
        while (deleting) {
            System.out.println("Nombre del alimento por eliminar (-1 para terminar)");
            String food = userInput.nextLine();
            if (food.equals("-1")) {
                deleting = !deleting;
            } else {
                deleteFood(food);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder foodListing = new StringBuilder("]> " + name + "\n");
        for (Food food : foodList) {
            foodListing.append(food.toString()).append("\n");
        }
        return foodListing.toString();
    }

    public static void main(String[] args) {

        Intake lunch = new Intake("Comida");
        lunch.createIntake();
        System.out.println("Ingesta creada");
        lunch.printFoodListing();
        Food rice = new Food("Arroz");
        Food egg = new Food("Huevo");
        lunch.addFood(rice);
        lunch.addFood(egg);
        System.out.println("Alimentos añadidos");
        lunch.printFoodListing();
        lunch.editFood("Arroz");
        System.out.println("Alimento editado");
        lunch.printFoodListing();
        lunch.editIntake();
        lunch.printFoodListing();
        lunch.deleteFood("Huevo");
        System.out.println("Huevo eliminado");
        lunch.printFoodListing();
        lunch.deleteAll();
        System.out.println("Ingesta eliminada");
        lunch.printFoodListing();

    }
}