import java.util.Scanner;

public class Diet {
    private DayNode firstDay;

    public Diet() {
        firstDay = null;
    }

    public void addDay(Day day){
        DayNode newDayNode = new DayNode(day);
        if (firstDay == null){
            firstDay = newDayNode;
        } else {
            DayNode current = firstDay;
            while(current.getNext()!=null){
                current = current.getNext();
            }
            current.setNext(newDayNode);
        }
    }

    public DayNode findDayNode(String dayName) {
        DayNode currentNode = firstDay;
        while (currentNode != null) {
            if (currentNode.getDay().getName().equals(dayName)) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        System.out.println("El día no existe\n");
        return null;
    }

    public void printDayListing(){
        System.out.println(this.toString());
    }

    public void createDays() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while(creating){
            System.out.println("Nombre del dia (-1 para terminar)");
            String dayName = userInput.nextLine();
            Day day = new Day();
            day.name = dayName;
            if(dayName.equals("-1")) {
                creating=!creating;
            } else {
                day.createIntakes();
                addDay(day);
            }
        }        
    }

    public void editDay(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Ingrese el día que desea editar");
        String dayName = userInput.nextLine();
        DayNode dayNode = findDayNode(dayName);
        if (dayNode != null) {
            dayNode.getDay().editIntake();
            System.out.println("Día editado\n");
        }
    }

    public void deleteDay(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Ingrese el día que desea eliminar");
        String dayName = userInput.nextLine();
        DayNode dayToDelete = findDayNode(dayName);
        if (dayToDelete != null) {
            DayNode previous = null;
            DayNode currentNode = firstDay;
            while (currentNode != null && currentNode != dayToDelete) {
                previous = currentNode;
                currentNode = currentNode.getNext();
            }
            if (previous == null) {
                firstDay = dayToDelete.getNext();
            } else {
                previous.setNext(dayToDelete.getNext());
            }
            System.out.println("El día se eliminó\n");
        }
    }

    @Override
    public String toString() {
        String daysListing = "";
        DayNode current = firstDay;
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
        diet.editDay();
        diet.printDayListing();
        diet.deleteDay();
        diet.printDayListing();
    }
}
