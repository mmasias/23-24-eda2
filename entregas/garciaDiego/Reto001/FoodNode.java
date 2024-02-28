package vEDA.v001;

class FoodNode {

    private Intake food;
    private FoodNode next;

    public FoodNode(Intake alimento) {
        this.food = alimento;
        this.next = null;
    }

    public Intake getFood() {
        return food;
    }

    public void setFood(Intake food) {
        this.food = food;
    }

    public FoodNode getNext() {
        return next;
    }

    public void setNext(FoodNode next) {
        this.next = next;
    }
}
