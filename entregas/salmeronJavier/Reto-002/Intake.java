import java.util.ArrayList;

class Intake {
    private ArrayList<Food> foods;
    private String identifier;

    public Intake(String identifier) {
        this.foods = new ArrayList<>();
        this.identifier = identifier;
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public Food findFood(String name) {
        for (Food food : foods) {
            if (food.getName().equals(name)) {
                return food;
            }
        }
        return null;
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

    public void deleteAllFood() {
        foods.clear();
    }

    public void printFoodListing() {
        System.out.println("Intake: " + identifier);
        for (Food food : this.foods) {
            System.out.println(food.toString());
        }
    }

    public String getIdentifier() {
        return identifier;
    }

    public void updateDetails(String newIdentifier) {
        this.identifier = newIdentifier;
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
