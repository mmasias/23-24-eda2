import java.util.Scanner;

class Intake {
    private FoodNode first;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public static void main(String[] args) {

        Intake breakfast = new Intake();
        breakfast.createIntake();
        breakfast.printFoodListing();
        breakfast.deleteIntake();
        breakfast.printFoodListing();
        breakfast.updatefood();
        breakfast.printFoodListing();


    }

    public void deleteIntake() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del alimento que quieres eliminar");
        String foodName = userInput.nextLine();
        FoodNode current = first;
        FoodNode previous = null;
        while (current != null) {
            if (current.getFood().getName().equalsIgnoreCase(foodName)) {
                if (current == first) {
                    first = current.getNext();
                    break;
                } else {
                    previous = current.getNext();
                }

            }
            previous = current;
            current = current.getNext();
        }

    }

    public void updatefood() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del alimento que quieres actualizar");
        String foodName = userInput.nextLine();
        System.out.println("Nombre del nuevo alimento");
        String newfoodName = userInput.nextLine();
        FoodNode current = first;
        while (current != null) {
            if (current.getFood().getName().equalsIgnoreCase(foodName)) {
                current.getFood().setName(newfoodName);
            }
            current = current.getNext();
        }

    }
}