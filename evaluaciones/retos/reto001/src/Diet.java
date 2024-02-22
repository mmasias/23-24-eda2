import java.util.Scanner;

public class Diet {
       private DayNode first;
       Scanner userInput = new Scanner(System.in);

    public Diet() {
        first = null;
    }

    private void addDay(Day day){
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
        System.out.println(this.toString());
    }

    public void createDays() {
        boolean creating = true;
        while(creating){
            System.out.println("Nombre del dia (-1 para terminar)");
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

    private void updateDay(String oldDayName, String newDayName) {
        DayNode current = first;
        while(current != null) {
            if (current.getDay().getDayName().equals(oldDayName)) {
                current.getDay().setDayName(newDayName);;
            }
            current = current.getNext();
        }

    }

    public void updateDays() {
        boolean updating = true;
        while (updating) {
            System.out.println("Nombre del día a editar (-1 para terminar)");
            String oldDay = userInput.nextLine();
            if (oldDay.equals("-1")) {
                updating = !updating;
            } else {
                System.out.println("Nuevo nombre del día: ");
                String newDay = userInput.nextLine();
                updateDay(oldDay, newDay);
            }
        }
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
    } 
}
