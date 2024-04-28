package entregas.mayenSergio.Reto_001;

import java.util.Scanner;

class Intake {
    private FoodNode first;

    public Intake() {
        first = null;
    }

    public void addFood(Food food) {
        FoodNode newFoodNode = new FoodNode(food);
        if (first == null) {
            first = newFoodNode;
        } else {
            FoodNode current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newFoodNode);
        }
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

    public void updateFood(String oldName, String newName) {
        FoodNode current = first;
        while (current != null) {
            if (current.getFood().getName().equals(oldName)) {
                current.getFood().setName(newName);
                System.out.println("Food updated successfully!");
                return;
            }
            current = current.getNext();
        }
        System.out.println("Food not found for update.");
    }

    public void deleteFood(String name) {
        FoodNode current = first;
        FoodNode previous = null;

        while (current != null) {
            if (current.getFood().getName().equals(name)) {
                if (previous == null) {
                    // If the found item is the first one, update 'first'
                    first = current.getNext();
                } else {
                    // Update the 'next' reference of the previous node
                    previous.setNext(current.getNext());
                }
                System.out.println("Food deleted successfully!");
                return;
            }
            previous = current;
            current = current.getNext();
        }
        System.out.println("Food not found for deletion.");
    }

    @Override
    public String toString() {
        String foodListing = "";
        FoodNode current = first;
        while (current != null) {
            foodListing = foodListing + current.getFood().toString() + "\n";
            current = current.getNext();
        }
        return foodListing;
    }

    public static void main(String[] args) {

        Intake breakfast = new Intake();
        breakfast.createIntake();
        breakfast.printFoodListing();

        Scanner userInput = new Scanner(System.in);
        System.out.println("Seleccione una opción:");
        System.out.println("1. Actualizar alimento");
        System.out.println("2. Eliminar alimento");
        int choice = userInput.nextInt();
        userInput.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                System.out.println("Ingrese el nombre del alimento que desea actualizar:");
                String oldName = userInput.nextLine();
                System.out.println("Ingrese el nuevo nombre del alimento:");
                String newName = userInput.nextLine();
                breakfast.updateFood(oldName, newName);
                break;
            case 2:
                System.out.println("Ingrese el nombre del alimento que desea eliminar:");
                String deleteName = userInput.nextLine();
                breakfast.deleteFood(deleteName);
                break;
            default:
                System.out.println("Opción no válida");
        }

        breakfast.printFoodListing();

    }
}