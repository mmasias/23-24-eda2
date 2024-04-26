package entregas.DiegoBarraza.reto002;

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
        Scanner userInput = new Scanner(System.in);
        while (true) {
            System.out.println(" Nombre de la ingesta (-1 para terminar) ");
            String intakeName = userInput.nextLine();
            if (intakeName.equals("-1")) {
                break;
            } else {
                Intake intake = new Intake();
                intake.createIntake();
                addIntake(intake);
            }
        }
    }

    public void editIntake() {
        Scanner userInput = new Scanner(System.in);
        System.out.println(" Ingrese la ingesta que desea editar");
        String intakeName = userInput.nextLine();
        for (Intake intake : intakes) {
            if (intake.getName().equals(intakeName)) {
                intake.editIntake();
                return;
            }
        }
        System.out.println(" No se pudo encontrar");
    }

    public void deleteIntake() {
        Scanner userInput = new Scanner(System.in);
        System.out.println(" Ingrese la ingesta que desea eliminar");
        String intakeName = userInput.nextLine();
        for (int i = 0; i < intakes.size(); i++) {
            if (intakes.get(i).getName().equals(intakeName)) {
                intakes.remove(i);
                System.out.println(" La ingesta se eliminó ");
                return;
            }
        }
        System.out.println(" La ingesta no se encontró ");
    }

    @Override
    public String toString() {
        StringBuilder intakeListing = new StringBuilder();
        for (Intake intake : intakes) {
            intakeListing.append(intake).append("\n");
        }
        return intakeListing.toString();
    }
}