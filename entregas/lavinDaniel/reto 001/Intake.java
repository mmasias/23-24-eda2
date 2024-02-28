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

    public static void main(String[] args) {
        Intake breakfast = new Intake();
        breakfast.addFood(new Food("Eggs"));
        breakfast.addFood(new Food("Bacon"));
        breakfast.addFood(new Food("Toast"));
        System.out.println("Before update and delete:");
        System.out.println(breakfast.toString());

        breakfast.updateFood(new Food("Pancakes"), 1);
        System.out.println("After update:");
        System.out.println(breakfast.toString());

        breakfast.deleteFood(0);
        System.out.println("After delete:");
        System.out.println(breakfast.toString());
    }
}