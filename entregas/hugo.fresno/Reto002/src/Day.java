import java.util.ArrayList;
import java.util.Scanner;

public class Day {
    private ArrayList<Intake> intakeList;
    private String name;

    public Day(String name) {
        this.intakeList = new ArrayList<>();
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addIntake(Intake intake) {
        intakeList.add(intake);
    }

    public void createIntakes() {
        Scanner userInput = new Scanner(System.in);
        while (true) {
            System.out.println("Nombre de la ingesta (-1 para terminar):");
            String intakeName = userInput.nextLine();
            if (intakeName.equals("-1")) {
                break;
            } else {
                Intake intake = new Intake(intakeName);
                intake.createIntake();
                addIntake(intake);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder intakeListing = new StringBuilder("Día: " + name + "\n");
        if (intakeList.isEmpty()) {
            intakeListing.append("  Sin ingestas registradas.\n");
        } else {
            for (Intake intake : intakeList) {
                intakeListing.append(intake).append("\n");
            }
        }
        return intakeListing.toString();
    }
}
