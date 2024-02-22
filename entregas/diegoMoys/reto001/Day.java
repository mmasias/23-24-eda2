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
                creating = !creating;
            } else {
                Intake intake = new Intake();
                intake.createIntake();
                addIntake(intake);
            }
        }
    }

    public IntakeNode findIntakeNode(String intakeName) {
        IntakeNode current = first;
        while (current != null) {
            if (current.getIntake().getName().equals(intakeName)) {
                return current;
            }
            current = current.getNext();
        }
        System.out.println("La ingesta no existe");
        return null;
    }

    public void editIntake(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Ingrese la ingesta que desea editar");
        String intakeName = userInput.nextLine();
        IntakeNode intakeNode = findIntakeNode(intakeName);
        if (intakeNode != null) {
            intakeNode.getIntake().editIntake();
        }
    }

    @Override
    public String toString() {
        String intakeListing = "Ingesta\n";
        IntakeNode current = first;
        while (current != null) {
            intakeListing = intakeListing + current.getIntake().toString() + "\n";
            current = current.getNext();
        }
        return intakeListing;
    }

    public static void main(String[] args) {

        Day newDay = new Day();
        newDay.createIntakes();
        newDay.printIntakeListing();
        newDay.editIntake();
        newDay.printIntakeListing();
    }
}
