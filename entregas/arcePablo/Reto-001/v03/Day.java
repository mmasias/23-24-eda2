package v03;
import java.util.Scanner;

public class Day {
    private IntakeNode first;

    public Day() {
        first = null;
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
            String dayName = userInput.nextLine();
            if (dayName.equals("-1")) {
                creating = false;
            } else {
                Intake intake = new Intake();
                intake.createIntake();
                addIntake(intake);
            }
        }
    }
    
    public void deleteIntake(String name) {
        if (first == null) {
            System.out.println("La lista de ingestas está vacía.");
            return;
        }

        if (first.getIntake().toString().equals(name)) {
            first = first.getNext();
            System.out.println("Se eliminó la ingesta con éxito.");
            return;
        }

        IntakeNode prev = first;
        IntakeNode current = first.getNext();
        while (current != null) {
            if (current.getIntake().toString().equals(name)) {
                prev.setNext(current.getNext());
                System.out.println("Se eliminó la ingesta con éxito.");
                return;
            }
            prev = current;
            current = current.getNext();
        }

        System.out.println("No se encontró la ingesta con el nombre proporcionado.");
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
        Day monday = new Day();
        monday.createIntakes();
        monday.printIntakeListing();
    }
}
