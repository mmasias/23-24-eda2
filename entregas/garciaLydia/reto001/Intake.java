package entregas.garciaLydia.reto001;

public class Intake {
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

    public void updateFood(Food food, int index) {
        FoodNode current = first;
        int count = 0;
        while (current != null) {
            if (count == index) {
                current.setFood(food);
                break;
            }
            current = current.getNext();
            count++;
        }
    }

    public void deleteFood(int index) {
        if (index == 0) {
            first = first.getNext();
        } else {
            FoodNode current = first;
            int count = 0;
            while (current != null) {
                if (count == index - 1) {
                    current.setNext(current.getNext().getNext());
                    break;
                }
                current = current.getNext();
                count++;
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
}
