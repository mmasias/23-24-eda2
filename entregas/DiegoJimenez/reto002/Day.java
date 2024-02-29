package vEDA.v003;

import java.util.ArrayList;
import java.util.Scanner;

class Day {
    private ArrayList<Intake> intakeList;
    private String name;

    public Day(String name) {
        this.name = name;
        intakeList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addIntake(Intake intake) {
        intakeList.add(intake);
    }

    public void printIntakeListing() {
        for (Intake intake : intakeList) {
            System.out.println("Ingesta: " + intake.getName());
            System.out.println("Alimentos:");
            intake.printFoodListing();
        }
    }

    public void createIntakes() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("Nombre de la ingesta (-1 para terminar)");
            String intakeName = userInput.nextLine();
            if (intakeName.equals("-1")) {
                creating = false;
            } else {
                Intake intake = new Intake();
                intake.setName(intakeName);
                intake.createIntake();
                addIntake(intake);
            }
        }
    }

    public void updateIntake(String oldName, String newName) {
        for (Intake intake : intakeList) {
            if (intake.getName().equals(oldName)) {
                intake.setName(newName);
                System.out.println("Ingesta actualizada exitosamente.");
                return;
            }
        }
        System.out.println("No se encontró la ingesta con el nombre proporcionado.");
    }

    public void deleteIntake(String name) {
        for (Intake intake : intakeList) {
            if (intake.getName().equals(name)) {
                intakeList.remove(intake);
                System.out.println("Ingesta eliminada exitosamente.");
                return;
            }
        }
        System.out.println("No se encontró la ingesta con el nombre proporcionado.");
    }

    @Override
    public String toString() {
        StringBuilder intakeListing = new StringBuilder();
        for (Intake intake : intakeList) {
            intakeListing.append(intake.toString()).append("\n");
        }
        return intakeListing.toString();
    }

    public static void main(String[] args) {
        Day monday = new Day("Monday");
        monday.createIntakes();
        monday.printIntakeListing();

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n¿Desea actualizar o eliminar alguna ingesta? (A/E/N)");
        String option = scanner.nextLine().toUpperCase();

        switch (option) {
            case "A":
                System.out.println("Ingrese el nombre de la ingesta que desea actualizar: ");
                String oldName = scanner.nextLine();
                System.out.println("Ingrese el nuevo nombre de la ingesta: ");
                String newName = scanner.nextLine();
                monday.updateIntake(oldName, newName);
                monday.printIntakeListing();
                break;
            case "E":
                System.out.println("Ingrese el nombre de la ingesta que desea eliminar: ");
                String nameToDelete = scanner.nextLine();
                monday.deleteIntake(nameToDelete);
                monday.printIntakeListing();
                break;
            default:
                System.out.println("Operación no reconocida.");
                break;
        }

        scanner.close();
    }
}
