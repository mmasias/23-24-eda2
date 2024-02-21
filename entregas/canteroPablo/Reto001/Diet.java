import java.util.Scanner;

public class Diet {
    private DayNode first;
    private static Scanner userInput = new Scanner(System.in);

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

    public void deleteDay(String dayName) {
        DayNode current = first;
        DayNode previous = null;
        while (current != null && !current.getDay().getName().equals(dayName)) {
            previous = current;
            current = current.getNext();
        }
        if (current != null) {
            if (previous == null) {
                first = current.getNext();
            } else {
                previous.setNext(current.getNext());
            }
        }
    }

    public void printDietListing() {
        System.out.println(this);
    }

    public void createDiet() {
        boolean creating = true;
        while (creating) {
            System.out.println("Nombre del dia (-1 para terminar)");
            String dayName = userInput.nextLine();
            if ("-1".equals(dayName)) {
                creating = false;
            } else {
                Day day = new Day(dayName);
                day.createDay();
                addDay(day);
            }
        }
    }

    public void deleteDiet() {
        boolean deleting = true;
        while (deleting) {
            System.out.println("Nombre del dia a eliminar (-1 para terminar)");
            String dayName = userInput.nextLine();
            if ("-1".equals(dayName)) {
                deleting = false;
            } else {
                deleteDay(dayName);
            }
        }
    }

    public void editDay(String dayName) {
        deleteDay(dayName);
        System.out.println("Nuevo nombre del dia");
        String newName = userInput.nextLine();
        Day newDay = new Day(newName);
        addDay(newDay);
    }

    public void editDiet() {
        System.out.println("Nombre del dia a editar");
        String dayName = userInput.nextLine();
        editDay(dayName);
    }

    @Override
    public String toString() {
        StringBuilder daysListing = new StringBuilder();
        DayNode current = first;
        while (current != null) {
            daysListing.append(current.getDay()).append("\n");
            current = current.getNext();
        }
        return daysListing.toString();
    }

    public static void main(String[] args) {
        Diet diet = new Diet();
        diet.createDiet();
        diet.printDietListing();
        diet.deleteDiet();
        diet.printDietListing();
        diet.editDiet();
        diet.printDietListing();
    }
}

