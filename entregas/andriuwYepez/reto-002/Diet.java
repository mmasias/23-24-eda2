import java.util.ArrayList;
import java.util.Scanner;

class Diet {
    private ArrayList<Day> days;

    public Diet() {
        this.days = new ArrayList<>();
    }

    public void addDay(Day day) {
        days.add(day);
    }

    public void printDayListing() {
        System.out.println(this.toString());
    }

    public void createDays() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("Nombre del día (-1 para terminar)");
            String dayName = userInput.nextLine();
            if (dayName.equals("-1")) {
                creating = false;
            } else {
                Day day = new Day(dayName);
                day.createIntakes();
                addDay(day);
            }
        }
    }

    public void deleteDay(int index) {
        days.remove(index);
    }

    public void editDay(int index, String newName) {
        days.get(index).setName(newName);
    }

    public void deleteAllDays() {
        days.clear();
    }

    public void deleteDiet() {
        boolean deleteDiet = true;
        Scanner userInput = new Scanner(System.in);

        while (deleteDiet) {
            System.out.println("1) Eliminar un día");
            System.out.println("2) Eliminar todos los días");
            System.out.println("3) Guardar Días\n");
            String option = userInput.nextLine();

            if (option.equals("1")) {
                for (int i = 0; i < days.size(); i++) {
                    System.out.println("El día actual es: " + days.get(i).getDetailsDiet());
                    System.out.println("1) Eliminar");
                    System.out.println("2) Siguiente\n");
                    String choice = userInput.nextLine();

                    if (choice.equals("1")) {
                        System.out.println("Eliminando un día");
                        deleteDay(i);
                        break;
                    } else if (choice.equals("2")) {
                        System.out.println("Siguiente día\n");
                    }
                }
            } else if (option.equals("2")) {
                System.out.println("Eliminando todos los días");
                deleteAllDays();
            } else if (option.equals("3")) {
                deleteDiet = false;
            }
        }
    }

    public void editDiet() {
        boolean editing = true;
        Scanner userInput = new Scanner(System.in);

        while (editing) {
            System.out.println("1) Editar un día");
            System.out.println("2) Guardar Días\n");
            String choice = userInput.nextLine();

            if (choice.equals("1")) {
                for (int i = 0; i < days.size(); i++) {
                    System.out.println("El día actual es: " + days.get(i).getDetailsDiet());
                    System.out.println("1) Editar");
                    System.out.println("2) Siguiente\n");
                    String option = userInput.nextLine();

                    if (option.equals("1")) {
                        System.out.println("Editando");
                        System.out.println("Ingrese el nuevo nombre:");
                        String newName = userInput.nextLine();
                        editDay(i, newName);
                    } else if (option.equals("2")) {
                        System.out.println("Guardado exitosamente!");
                    }
                }
            } else if (choice.equals("2")) {
                editing = false;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Day day : days) {
            result.append(day.getDetailsDiet()).append("\n");
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Diet diet = new Diet();
        diet.createDays();
        diet.editDiet();
        diet.deleteDiet();
        diet.printDayListing();
    }
}
