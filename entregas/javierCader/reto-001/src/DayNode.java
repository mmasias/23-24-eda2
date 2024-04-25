package vEDA.v003;

class DayNode {

    private Day day;
    private DayNode next;

    public DayNode(Day day) {
        this.day = day;
        this.next = null;
    }

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public DayNode getNext() {
        return next;
    }

    public void setNext(DayNode next) {
        this.next = next;
    }
}
