package Crud;

import java.util.ArrayList;
import java.util.Scanner;

class Day {

    private String name;
    private ArrayList<Intake> intakes;

    public Day(String name) {
        this.name = name;
        this.intakes = new ArrayList<>();
        this.manage();
    }

    private void addIntake(Intake intake) {
        intakes.add(intake);
    }

    private void createIntake() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("Creando ingestas del " + this.name);
            System.out.println("Nombre de la ingesta (-1 para terminar)");
            String intakeName = userInput.nextLine();
            if (intakeName.equals("-1")) {
                creating = !creating;
            } else {
                Intake intake = new Intake(intakeName + " del " + this.name);
                intake.manage();
                addIntake(intake);
            }
        }
    }

    private void editIntake() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre de la ingesta a editar:");
        String intakeName = userInput.nextLine();
        for (Intake intake : intakes) {
            if (intake.getName().equals(intakeName)) {
                intake.manage();
                return;
            }
        }
        System.out.println("Ingesta no encontrada");
    }

    private void deleteIntake() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre de la ingesta por eliminar:");
        String intakeName = userInput.nextLine();
        intakes.removeIf(intake -> intake.getName().equals(intakeName));
    }

    private void renameDay() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nuevo nombre de [" + this.name + "]");
        String newName = userInput.nextLine();
        this.name = newName;
    }

    public void manage() {
        boolean managing = true;
        Scanner userInput = new Scanner(System.in);
        while (managing) {
            System.out.println("Gestionando [" + this.name.toUpperCase() + "]");
            System.out.println("[C]reate / [R]ead / Re[N]ame  / [U]pdate / [D]elete / e[X]it");
            char userOption = userInput.nextLine().toUpperCase().charAt(0);
            switch (userOption) {
                case 'C':
                    createIntake();
                    break;
                case 'R':
                    System.out.println(this.toString());
                    break;
                case 'U':
                    editIntake();
                    break;
                case 'N':
                    renameDay();
                    break;
                case 'D':
                    deleteIntake();
                    break;
                case 'X':
                    managing = !managing;
                    break;
                default:
                    System.out.println("El carácter ingresado no es válido.");
                    break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder intakeListing = new StringBuilder();
        for (Intake intake : intakes) {
            intakeListing.append(intake.toString()).append("\n");
        }
        return intakeListing.toString();
    }

    public static void main(String[] args) {
        Day monday = new Day("Lunes");
        System.out.println(monday.toString());
    }
}
