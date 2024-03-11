package entregas.diestroPaula.Reto001;

import java.util.Scanner;

class Day {
    private String name;
    private IntakeNode first;

    public Day(String name) {
        this.name = name;
        this.first = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addIntake(Intake intake) {
        IntakeNode newIntakeNode = new IntakeNode(intake);
        if (first == null) {
            first = newIntakeNode;
        } else {
            IntakeNode current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newIntakeNode);
        }
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
                creating = !creating;
            } else {
                Intake intake = new Intake();
                intake.createIntake();
                addIntake(intake);
            }
        }
    }

    public void updateDay() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Ingrese el nuevo nombre del día:");
        String newName = userInput.nextLine();
        this.name = newName;
        System.out.println("Nombre del día actualizado con éxito.");
    }

    public void deleteIntake() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Ingrese el nombre de la ingesta que desea eliminar:");
        String intakeName = userInput.nextLine();
        if (first != null && first.getIntake().getName().equalsIgnoreCase(intakeName)) {
            first = first.getNext();
            System.out.println("Ingesta eliminada con éxito.");
            return;
        }
        IntakeNode current = first;
        while (current != null && current.getNext() != null) {
            if (current.getNext().getIntake().getName().equalsIgnoreCase(intakeName)) {
                current.setNext(current.getNext().getNext());
                System.out.println("Ingesta eliminada con éxito.");
                return;
            }
            current = current.getNext();
        }
        System.out.println("La ingesta no se encontró en la lista.");
    }

    @Override
    public String toString() {
        String intakeListing = "Ingestas del día " + name + ":\n";
        IntakeNode current = first;
        while (current != null) {
            intakeListing += current.getIntake().toString() + "\n";
            current = current.getNext();
        }
        return intakeListing;
    }

    public static void main(String[] args) {
        Day monday = new Day("Lunes");
        monday.createIntakes();
        monday.printIntakeListing();
    }
}
