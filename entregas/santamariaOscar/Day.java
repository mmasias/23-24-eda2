import java.util.ArrayList;
import java.util.Scanner;

class Day {
    private ArrayList<Intake> intakes;

    public Day() {
        intakes = new ArrayList<>();
    }

    public void addIntake(Intake intake) {
        intakes.add(intake);
    }

    public void printIntakeListing() {
        for (Intake intake : intakes) {
            System.out.println(intake);
        }
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
                intake.createIntake();
                addIntake(intake);
            }
        }
        userInput.close();
    }

    public boolean updateIntake(int position, Intake newIntake) {
        if (position >= 0 && position < intakes.size()) {
            intakes.set(position, newIntake);
            return true;
        }
        return false;
    }

    public boolean deleteIntake(int position) {
        if (position >= 0 && position < intakes.size()) {
            intakes.remove(position);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Day monday = new Day();
        monday.createIntakes();
        monday.printIntakeListing();
    }
}
