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
        if (first == null) {
            System.out.println("No hay Ingestas registradas");
            return;
        } else {
        System.out.println(this.toString());
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
                intake.setName(intakeName);
                intake.createIntake();
                addIntake(intake);
            }
        }
    }

    public void editDay() {
        boolean isEditing = true;
    Scanner QueEditar = new Scanner(System.in);
    while (isEditing) {
        System.out.println("¿Qué ingesta desea editar? (-1 para salir)");
        String intakeName = QueEditar.nextLine();
        if (intakeName.equals("-1")) {
            isEditing = false;
        } else {
            editSpecificIntake(intakeName);
        }
    }
}

public void editSpecificIntake(String intakeName) {
    IntakeNode current = first;
    while (current != null) {
        if (current.getIntake().getName().equals(intakeName)) {
            System.out.println("Editando la ingesta: " + intakeName);
            current.getIntake().editIntake();
            return;
        }
        current = current.getNext();
    }
    System.out.println("Ingesta no encontrada");
}


    public void deleteDay() {
        Scanner confirmación = new Scanner(System.in);
        System.out.println("¿Estás seguro de que quieres eliminar el día? (s/n)");
        if (confirmación.nextLine().equals("s")) {
            first = null;
        } else{}
        return;
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
        Boolean Editing = true;
        while (Editing){
        System.out.println("Estás en el registro de Días");
        System.out.println("¿Que desea hacer?");
        System.out.println("1 Crear un día");
        System.out.println("2 Leer el día");
        System.out.println("3 Editar un día");
        System.out.println("4 Eliminar un día");
        System.out.println("Para Salir introduzca [-1]");
        Scanner userInput = new Scanner(System.in);
        String option = userInput.nextLine();
        switch (option) {
            case "1":
                System.out.println("Creando Día");
                monday.createIntakes();
                monday.printIntakeListing();
                break;
            case "2":
                System.out.println("Mostrando Día");
                monday.printIntakeListing();
                break;
            case "3":
                System.out.println("Editando Día");
                monday.editDay();
                monday.printIntakeListing();
                break;
            case "4":
                System.out.println("Eliminando Día");
                monday.deleteDay();
                monday.printIntakeListing();
                break;
            case "-1":
                System.out.println("Saliendo");
                Editing = false;
                System.out.println("Esto es el día que has registrado:");
                monday.printIntakeListing();
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
        
    }
        
    }
}