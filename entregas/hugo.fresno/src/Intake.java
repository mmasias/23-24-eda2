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
    }


    private void deleteIntake(String foodName) {
        if (first == null){
            System.out.println("No hay ninguna alimento");

        }else {

            if (first.getFood().getName().equals(foodName)) {
                System.out.println(first.getFood().getName()+" ha sido eliminado");
                first = first.getNext();

            } else {

                FoodNode current = first;
                while (current.getNext() != null) {
                    if (current.getNext().getFood().getName().equals(foodName)) {
                        System.out.println(current.getNext().getFood().getName()+" ha sido eliminado");
                        current.setNext(current.getNext().getNext());
                        break;
                    }
                    current = current.getNext();
                }
            }

        }

    }


    private void editIntake() {

    }

    public static void main(String[] args) {

        Intake breakfast = new Intake();
        breakfast.createIntake();
        breakfast.editIntake();
        breakfast.deleteIntake("cafe");
        breakfast.deleteAllIntake();
        breakfast.printFoodListing();

    }


}
