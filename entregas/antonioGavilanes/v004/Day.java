package antonioGavilanes.v004;

import java.util.Scanner;

class Day {

    private String name;
    private IntakeNode first;

    public Day(String name) {
        this.name = name;
        this.first = null;
    }

    private void addIntake(Intake intake) {
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

    private void createIntake() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("Creando ingestas del " + this.name);
            System.out.println("Nombre de la ingesta (-1 para terminar)");
            String intakeName = userInput.nextLine();
            if (intakeName.equals("-1")) {
                creating = !creating;
            } else {
                Intake intake = new Intake(intakeName + " del " + this.name);
                intake.manage();
                addIntake(intake);
            }
        }
    }

    private void editIntake() {
        boolean editing = true;
        Scanner userInput = new Scanner(System.in);
        while (editing) {
            System.out.println("Nombre de la ingesta a editar (-1 para terminar)");
            String intakeName = userInput.nextLine();
            if (intakeName.equals("-1")) {
                editing = !editing;
            } else {
                editIntake(intakeName);
            }
        }
    }

    private void editIntake(String intakeName) {
        Scanner userInput = new Scanner(System.in);
        IntakeNode current = first;
        while (current != null) {
            if (current.getIntake().getName().equals(intakeName)) {
                current.getIntake().manage();
                return;
            }
            current = current.getNext();
        }
        System.out.println("Ingesta no encontrada");
    }

    private void deleteIntake() {
        Scanner userInput = new Scanner(System.in);
        boolean deleting = true;
        while (deleting) {
            System.out.println("Nombre de la ingesta por eliminar (-1 para terminar)");
            String intakeName = userInput.nextLine();
            if (intakeName.equals("-1")) {
                deleting = !deleting;
            } else {
                removeIntake(intakeName);
            }
        }
    }

    private void removeIntake(String intakeName) {
        if (first.getIntake().getName().equals(intakeName)) {
            first = first.getNext();
            return;
        } else {
            IntakeNode current = first;
            while (current.getNext() != null && !current.getNext().getIntake().getName().equals(intakeName)) {
                current = current.getNext();
            }
            if (current.getNext() != null) {
                current.setNext(current.getNext().getNext());
            }
        }
    }

    private void renameDay() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nuevo nombre de [" + this.name + "]");
        String newName = userInput.nextLine();
        this.name = newName;
    }

    public void startManagement() {
        manage();
    }

    public void manage() {
        boolean managing = true;
        Scanner userInput = new Scanner(System.in);
        char userOption = ' ';
        do {
            System.out.println("Gestionando [" + this.name.toUpperCase() + "]");
            System.out.println("[C]reate / [R]ead / Re[N]ame  / [U]pdate / [D]elete / e[X]it");
            String input = userInput.nextLine();
            if (input.isEmpty()) {
                System.out.println("No se ha ingresado ninguna opción. Inténtelo de nuevo.");
                continue;
            }
            userOption = input.toUpperCase().charAt(0);
            switch (userOption) {
                case 'C':
                    createIntake();
                    break;
                case 'R':
                    System.out.println(this.toString());
                    break;
                case 'U':
                    editIntake();
                    break;
                case 'N':
                    renameDay();
                    break;
                case 'D':
                    deleteIntake();
                    break;
                case 'X':
                    managing = !managing;
                    break;
                default:
                    System.out.println("El carácter ingresado no es CRUD.");
                    break;
            }
        } while (managing);

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
        Day monday = new Day("Lunes");
        monday.startManagement();
        System.out.println(monday.toString());
    }

    public String getName() {
        return this.name;
    }

    public IntakeNode getFirst() {
        return this.first;
    }
}
