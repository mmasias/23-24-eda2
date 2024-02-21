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
        System.out.println("+--------------------------+");
        System.out.println("| Creación de una Ingesta: |");
        System.out.println("+--------------------------+");
        while (creating) {
            System.out.println("+----------------------------------------+");
            System.out.println("| Nombre del alimento (-1 para terminar) |");
            System.out.println("+----------------------------------------+");
            String foodName = userInput.nextLine();
            if (foodName.equals("-1")) {
                creating = !creating;
            } else {
                Food food = new Food(foodName);
                addFood(food);
            }
        }
    }

    public void modifyIntake() {
        boolean modifying = true;
        Scanner userInput = new Scanner(System.in);
        System.out.println("+--------------------------------+");
        System.out.println("| Modificacion de alimentos      |");
        System.out.println("+--------------------------------+");
        while (modifying) {
            System.out.println("+--------------------------------+");
            System.out.println("| Alimento a modificar: " + " |");
            System.out.println("+--------------------------------+");
            String newFoodName = userInput.nextLine();
            if (newFoodName.equals("-1")) {
                modifying = !modifying;
            } else {
                Food food = new Food(newFoodName);
                addFood(food);
            }
        }
        printFoodListing();
    }

    public void deleteIntake() {
        System.out.println("Eliminar alimentos...");
        printFoodListing();
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
        breakfast.modifyIntake();
        breakfast.deleteIntake();

    }
}