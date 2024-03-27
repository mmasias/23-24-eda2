import java.util.Scanner;

class Intake {
    private FoodNode first;
    private String name;

    public Intake(String name) {
        first = null;
        name = name;
    }
    

    public FoodNode getFirst() {
        return first;
    }


    public void setFirst(FoodNode first) {
        this.first = first;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
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
    public void deleteFood(String foodName) {
        FoodNode current = first;
        FoodNode previous = null;
        while (current != null && !current.getFood().getName().equals(foodName)) {
            previous = current;
            current = current.getNext();
        }
        if (current != null) {
            if (previous == null) {
                first = current.getNext();
            } else {
                previous.setNext(current.getNext());
            }
        }
    }
    public void editFood(String foodName) {
        deleteFood(foodName);
        System.out.println("Nuevo nombre del alimento");
        Scanner userInput = new Scanner(System.in);
        String newFoodName = userInput.nextLine();
        Food food = new Food(newFoodName);
        addFood(food);
    }

    public void printIntakeListing() {
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
    public void editIntake() {
        boolean editing = true;
        Scanner userInput = new Scanner(System.in);
        while (editing) {
            System.out.println("Nombre del alimento a editar (-1 para terminar)");
            String foodName = userInput.nextLine();
            if (foodName.equals("-1")) {
                editing = !editing;
            } else {
                editFood(foodName);
            }
        }
    }
    public void deleteIntake() {
        boolean deleting = true;
        Scanner userInput = new Scanner(System.in);
        while (deleting) {
            System.out.println("Nombre del alimento a eliminar (-1 para terminar)");
            String foodName = userInput.nextLine();
            if (foodName.equals("-1")) {
                deleting = !deleting;
            } else {
                deleteFood(foodName);
            }
        }
    }

    @Override
    public String toString() {
        String foodListing = "" + name + "\n";
        FoodNode current = first;
        while (current != null) {
            foodListing = foodListing + current.getFood().toString() + "\n";
            current = current.getNext();
        }
        return foodListing;
    }

    public static void main(String[] args) {

        Intake breakfast = new Intake("Desayuno");
        breakfast.createIntake();
        breakfast.printIntakeListing();
        System.out.println();
        breakfast.editIntake();
        breakfast.printIntakeListing();
        System.out.println();
        breakfast.deleteIntake();
        breakfast.printIntakeListing();

    }
}