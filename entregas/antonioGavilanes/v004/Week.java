package antonioGavilanes.v004;

import java.util.Scanner;

public class Week {
    private String name;
    private DayNode first;

    public Week(String name) {
        this.name = name;
        this.first = null;
    }

    private void addDay(Day day) {
        DayNode newDayNode = new DayNode(day);
        if (first == null) {
            first = newDayNode;
        } else {
            DayNode current = first;
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
            System.out.println("Creando días de la " + this.name);
            System.out.println("Nombre del día (-1 para terminar)");
            String dayName = userInput.nextLine();
            if (dayName.equals("-1")) {
                creating = !creating;
            } else {
                Day day = new Day(dayName + " de la " + this.name);
                day.manage();
                addDay(day);
            }
        }
    }

    private void editDay() {
        boolean editing = true;
        Scanner userInput = new Scanner(System.in);
        while (editing) {
            System.out.println("Nombre del día a editar (-1 para terminar)");
            String dayName = userInput.nextLine();
            if (dayName.equals("-1")) {
                editing = !editing;
            } else {
                editDay(dayName);
            }
        }
    }

    private void editDay(String dayName) {
        Scanner userInput = new Scanner(System.in);
        DayNode current = first;
        while (current != null) {
            if (current.getDay().getName().equals(dayName)) {
                current.getDay().manage();
                return;
            }
            current = current.getNext();
        }
        System.out.println("No se encontró el día " + dayName);

    }

    private void deleteDay() {
        Scanner userInput = new Scanner(System.in);
        boolean deleting = true;
        while (deleting) {
            System.out.println("Nombre del día a eliminar (-1 para terminar)");
            String dayName = userInput.nextLine();
            if (dayName.equals("-1")) {
                deleting = !deleting;
            } else {
                removeDay(dayName);
            }
        }
    }

    private void removeDay(String dayName) {
        if (first.getDay().getName().equals(dayName)) {
            first = first.getNext();
            return;
        } else {
            DayNode current = first;
            while (current.getNext() != null && !current.getNext().getDay().getName().equals(dayName)) {
                current = current.getNext();
            }
            if (current.getNext() != null) {
                current.setNext(current.getNext().getNext());
            }
        }
    }

    public void startManagement() {
        manage();
    }

    public void manage() {
        boolean managing = true;
        Scanner userInput = new Scanner(System.in);
        char userOption = ' ';
        do {
            System.out.println("Gestión de la " + this.name);
            System.out.println("[C]reate / [R]ead / [U]pdate / [D]elete / e[X]it");
            String input = userInput.nextLine();
            if (input.isEmpty()) {
                System.out.println("No se ha ingresado ninguna opción. Inténtelo de nuevo.");
                continue;
            }
            userOption = input.toUpperCase().charAt(0);
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
                case 'D':
                    deleteDay();
                    break;
                case 'X':
                    managing = !managing;
                    break;
                default:
                    System.out.println("El carácter ingresado no es CRUD.");
                    break;
            }
        } while (managing);
    }

    @Override
    public String toString() {
        String dayListing = "";
        DayNode current = first;
        while (current != null) {
            dayListing = dayListing + current.getDay().toString() + "\n";
            current = current.getNext();
        }
        return this.name + "\n" + dayListing;
    }

    public static void main(String[] args) {
        Week week = new Week("Semana 1");
        week.startManagement();
    }

    public void showSchedule() {
        DayNode currentDay = first;
        while (currentDay != null) {
            System.out.println("==============================");
            System.out.println("Dia: " + currentDay.getDay().getName());
            IntakeNode currentIntake = currentDay.getDay().getFirst();
            while (currentIntake != null) {
                System.out.println("Ingesta: " + currentIntake.getIntake().getName());
                FoodNode currentFood = currentIntake.getIntake().getFirst();
                System.out.println("--------------");
                System.out.println("Comida:");
                System.out.println("--------------");
                while (currentFood != null) {
                    System.out.println("]> " + currentFood.getFood().getName());
                    currentFood = currentFood.getNext();
                }
                currentIntake = currentIntake.getNext();
            }
            currentDay = currentDay.getNext();
        }
    }
}
