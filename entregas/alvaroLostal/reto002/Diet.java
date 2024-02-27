import java.util.ArrayList;
import java.util.Scanner;

public class Diet {
    private ArrayList<Day> days;

    public Diet() {
        days = new ArrayList<>();
    }

    public void addDay(Day day) {
        days.add(day);
    }

    public void deleteDay(String dayName) {
        for (Day day : days) {
            if (day.getName().equalsIgnoreCase(dayName)) {
                days.remove(day);
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
            System.out.println("Dia de la semana (-1 para terminar)");
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
        for (Day day : days) {
            if (day.getName().equalsIgnoreCase(dayName)) {
                System.out.println("Nuevo nombre del día:");
                Scanner userInput = new Scanner(System.in);
                String newName = userInput.nextLine();
                day.setName(newName);
                break;
            }
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
        String dietListing = "\n";
        for (Day day : days) {
            dietListing += day.toString() + "\n";
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
