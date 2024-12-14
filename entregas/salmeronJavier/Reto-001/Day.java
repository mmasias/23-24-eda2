import java.util.Scanner;

class Day {
    private IntakeNode first;
    private String identifier;

    public Day(String identifier) {
        this.first = null;
        this.identifier = identifier;
    }

    public void addIntake(Intake intake) {
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

    public Intake findIntake(String identifier) {
        IntakeNode current = first;
        while (current != null) {
            if (current.getIntake().getIdentifier().equals(identifier)) {
                return current.getIntake();
            }
            current = current.getNext();
        }
        return null;
    }

    public boolean updateIntake(String identifier, String newDetail) {
        IntakeNode current = first;
        while (current != null) {
            if (current.getIntake().getIdentifier().equals(identifier)) {
                current.getIntake().updateDetails(newDetail);
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public boolean deleteIntake(String identifier) {
        if (first == null)
            return false;

        if (first.getIntake().getIdentifier().equals(identifier)) {
            first = first.getNext();
            return true;
        }

        IntakeNode current = first;
        while (current.getNext() != null) {
            if (current.getNext().getIntake().getIdentifier().equals(identifier)) {
                current.setNext(current.getNext().getNext());
                return true;
            }
            current = current.getNext();
        }
        return false;
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
        IntakeNode current = first;
        while (current != null) {
            intakeListing.append(current.getIntake().toString()).append("\n");
            current = current.getNext();
        }
        return intakeListing.toString();
    }
}
