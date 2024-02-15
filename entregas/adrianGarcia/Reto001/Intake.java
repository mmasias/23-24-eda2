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

    public boolean removeFood(String foodName) {
        if (first == null) return false;
        if (first.getFood().getName().equals(foodName)) {
            first = first.getNext();
            return true;
        }
        FoodNode current = first;
        while (current.getNext() != null) {
            if (current.getNext().getFood().getName().equals(foodName)) {
                current.setNext(current.getNext().getNext());
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public boolean updateFood(String oldName, String newName) {
        FoodNode current = first;
        while (current != null) {
            if (current.getFood().getName().equals(oldName)) {
                current.getFood().setName(newName);
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void printFoodListing() {
        System.out.println(this.toString());
    }

    public void createIntake() {
        Scanner userInput = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("1. Agregar alimento\n2. Listar alimentos\n3. Eliminar alimento\n4. Modificar alimento\n5. Salir");
            String choice = userInput.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Nombre del alimento:");
                    String foodName = userInput.nextLine();
                    addFood(new Food(foodName));
                    break;
                case "2":
                    printFoodListing();
                    break;
                case "3":
                    System.out.println("Nombre del alimento a eliminar:");
                    String foodToDelete = userInput.nextLine();
                    if (removeFood(foodToDelete)) {
                        System.out.println("Alimento eliminado.");
                    } else {
                        System.out.println("Alimento no encontrado.");
                    }
                    break;
                case "4":
                    System.out.println("Nombre del alimento a modificar:");
                    String oldName = userInput.nextLine();
                    System.out.println("Nuevo nombre del alimento:");
                    String newName = userInput.nextLine();
                    if (updateFood(oldName, newName)) {
                        System.out.println("Alimento modificado.");
                    } else {
                        System.out.println("Alimento no encontrado.");
                    }
                    break;
                case "5":
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder foodListing = new StringBuilder();
        FoodNode current = first;
        while (current != null) {
            foodListing.append(current.getFood().toString()).append("\n");
            current = current.getNext();
        }
        return foodListing.toString();
    }

    public static void main(String[] args) {
        Intake intake = new Intake();
        intake.createIntake();
    }
}
