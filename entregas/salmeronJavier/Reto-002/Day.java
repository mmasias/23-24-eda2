import java.util.ArrayList;

class Day {
    private ArrayList<Intake> intakes;
    private String identifier;

    public Day(String identifier) {
        this.intakes = new ArrayList<>();
        this.identifier = identifier;
    }

    public void addIntake(Intake intake) {
        intakes.add(intake);
    }

    public Intake findIntake(String identifier) {
        for (Intake intake : intakes) {
            if (intake.getIdentifier().equals(identifier)) {
                return intake;
            }
        }
        return null;
    }

    public boolean updateIntake(String identifier, String newDetail) {
        for (Intake intake : intakes) {
            if (intake.getIdentifier().equals(identifier)) {
                intake.updateDetails(newDetail);
                return true;
            }
        }
        return false;
    }

    public boolean deleteIntake(String identifier) {
        return intakes.removeIf(intake -> intake.getIdentifier().equals(identifier));
    }

    public void printIntakeListing() {
        System.out.println(this.toString());
    }

    public String getIdentifier() {
        return identifier;
    }

    public void updateIdentifier(String newIdentifier) {
        this.identifier = newIdentifier;
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
