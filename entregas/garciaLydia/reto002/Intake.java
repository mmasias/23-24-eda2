package entregas.garciaLydia.reto002;

import java.util.ArrayList;

public class Intake {
    private ArrayList<Food> foods;

    public Intake() {
        foods = new ArrayList<>();
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public void updateFood(Food food, int index) {
        if (index >= 0 && index < foods.size()) {
            foods.set(index, food);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void deleteFood(int index) {
        if (index >= 0 && index < foods.size()) {
            foods.remove(index);
        } else {
            System.out.println("Índice inválido.");
        }
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
