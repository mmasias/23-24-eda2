package entregas.oteroJorge.Reto002;

import java.util.LinkedList;
import java.util.Scanner;

public class Day {
    private LinkedList<Intake> intakeList;
    private String name;

    public Day(String name) {
        intakeList = new LinkedList<>();
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void addIntake(Intake intake) {
        intakeList.add(intake);
    }

    public void printIntakeListing() {
        System.out.println(this.toString());
    }

    public void createDay() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("Nombre de la ingesta (-1 para terminar)");
            String intakeName = userInput.nextLine();
            if (intakeName.equals("-1")) {
                creating = false;
            } else {
                Intake intake = new Intake(intakeName);
                intake.createIntake();
                addIntake(intake);
            }
        }
    }

    private void editIntake(String intakeName) {
        Scanner userInput = new Scanner(System.in);
        for (Intake intake : intakeList) {
            if (intake.getName().equals(intakeName)) {
                System.out.println("Nuevo nombre de [" + intakeName + "]");
                String newName = userInput.nextLine();
                intake.setName(newName);
                return;
            }
        }
        System.out.println("No se encontró la ingesta [" + intakeName + "]");
    }

    public void editDay() {
        boolean editing = true;
        Scanner userInput = new Scanner(System.in);
        while (editing) {
            System.out.println("Nombre de la ingesta por editar (-1 para terminar)");
            String intakeName = userInput.nextLine();
            if (intakeName.equals("-1")) {
                editing = !editing;
            } else {
                editIntake(intakeName);
            }
        }
    }

    private void removeIntake(String intakeName) {
        boolean removed = intakeList.removeIf(food -> food.getName().equals(intakeName));
        if (!removed) {
            System.out.println("Alimento no encontrado.");
        }
    }

    public void deleteDay() {
        Scanner userInput = new Scanner(System.in);
        boolean deleting = true;
        while (deleting) {
            System.out.println("Nombre de la ingesta por eliminar (-1 para terminar)");
            String intakeName = userInput.nextLine();
            if (intakeName.equals("-1")) {
                deleting = !deleting;
            } else {
                removeIntake(intakeName);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("]> ").append(name).append("\n");
        for (Intake intake : intakeList) {
            sb.append(intake.toString()).append("\n");
        }
        return sb.toString();
    }

    public void deleteAllIntake() {
        intakeList.clear();
    }

    public static void main(String[] args) {
        Day day = new Day("Lunes");

        day.createDay();
        day.printIntakeListing();
        day.editDay();
        day.printIntakeListing();
        day.deleteDay();
        day.printIntakeListing();
        day.deleteAllIntake();
        day.printIntakeListing();
    } 
}
