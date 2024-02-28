import java.util.ArrayList;
import java.util.Scanner;

class Diet {
    private ArrayList<Day> days;

    public Diet() {
        days = new ArrayList<>();
    }

    public void addDay(Day day) {
        days.add(day);
    }

    public void printAllDays() {
        for (Day day : days) {
            System.out.println(day);
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

    public void removeDays() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del día a eliminar, 0 para cancelar");
        String dayName = userInput.nextLine();

        if (dayName.equals("0")) {
            return;
        }

        for (Day day : days) {
            if (day.getName().equals(dayName)) {
                days.remove(day);
            }
        }
    }

    public void updateDays() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del día a modificar, 0 para cancelar");
        String dayName = userInput.nextLine();

        if (dayName.equals("0")) {
            return;
        }

        for (Day day : days) {
            if (day.getName().equals(dayName)) {
                day.createIntakes();
            }
        }
    }

    public void deleteDays() {
        days.clear();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Day day : days) {
            result.append(day).append("\n");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Diet diet = new Diet();
        diet.createDays();
        diet.printAllDays();
    }
}
