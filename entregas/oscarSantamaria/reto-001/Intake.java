package reto001;
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

    public void removeIntake(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del alimento a eliminar, 0 para cancelar");
        String foodName = userInput.nextLine();
        FoodNode current = first;
        FoodNode previous = null;

        if(foodName.equals("0")){
            return;
        }
        
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

    public void continueAdding() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("¿Desea continuar agregando alimentos? (S/N)");
        String input = userInput.nextLine();
        if (!input.equalsIgnoreCase("S")) {
            printFoodListing();
        } else {
            createIntake();
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

        Intake breakfast = new Intake();
        breakfast.createIntake();
        breakfast.printFoodListing();
        breakfast.removeIntake();
        breakfast.printFoodListing();
        breakfast.continueAdding();
        breakfast.printFoodListing();
    }
 
}

// crud create, read, update, delete