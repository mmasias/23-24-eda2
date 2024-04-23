package entregas.CayetanoCastillo.Reto002;

import java.util.ArrayList;
import java.util.Scanner;

class Intake {
    private ArrayList<Food> foods;

    public Intake() {
        foods = new ArrayList<>();
    }

    public void addFood(Food food) {
        foods.add(food);
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

    public boolean updateFood(String oldName, String newName) {
        for (Food food : foods) {
            if (food.getName().equals(oldName)) {
                food.setName(newName);
                return true;
            }
        }
        return false;
    }

    public boolean deleteFood(String name) {
        return foods.removeIf(food -> food.getName().equals(name));
    }

    @Override
    public String toString() {
        StringBuilder foodListing = new StringBuilder();
        for (Food food : foods) {
            foodListing.append(food.toString()).append("\n");
        }
        return foodListing.toString();
    }
}
