package vEDA.v003;
import java.util.Scanner;

class Diet {
    private DayNode first;

    public Diet() {
        first = null;
    }

    public void addDay(Day day){
        DayNode newDayNode = new DayNode(day);
        if (first == null){
            first = newDayNode;
        } else {
            DayNode current = first;
            while(current.getNext()!=null){
                current = current.getNext();
            }
            current.setNext(newDayNode);
        }
    }

    public void printDayListing(){
        DayNode current = first;
        while (current != null) {
            System.out.println("Día: " + current.getDay().getName());
            current.getDay().printIntakeListing(); 
            System.out.println(); 
            current = current.getNext();
        }
    }

    public void createDays() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while(creating){
            System.out.println("Nombre del día (-1 para terminar)");
            String dayName = userInput.nextLine();
            if(dayName.equals("-1")) {
                creating=!creating;
            } else {
                Day day = new Day(dayName); 
                day.createIntakes();
                addDay(day);
            }
        }        
    }

    public void updateDay(String oldName, String newName) {
        DayNode current = first;
        while (current != null) {
            if (current.getDay().getName().equals(oldName)) {
                current.getDay().setName(newName);
                System.out.println("Día actualizado exitosamente.");
                return;
            }
            current = current.getNext();
        }
        System.out.println("No se encontró el día con el nombre proporcionado.");
    }

    public void deleteDay(String name) {
        if (first == null) {
            System.out.println("La lista de días está vacía.");
            return;
        }
        if (first.getDay().getName().equals(name)) {
            first = first.getNext();
            System.out.println("Día eliminado exitosamente.");
            return;
        }
        DayNode previous = first;
        DayNode current = first.getNext();
        while (current != null) {
            if (current.getDay().getName().equals(name)) {
                previous.setNext(current.getNext());
                System.out.println("Día eliminado exitosamente.");
                return;
            }
            previous = current;
            current = current.getNext();
        }
        System.out.println("No se encontró el día con el nombre proporcionado.");
    }

    @Override
    public String toString() {
        String daysListing = "";
        DayNode current = first;
        while (current != null) {
            daysListing = daysListing + current.getDay().toString() + "\n";
            current = current.getNext();
        }

        return daysListing;
    }    

    public static void main(String[] args) {

        Diet diet = new Diet();
        diet.createDays();
        diet.printDayListing();

        // Solicitar al usuario que elija la operación
        Scanner scanner = new Scanner(System.in);
        System.out.println("\n¿Desea actualizar o eliminar algún día? (A/E/N)");
        String option = scanner.nextLine().toUpperCase();

        // Realizar la operación seleccionada
        switch (option) {
            case "A":
                System.out.println("Ingrese el nombre del día que desea actualizar: ");
                String oldName = scanner.nextLine();
                System.out.println("Ingrese el nuevo nombre del día: ");
                String newName = scanner.nextLine();
                diet.updateDay(oldName, newName);
                diet.printDayListing();
                break;
            case "E":
                System.out.println("Ingrese el nombre del día que desea eliminar: ");
                String nameToDelete = scanner.nextLine();
                diet.deleteDay(nameToDelete);
                diet.printDayListing();
                break;
            default:
                System.out.println("Operación no reconocida.");
                break;
        }

        scanner.close();
    }      
}
