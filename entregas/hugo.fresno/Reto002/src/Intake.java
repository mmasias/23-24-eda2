import java.util.ArrayList;
import java.util.Scanner;

public class Intake {
    private ArrayList<Food> foodList;
    private String name;

    public Intake(String name) {
        this.foodList = new ArrayList<>();
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

    public void createIntake() {
        Scanner userInput = new Scanner(System.in);
        while (true) {
            System.out.println("Nombre del alimento (-1 para terminar):");
            String foodName = userInput.nextLine();
            if (foodName.equals("-1")) {
                break;
            } else {
                Food food = new Food(foodName);
                addFood(food);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder foodListing = new StringBuilder("Ingesta: " + name + "\n");
        for (Food food : foodList) {
            foodListing.append("  ").append(food).append("\n");
        }
        return foodListing.toString();
    }
}
