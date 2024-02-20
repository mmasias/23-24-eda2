package vEDA.v001;

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
            System.out.println("Food Name (quit with -1)");
            String foodName = userInput.nextLine();
            if (foodName.equals("-1")) {
                creating = !creating;
            } else {
                Food food = new Food(foodName);
                addFood(food);
            }
        }
    }

    public void deleteIntake() {
        Scanner s = new Scanner(System.in);
        System.out.println("Food to remove:");
        String foodToRemove = s.nextLine();
        FoodNode current = first;
        FoodNode previous = null;
        while (current != null) {
            if (current.getFood().getName().equals(foodToRemove)) {
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


    public void updateFood() {
        Scanner s = new Scanner(System.in);
        System.out.println("Food to update:");
        String foodToUpdate = s.nextLine();
        FoodNode current = first;
        while (current != null) {
            if (current.getFood().getName().equals(foodToUpdate)) {
                System.out.println("New Food Name:");
                String newFoodName = s.nextLine();
                current.getFood().setName(newFoodName);
                return;
            }
            current = current.getNext();
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

    public void optionMenu() {
        Scanner s = new Scanner(System.in);
        int option;

        do {
            System.out.println("1. Create Food");
            System.out.println("2. Read Food List");
            System.out.println("3. Update Food");
            System.out.println("4. Delete Food");
            System.out.println("5. Exit");
            System.out.println("Enter a number between (1-5): ");
            option = s.nextInt();
            switch (option) {
                case 1:

                    createIntake();
                    break;

                case 2:

                    printFoodListing();
                    break;
                    
                case 3:
                    updateFood();
                    break;

                case 4:
                    deleteIntake();
                    break;

                case 5:

                    System.out.println("Saliendo...");
                    break;

                default:
                    System.out.println("ERROR NON VALID OPTION");
            }
        } while (option != 5);
    }
    public static void main(String[] args) {

        Intake intake = new Intake();
        intake.optionMenu();
    }
}
