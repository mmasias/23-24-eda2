package entregas.garciaLydia.reto001;

public class Day {
    private IntakeNode first;

    public Day() {
        first = null;
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

    public void updateIntake(Intake intake, int index) {
        IntakeNode current = first;
        int count = 0;
        while (current != null) {
            if (count == index) {
                current.setIntake(intake);
                break;
            }
            current = current.getNext();
            count++;
        }
    }

    public void deleteIntake(int index) {
        if (index == 0) {
            first = first.getNext();
        } else {
            IntakeNode current = first;
            int count = 0;
            while (current != null) {
                if (count == index - 1) {
                    current.setNext(current.getNext().getNext());
                    break;
                }
                current = current.getNext();
                count++;
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
}
