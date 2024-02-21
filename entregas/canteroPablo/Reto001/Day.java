import java.util.Scanner;

public class Day {
    private IntakeNode first;
    private IntakeNode last; 
    private String name;
    private static Scanner userInput = new Scanner(System.in); 
    public Day(String name) {
        this.first = null;
        this.last = null; 
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
            first = last = newIntakeNode;
        } else {
            last.setNext(newIntakeNode);
            last = newIntakeNode;
        }
    }

    public void deleteIntake(String intakeName) {
        IntakeNode current = first;
        IntakeNode previous = null;
        while (current != null && !current.getIntake().getName().equals(intakeName)) {
            previous = current;
            current = current.getNext();
        }
        if (current == first) {
            first = first.getNext();
            if (first == null) last = null; 
        } else if (current != null) {
            previous.setNext(current.getNext());
            if (current == last) last = previous; 
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
        StringBuilder result = new StringBuilder("]> " + name + "\n");
        IntakeNode current = first;
        while (current != null) {
            result.append(current.getIntake().toString()).append("\n");
            current = current.getNext();
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Day monday = new Day("Sunday");
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
