import java.util.Scanner;

public class Day {
     private IntakeNode firstIntake;
     public String name;

    public Day() {
        firstIntake = null;
    }

    public void addIntake(Intake intake) {
        IntakeNode newIntakeNode = new IntakeNode(intake);
        if (firstIntake == null) {
            firstIntake = newIntakeNode;
        } else {
            IntakeNode current = firstIntake;
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
            System.out.println("Intake name (-1 to end)\n");
            String dayName = userInput.nextLine();
            Intake intake = new Intake();
            intake.name = dayName;
            if (dayName.equals("-1")) {
                creating = !creating;
            } else {
                intake.createIntake();
                addIntake(intake);
                System.out.println("Intake created\n");
            }
        }
    }

    public IntakeNode findIntakeNode(String intakeName) {
        IntakeNode current = firstIntake;
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
        System.out.println("Write the inteke you want to edit:\n");
        String intakeName = userInput.nextLine();
        IntakeNode intakeNode = findIntakeNode(intakeName);
        if (intakeNode != null) {
            intakeNode.getIntake().editIntake();
            System.out.println("Ingesta editada\n");
        }
    }

    public void deleteIntake(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Write the inteke you want to delete:\n");
        String intakeName = userInput.nextLine();
        IntakeNode intakeToDelete = findIntakeNode(intakeName);
        if (intakeToDelete != null) {
            IntakeNode previous = null;
            IntakeNode currentNode = firstIntake;
            while (currentNode != null && currentNode != intakeToDelete) {
                previous = currentNode;
                currentNode = currentNode.getNext();
            }
            if (previous == null) {
                firstIntake = intakeToDelete.getNext();
            } else {
                previous.setNext(intakeToDelete.getNext());
            }
            System.out.println("La ingesta se eliminó\n");
        }
    }

    @Override
    public String toString() {
        String intakeListing = "Ingesta:\n";
        IntakeNode current = firstIntake;
        while (current != null) {
            intakeListing = intakeListing + current.getIntake().toString() + "\n";
            current = current.getNext();
        }
        return intakeListing;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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
