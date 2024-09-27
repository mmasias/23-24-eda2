package src;

import java.util.ArrayList;
import java.util.Scanner;

class Day {
    private ArrayList<Intake> intakes;

    public Day() {
        intakes = new ArrayList<>();
    }

    public void addIntake(Intake intake) {
        intakes.add(intake);
    }

    public void printIntakeListing() {
        for (Intake intake : intakes) {
            System.out.println(intake);
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
                intake.menu();
                addIntake(intake);
            }
        }
    }

    public void deleteIntake() {
        Scanner userInput = new Scanner(System.in);
        if (intakes.isEmpty()) {
            System.out.println("La lista de ingestas está vacía.");
            return;
        }

        System.out.println("¿Qué ingesta deseas eliminar?");
        String intakeName = userInput.nextLine();

        boolean found = false;
        for (Intake intake : intakes) {
            if (intake.toString().equals(intakeName)) {
                intakes.remove(intake);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No se encontró la ingesta a eliminar.");
        }
    }

    private void deleteAllIntakes() {
        intakes.clear();
        System.out.println("\nTodos las ingestas han sido eliminados con éxito!");
    }

    public void updateIntake() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("¿Qué ingesta deseas actualizar?");
        String name = userInput.nextLine();

        boolean found = false;
        for (Intake intake : intakes) {
            if (intake.toString().equals(name)) {
                intake.createIntake();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No se encontró la ingesta a actualizar.");
        }
    }

    public void menu() {
        Scanner userInput = new Scanner(System.in);
        boolean finish = false;
        System.out.println(">>OPCIONES DIA<< \n");
        while (!finish) {
            System.out.println("1. Agregar");
            System.out.println("2. Eliminar");
            System.out.println("3. Modificar");
            System.out.println("4. Mostrar");
            System.out.println("5. Eliminar todo");
            System.out.println("6. Salir");
            int option = userInput.nextInt();
            switch (option) {
                case 1:
                    createIntakes();
                    break;
                case 2:
                    deleteIntake();
                    break;
                case 3:
                    updateIntake();
                    break;
                case 4:
                    printIntakeListing();
                    break;
                case 5:
                    deleteAllIntakes();
                    break;
                case 6:
                    finish = true;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

    public static void main(String[] args) {

        Day monday = new Day();
        monday.menu();
    }
}