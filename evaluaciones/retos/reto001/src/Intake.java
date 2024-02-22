import java.util.Scanner;

class Intake {
    
     private FoodNode first;
     private String name;

    public Intake(String name) {
        first = null;
        this.name = name;
    }

    public String getIntakeName() {
        return name;
    }

    public void setIntakeName(String name) {
        this.name = name;
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
            System.out.println("Nombre del alimento por crear (-1 para terminar)");
            String foodName = userInput.nextLine();
            if (foodName.equals("-1")) {
                creating = !creating;
            } else {
                Food food = new Food(foodName);
                addFood(food);
            }
        }
    }

    private void deleteFood(String foodName) {

        if (first.getFood().getName().equals(foodName)) {
            first = first.getNext();
        } else {
            FoodNode current = first;
        
            while (current.getNext() != null) {
                current = current.getNext();
            }
        }
        
    }

    public void deleteIntake() {
        boolean deleting = true;
        Scanner userInput = new Scanner(System.in);

        while (deleting) {
            System.out.println("Nombre del alimento por eliminar (-1 para terminar)");
            String foodName = userInput.nextLine();

            if (foodName.equals("-1")) {
                deleting = !deleting;
            } else {
                deleteFood(foodName);
            }
        }
    }
  

    private void deleteAllIntake() {
        first = null;
    }

    private void updateFood(String oldFoodName, String newFoodName) {
        FoodNode current = first;

        while (current != null) {
            if (current.getFood().getName().equals(oldFoodName)) {
                current.getFood().setName(newFoodName);
            }

            current = current.getNext();
        }
    }

    public void updateIntake() {
        boolean updating = true;
        Scanner userInput = new Scanner(System.in);
        while(updating) {
            System.out.println("Nombre del alimento a editar (-1 para terminar): ");
            String oldName = userInput.nextLine();

            if (oldName.equals("-1")) {
                updating = !updating;
            } else {
                System.out.println("Nuevo nombre del alimento:" );
                String newName = userInput.nextLine();
                updateFood(oldName, newName);
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
        Scanner userInput = new Scanner(System.in);

        System.out.println("Introduce el nombre del intake: ");
        String intakeName = userInput.nextLine();
        Intake breakfast = new Intake(intakeName);

        breakfast.createIntake();
        breakfast.printFoodListing();

        breakfast.updateIntake();
        breakfast.printFoodListing();

        breakfast.deleteIntake();
        breakfast.printFoodListing();

        breakfast.deleteAllIntake();
        breakfast.printFoodListing();
    }
}
