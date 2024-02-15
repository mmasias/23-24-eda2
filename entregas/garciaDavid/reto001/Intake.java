package entregas.garciaDavid.reto001;

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
                System.out.println("El alimento se actualizó correctamente.");
                return;
            }
            current = current.getNext();
        }
        System.out.println("El alimento no se encontró en la lista.");
    }

    public void removeFood(String name) {
        FoodNode prev = null;
        FoodNode current = first;
        while (current != null) {
            if (current.getFood().getName().equals(name)) {
                if (prev == null) {
                    first = current.getNext();
                } else {
                    prev.setNext(current.getNext());
                }
                System.out.println("El alimento se eliminó correctamente.");
                return;
            }
            prev = current;
            current = current.getNext();
        }
        System.out.println("El alimento no se encontró en la lista.");
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

    private void menu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\nMenu:");
            System.out.println("1. Crear lista de alimentos");
            System.out.println("2. Mostrar lista de alimentos");
            System.out.println("3. Actualizar alimento");
            System.out.println("4. Eliminar alimento");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    createIntake();
                    break;
                case 2:
                    printFoodListing();
                    break;
                case 3:
                    scanner.nextLine();
                    System.out.println("Ingrese el nombre del alimento a actualizar:");
                    String oldName = scanner.nextLine();
                    System.out.println("Ingrese el nuevo nombre del alimento:");
                    String newName = scanner.nextLine();
                    updateFood(oldName, newName);
                    break;
                case 4:
                    scanner.nextLine();
                    System.out.println("Ingrese el nombre del alimento a eliminar:");
                    String removeName = scanner.nextLine();
                    removeFood(removeName);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        } while (choice != 5);
        
        scanner.close();
    }

    public static void main(String[] args) {
        Intake breakfast = new Intake();
        breakfast.menu();
    }
}
