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
    public void deleteFood(String foodName){
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
        System.out.println("Comida eliminada");
    }

    public void printFoodListing() {
        System.out.println(this.toString());
    }

    public void createIntake() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("Nombre del alimento (-1 para terminar): ");
            String foodName = userInput.nextLine();
            if (foodName.equals("-1")) {
                creating = !creating;
            } else {
                Food food = new Food(foodName);
                addFood(food);
            }
        }
    }

    public void deleteIntake(){
        System.out.println("Nombre del alimento a eliminar: ");
        String foodNameDelete = new Scanner(System.in).nextLine();
        System.out.print("Eliminando esta comida: " + foodNameDelete + "\n");
        deleteFood(foodNameDelete);
    }
    public void editIntake(){
        System.out.println("Nombre del alimento a editar: ");
        String foodNameEdit = new Scanner(System.in).nextLine();
        System.out.print("Editando esta comida: " + foodNameEdit + "\n");
        deleteFood(foodNameEdit);

        System.out.println("Nombre del alimento nuevo: ");
        String foodNameNew = new Scanner(System.in).nextLine();
        Food food = new Food(foodNameNew);
        addFood(food);
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
        breakfast.editIntake();
        breakfast.deleteIntake();
        breakfast.printFoodListing();

    }
}