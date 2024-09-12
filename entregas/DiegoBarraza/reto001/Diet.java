package entregas.DiegoBarraza.reto001;
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
        System.out.println(this.toString());
    }

    public void createDays() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while(creating){
            System.out.println("Nombre del dia (-1 para terminar)");
            String dayName = userInput.nextLine();
            if(dayName.equals("-1")) {
                creating=!creating;
            } else {
                Day day = new Day();
                day.createIntakes();
                addDay(day);
            }
        }
    }

    public void deleteDays(int numberDay){
        DayNode current = first;
        DayNode previous = null;
        int count = 1;
        while (current != null) {
            if (count == numberDay) {
                if (previous == null) {
                    first = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                return;
            }
            count++;
            previous = current;
            current = current.getNext();
        }
    }
    public void editDay(){
        System.out.println("Ingrese el dia que desea editar");
        int dayEdit = Integer.parseInt(new Scanner(System.in).nextLine());
        deleteDays(dayEdit);
        createDays();
    }
    public void deleteDays(){
        System.out.println(" Ingrese el dia que desea eliminar");
        int dayDelete = Integer.parseInt(new Scanner(System.in).nextLine());
        deleteDays(Integer.parseInt(String.valueOf(dayDelete)));
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
        diet.editDay();
        diet.printDayListing();
        diet.deleteDays();
        diet.printDayListing();
    }
}
