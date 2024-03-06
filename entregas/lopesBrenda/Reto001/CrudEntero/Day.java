package entregas.lopesBrenda.Reto001.CrudEntero;

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
        while (current != null) {
            if(current.getIntake().getName().equals(intakeName)) {
                if (previous == null) {
                    first = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                break;
            }
            previous = current;
            current = current.getNext();
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
            String dayName = userInput.nextLine();
            if (dayName.equals("-1")) {
                creating = !creating;
            } else {
                Intake intake = new Intake(name);
                intake.createIntake();
                addIntake(intake);
            }
        }
    }

    public void createDay() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {

            System.out.println("Nombre de la ingesta (-1 para terminar)");
            String name = userInput.nextLine();
            if (name.equals("-1")) {
                creating = !creating;
            } else {
                Intake ingesta = new Intake(name);
                addIntake(ingesta);
            }
        }
    }

    public void updateDay() {
        System.out.println("Que ingesta desea editar");
        Scanner userInput = new Scanner(System.in);
        String name = userInput.nextLine();
        updateIntake(name);
    }

    public void updateIntake (String intake) {
        deleteIntake(intake);
        System.out.println("Nuevo nombre para la ingesta \n");
        Scanner userInput = new Scanner(System.in);
        String n = userInput.nextLine();
        Intake ingesta = new Intake(n);
        addIntake(ingesta);

    }

    public void deleteDay() {
        setName("Día eliminado");
        System.out.println(getName());
        this.first = null;
    }
    
    @Override
    public String toString() {
        String intakeListing = "";
        IntakeNode current = first;
        while (current != null) {
            intakeListing = intakeListing + current.getIntake().toString() + "\n";
            current = current.getNext();
        }
        return intakeListing;
    }

    public static void main(String[] args) {

        Day monday = new Day("Monday");
        monday.createDay();
        monday.printIntakeListing();
        System.out.println();

        monday.updateDay();
        monday.printIntakeListing();
        System.out.println("Nombre modificado");

        monday.deleteDay();
        monday.printIntakeListing();
        System.out.println();
    }
}