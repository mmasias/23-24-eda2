package entregas.diestroPaula.Reto002;

import java.util.LinkedList;
import java.util.Scanner;

class Diet {
    private LinkedList<Day> dayList;

    public Diet() {
        dayList = new LinkedList<>();
    }

    public void addDay(Day day) {
        dayList.add(day);
    }

    public void printDayListing() {
        System.out.println(this.toString());
    }

    public void createDays() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("Nombre del dia (-1 para terminar)");
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

    private void editDays(String dayName) {
        Scanner userInput = new Scanner(System.in);
        for (Day day : dayList) {
            if (day.getName().equals(dayName)) {
                System.out.println("Nuevo nombre de [" + dayName + "]");
                String newDayName = userInput.nextLine();
                day.setName(newDayName);
                return;
            }
        }
        System.out.println("Dia no encontrado.");
    }

    public void deleteDays() {
        Scanner userInput = new Scanner(System.in);
        boolean deleting = true;
        while (deleting) {
            System.out.println("Nombre del dia por eliminar (-1 para terminar)");
            String dayName = userInput.nextLine();
            if (dayName.equals("-1")) {
                deleting = !deleting;
            } else {
                removeDay(dayName);
            }
        }
    }

    private void removeDay(String dayName) {
        boolean removed = dayList.removeIf(day -> day.getName().equals(dayName));
        if (!removed) {
            System.out.println("Dia no encontrado.");
        }
    }

    @Override
    public String toString() {
        StringBuilder daysListing = new StringBuilder();
        for (Day day : dayList) {
            daysListing.append(day.toString()).append("\n");
        }
        return daysListing.toString();
    }

    public static void main(String[] args) {

        Diet diet = new Diet();
        diet.createDays();
        diet.printDayListing();

        diet.editDays("Lunes");
        diet.printDayListing();

        diet.deleteDays();
        diet.printDayListing();
    }
}