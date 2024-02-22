import java.util.Scanner;

public class Day {
     private IntakeNode first;

    public Day() {
        first = null;
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
                Intake intake = new Intake(intakeName);
                intake.createIntake();
                addIntake(intake);
            }
        }
    }

    private void updateIntake(String oldIntakeName, String newIntakeName) {
        IntakeNode current = first;
        while(current != null) {
            if (current.getIntake().getIntakeName().equals(oldIntakeName)) {
                current.getIntake().setIntakeName(newIntakeName);;
            }
            current = current.getNext();
        }
    }

    public void updateIntakes() {
        boolean updating = true;
        Scanner userInput = new Scanner(System.in);

        while (updating) {
            System.out.println("Nombre del intake a editar (-1 para terminar)");
            String oldIntake = userInput.nextLine();
            if (oldIntake.equals("-1")) {
                updating = !updating;
            } else {
                System.out.println("Nuevo nombre del intake: ");
                String newIntake = userInput.nextLine();
                updateIntake(oldIntake, newIntake);
            }
        }
    }

    private void removeIntake(String intakeName) {
        if(first.getIntake().getIntakeName().equals(intakeName)) {
            first = first.getNext();
        } else {
            IntakeNode current = first;
            while(current.getNext() != null) {
                current = current.getNext();
            }
        }
    }

    public void deleteIntakes() {
        boolean deleting = true;
        Scanner userInput = new Scanner(System.in);

        while(deleting) {
            System.out.println("Introduzca el Intake a eliminar (-1 para termianr)");
            String intakeName = userInput.nextLine();

            if (intakeName.equals("-1")) {
                deleting = !deleting;
            } else {
                removeIntake(intakeName);
            }
        }
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
