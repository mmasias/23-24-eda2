package vEDA.v003;

import java.util.ArrayList;
import java.util.Scanner;

class Diet {
    private ArrayList<Day> dayList;

    public Diet() {
        dayList = new ArrayList<>();
    }

    public void addDay(Day day) {
        dayList.add(day);
    }

    public void printDayListing() {
        for (Day day : dayList) {
            System.out.println("Día: " + day.getName());
            day.printIntakeListing();
            System.out.println();
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
                Day day = new Day(dayName);
                day.createIntakes();
                addDay(day);
            }
        }
    }

    public void updateDay(String oldName, String newName) {
        for (Day day : dayList) {
            if (day.getName().equals(oldName)) {
                day.setName(newName);
                System.out.println("Día actualizado exitosamente.");
                return;
            }
        }
        System.out.println("No se encontró el día con el nombre proporcionado.");
    }

    public void deleteDay(String name) {
        for (Day day : dayList) {
            if (day.getName().equals(name)) {
                dayList.remove(day);
                System.out.println("Día eliminado exitosamente.");
                return;
            }
        }
        System.out.println("No se encontró el día con el nombre proporcionado.");
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

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n¿Desea actualizar o eliminar algún día? (A/E/N)");
        String option = scanner.nextLine().toUpperCase();

        switch (option) {
            case "A":
                System.out.println("Ingrese el nombre del día que desea actualizar: ");
                String oldName = scanner.nextLine();
                System.out.println("Ingrese el nuevo nombre del día: ");
                String newName = scanner.nextLine();
                diet.updateDay(oldName, newName);
                diet.printDayListing();
                break;
            case "E":
                System.out.println("Ingrese el nombre del día que desea eliminar: ");
                String nameToDelete = scanner.nextLine();
                diet.deleteDay(nameToDelete);
                diet.printDayListing();
                break;
            default:
                System.out.println("Operación no reconocida.");
                break;
        }

        scanner.close();
    }
}
