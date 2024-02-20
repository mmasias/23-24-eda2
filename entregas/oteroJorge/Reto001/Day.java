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

    public void deleteIntake(String intakeName) {
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

    public void editIntake(String intakeName) {
        deleteIntake(intakeName);
        System.out.println("Nuevo nombre de la ingesta");
        Scanner userInput = new Scanner(System.in);
        String newName = userInput.nextLine();
        Intake newIntake = new Intake(newName);
        addIntake(newIntake);
        
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
        System.out.println("Nombre de la ingesta a editar");
        Scanner userInput = new Scanner(System.in);
        String dayName = userInput.nextLine();
        editIntake(dayName);
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

    }
}