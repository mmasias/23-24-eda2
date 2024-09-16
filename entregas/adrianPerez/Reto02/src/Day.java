import java.util.ArrayList;
import java.util.Scanner;

class Day {
    private ArrayList<Intake> intakes;
    String name;

    public Day(String name) {
        intakes = new ArrayList<Intake>();
        this.name = name;
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

    public void createIntakes() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("Nombre de la ingesta (-1 para terminar)");
            String intakeName = userInput.nextLine();
            if (intakeName.equals("-1")) {
                creating = !creating;
            } else {
                Intake intake = new Intake(intakeName);
                intake.createFoods();
                addIntake(intake);
            }
        }
    }

    public void deleteIntakes() {
        Scanner scanner = new Scanner(System.in);
        boolean deleting = true;
        
        while(deleting == true) {

            System.out.println("Quiere borrar una ingesta (1) o todas las ingestas (2)? Pulse (3) para salir");

            String userInput = scanner.nextLine();

            if (userInput.equals("1")){
                System.out.println("Indique la ingesta que quiere borrar:");
                userInput = scanner.nextLine();
                deleteIntake(userInput);
            }
            else if (userInput.equals("2")) {
                deleting = !deleting;
                deleteAllIntakes();
            }
            else if (userInput.equals("3")) {
                deleting = !deleting;
            }
        }
    }

    public void deleteIntake(String intakeName) {
        for (Intake intake : intakes) {
            if (intakeName.equals(intakeName)) {
                intakes.remove(intake);
                System.out.println("Ingesta eliminada");
                break;
            }
            else {
                System.out.println("Ingesta no encontrada");
                break;
            }
        }
    }

    public void deleteAllIntakes() {
        intakes.clear();
        System.out.println("Todas las ingestas han sido eliminadas");
    }

    public void editIntake() {
        Scanner scanner = new Scanner(System.in);
        boolean editing = true;

        while (editing) {
            System.out.println("¿Desea editar una ingesta? (1) Sí, (2) No");
            String userInput = scanner.nextLine();

            if (userInput.equals("1")) {
                System.out.println("Ingrese el nombre de la ingesta que desea editar:");
                String nameIngesta = scanner.nextLine();

                boolean found = false;
                for (Intake intake : intakes) {
                    if (intake.getName().equals(nameIngesta)) {
                        System.out.println("Ingrese el nuevo nombre de la ingesta:");
                        String newNameIngesta = scanner.nextLine();
                        intake.setName(newNameIngesta);
                        found = true;
                        System.out.println("Ingesta editada exitosamente.");
                        break;
                    }
                }

                if (!found) {
                    System.out.println("No se encontró ningúna ingesta con ese nombre.");
                }
            } else if (userInput.equals("2")) {
                editing = false;
            }
        }
    }

    @Override
    public String toString() {
        String intakeListing = "";
        for (Intake intake : intakes) {
            intakeListing = intakeListing + intake.toString() + "\n";
        }
        return intakeListing;
    }

    public static void main(String[] args) {

        Day monday = new Day("Lunes");
        monday.createIntakes();
        monday.printIntakeListing();
    }
}