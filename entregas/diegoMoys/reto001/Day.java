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
            System.out.println("Nombre de la ingesta (-1 para terminar)\n");
            String dayName = userInput.nextLine();
            Intake intake = new Intake();
            intake.name = dayName;
            if (dayName.equals("-1")) {
                creating = !creating;
            } else {
                intake.createIntake();
                addIntake(intake);
                System.out.println("Ingesta creada\n");
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
        System.out.println("La ingesta no existe\n");
        return null;
    }

    public void editIntake(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Ingrese la ingesta que desea editar\n");
        String intakeName = userInput.nextLine();
        IntakeNode intakeNode = findIntakeNode(intakeName);
        if (intakeNode != null) {
            intakeNode.getIntake().editIntake();
            System.out.println("Ingesta editada\n");
        }
    }

    public void deleteIntake(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Ingrese la ingesta que desea eliminar\n");
        String intakeName = userInput.nextLine();
        IntakeNode current = findIntakeNode(intakeName);
        if (current != null) {
            IntakeNode previous = null;
            IntakeNode temp = first;
            while (temp != null && temp != current) {
                previous = temp;
                temp = temp.getNext();
            }
            if (previous == null) {
                first = current.getNext();
            } else {
                previous.setNext(current.getNext());
            }
            System.out.println("La ingesta se eliminó\n");
        }
    }

    @Override
    public String toString() {
        String intakeListing = "Ingesta:\n";
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
        newDay.deleteIntake();
        newDay.printIntakeListing();
    }
}
