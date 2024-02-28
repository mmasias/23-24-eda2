

import java.util.ArrayList;
import java.util.Scanner;

class Diet {
    private ArrayList<Day> days;

    public Diet() {
        days = new ArrayList<Day>();
    }

    public void addDay(Day day){
        days.add(day);
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
                Day day = new Day(dayName);
                day.createIntakes();
                addDay(day);
            }
        }        
    }
    public void updateDay() {
        boolean actualizado = false;
        Scanner userInput = new Scanner(System.in);

        System.out.println("Nombre del dia a modificar (-1 para terminar)");
        String dayName = userInput.nextLine();
        while(!actualizado){          
            if(dayName.equals("-1")) 
                actualizado=!actualizado;            
            else 
            {
                for (int i=0; i<days.size(); i++)
                {
                    if (days.get(i).getNombreDia().equals(dayName))
                    {
                        days.get(i).UpdateIntake();
                        actualizado=!actualizado;
                    }
                }
            }
        }   
        if (!actualizado)
            System.out.println("No se ha encontrado el dia a borrar");
    }
    public void deleteDay() {
        boolean borrado = false;
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del dia a borrar (-1 para terminar)");
        String dayName = userInput.nextLine();

        while (!borrado) {
            if (dayName.equals("-1")) {
                borrado = !borrado;
            } else {
                for (int i = 0; i < days.size(); i++) {
                    if (days.get(i).getNombreDia().equals(dayName)) {
                        days.remove(i);
                        borrado = !borrado;
                    }
                }
            }
            if (!borrado)
                System.out.println("No se ha encontrado el dia a borrar");
        }
    }



        public static void main(String[] args) {
        Diet diet = new Diet();
        diet.createDays();
        diet.printDayListing();
        diet.deleteDay();
        diet.printDayListing();
        diet.updateDay();
        diet.printDayListing();  
    }      
}

