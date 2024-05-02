import java.util.ArrayList;
import java.util.Scanner;

public class Diet {
    private ArrayList<Day> dayList;
    private String name;

    public Diet(String name) {
        this.name = name;
        this.dayList = new ArrayList<>();
    }

    public void addDay(Day day) {
        dayList.add(day);
    }

    public void createDay() {
        Scanner userInput = new Scanner(System.in);
        while (true) {
            System.out.println("Nombre del día (-1 para terminar):");
            String dayName = userInput.nextLine();
            if (dayName.equals("-1")) {
                break;
            } else {
                Day day = new Day(dayName);
                day.createIntakes();
                addDay(day);
            }
        }
    }

    public void deleteDiet() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del día que quieres eliminar:");
        String dayName = userInput.nextLine();
        dayList.removeIf(day -> day.getName().equalsIgnoreCase(dayName));
        System.out.println("Día eliminado.");
    }

    public void editDiet() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del día que quieres actualizar:");
        String dayName = userInput.nextLine();
        for (Day day : dayList) {
            if (day.getName().equalsIgnoreCase(dayName)) {
                System.out.println("Nuevo nombre del día:");
                String newDayName = userInput.nextLine();
                day.setName(newDayName);
                System.out.println("Día actualizado.");
                return;
            }
        }
        System.out.println("Día no encontrado.");
    }

    public void printDietListing() {
        if (dayList.isEmpty()) {
            System.out.println("La dieta está vacía.");
        } else {
            System.out.println("Días en la dieta '" + name + "':");
            dayList.forEach(System.out::println);
        }
    }

    @Override
    public String toString() {
        StringBuilder daysListing = new StringBuilder("Dieta: " + name + "\n");
        for (Day day : dayList) {
            daysListing.append(day).append("\n");
        }
        return daysListing.toString();
    }

    public static void main(String[] args) {
        Diet diet = new Diet("Dieta");
        diet.createDay();
        diet.printDietListing();
        diet.deleteDiet();
        diet.printDietListing();
        diet.editDiet();
        diet.printDietListing();
    }
}
