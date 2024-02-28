import java.util.ArrayList;

class Intake {
  private ArrayList<Food> foods;

  public Intake() {
      foods = new ArrayList<>();
  }

  public void addFood(Food food) {
      foods.add(food);
  }

  public void updateFood(Food food, int index) {
      foods.set(index, food);
  }

  public void deleteFood(int index) {
      foods.remove(index);
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