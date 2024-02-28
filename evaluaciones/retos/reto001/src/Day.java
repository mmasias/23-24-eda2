import java.util.Scanner;

public class Day {
     private IntakeNode first;
     private String name;
     Scanner userInput = new Scanner(System.in);

    public Day(String name) {
        first = null;
        this.name = name;
    }

    public String getDayName() {
        return name;
    }

    public void setDayName(String name) {
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

    public void printIntakeListing() {
        System.out.println(this.toString());
    }

    public void createIntakes() {
        boolean creating = true;
        while (creating) {
            System.out.println("Nombre de la ingesta (-1 para terminar)");
            String intakeName = userInput.nextLine();
            if (intakeName.equals("-1")) {
                creating = !creating;
            } else {
                Intake intake = new Intake(intakeName);
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
        Scanner userInput = new Scanner(System.in);

        System.out.println("Introduce el nombre del día: ");
        String dayName = userInput.nextLine();

        Day day = new Day(dayName);
        day.createIntakes();
        day.printIntakeListing();
        day.deleteIntakes();
        day.updateIntakes();
    }
}
