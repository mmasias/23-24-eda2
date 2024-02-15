package entregas.andresAlarcon.EC1.src;

class Intake {
    private FoodNode first;

    public Intake() {
        first = null;
    }

    // CREATE
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

    // READ
    public Food getFood(String name) {
        FoodNode current = first;
        while (current != null) {
            if (current.getFood().getName().equals(name)) {
                return current.getFood();
            }
            current = current.getNext();
        }
        return null; // Return null if the food is not found
    }

    // UPDATE
    public void updateFood(String oldName, String newName) {
        FoodNode current = first;
        while (current != null) {
            if (current.getFood().getName().equals(oldName)) {
                current.getFood().setName(newName);
                break;
            }
            current = current.getNext();
        }
    }

    // DELETE
    public void deleteFood(String name) {
        if (first != null && first.getFood().getName().equals(name)) {
            first = first.getNext();
        } else {
            FoodNode current = first;
            while (current != null && current.getNext() != null) {
                if (current.getNext().getFood().getName().equals(name)) {
                    current.setNext(current.getNext().getNext());
                    break;
                }
                current = current.getNext();
            }
        }
    }

    public void printFoodListing() {
        System.out.println(this.toString());
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
        breakfast.addFood(new Food("Apple"));
        breakfast.addFood(new Food("Banana"));
        breakfast.printFoodListing();
        breakfast.updateFood("Apple", "Orange");
        breakfast.deleteFood("Banana");
        breakfast.printFoodListing();
    }
}
