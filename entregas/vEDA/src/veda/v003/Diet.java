package veda.v003;

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
                Day day = new Day(dayName);
                day.createIntakes();
                addDay(day);
            }
        }        
    }
    public void updateDay() {
        boolean actualizado = false;
        Scanner userInput = new Scanner(System.in);
        DayNode current=this.first;
        DayNode sgte=null;
        System.out.println("Nombre del dia a modificar (-1 para terminar)");
        String dayName = userInput.nextLine();
        while(!actualizado){          
            if(dayName.equals("-1")) 
                actualizado=!actualizado;            
            else 
            {
                if(current.getDay().getNombreDia().equals(dayName))
                {
                    this.first.getDay().UpdateIntake();
                    actualizado=!actualizado;
                }
                while(!actualizado)
                {
                    sgte=current.getNext();
                    if(sgte.getDay().getNombreDia().equals(dayName))
                    {
                        sgte.getDay().UpdateIntake();
                        actualizado=!actualizado;
                    }          
                    current=sgte;
                }                    
            }             
        }   
        if (!actualizado)
            System.out.println("No se ha encontrado el dia a borrar");
    }
    public void deleteDay() {
        boolean borrado = false;
        Scanner userInput = new Scanner(System.in);
        DayNode current=this.first;
        DayNode sgte=null;
        System.out.println("Nombre del dia a borrar (-1 para terminar)");
        String dayName = userInput.nextLine();
        
        while(!borrado){            
            if(dayName.equals("-1")) {
                borrado=!borrado;
            }
            else 
            {
                if(current.getDay().getNombreDia().equals(dayName))
                {
                    this.first=current.getNext();
                    borrado=!borrado;
                }
                while(!borrado)
                {
                    sgte=current.getNext();  
                    if(sgte.getDay().getNombreDia().equals(dayName))
                    {
                        current.setNext(sgte.getNext());
                        borrado=!borrado;
                    }
                    current=current.getNext();
                }                    
            }             
        }   
        if (!borrado)
            System.out.println("No se ha encontrado el dia a borrar");
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
        diet.deleteDay();
        diet.printDayListing();
        diet.updateDay();
        diet.printDayListing();  
    }      
}
