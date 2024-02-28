

import java.util.ArrayList;
import java.util.Scanner;

class Day {
    private ArrayList<Intake> x;

    public Day() {
        x=new ArrayList<>();

    }

    public void addIntake(Intake intake) {
        x.add(intake);

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
                Intake intake = new Intake();
                intake.createIntake();
                addIntake(intake);
            }
        }
    }

    @Override
    public String toString() {
        return x.toString();

    }

    public static void main(String[] args) {

        Day monday = new Day();
        monday.createIntakes();
        monday.printIntakeListing();
    }
}
