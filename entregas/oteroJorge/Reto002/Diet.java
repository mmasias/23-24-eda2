package entregas.oteroJorge.Reto002;

import java.util.LinkedList;
import java.util.Scanner;

public class Diet {

    private LinkedList<Day> dayList;

    public Diet() {
        dayList = new LinkedList<>();
    }

    private void addDay(Day day) {
        dayList.add(day);
    }

    public void printDayListing() {
        System.out.println(this.toString());
    }

    public void createDiet() {
        boolean createDiet = true;
        Scanner userInput = new Scanner(System.in);
        while (createDiet) {
            System.out.println("Nombre del día (-1 para terminar)");
            String dayName = userInput.nextLine();
            if (dayName.equals("-1")) {
                createDiet = false;
            } else {
                Day day = new Day(dayName);
                day.createDay();
                addDay(day);
            }
        }
    }

    private void editDay(String dayName) {
        Scanner userInput = new Scanner(System.in);
        for (Day day : dayList) {
            if (day.getName().equals(dayName)) {
                System.out.println("Nuevo nombre de [" + dayName + "]");
                String newName = userInput.nextLine();
                day.setName(newName);
                return;
            }
        }
        System.out.println("No se encontró el día [" + dayName + "]");
    }

    public void editDiet() {
        boolean editing = true;
        Scanner userInput = new Scanner(System.in);
        while (editing) {
            System.out.println("Nombre del día por editar (-1 para terminar)");
            String dayName = userInput.nextLine();
            if (dayName.equals("-1")) {
                editing = !editing;
            } else {
                editDay(dayName);
            }
        }
    }

    private void removeDay(String dayName) {
        for (Day day : dayList) {
            if (day.getName().equals(dayName)) {
                dayList.remove(day);
                return;
            }
        }
        System.out.println("No se encontró el día [" + dayName + "]");
    }

    public void removeDiet() {
        boolean removing = true;
        Scanner userInput = new Scanner(System.in);
        while (removing) {
            System.out.println("Nombre del día por eliminar (-1 para terminar)");
            String dayName = userInput.nextLine();
            if (dayName.equals("-1")) {
                removing = !removing;
            } else {
                removeDay(dayName);
            }
        }
    }

    public void deleteAllDays() {
        System.out.println("Eliminando todos los días...");
        dayList.clear();
    }

    @Override
    public String toString() {
        StringBuilder dayListing = new StringBuilder();
        for (Day day : dayList) {
            dayListing.append(day.toString()).append("\n");
        }
        return dayListing.toString();
    }

    public static void main(String[] args) {
        Diet diet = new Diet();

        diet.createDiet();
        diet.printDayListing();
        diet.editDiet();
        diet.printDayListing();
        diet.removeDiet();
        diet.printDayListing();
        diet.deleteAllDays();
    }


}
