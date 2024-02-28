package entregas.oteroJorge.Reto002;

import java.util.LinkedList;
import java.util.Scanner;

public class Intake {
        private LinkedList<Food> foodList;
        private String name;

    public Intake(String name) {
        foodList = new LinkedList<>();
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addFood(Food food) {
        foodList.add(food);
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
                creating = false;
            } else {
                Food food = new Food(foodName);
                addFood(food);
            }
        }
    }

    private void editIntake() {
        boolean editing = true;
        Scanner userInput = new Scanner(System.in);
        while (editing) {
            System.out.println("Nombre del alimento por editar (-1 para terminar)");
            String foodName = userInput.nextLine();
            if (foodName.equals("-1")) {
                editing = !editing;
            } else {
                editFood(foodName);
            }
        }
    }

    private void editFood(String foodName) {
        Scanner userInput = new Scanner(System.in);
        for (Food food : foodList) {
            if (food.getName().equals(foodName)) {
                System.out.println("Nuevo nombre de [" + foodName + "]");
                String newFoodName = userInput.nextLine();
                food.setName(newFoodName);
                return;
            }
        }
        System.out.println("Alimento no encontrado.");
    }

    private void deleteIntake() {
        Scanner userInput = new Scanner(System.in);
        boolean deleting = true;
        while (deleting) {
            System.out.println("Nombre del alimento por eliminar (-1 para terminar)");
            String foodName = userInput.nextLine();
            if (foodName.equals("-1")) {
                deleting = !deleting;
            } else {
                removeFood(foodName);
            }
        }
    }

    public void removeFood(String foodName) {
        boolean removed = foodList.removeIf(food -> food.getName().equals(foodName));
        if (!removed) {
            System.out.println("Alimento no encontrado.");
        }
    }

    public void deleteAllIntake() {
        foodList.clear();
    }

    @Override
    public String toString() {
        StringBuilder foodListing = new StringBuilder("]>> " + name + "\n");
        for (Food food : foodList) {
            foodListing.append(food.toString()).append("\n");
        }
        return foodListing.toString();
    }

    public static void main(String[] args) {

        Intake breakfast = new Intake("Desayuno");

        breakfast.createIntake();
        breakfast.printFoodListing();

        breakfast.editIntake();
        breakfast.printFoodListing();

        breakfast.deleteIntake();
        breakfast.printFoodListing();

        breakfast.deleteAllIntake();
        breakfast.printFoodListing();

    }
}
