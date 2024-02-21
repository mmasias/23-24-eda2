package v01;
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

    public void createIntake(Scanner userInput) {
        boolean creating = true;
        userInput.nextLine();
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

    public void deleteFood(String foodName) {
        FoodNode current = first;
        FoodNode previous = null;
        while (current != null) {
            if (current.getFood().getName().equals(foodName)) {
                if (previous == null) {
                    first = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                return;
            }
            previous = current;
            current = current.getNext();
        }
    }

    public void deleteAll(){
        first = null;
        System.out.println("Has borrado todos los alimentos\n");
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
        boolean running = true;
        Scanner input = new Scanner(System.in);
        while (running) {
            int option = askOption(input); 
            switch (option) {
                case 1:
                    breakfast.createIntake(input);
                    break;
                case 2:
                    breakfast.printFoodListing();
                    break;
                case 3:
                    
                    break;
                case 4: 
                    breakfast.deleteAll();
                    break;
                case 5:
                    running = !running;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
        input.close();
    }

    public static int askOption(Scanner userInput) {
        System.out.println("Desayuno");
        System.out.println("1. Crear ingesta");
        System.out.println("2. Listar alimentos");
        System.out.println("3. Borrar un alimento");
        System.out.println("4. Borrar todos");
        System.out.println("5. Salir");
        while (true) {
            if (userInput.hasNextInt()) {
                int option = userInput.nextInt();
                System.out.println();
                return option;
            } else {
                System.out.println("Por favor ingrese un número válido.");
                userInput.next(); // Limpiar el buffer de entrada
            }
        }
    }
}