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

    public Food findFood(String name) {
        FoodNode current = first;
        while (current != null) {
            if (current.getFood().getName().equals(name)) {
                return current.getFood();
            }
            current = current.getNext();
        }
        return null;
    }

    public boolean updateFood(String oldName, String newName) {
        FoodNode current = first;
        while (current != null) {
            if (current.getFood().getName().equals(oldName)) {
                current.getFood().setName(newName);
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public boolean deleteFood(String name) {
        if (first == null)
            return false;

        if (first.getFood().getName().equals(name)) {
            first = first.getNext();
            return true;
        }

        FoodNode current = first;
        while (current.getNext() != null) {
            if (current.getNext().getFood().getName().equals(name)) {
                current.setNext(current.getNext().getNext());
                return true;
            }
            current = current.getNext();
        }

        return false;
    }

    public void deleteAllFood() {
        first = null;
    }

    public void printFoodListing() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        String foodListing = "";
        FoodNode current = first;
        while (current != null) {
            foodListing += current.getFood().toString() + "\n";
            current = current.getNext();
        }
        return foodListing;
    }

    public static void main(String[] args) {

        Intake breakfast = new Intake();

        // Create
        System.out.println("Adding food...");
        breakfast.addFood(new Food("Apple"));
        breakfast.addFood(new Food("Banana"));
        breakfast.addFood(new Food("Pineapple"));
        breakfast.addFood(new Food("Carrot"));
        breakfast.printFoodListing();

        // Read
        System.out.println("Finding Banana...");
        Food foundFood = breakfast.findFood("Banana");
        if (foundFood != null) {
            System.out.println("Found: " + foundFood);
        } else {
            System.out.println("Food not found.");
        }

        // Update
        System.out.println("Updating 'Banana' to 'Raspberry'...");
        boolean updateResult = breakfast.updateFood("Banana", "Raspberry");
        if (updateResult) {
            System.out.println("'Banana' updated to 'Raspberry'.");
        } else {
            System.out.println("Food to update was not found.");
        }
        breakfast.printFoodListing();

        // Delete
        System.out.println("Deleting 'Carrot'...");
        boolean deleteResult = breakfast.deleteFood("Carrot");
        if (deleteResult) {
            System.out.println("'Carrot' deleted.");
        } else {
            System.out.println("Food to delete was not found.");
        }
        breakfast.printFoodListing();

        System.out.println("Deleting all foods...");
        breakfast.deleteAllFood();
        breakfast.printFoodListing();
    }

}
