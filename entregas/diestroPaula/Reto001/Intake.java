package entregas.diestroPaula.Reto001;

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

    public void editIntake() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Ingrese el nombre del alimento que desea editar:");
        String foodName = userInput.nextLine();
        FoodNode current = first;
        while (current != null) {
            if (current.getFood().getName().equalsIgnoreCase(foodName)) {
                System.out.println("Ingrese el nuevo nombre del alimento:");
                String newFoodName = userInput.nextLine();
                current.getFood().setName(newFoodName);
                System.out.println("Alimento editado con éxito.");
                return;
            }
            current = current.getNext();
        }
        System.out.println("El alimento no se encontró en la lista.");
    }

    public void deleteIntake() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Ingrese el nombre del alimento que desea eliminar:");
        String foodName = userInput.nextLine();
        if (first != null && first.getFood().getName().equalsIgnoreCase(foodName)) {
            first = first.getNext();
            System.out.println("Alimento eliminado con éxito.");
            return;
        }
        FoodNode current = first;
        while (current != null && current.getNext() != null) {
            if (current.getNext().getFood().getName().equalsIgnoreCase(foodName)) {
                current.setNext(current.getNext().getNext());
                System.out.println("Alimento eliminado con éxito.");
                return;
            }
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

    public void deleteAllIntake() {
        first = null;
        System.out.println("Todos los alimentos han sido eliminados.");
    }

    public static void main(String[] args) {

        Intake breakfast = new Intake();
        breakfast.createIntake();
        Scanner userInput = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("-----------------------------------");
            System.out.println("¿Qué desea hacer ahora?");
            System.out.println("1 para editar un alimento");
            System.out.println("2 para eliminar un alimento");
            System.out.println("3 para eliminar todos los alimentos");
            System.out.println("4 para listar los alimentos");
            System.out.println("0 para salir");
            System.out.println("-----------------------------------");

            int option = userInput.nextInt();
            switch (option) {
                case 1:
                    breakfast.editIntake();
                    System.out.println("¿Desea realizar otra acción? (s/n)");
                    userInput.nextLine();
                    if (userInput.nextLine().equalsIgnoreCase("n")) {
                        running = false;
                    }
                    break;
                case 2:
                    breakfast.deleteIntake();
                    System.out.println("¿Desea realizar otra acción? (s/n)");
                    userInput.nextLine();
                    if (userInput.nextLine().equalsIgnoreCase("n")) {
                        running = false;
                    }
                    break;
                case 3:
                    breakfast.deleteAllIntake();
                    System.out.println("¿Desea realizar otra acción? (s/n)");
                    userInput.nextLine();
                    if (userInput.nextLine().equalsIgnoreCase("n")) {
                        running = false;
                    }
                    break;
                case 4:
                    breakfast.printFoodListing();
                    System.out.println("¿Desea realizar otra acción? (s/n)");
                    userInput.nextLine();
                    if (userInput.nextLine().equalsIgnoreCase("n")) {
                        running = false;
                    }
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }
}