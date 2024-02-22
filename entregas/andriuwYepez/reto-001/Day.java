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
        System.out.println(this.toStringIntake());
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
                Intake intake = new Intake(intakeName);
                intake.createIntake();
                addIntake(intake);
            }
        }
    }

    public void deleteDayFunctionality(IntakeNode nodeToDelete) {
        if (nodeToDelete == null) {
            return;
        }
        
        IntakeNode previous = null;
        IntakeNode current = first;
        
        while (current != null && current != nodeToDelete) {
            previous = current;
            current = current.getNext();
        }
        
        if (current == null) {
            return;
        }
        

        if (previous != null) {
            previous.setNext(current.getNext());
        } else {
            first = current.getNext();
        }
    }

    public void editDayFunctionality(IntakeNode node) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Ingresa la nueva ingesta");
        String newIntakeName = userInput.nextLine();
        node.getIntake().setName(newIntakeName);
    }

    public void deleteAllDay(){
        first = null;
    }

    public void deleteDay() {
        boolean deleteDay = true;
        Scanner userInput = new Scanner(System.in);
        
        while (deleteDay) {
            System.out.println("1) Eliminar una ingesta");
            System.out.println("2) Eliminar todas las ingestas");
            System.out.println("3) Guardar Ingestas\n");
            String o = userInput.nextLine();
            
            if (o.equals("1")) {
                IntakeNode current = first;
                while (current != null) {
                    System.out.println("La ingesta actual es: " + current.getIntake().toStringIntake()); // crear un toString para intake
                    System.out.println("1) Eliminar");
                    System.out.println("2) Siguiente\n");
                    String optionDelete = userInput.nextLine();
    
                    if (optionDelete.equals("1")) {
                        System.out.println("Eliminando una ingesta");
                        deleteDayFunctionality(current);
                        break;
                    } else if (optionDelete.equals("2")) {
                        System.out.println("Siguiente ingesta\n");
                    }
                    current = current.getNext();
                }
            } else if (o.equals("2")) {
                System.out.println("Eliminando todas las ingestas");
                deleteAllDay();
            } else if (o.equals("3")) {
                deleteDay = false;
            }
        }
    }

    public void editDay() {
        boolean editing = true;
        Scanner userInput = new Scanner(System.in);
        
        while (editing) {
            System.out.println("1) Editar una ingesta");
            System.out.println("2) Guardar Ingestas\n");
            String o = userInput.nextLine();
            
            if (o.equals("1")) {
                IntakeNode current = first;
                while (current != null) {
                    System.out.println("La ingesta actual es: " + current.getIntake().toStringIntake());
                    System.out.println("1) Editar");
                    System.out.println("2) Siguiente\n");
                    String optionEditing = userInput.nextLine();
                    
                    if (optionEditing.equals("1")) {
                        System.out.println("Editando");
                        editDayFunctionality(current);
                    } else if (optionEditing.equals("2")) {
                        System.out.println("Guardado exitosamente!");
                    }
                    current = current.getNext();
                }
            } else if (o.equals("2")) {
                editing = false;
            }
        }
    }

    @Override
    public String toStringIntake() {
        String intakeListing = "";
        IntakeNode current = first;
        while (current != null) {
            intakeListing = intakeListing + current.getIntake().toStringIntake() + "\n";
            current = current.getNext();
        }
        return intakeListing;
    }

    public static void main(String[] args) {

        Day monday = new Day();
        monday.createIntakes();
        monday.editDay();
        monday.deleteDay();
        monday.printIntakeListing();
    }

    // un solo main
}