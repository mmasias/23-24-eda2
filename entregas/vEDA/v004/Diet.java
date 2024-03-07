package vEDA.v004;

import java.util.Scanner;

public class Diet {
    
    private int dietNumber;
    private DayNode firstDay;

    public Diet(int dietNumber) {
        this.dietNumber = dietNumber;
        this.firstDay = null;
        this.manage();
    }

    private void addDay(Day day) {
        DayNode newDayNode = new DayNode(day);
        if (firstDay == null) {
            firstDay = newDayNode;
        } else {
            DayNode current = firstDay;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newDayNode);
        }
    }

    private void createDay() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("Creando día para la dieta " + dietNumber);
            System.out.println("Nombre del día (-1 para terminar):");
            String dayName = userInput.nextLine();
            if (dayName.equals("-1")) {
                creating = !creating;
            } else {
                Day day = new Day(dayName);
                day.manage();
                addDay(day);
            }
        }
    }

    private void editDay() {
        boolean editing = true;
        Scanner userInput = new Scanner(System.in);
        while (editing) {
            System.out.println("Nombre del día a editar (-1 para terminar):");
            String dayName = userInput.nextLine();
            if (dayName.equals("-1")) {
                editing = !editing;
            } else {
                editDay(dayName);
            }
        }
    }

    private void editDay(String dayName){
        DayNode current = firstDay;
        while (current != null) {
            if (current.getDay().getName().equals(dayName)) {
                current.getDay().manage();
                return;
            }
            current = current.getNext();
        }
        System.out.println("Día no encontrado");
    }

    private void deleteDay() {
        Scanner userInput = new Scanner(System.in);
        boolean deleting = true;
        while (deleting) {
            System.out.println("Nombre del día por eliminar (-1 para terminar):");
            String dayName = userInput.nextLine();
            if (dayName.equals("-1")) {
                deleting = !deleting;
            } else {
                removeDay(dayName);
            }
        }        
    }

    private void removeDay(String dayName){
        if (firstDay.getDay().getName().equals(dayName)) {
            firstDay = firstDay.getNext();
            return;
        } else {
            DayNode current = firstDay;
            while (current.getNext() != null && !current.getNext().getDay().getName().equals(dayName)) {
                current = current.getNext();
            }
            if (current.getNext() != null) {
                current.setNext(current.getNext().getNext());
            }
        }
    }

    private void renameDiet() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nuevo nombre de dieta " + dietNumber);
        int newDietNumber = userInput.nextInt();
        this.dietNumber = newDietNumber;
    }

    public void manage() {
        boolean managing = true;
        Scanner userInput = new Scanner(System.in);
        while (managing) {
            System.out.println("Gestionando Dieta " + dietNumber);
            System.out.println("[C]reate / [R]ead / Re[N]ame  / [U]pdate / [D]elete / e[X]it");
            char userOption = userInput.nextLine().toUpperCase().charAt(0);
            switch (userOption) {
                case 'C':
                    createDay();
                    break;
                case 'R':
                    System.out.println(this.toString());
                    break;
                case 'U':
                    editDay();
                    break;
                case 'N':
                    renameDiet();
                    break;                    
                case 'D':
                    deleteDay();
                    break;
                case 'X':
                    managing = !managing;
                    break;
                default:
                    System.out.println("El carácter ingresado no es válido.");
                    break;
            }
        }
    }

    @Override
    public String toString() {
        String dayListing = "";
        DayNode current = firstDay;
        while (current != null) {
            dayListing = dayListing + current.getDay().toString() + "\n";
            current = current.getNext();
        }
        return "Dieta " + dietNumber + "\n" + dayListing;
    }

    public static void main(String[] args) {
        Diet diet1 = new Diet(1);
    }
}
