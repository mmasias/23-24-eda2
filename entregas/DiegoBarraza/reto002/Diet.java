package entregas.DiegoBarraza.reto002;

import java.util.ArrayList;
import java.util.Scanner;

class Diet {
    private ArrayList<Day> days;

    public Diet() {
        days = new ArrayList<>();
    }

    public void addDay(Day day) {
        days.add(day);
    }

    public void printDayListing() {
        for (Day day : days) {
            System.out.println(day);
        }
    }

    public void createDays() {
        Scanner userInput = new Scanner(System.in);
        while (true) {
            System.out.println("Nombre del dia (-1 para terminar)");
            String dayName = userInput.nextLine();
            if (dayName.equals("-1")) {
                break;
            } else {
                Day day = new Day();
                day.createIntakes();
                addDay(day);
            }
        }
    }

    public void editDay() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Ingrese el número del día que desea editar:");
        int dayIndex = Integer.parseInt(userInput.nextLine());
    
        if (dayIndex >= 0 && dayIndex < days.size()) {
            Day dayToEdit = days.get(dayIndex);
            System.out.println("Editando el día " + dayIndex + ":");
    
            dayToEdit.editIntake();
    
            System.out.println("El día se ha editado correctamente.");
        } else {
            System.out.println("El número de día ingresado no es válido.");
        }
    }
    
    public void deleteDay(int numberDay) {
        if (numberDay >= 0 && numberDay < days.size()) {
            days.remove(numberDay);
        } else {
            System.out.println("El día no existe");
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
}