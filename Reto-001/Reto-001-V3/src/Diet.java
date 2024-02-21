
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
    public void createDiet(){
        boolean creating=true;

        Intake i=new Intake();
        i.createIntake();
        Day d=new Day();
        d.addIntake(i);
        DayNode current=first;
        while (first!=null){
        current=current.getNext();
        }
        current.setNext(new DayNode(d));
    }
    public void deleteDiet(){
        Scanner userInput =new Scanner(System.in);
        System.out.println("Introduce el dia que quieres eliminar");
        int dayDelete=userInput.nextInt();
        DayNode current=first;
        DayNode previous=null;
     int comtador=1;

        while (current!=null){
            if (comtador==dayDelete){
                if (current==first){
                    first=first.getNext();
                    break;
                }else {
                    previous.setNext(current.getNext());
                }
            }
            comtador++;
            current=current.getNext();
        }
    }
    public void updateDiet() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter the day number you want to update:");
        int dayNumber = userInput.nextInt();

        DayNode current = first;
        int counter = 1;

        while (current != null) {
            if (counter == dayNumber) {
                // Found the day to update
                System.out.println("Updating details for Day " + dayNumber);
                current.getDay().createIntakes();  break;
            }
            counter++;
            current = current.getNext();
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
        diet.createDiet();
        diet.deleteDiet();
        diet.updateDiet();
    }


}
