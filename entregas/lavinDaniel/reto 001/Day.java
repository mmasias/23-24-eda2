class Day {
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

    public static void main(String[] args) {
        Day monday = new Day();
        Intake breakfast = new Intake();
        breakfast.addFood(new Food("Eggs"));
        breakfast.addFood(new Food("Bacon"));
        breakfast.addFood(new Food("Toast"));
        monday.addIntake(breakfast);
        System.out.println("Before update and delete:");
        System.out.println(monday.toString());

        Intake lunch = new Intake();
        lunch.addFood(new Food("Sandwich"));
        lunch.addFood(new Food("Chips"));
        lunch.addFood(new Food("Apple"));
        monday.updateIntake(lunch, 0);
        System.out.println("After update:");
        System.out.println(monday.toString());

        monday.deleteIntake(0);
        System.out.println("After delete:");
        System.out.println(monday.toString());
    }
}