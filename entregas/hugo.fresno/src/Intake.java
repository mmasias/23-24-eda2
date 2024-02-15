import java.sql.SQLOutput;
import java.util.Scanner;

class Intake {
    private FoodNode first;
    Scanner text = new Scanner(System.in);

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

    private void deleteAllIntake() {
        first = null;
        System.out.println("\nTodos los alimentos han sido eliminados con exito!");
    }


    private void deleteIntake() {
        if (first == null){
            System.out.println("No hay ninguna alimento");

        }else {

            System.out.println("\n**METODO DELETE**");
            System.out.println("Que alimento deseas eliminar?");
            String foodToDelete = text.nextLine();

            if (first.getFood().getName().equals(foodToDelete)) {
                first = first.getNext();

            } else {

                FoodNode current = first;
                while (current.getNext() != null) {
                    if (current.getNext().getFood().getName().equals(foodToDelete)) {
                        current.setNext(current.getNext().getNext());
                        break;
                    }
                    current = current.getNext();
                }
            }

        }

    }


    private void editIntake() {


        if (first == null){
            System.out.println("No hay ninguna alimento");

        }else {

            System.out.println("\n**METODO EDIT**");
            System.out.println("Que alimento deseas eliminar?");
            String foodToDelete = text.nextLine();
            System.out.println("Que alimento deseas añadir a cambio?");
            String foodInChange = text.nextLine();

            if (first.getFood().getName().equals(foodToDelete)) {
                first.getFood().setName(foodInChange);

            }else {

                FoodNode current = first;
                while (current!=null){
                    if (current.getNext().getFood().getName().equals(foodToDelete)){
                        current.getFood().setName(foodInChange);
                        break;
                    }
                    current=current.getNext();

                }

            }
        }
    }

    public static void main(String[] args) {

        Intake breakfast = new Intake();
        breakfast.createIntake();
        breakfast.editIntake();
        breakfast.deleteIntake();
        breakfast.printFoodListing();
        breakfast.deleteAllIntake();
        breakfast.printFoodListing();

    }


}
