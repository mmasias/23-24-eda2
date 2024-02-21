package entregas.oteroJorge.Reto001;

import java.util.Scanner;

class Day {
    private IntakeNode first;
    private String name;

    public Day(String name) {
        first = null;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void addIntake(Intake intake) {
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

    private void deleteIntake(String intakeName) {
        IntakeNode current = first;
        IntakeNode previous = null;
        while (current != null && !current.getIntake().getName().equals(intakeName)) {
            previous = current;
            current = current.getNext();
        }
        if (current != null) {
            if (previous == null) {
                first = current.getNext();
            } else {
                previous.setNext(current.getNext());
            }
        }
    }

    private void editIntake(String intakeName) {
        Scanner userInput = new Scanner(System.in);
        IntakeNode current = first;
        while (current != null) {
            if(current.getIntake().getName().equals(intakeName)) {
                System.out.println("Nuevo nombre de [" + intakeName + "]");
                String newName = userInput.nextLine();
                current.getIntake().setName(newName);
                return;
            }
            current = current.getNext();
        }
        System.out.println("Ingesta no encontrada");
    }

    public void printIntakeListing() {
        System.out.println(this.toString());
    }

    public void createDay() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("Nombre de la ingesta (-1 para terminar)");
            String dayName = userInput.nextLine();
            if (dayName.equals("-1")) {
                creating = !creating;
            } else {
                Intake intake = new Intake(dayName);
                intake.createIntake();
                addIntake(intake);
            }
        }
    }

    public void deleteDay() {
        boolean deleting = true;
        Scanner userInput = new Scanner(System.in);
        while (deleting) {
            System.out.println("Nombre de la ingesta a eliminar (-1 para terminar)");
            String dayName = userInput.nextLine();
            if (dayName.equals("-1")) {
                deleting = !deleting;
            } else {
                deleteIntake(dayName);
            }
        }
    }

    public void editDay() {
        boolean editing = true;
        Scanner userInput = new Scanner(System.in);
        while (editing) {
            System.out.println("Nombre de la ingesta a editar (-1 para terminar)");
            String dayName = userInput.nextLine();
            if (dayName.equals("-1")) {
                editing = !editing;
            } else {
                editIntake(dayName);
            }
        }
    }

    public void deleteAll() {
        System.out.println("Eliminando todas las ingestas");
        first = null;
    }

    @Override
    public String toString() {
        String result = "]> " + name + "\n";
        IntakeNode current = first;
        while (current != null) {
            result += current.getIntake().toString() + "\n";
            current = current.getNext();
        }
        return result;
    }

    public static void main(String[] args) {

        Day monday = new Day("Lunes");
        monday.createDay();
        monday.printIntakeListing();
        System.out.println();
        monday.deleteDay();
        monday.printIntakeListing();
        System.out.println();
        monday.editDay();
        monday.printIntakeListing();
        System.out.println();
        monday.deleteAll();
        monday.printIntakeListing();

    }
}