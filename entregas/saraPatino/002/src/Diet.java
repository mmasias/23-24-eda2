package src;

import java.util.ArrayList;
import java.util.Scanner;

class Diet {
    private ArrayList<Day> days;

    public Diet() {
        days = new ArrayList<>();
    }

    public void addDay(Day day){
        days.add(day);
    }

    public void printDayListing(){
        for (Day day : days) {
            System.out.println(day);
        }
    }

    public void createDays() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while(creating){
            System.out.println("Nombre del dia (-1 para terminar)");
            String dayName = userInput.nextLine();
            if(dayName.equals("-1")) {
                creating = false;
            } else {
                Day day = new Day();
                day.menu();
                addDay(day);
            }
        }        
    }

    public void deleteDay() {
        Scanner userInput = new Scanner(System.in);
        if (days.isEmpty()) {
            System.out.println("La lista de ingestas está vacía.");
            return;
        }

        System.out.println("¿Qué día deseas eliminar?");
        String dayName = userInput.nextLine();

        boolean found = false;
        for (Day day : days) {
            if (day.toString().equals(dayName)) {
                days.remove(day);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No se encontró el día a eliminar.");
        }
    }

    private void deleteAllDays() {
        days.clear();
        System.out.println("\nTodos los días han sido eliminados con éxito!");
    }

    public void updateDay() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("¿Qué día deseas actualizar?");
        String name = userInput.nextLine();

        boolean found = false;
        for (Day day : days) {
            if (day.toString().equals(name)) {
                day.createIntakes();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No se encontró el día a actualizar.");
        }
    }

    @Override
    public String toString() {
        StringBuilder daysListing = new StringBuilder();
        for (Day day : days) {
            daysListing.append(day).append("\n");
        }
        return daysListing.toString();
    }
    
    public void menu() {
        Scanner userInput = new Scanner(System.in);
        boolean finish = false;
        System.out.println(">>OPCIONES DIA<< \n");
        while (!finish) {
            System.out.println("1. Agregar");
            System.out.println("2. Eliminar");
            System.out.println("3. Modificar");
            System.out.println("4. Mostrar");
            System.out.println("5. Eliminar todo");
            System.out.println("6. Salir");
            int option = userInput.nextInt();
            switch (option) {
                case 1:
                    createDays();
                    break;
                case 2:
                    deleteDay();
                    break;
                case 3:
                    updateDay();
                    break;
                case 4:
                    printDayListing();
                    break;
                case 5:
                    deleteAllDays();
                    break;
                case 6:
                    finish = true;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

    public static void main(String[] args) {

        Diet diet = new Diet();
        diet.menu();
    }      
}