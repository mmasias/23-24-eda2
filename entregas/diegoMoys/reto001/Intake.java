import java.util.Scanner;

public class Intake {
    private FoodNode first;

    public Intake() {
        first = null;
    }

    public void printFoodListing() {
        System.out.println(this.toString());
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

    public FoodNode findFood(String foodName) {
        FoodNode current = first;
        while (current != null) {
            if (current.getFood().getName().equals(foodName)) {
                return current;
            }
            current = current.getNext();
        }
        System.out.println("El alimento no existe");
        return null;
    }
    
    public void editFood(FoodNode foodNode, String newFoodName) {
        if (foodNode == null) {
            return;
        }
        foodNode.getFood().setName(newFoodName);
    }
    
    public void editIntake() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Ingrese el alimento a editar(-1 para terminar)");
        String foodToEdit = userInput.nextLine();
        FoodNode foodNode = findFood(foodToEdit);
        if(foodToEdit.equals("-1")){
            return;
        } else if (foodNode == null) {
            return;
        }
        System.out.println("Ingrese el nuevo nombre del alimento");
        String newFoodName = userInput.nextLine();
        editFood(foodNode, newFoodName);
    }

    public void deleteFood(FoodNode foodNode) {
        if (foodNode == null) {
            return;
        }
        if (foodNode == first) {
            first = first.getNext();
        } else {
            FoodNode current = first;
            while (current.getNext() != foodNode) {
                current = current.getNext();
            }
            current.setNext(foodNode.getNext());
        }
    }
    
    public void deleteIntake() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Ingrese el alimento a eliminar(-1 para terminar)");
        String foodToDelete = userInput.nextLine();
        if(foodToDelete.equals("-1")){
            return;
        }
        FoodNode foodNode = findFood(foodToDelete);
        deleteFood(foodNode);
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
        Intake newIntake = new Intake();
        newIntake.createIntake();
        newIntake.printFoodListing();
        newIntake.editIntake();
        newIntake.printFoodListing();
        newIntake.deleteIntake();
        newIntake.printFoodListing();
    }
}
