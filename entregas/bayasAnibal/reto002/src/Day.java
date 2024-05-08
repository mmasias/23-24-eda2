import java.util.ArrayList;
import java.util.Scanner;

class Day {
    private ArrayList<Intake> intakes;
    private String name;

    public Day() {
        intakes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addIntake(Intake intake) {
        intakes.add(intake);
    }

    public void printIntakeListing() {
        System.out.println(this.toString());
    }

    public void createDay() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("Nombre de la ingesta (-1 para terminar)");
            String intakeName = userInput.nextLine();
            if (intakeName.equals("-1")) {
                creating = !creating;
            } else {
                Intake intake = new Intake(intakeName);
                intake.createIntake();
                addIntake(intake);
                intake.setName(intakeName);
            }
        }
    }

    public void updateDay() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre de la ingesta que quieres actualizar");
        String intakeNameToUpdate = userInput.nextLine();
        for (Intake intake : intakes) {
            if (intake.getName().equals(intakeNameToUpdate)) {
                System.out.println("Nuevo nombre de la ingesta");
                String newIntakeName = userInput.nextLine();
                intake.setName(newIntakeName);
                return;
            }
        }
    }

    public void deleteDay() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre de la ingesta que quieres eliminar");
        String intakeNameToRemove = userInput.nextLine();
        intakes.removeIf(intake -> intake.getName().equals(intakeNameToRemove));
    }

    public void menu() {
        Scanner userInput = new Scanner(System.in);
        boolean menu = true;
        while (menu) {
            System.out.println("1. Crear ingesta");
            System.out.println("2. Modificar ingesta");
            System.out.println("3. Eliminar ingesta");
            System.out.println("4. Listar ingesta");
            System.out.println("5. Salir");
            int option = userInput.nextInt();
            switch (option) {
                case 1:
                    createDay();
                    break;
                case 2:
                    updateDay();
                    break;
                case 3:
                    deleteDay();
                    break;
                case 4:
                    printIntakeListing();
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
        StringBuilder intakeListing = new StringBuilder();
        for (Intake intake : intakes) {
            intakeListing.append(intake.toString()).append("\n");
        }
        return intakeListing.toString();
    }

    public static void main(String[] args) {
        Day monday = new Day();
        monday.menu();
    }
}