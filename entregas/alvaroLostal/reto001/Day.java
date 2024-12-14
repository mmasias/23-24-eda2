import java.util.Scanner;

public class Day {
    private IntakeNode first;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
            String intakeName = userInput.nextLine();
            if (intakeName.equals("-1")) {
                creating = false;
            } else {
                Intake intake = new Intake();
                intake.setName(intakeName);
                intake.createIntake();
                addIntake(intake);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder intakeListing = new StringBuilder();
        IntakeNode current = first;
        while (current != null) {
            intakeListing.append(current.getIntake().toString()).append("\n");
            current = current.getNext();
        }
        return intakeListing.toString();
    }
}
