package vEDA.v003;
import java.util.Scanner;

class Day {
    private IntakeNode first;
    private String name;

    public Day(String name) {
        this.name = name;
        first = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        IntakeNode current = first;
        while (current != null) {
            System.out.println("Ingesta: " + current.getIntake().getName());
            System.out.println("Alimentos:");
            current.getIntake().printFoodListing(); 
            current = current.getNext();
        }
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
                intake.setName(intakeName); // Establecer el nombre del Intake
                intake.createIntake();
                addIntake(intake);
            }
        }
    }

    

    public void updateIntake(String oldName, String newName) {
        IntakeNode current = first;
        while (current != null) {
            if (current.getIntake().getName().equals(oldName)) {
                current.getIntake().setName(newName);
                System.out.println("Ingesta actualizada exitosamente.");
                return;
            }
            current = current.getNext();
        }
        System.out.println("No se encontró la ingesta con el nombre proporcionado.");
    }

    

    public void deleteIntake(String name) {
        if (first == null) {
            System.out.println("La lista de ingestas está vacía.");
            return;
        }
        if (first.getIntake().getName().equals(name)) {
            first = first.getNext();
            System.out.println("Ingesta eliminada exitosamente.");
            return;
        }
        IntakeNode previous = first;
        IntakeNode current = first.getNext();
        while (current != null) {
            if (current.getIntake().getName().equals(name)) {
                previous.setNext(current.getNext());
                System.out.println("Ingesta eliminada exitosamente.");
                return;
            }
            previous = current;
            current = current.getNext();
        }
        System.out.println("No se encontró la ingesta con el nombre proporcionado.");
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

        Day monday = new Day("Monday");
        monday.createIntakes();
        monday.printIntakeListing();

        
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n¿Desea actualizar o eliminar alguna ingesta? (A/E/N)");
        String option = scanner.nextLine().toUpperCase();

        
        switch (option) {
            case "A":
                System.out.println("Ingrese el nombre de la ingesta que desea actualizar: ");
                String oldName = scanner.nextLine();
                System.out.println("Ingrese el nuevo nombre de la ingesta: ");
                String newName = scanner.nextLine();
                monday.updateIntake(oldName, newName);
                monday.printIntakeListing();
                break;
            case "E":
                System.out.println("Ingrese el nombre de la ingesta que desea eliminar: ");
                String nameToDelete = scanner.nextLine();
                monday.deleteIntake(nameToDelete);
                monday.printIntakeListing();
                break;
            default:
                System.out.println("Operación no reconocida.");
                break;
        }

        scanner.close();
    }
}
