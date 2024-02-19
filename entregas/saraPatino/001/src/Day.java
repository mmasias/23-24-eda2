package src;

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
                intake.menu();
                addIntake(intake);
            }
        }
    }

    public void deleteIntake() {
        Scanner userInput = new Scanner(System.in);
        if (first == null) {
            System.out.println("La lista de ingestas está vacía.");
            return;
        }

        System.out.println("Que ingesta deseas eliminar?");
        String foodName = userInput.nextLine();
        boolean found = false;
        
        if (first.getIntake().toString().equals(foodName)) {
            first = first.getNext();
            found = true;
            return;
        }

        IntakeNode current = first;
        IntakeNode previous = null;

        while (current != null) {
            if (current.getIntake().toString().equals(foodName)) {
                previous.setNext(current.getNext());
                found = true;
                return;
            }
            previous = current;
            current = current.getNext();
        }
        if(found = false) {
            System.out.println("No se encontró la ingesta a eliminar.");
        }
    }

    private void deleteAllIntakes() {
        first = null;
        System.out.println("\nTodos las ingestas han sido eliminados con exito!");
    }

    public void updateIntake() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Que alimento deseas actualizar?");
        String name = userInput.nextLine();


        IntakeNode current = first;

        boolean found = false; 
        while (current != null) {
            if (current.getIntake().toString().equals(name)) {
                current.getIntake().createIntake();
                found = true;
                return;
            }
            current = current.getNext();
        }

        if(found = false) {
            System.out.println("No se encontró el alimento a actualizar.");
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

    public void menu() {
        Scanner userInput = new Scanner(System.in);
        boolean finish = false;
        System.out.println(">>OPCIONES DIA<< \n");
        while (finish == false) {
            System.out.println("1. Agregar");
            System.out.println("2. Eliminar");
            System.out.println("3. Modificar");
            System.out.println("4. Mostrar");
            System.out.println("5. Eliminar todo");
            System.out.println("6. Salir");
            int option = userInput.nextInt();
            switch (option) {
                case 1:
                    createIntakes();
                    break;
                case 2:
                    deleteIntake();
                    break;
                case 3:
                    updateIntake();
                    break;
                case 4:
                    printIntakeListing();
                    break;
                case 5:
                    deleteAllIntakes();
                    break;
                case 6:
                    finish = true;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

    public static void main(String[] args) {

        Day monday = new Day();
        monday.menu();
    }
}
