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

    public void updateFood(Food food) {
        FoodNode current = first;
        int count = 0;
        int index = 0;

        while (current != null && count < index) {
            current = current.getNext();
            count++;
        }

        if (current != null) {
            Food newName = food;
            current.setFood(newName);

        }

    }

    public void deleteFood(Food food) {
        FoodNode current = first;
        FoodNode prev = null;
        FoodNode last = new FoodNode(food);
        int count = 0;
        int index = 0;

        while (current != null && count < index) {
            current = current.getNext();
            count++;

        }

        if (current != null) {
            if (current == first) {

                first = first.getNext();

            } else if (current == last) {

                prev.getNext();
                last = prev;

            } else {
                FoodNode fl = prev.getNext();
                fl = current.getNext();
            }

            prev = current;
            current = current.getNext();

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
                updateIntake();
            } else {
                Food food = new Food(foodName);
                addFood(food);
            }

        }
    }

    public void updateIntake() {
        boolean updating = true;
        Scanner userInput = new Scanner(System.in);

        while (updating) {

            System.out.println("Introduzca nuevo alimento (-2 para salir)");
            String foodName = userInput.nextLine();
            if (foodName.equals("-2")) {

                updating = !updating;
                deleteIntake();
            } else {
                Food food = new Food(foodName);
                updateFood(food);
            }
        }

    }

    public void deleteIntake() {
        boolean delete = true;
        Scanner userInput = new Scanner(System.in);

        while (delete) {

            System.out.println("Introduzca alimento a borrar (-3 para salir)");
            String foodName = userInput.nextLine();
            if (foodName.equals("-3")) {

                delete = !delete;

            } else {
                Food food = new Food(foodName);
                deleteFood(food);
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
        // breakfast.updateIntake();
        breakfast.printFoodListing();

    }
}
