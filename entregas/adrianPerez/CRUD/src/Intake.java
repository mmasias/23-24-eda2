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

    public void editIntake(String oldFoodName, String newFoodName) {
        FoodNode current = first;
        while (current != null) {
            if (current.getFood().getName().equals(oldFoodName)) {
                current.getFood().setName(newFoodName);
                System.out.println("Food updated successfully.");
                return;
            }
            current = current.getNext();
        }
        System.out.println("Food not found.");
    }

    public void deleteIntake(String foodName) {
        FoodNode current = first;
        FoodNode previous = null;
        while (current != null) {
            if (current.getFood().getName().equals(foodName)) {
                if (previous == null) {
                    first = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                System.out.println("Food deleted successfully.");
                return;
            }
            previous = current;
            current = current.getNext();
        }
        System.out.println("Food not found.");
    }

    public void deleteAllIntake() {
        first = null;
        System.out.println("All foods have been deleted.");
    }

    public void printFoodListing() {
        System.out.println(this.toString());
    }

    public void createIntake() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("Nombre del alimento (-1 para terminar):");
            String foodName = userInput.nextLine();
            if (foodName.equals("-1")) {
                creating = false;
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
            foodListing += current.getFood().toString() + "\n";
            current = current.getNext();
        }
        return foodListing.isEmpty() ? "No food added yet." : foodListing;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Intake intake = new Intake();
        boolean running = true;

        while (running) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add Food");
            System.out.println("2. Edit Food");
            System.out.println("3. Delete Food");
            System.out.println("4. Delete All Foods");
            System.out.println("5. Print Food Listing");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter the name of the food to add:");
                    String foodNameToAdd = scanner.nextLine();
                    Food food = new Food(foodNameToAdd);
                    intake.addFood(food);
                    System.out.println(foodNameToAdd + " added.");
                    break;
                case 2:
                    System.out.println("Enter the name of the food to edit:");
                    String oldFoodName = scanner.nextLine();
                    System.out.println("Enter the new name of the food:");
                    String newFoodName = scanner.nextLine();
                    intake.editIntake(oldFoodName, newFoodName);
                    break;
                case 3:
                    System.out.println("Enter the name of the food to delete:");
                    String foodNameToDelete = scanner.nextLine();
                    intake.deleteIntake(foodNameToDelete);
                    break;
                case 4:
                    intake.deleteAllIntake();
                    System.out.println("All foods have been deleted.");
                    break;
                case 5:
                    intake.printFoodListing();
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}