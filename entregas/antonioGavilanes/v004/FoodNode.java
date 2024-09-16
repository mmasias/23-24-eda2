package antonioGavilanes.v004;

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
    
}
