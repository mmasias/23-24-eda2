package entregas.garciaDavid.reto002;

import java.util.ArrayList;
import java.util.Scanner;

public class Diet {
        private ArrayList<Day> dayList;
        private String name;

    public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

    public Diet() {
        dayList = new ArrayList<Day>();
    }

    public void addDay(Day day){
        dayList.add(day);
    }



    public void printDietListing(){
        System.out.println(this.toString());
    }

    public void createDay() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while(creating){
            System.out.println("Nombre del dia (-1 para terminar)");
            String dayName = userInput.nextLine();
            if(dayName.equals("-1")) {
                creating=!creating;
            } else {
                Day day = new Day();
                day.setName(dayName);
                day.createIntakes();;
                addDay(day);
            }
        }        
    }

    public void deleteDiet() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombrame el nombre del dia que quieres eliminar");
        String dayName = userInput.nextLine();
        for(int i=0; i<this.dayList.size();i++){
            if (this.dayList.get(i).getName().equalsIgnoreCase(dayName)) {
                this.dayList.remove(i);
            }
        }         
    }



    public void editDiet() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombrame el nombre del dia que quieres actualizar");
        String dayName = userInput.nextLine();
        for(int i=0; i<this.dayList.size();i++){
            if (this.dayList.get(i).getName().equalsIgnoreCase(dayName)) {
                System.out.println("Nombrame el nombre del dia que quieres añadir");
                String newdayName = userInput.nextLine();

                Day day= new Day();
                day.setName(newdayName);
                day.createIntakes(); 

                dayList.set(i, day);

            }
        }       
    }

    @Override
    public String toString() {
        String daysListing = "\n";
        for (Day day : dayList) {
            daysListing = daysListing + day.toString() + "\n";
        }
        return daysListing;
    }    

    public static void main(String[] args) {

        Diet diet = new Diet();
        diet.createDay();
        diet.printDietListing();
        diet.deleteDiet();
        diet.printDietListing();
        diet.editDiet();
        diet.printDietListing();
    }  
}