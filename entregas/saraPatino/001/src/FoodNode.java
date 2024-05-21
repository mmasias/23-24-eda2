package src;

class FoodNode {

    private Food food;
    private FoodNode next;

    public FoodNode(Food alimento) {
        this.food = alimento;
        this.next = null;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public FoodNode getNext() {
        return next;
    }

    public void setNext(FoodNode next) {
        this.next = next;
    }

    public FoodNode findFoodByName(String name) {
        FoodNode current = this;
        while (current != null) {
            if (current.food.getName().equals(name)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public boolean updateNode(String name, Food updatedFood) {
        FoodNode nodeToUpdate = findFoodByName(name);
        if (nodeToUpdate != null) {
            nodeToUpdate.setFood(updatedFood);
            return true;
        }
        return false;
    }

    public boolean deleteNode(String name) {
        FoodNode current = this;
        FoodNode previous = null;
        while (current != null) {
            if (current.food.getName().equals(name)) {
                if (previous != null) {
                    previous.next = current.next;
                }
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }
}