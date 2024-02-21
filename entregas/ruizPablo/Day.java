import java.util.Scanner;

class Day {
    private IntakeNode first; // Nodo que almacena la primera ingesta del día

    public Day() {
        first = null;
    }

    // Añadir una nueva ingesta al final de la lista de ingestas del día
    public void addIntake(Intake intake) {
        IntakeNode newIntakeNode = new IntakeNode(intake);
        if (first == null) {
            // Si la lista está vacía el nuevo nodo se convierte en el primer nodo
            first = newIntakeNode;
        } else {
            // Si la lista no está vacía agrega el nuevo nodo al final
            IntakeNode current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newIntakeNode);
        }
    }

    // Imprimir la lista de ingestas del día
    public void printIntakeListing() {
        System.out.println(this.toString());
    }

    // Crear nuevas ingestas a partir de la entrada del usuario
    @SuppressWarnings("resource")
    public void createIntakes() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("Nombre de la ingesta (-1 para terminar)");
            String dayName = userInput.nextLine();
            if (dayName.equals("-1")) {
                creating = !creating; // Se sale del bucle si el usuario ingresa "-1"
            } else {
                Intake intake = new Intake();
                intake.createIntake();
                addIntake(intake); // Se agrega la nueva ingesta a la lista del día
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
        monday.createIntakes(); // Solicita al usuario que ingrese las ingestas del día
        monday.printIntakeListing(); // Imprime la lista de ingestas del día
    }
}
