
import java.util.ArrayList;
import java.util.Scanner;

class Intake {
    private ArrayList<Food> foodList;
    private String name;

    public Intake() {
        foodList = new ArrayList<>();
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                creating = false;
            } else {
                Food food = new Food(foodName);
                addFood(food);
            }
        }
    }

    public void updateFood(String oldName, String newName) {
        for (Food food : foodList) {
            if (food.getName().equals(oldName)) {
                food.setName(newName);
                System.out.println("Alimento actualizado exitosamente.");
                return;
            }
        }
        System.out.println("No se encontró el alimento con el nombre proporcionado.");
    }

    public void deleteFood(String name) {
        for (Food food : foodList) {
            if (food.getName().equals(name)) {
                foodList.remove(food);
                System.out.println("Alimento eliminado exitosamente.");
                return;
            }
        }
        System.out.println("No se encontró el alimento con el nombre proporcionado.");
    }

    @Override
    public String toString() {
        StringBuilder foodListing = new StringBuilder();
        for (Food food : foodList) {
            foodListing.append(food.toString()).append("\n");
        }
        return foodListing.toString();
    }

    public static void main(String[] args) {
        Intake breakfast = new Intake();
        breakfast.createIntake();
        breakfast.printFoodListing();

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n¿Desea actualizar o eliminar algún alimento? (A/E/N)");
        String option = scanner.nextLine().toUpperCase();

        switch (option) {
            case "A":
                System.out.println("Ingrese el nombre del alimento que desea actualizar: ");
                String oldName = scanner.nextLine();
                System.out.println("Ingrese el nuevo nombre del alimento: ");
                String newName = scanner.nextLine();
                breakfast.updateFood(oldName, newName);
                breakfast.printFoodListing();
                break;
            case "E":
                System.out.println("Ingrese el nombre del alimento que desea eliminar: ");
                String nameToDelete = scanner.nextLine();
                breakfast.deleteFood(nameToDelete);
                breakfast.printFoodListing();
                break;
            default:
                System.out.println("Operación no reconocida.");
                break;
        }

        scanner.close();
    }
}
