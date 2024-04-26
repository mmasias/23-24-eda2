package entregas.garciaLydia.reto002;

import java.util.ArrayList;

public class Day {
    private ArrayList<Intake> intakes;

    public Day() {
        intakes = new ArrayList<>();
    }

    public void addIntake(Intake intake) {
        intakes.add(intake);
    }

    public void updateIntake(Intake intake, int index) {
        if (index >= 0 && index < intakes.size()) {
            intakes.set(index, intake);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    public void deleteIntake(int index) {
        if (index >= 0 && index < intakes.size()) {
            intakes.remove(index);
        } else {
            System.out.println("Índice inválido.");
        }
    }

    @Override
    public String toString() {
        StringBuilder intakeListing = new StringBuilder();
        for (Intake intake : intakes) {
            intakeListing.append(intake.toString()).append("\n");
        }
        return intakeListing.toString();
    }
}