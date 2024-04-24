
class DietNode {

    private Diet diet;
    private DietNode next;

    public DietNode(Diet diet) {
        this.diet = diet;
        this.next = null;
    }

    public Intake getDiet() {
        return diet;
    }

    public void setDiet(Intake food) {
        this.diet = food;
    }

    public DietNode getNext() {
        return next;
    }

    public void setNext(iet next) {
        this.next = next;
    }
}
