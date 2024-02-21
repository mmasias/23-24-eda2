package v03;
import java.util.Scanner;

public class Diet {
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

    public void createDays() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("Nombre del día (-1 para terminar)");
            String dayName = userInput.nextLine();
            if (dayName.equals("-1")) {
                creating = false;
            } else {
                Day day = new Day();
                day.createIntakes();
                addDay(day);
            }
        }
    }

    public void printDayListing() {
        System.out.println(this.toString());
    }

    public void deleteDay(String name) {
        if (first == null) {
            System.out.println("La lista de días está vacía.");
            return;
        }

        if (first.getDay().toString().equals(name)) {
            first = first.getNext();
            System.out.println("Se eliminó el día con éxito.");
            return;
        }

        DayNode prev = first;
        DayNode current = first.getNext();
        while (current != null) {
            if (current.getDay().toString().equals(name)) {
                prev.setNext(current.getNext());
                System.out.println("Se eliminó el día con éxito.");
                return;
            }
            prev = current;
            current = current.getNext();
        }

        System.out.println("No se encontró el día con el nombre proporcionado.");
    }

    @Override
    public String toString() {
        String daysListing = "";
        DayNode current = first;
        while (current != null) {
            daysListing = daysListing + current.getDay().toString() + "\n";
            current = current.getNext();
        }
        return daysListing;
    }

    public static void main(String[] args) {
        Diet diet = new Diet();
        diet.createDays();
        diet.printDayListing();
    }
}
