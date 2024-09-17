package entregas.diestroPaula.Reto002;

import java.util.LinkedList;
import java.util.Scanner;

class Day {

    private String name;

    public Day(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private LinkedList<Intake> intakeList;

    public Day() {
        intakeList = new LinkedList<>();
    }

    public void addIntake(Intake intake) {
        intakeList.add(intake);
    }

    public void printIntakeListing() {
        System.out.println(this.toString());
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
                intake.createIntake();
                addIntake(intake);
            }
        }
    }

    public void editIntakes() {
        boolean editing = true;
        Scanner userInput = new Scanner(System.in);
        System.out.println("Seleccione el nombre de la ingesta a editar (-1 para terminar):");
        while (editing) {
            String intakeName = userInput.nextLine();
            if (intakeName.equals("-1")) {
                editing = !editing;
            } else {
                editIntake(intakeName);
            }
        }
    }

    private void editIntake(String intakeName) {
        Scanner userInput = new Scanner(System.in);
        for (Intake intake : intakeList) {
            if (intake.getName().equals(intakeName)) {
                System.out.println("Nuevo nombre de [" + intakeName + "]");
                String newIntakeName = userInput.nextLine();
                intake.setName(newIntakeName);
                return;
            }
        }
        System.out.println("Ingesta no encontrada.");
    }

    public void deleteIntakes() {
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

    public void removeIntake(String intakeName) {
        boolean removed = intakeList.removeIf(intake -> intake.getName().equals(intakeName));
        if (!removed) {
            System.out.println("Ingesta no encontrado.");
        }
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

        Day monday = new Day();
        monday.createIntakes();
        monday.printIntakeListing();

        monday.editIntakes();
        monday.printIntakeListing();

        monday.deleteIntakes();
        monday.printIntakeListing();
    }
}
