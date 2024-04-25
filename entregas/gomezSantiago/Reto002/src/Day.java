import java.util.ArrayList;
import java.util.Scanner;

class Day {

    private ArrayList<Intake> intakeList;
    public Day() {
        intakeList = new ArrayList<>();
    }

    public void addIntake(Intake intake) {
        intakeList.add(intake);
    }

    public void printIntakeListing() {
        for (Intake intake : intakeList){
            System.out.println(this.toString());
        }
    }

    public void createIntakes() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("+-----------------------------------------+");
            System.out.println("| Nombre de la ingesta (-1 para terminar) |");
            System.out.println("+-----------------------------------------+");
            String intakeName = userInput.nextLine();
            if (intakeName.equals("-1")) {
                creating = !creating;
            } else {
                Intake intake = new Intake();
                addIntake(intake);
            }
        }
    }

    public void deleteIntake(){
        Scanner userInput = new Scanner(System.in);
        if (intakeList.isEmpty()) {
            System.out.println("+---------------------------------+");
            System.out.println("| La lista de ingestas esta vacía |");
            System.out.println("+---------------------------------+");
            return;
        }

        System.out.println("+----------------------------------------+");
        System.out.println("| Ingrese la ingesta que desea eliminar: |");
        System.out.println("+----------------------------------------+");
        String intakeNameDelete = userInput.nextLine();
        System.out.println("+-----------------------------------------+");
        System.out.println("| Se ha eliminado " + intakeNameDelete + " correctamente |" + "\n");
        System.out.println("+-----------------------------------------+");

        boolean intakeInList = false;
        for (Intake intake : intakeList) {
            if (intake.toString().equals(intakeNameDelete)) {
                intakeList.remove(intake);
                intakeInList = true;
                break;
            }
        }

        if (!intakeInList) {
            System.out.println("+------------------------------------+");
            System.out.println("| No se ha encontrado ninguna comida |");
            System.out.println("+------------------------------------+");
        }
    }

    public void modifyIntake(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("+--------------------------------------+");
        System.out.println("| Ingrese la ingesta que desea editar: |");
        System.out.println("+--------------------------------------+");
        String intakeNameEdit = userInput.nextLine();
        System.out.println("+-------------------------------------------------+");
        System.out.println("| Se ha editado la ingesta: " + intakeNameEdit + " |"+ "\n");
        System.out.println("+-------------------------------------------------+");

        boolean intakeToEdit = false;
        for (Intake intake : intakeList) {
            if (intake.toString().equals(intakeNameEdit)) {
                intake.modifyIntake();
                intakeToEdit = true;
                break;
            }
        }

        if (!intakeToEdit) {
            System.out.println("+-----------------------------------------+");
            System.out.println("| No se pudo encontrar la ingesta deseada |");
            System.out.println("+-----------------------------------------+");
        }

    }

    public void optionsMenu() {
        Scanner userInput = new Scanner(System.in);
        boolean options = false;
        System.out.println("+-----------------+");
        System.out.println("| Opciones de Dia |");
        System.out.println("+-----------------+");
        while (!options) {
            System.out.println("+-------------------+");
            System.out.println("| Agregar dia (1)   |");
            System.out.println("| Eliminar dia (2)  |");
            System.out.println("| Modificar dia (3) |");
            System.out.println("| Mostrar dia (4)   |");
            System.out.println("| Salir de dia (0)  |");
            System.out.println("+-------------------+");
            int option = userInput.nextInt();
            switch (option) {
                case 1:
                    createIntakes();
                    break;
                case 2:
                    deleteIntake();
                    break;
                case 3:
                    modifyIntake();
                    break;
                case 4:
                    printIntakeListing();
                    break;
                case 0:
                    options = true;
                    break;
                default:
                    System.out.println("+------------------+");
                    System.out.println("| Opción no válida |");
                    System.out.println("+------------------+");
                    break;
            }
        }
    }

    public static void main(String[] args) {

        Day day1 = new Day();

        day1.optionsMenu();

    }
}