import java.util.Scanner;

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

    public void editIntake(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre de la ingesta a editar: ");
        String intakeName = userInput.nextLine();
        IntakeNode current = first;
        while (current != null) {
            if (current.getIntake().equals(intakeName)) {
                current.getIntake().editIntake();
                return;
            }
            current = current.getNext();
        }
        System.out.println("No se encontro la ingesta");
    }

    public void deleteIntake(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre de la ingesta a eliminar: ");
        String intakeName = userInput.nextLine();
        IntakeNode current = first;
        IntakeNode previous = null;
        while (current != null) {
            if (current.getIntake().equals(intakeName)) {
                if (previous == null) {
                    first = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                return;
            }
            previous = current;
            current = current.getNext();
        }
        System.out.println("Ingesta eliminada");
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