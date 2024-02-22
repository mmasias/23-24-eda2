import java.util.Scanner;

class Intake {
    private FoodNode first;
    private String name;

    public Intake(String name) {
        this.name = name;
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
    
    public void deleteIntake() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del alimento que quieres eliminar");
        String foodNameToRemove = userInput.nextLine();
        FoodNode current = first;
        FoodNode previous = null;
        while (current != null) {
            if (current.getFood().getName().equals(foodNameToRemove)) {
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

    public void updateIntake() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del alimento que quieres modificar");
        String foodNameToUpdate = userInput.nextLine();
        FoodNode current = first;
        while (current != null) {
            if (current.getFood().getName().equals(foodNameToUpdate)) {
                System.out.println("Nuevo nombre del alimento");
                String newFoodName = userInput.nextLine();
                current.getFood().setName(newFoodName);
                return;
            }
            current = current.getNext();
        }
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
                    running = !running;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
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
        Intake breakfast = new Intake( "Desayuno");
        breakfast.menu();
    }
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}