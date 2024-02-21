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
        System.out.println("+---------------------------+");
        System.out.println("| Se ha eliminado la comida |");
        System.out.println("+---------------------------+");
    }

    public void printFoodListing() {
        System.out.println(this.toString());
    }

    public void createIntake() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("+-----------------------------------------+");
            System.out.println("| Nombre del alimento (-1 para terminar): |");
            System.out.println("+-----------------------------------------+");
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
        System.out.println("+-----------------------------------------+");
        System.out.println("| Ingrese el alimento que desea eliminar: |");
        System.out.println("+-----------------------------------------+");
        String foodNameDelete = new Scanner(System.in).nextLine();
        System.out.println("+-----------------------------------------+");
        System.out.println("| Se ha eliminado " + foodNameDelete + " correctamente |" + "\n");
        System.out.println("+-----------------------------------------+");
        deleteFood(foodNameDelete);
    }
    public void editIntake(){
        System.out.println("+---------------------------------------+");
        System.out.println("| Ingrese el alimento que desea editar: |");
        System.out.println("+---------------------------------------+");
        String foodNameEdit = new Scanner(System.in).nextLine();
        System.out.println("+--------------------------------------------------+");
        System.out.println("| Se ha editado la comida: " + foodNameEdit + " |"+ "\n");
        System.out.println("+--------------------------------------------------+");
        deleteFood(foodNameEdit);

        System.out.println("+---------------------------------------+");
        System.out.println("| Ingrese el nombre del nuevo alimento: |");
        System.out.println("+---------------------------------------+");
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