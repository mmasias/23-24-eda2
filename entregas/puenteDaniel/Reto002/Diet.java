package entregas.puenteDaniel.Reto002;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Diet {
    private List<Day> days;

    public Diet() {
        days = new ArrayList<>();
    }

    public void addDay(Day day) {
        days.add(day);
    }

    public void printDayListing() {
        System.out.println(this.toString());
    }

    public void createDiets() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("Nombre del día (-1 para terminar)");
            String dayName = userInput.nextLine();
            if (dayName.equals("-1")) {
                creating = false;
            } else {
                Day day = new Day(dayName);
                day.createDay();
                addDay(day);
            }
        }
    }

    public void updateDiets() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del día que quieres actualizar");
        String dayNameToUpdate = userInput.nextLine();
        for (Day day : days) {
            if (day.getName().equals(dayNameToUpdate)) {
                System.out.println("Nuevo nombre del día");
                String newDayName = userInput.nextLine();
                day.setName(newDayName);
                return;
            }
        }
        System.out.println("No se encontró el día para actualizar.");
    }

    public void deleteDiets() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del día que quieres eliminar");
        String dayNameToRemove = userInput.nextLine();
        days.removeIf(day -> day.getName().equals(dayNameToRemove));
    }

    public void menu() {
        Scanner userInput = new Scanner(System.in);
        boolean menu = true;
        while (menu) {
            System.out.println("1. Crear dieta");
            System.out.println("2. Ver dieta");
            System.out.println("3. Actualizar dieta");
            System.out.println("4. Eliminar dieta");
            System.out.println("5. Salir");
            System.out.println("Opción: ");
            int option = userInput.nextInt();
            switch (option) {
                case 1:
                    createDiets();
                    break;
                case 2:
                    printDayListing();
                    break;
                case 3:
                    updateDiets();
                    break;
                case 4:
                    deleteDiets();
                    break;
                case 5:
                    menu = false;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder daysListing = new StringBuilder();
        for (Day day : days) {
            daysListing.append(day.toString()).append("\n");
        }
        return daysListing.toString();
    }

    public static void main(String[] args) {
        Diet diet = new Diet();
        diet.menu();
    }
}