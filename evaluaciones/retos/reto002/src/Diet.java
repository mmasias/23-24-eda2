import java.util.ArrayList;
import java.util.Scanner;

public class Diet {
    private String name;
    Scanner userInput = new Scanner(System.in);
    private ArrayList<Day> days;

    public Diet(String name) {
        this.name = name;
        days = new ArrayList<>();
    }

    public String getDietName() {
        return name;
    }

    public void setDietName(String name) {
        this.name = name;
    }

    public Day searchDay(String dayName) {
        for(Day d : days) {
            if(d.getDayName().equals(dayName)) {
                return d;
            }
        }

        return null;
    }

    public void printDayListing() {
        System.out.println(this.toString());
    }

    private void addDay(Day day) {
        days.add(day);
    }

    public void createDays() {
        boolean creating = true;
        while (creating) {
            System.out.println("Nombre del día por crear (-1 para terminar)");
            String dayName = userInput.nextLine();
            if (dayName.equals("-1")) {
                creating = !creating;
            } else {
                Day day = new Day(dayName);
                addDay(day);
            }
        }
    }

    private void deleteDay(String dayName) {
        Day dayWanted = searchDay(dayName);
        days.remove(dayWanted);
    }

    public void deleteDays() {
        boolean deleting = true;
        while (deleting) {
            System.out.println("Nombre del día por eliminar (-1 para terminar)");
            String dayName = userInput.nextLine();

            if (dayName.equals("-1")) {
                deleting = !deleting;
            } else {
                deleteDay(dayName);
            }
        }
    }

    public void deleteAllDays() {
        days.clear();
    }

    private void updateDay(String oldName, String newName) {
        Day dayWanted = searchDay(oldName);
        dayWanted.setDayName(newName);
    }

    public void updateDays() {
        boolean updating = true;
        while(updating) {
            System.out.println("Nombre del día a editar (-1 para terminar): ");
            String oldName = userInput.nextLine();

            if (oldName.equals("-1")) {
                updating = !updating;
            } else {
                System.out.println("Nuevo nombre del día:" );
                String newName = userInput.nextLine();
                updateDay(oldName, newName);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder dayListing = new StringBuilder();
        for (Day d : days) {
            dayListing.append(d.toString()).append("\n");
        }

        return dayListing.toString();
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Introduce el nombre de la dieta: ");
        String dietName = userInput.nextLine();

        Diet diet = new Diet(dietName);
        diet.createDays();
        diet.printDayListing();

        diet.deleteDays();
        diet.printDayListing();

        diet.updateDays();
        diet.printDayListing();
    }


}
