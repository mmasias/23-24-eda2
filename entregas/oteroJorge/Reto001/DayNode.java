package entregas.oteroJorge.Reto001;

public class DayNode {
    
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
