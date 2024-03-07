package entregas.DiegoBarraza.reto002;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Diet diet = new Diet();
        
        Scanner userInput = new Scanner(System.in);
        
    
        Day day1 = new Day();
        System.out.println("Creación de ingestas para el día 1:");
        day1.createIntakes();
        diet.addDay(day1);
        
        Day day2 = new Day();
        System.out.println("Creación de ingestas para el día 2:");
        day2.createIntakes();
        diet.addDay(day2);

        Day day3 = new Day();
        System.out.println("Creación de ingestas para el día 3:");
        day3.createIntakes();
        diet.addDay(day3);

        Day day4 = new Day();
        System.out.println("Creación de ingestas para el día 4:");
        day4.createIntakes();
        diet.addDay(day4);

        Day day5 = new Day();
        System.out.println("Creación de ingestas para el día 5:");
        day5.createIntakes();
        day5.deleteIntake();
        diet.addDay(day5);
    
        
    
        System.out.println("Lista de días y sus ingestas:");
        diet.printDayListing();
        
        diet.editDay();
        
    
        System.out.println("Lista actualizada de días y sus ingestas:");
        diet.printDayListing();

        
        
        userInput.close();
    }
}
