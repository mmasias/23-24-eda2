package src;

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
                day.menu();
                addDay(day);
            }
        }        
    }

    public void deleteDay() {
        Scanner userInput = new Scanner(System.in);
        if (first == null) {
            System.out.println("La lista de ingestas está vacía.");
            return;
        }

        System.out.println("Que ingesta deseas eliminar?");
        String foodName = userInput.nextLine();
        boolean found = false;
        
        if (first.getDay().toString().equals(foodName)) {
            first = first.getNext();
            found = true;
            return;
        }

        DayNode current = first;
        DayNode previous = null;

        while (current != null) {
            if (current.getDay().toString().equals(foodName)) {
                previous.setNext(current.getNext());
                found = true;
                return;
            }
            previous = current;
            current = current.getNext();
        }
        if(found = false) {
            System.out.println("No se encontró la ingesta a eliminar.");
        }
    }

    private void deleteAllDays() {
        first = null;
        System.out.println("\nTodos las ingestas han sido eliminados con exito!");
    }

    public void updateDay() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Que alimento deseas actualizar?");
        String name = userInput.nextLine();


        DayNode current = first;

        boolean found = false; 
        while (current != null) {
            if (current.getDay().toString().equals(name)) {
                current.getDay().createIntakes();
                found = true;
                return;
            }
            current = current.getNext();
        }

        if(found = false) {
            System.out.println("No se encontró el alimento a actualizar.");
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
    
    public void menu() {
        Scanner userInput = new Scanner(System.in);
        boolean finish = false;
        System.out.println(">>OPCIONES DIA<< \n");
        while (finish == false) {
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