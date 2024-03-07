import java.util.ArrayList;
import java.util.Scanner;

public class Diet {
    private ArrayList<Day> days;

    public Diet() {
        super();
        days = new ArrayList<>();
    }

    public void addDay(Day day) {
        days.add(day);
    }

    public void deleteDay(String dayName) {
        for (int i = 0; i < days.size(); i++) {
            if (days.get(i).getName().equals(dayName)) {
                days.remove(i);
                break;
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
            System.out.println("Nombre del dia (-1 para terminar)");
            String dayName = userInput.nextLine();
            if (dayName.equals("-1")) {
                creating = false;
            } else {
                Day day = new Day(dayName);
                day.createIntakes();
                addDay(day);
            }
        }
    }

    public void deleteDiet() {
        boolean deleting = true;
        Scanner userInput = new Scanner(System.in);
        while (deleting) {
            System.out.println("Nombre del dia a eliminar (-1 para terminar)");
            String dayName = userInput.nextLine();
            if (dayName.equals("-1")) {
                deleting = false;
            } else {
                deleteDay(dayName);
            }
        }
    }

    public void editDay(String dayName) {
        deleteDay(dayName);
        System.out.println("Nuevo nombre del dia");
        Scanner userInput = new Scanner(System.in);
        String newName = userInput.nextLine();
        Day newDay = new Day(newName);
        addDay(newDay);
    }

    public void editDiet() {
        System.out.println("Nombre del dia a editar");
        Scanner userInput = new Scanner(System.in);
        String dayName = userInput.nextLine();
        editDay(dayName);
    }

    @Override
    public String toString() {
        StringBuilder daysListing = new StringBuilder();
        for (Day day : days) {
            daysListing.append(day.toString()).append("\n");
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