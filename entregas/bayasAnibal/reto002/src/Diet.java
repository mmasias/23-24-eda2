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
        System.out.println(this.toString());
    }

    public void createDiets() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("Nombre del dia (-1 para terminar)");
            String dayName = userInput.nextLine();
            if (dayName.equals("-1")) {
                creating = !creating;
            } else {
                Day day = new Day();
                day.createDay();
                addDay(day);
                day.setName(dayName);
            }
        }
    }

    public void updateDiets() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del dia que quieres actualizar");
        String dayNameToUpdate = userInput.nextLine();
        for (Day day : days) {
            if (day.getName().equals(dayNameToUpdate)) {
                System.out.println("Nuevo nombre del dia");
                String newDayName = userInput.nextLine();
                day.setName(newDayName);
                return;
            }
        }
    }

    public void deleteDiets() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del dia que quieres eliminar");
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
            System.out.println("Opcion: ");
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
                    menu = !menu;
                    break;
                default:
                    System.out.println("Opcion no valida");
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
