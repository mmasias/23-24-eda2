import java.util.ArrayList;
import java.util.Scanner;

public class Day {
    private String name;
    private ArrayList<Intake> intakes;
    Scanner userInput = new Scanner(System.in);

    public Day(String dayName) {
        this.name = name;
        intakes = new ArrayList<>();
    }

    public String getDayName() {
        return name;
    }

    public void setDayName(String name) {
        this.name = name;
    }

    public Intake searchIntake(String intakeName) {
        for(Intake i : intakes) {
            if(i.getIntakeName().equals(intakeName)) {
                return i;
            }
        }
        return null;
    }

    private void addIntake(Intake intake) {
        intakes.add(intake);
    }

    public void printIntakeListing() {
        System.out.println(this.toString());
    }

    public void createIntakes() {
        boolean creating = true;
        while (creating) {
            System.out.println("Nombre de la ingesta por crear (-1 para terminar)");
            String intakeName = userInput.nextLine();
            if (intakeName.equals("-1")) {
                creating = !creating;
            } else {
                Intake intake = new Intake(intakeName);
                addIntake(intake);
            }
        }
    }

    private void deleteIntake(String intakeName) {
        Intake intakeWanted = searchIntake(intakeName);
        intakes.remove(intakeWanted);
    }

    public void deleteIntakes() {
        boolean deleting = true;
        while (deleting) {
            System.out.println("Nombre de la ingesta por eliminar (-1 para terminar)");
            String intakeName = userInput.nextLine();

            if (intakeName.equals("-1")) {
                deleting = !deleting;
            } else {
                deleteIntake(intakeName);;
            }
        }
    }

    public void deletAllIntakes() {
        intakes.clear();
    }

    private void updateIntake(String oldName, String newName) {
        Intake intakeToEdit = searchIntake(oldName);
        intakeToEdit.setIntakeName(newName);
    }

    public void updateIntakes() {
        boolean updating = true;
        while(updating) {
            System.out.println("Nombre de la ingesta a editar (-1 para terminar): ");
            String oldName = userInput.nextLine();

            if (oldName.equals("-1")) {
                updating = !updating;
            } else {
                System.out.println("Nuevo nombre de la ingesta:" );
                String newName = userInput.nextLine();
                updateIntake(oldName, newName);
            }
        }

    }

    @Override
    public String toString() {
        StringBuilder intakeListing = new StringBuilder();
        for (Intake i : intakes) {
            intakeListing.append(i.toString()).append("\n");
        }

        return intakeListing.toString();
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Introduce el nombre del día: ");
        String dayName = userInput.nextLine();

        Day day = new Day(dayName);
        day.createIntakes();
        day.printIntakeListing();

        day.deleteIntakes();
        day.printIntakeListing();

        day.updateIntakes();
        day.printIntakeListing();
    }

}
