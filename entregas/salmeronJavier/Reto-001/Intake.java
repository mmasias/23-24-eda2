class Intake {
    private FoodNode first;
    private String identifier;

    public Intake(String identifier) {
        this.first = null;
        this.identifier = identifier;
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
        System.out.println("Intake: " + identifier);
        FoodNode current = first;
        while (current != null) {
            System.out.println(current.getFood().toString());
            current = current.getNext();
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
        FoodNode current = first;
        while (current != null) {
            foodListing.append(current.getFood().toString()).append("\n");
            current = current.getNext();
        }
        return foodListing.toString();
    }
}
