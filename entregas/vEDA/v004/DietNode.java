package vEDA.v004;

public class DietNode {

    private Diet diet;
    private DietNode next;

    public DietNode(Diet diet) {
        this.diet = diet;
        this.next = null;
    }

    public Diet getDiet() {
        return diet;
    }

    public void setDiet(Diet diet) {
        this.diet = diet;
    }

    public DietNode getNext() {
        return next;
    }

    public void setNext(DietNode next) {
        this.next = next;
    }
}
