
import java.util.ArrayList;
import java.util.Scanner;

class Diet {
    private ArrayList<Day> first;

    public Diet() {
first=new ArrayList<>();
    }

    public void addDay(Day day){
        first.add(day);


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
        first.add(d);

    }
    public void deleteDiet() {

        Scanner userInput = new Scanner(System.in);
        System.out.println("Introduce el dia que quieres eliminar");
        int dayDelete = userInput.nextInt();
        for (int i = 0; i < first.size(); i++) {
            if (dayDelete==i+1){
                first.remove(i);
            }
        }


    }

    public void updateDiet() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter the day number you want to update:");
        int dayNumber = userInput.nextInt();
        for (int i = 0; i < first.size(); i++) {
            if (dayNumber==i+1){
                System.out.println("Update your food");
                Food update=  new Food(userInput.next());
                Intake in=new Intake();
                in.addFood(update);


                Day d=new Day();
                d.addIntake(in);
                first.set(i,d);
            }
        }


    }
    @Override
    public String toString() {

        return first.toString();
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
