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
        System.out.println(toString());
    }

    public void createDiet() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("Numero de día (-1 para terminar)");
            String dayName = userInput.nextLine();
            if (dayName.equals("-1")) {
                creating = false;
            } else {
                Day day = new Day();
                day.setName(dayName);
                day.createIntakes();
                addDay(day);
            }
        }
    }

    public void deleteDiet() {
        boolean deleting = true;
        Scanner userInput = new Scanner(System.in);
        while (deleting) {
            System.out.println("Nombre del día a eliminar (-1 para terminar)");
            String dayName = userInput.nextLine();
            if (dayName.equals("-1")) {
                deleting = false;
            } else {
                deleteDay(dayName);
            }
        }
    }

    public void editDay(String dayName) {
        DayNode current = first;
        while (current != null) {
            if (current.getDay().getName().equalsIgnoreCase(dayName)) {
                System.out.println("Nuevo nombre del día:");
                Scanner userInput = new Scanner(System.in);
                String newName = userInput.nextLine();
                current.getDay().setName(newName);
                break;
            }
            current = current.getNext();
        }
    }

    public void editDiet() {
        System.out.println("Nombre del día a editar:");
        Scanner userInput = new Scanner(System.in);
        String dayName = userInput.nextLine();
        editDay(dayName);
    }

    @Override
    public String toString() {
        StringBuilder dietListing = new StringBuilder();
        DayNode current = first;
        while (current != null) {
            dietListing.append(current.getDay().toString()).append("\n");
            current = current.getNext();
        }
        return dietListing.toString();
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
