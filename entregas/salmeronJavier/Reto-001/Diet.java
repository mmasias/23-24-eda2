import java.util.Scanner;

class Diet {
    private DayNode first;

    public Diet() {
        first = null;
    }

    public void addDay(Day day) {
        DayNode newDayNode = new DayNode(day);
        if (first == null) {
            first = newDayNode;
        } else {
            DayNode current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newDayNode);
        }
    }

    public Day findDay(String identifier) {
        DayNode current = first;
        while (current != null) {
            if (current.getDay().getIdentifier().equals(identifier)) {
                return current.getDay();
            }
            current = current.getNext();
        }
        return null;
    }

    public boolean updateDay(String identifier, Day newDayDetails) {
        DayNode current = first;
        while (current != null) {
            if (current.getDay().getIdentifier().equals(identifier)) {
                current.setDay(newDayDetails);
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public boolean deleteDay(String identifier) {
        if (first == null)
            return false;

        if (first.getDay().getIdentifier().equals(identifier)) {
            first = first.getNext();
            return true;
        }

        DayNode current = first;
        while (current.getNext() != null) {
            if (current.getNext().getDay().getIdentifier().equals(identifier)) {
                current.setNext(current.getNext().getNext());
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void printDayListing() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        StringBuilder daysListing = new StringBuilder();
        DayNode current = first;
        while (current != null) {
            daysListing.append(current.getDay().toString()).append("\n");
            current = current.getNext();
        }
        return daysListing.toString();
    }

    public static void main(String[] args) {
        Diet diet = new Diet();
        diet.printDayListing();
    }
}
