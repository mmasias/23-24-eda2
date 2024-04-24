import java.util.ArrayList;
import java.util.Scanner;

public class Day {
    private ArrayList<Intake> intakes;
    private String name;

    public Day() {
        intakes = new ArrayList<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addIntake(Intake intake) {
        intakes.add(intake);
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
        String intakeListing = name+"\n";
        for (Intake intake : intakes) {
            intakeListing += intake.toString() + "\n";
        }
        return intakeListing.toString();
    }
}
