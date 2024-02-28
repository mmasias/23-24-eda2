import java.util.Scanner;
import java.lang.reflect.Array;
import java.util.ArrayList;

class Day {
    private ArrayList<Intake> intakeList;
    String name;
    public Day() {
        intakeList = new ArrayList<Intake>();
    }
    public Day(String name) {
        this.name = name;
        intakeList = new ArrayList<Intake>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addIntake(Intake intake) {
        intakeList.add(intake);
    }

    public void printIntakeListing() {
        if (intakeList.isEmpty()) {
            System.out.println("No hay Ingestas registradas");
        } else {
            for (Intake intake : intakeList) {
                System.out.println("Ingesta " + intake.getName() + ":");
                intake.printFoodListing();
            }
        }
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
                Intake intake = new Intake();
                intake.setName(intakeName);
                intake.createIntake();
                addIntake(intake);
            }
        }
    }

    public void editDay() {
        boolean isEditing = true;
    Scanner QueEditar = new Scanner(System.in);
    while (isEditing) {
        System.out.println("¿Qué ingesta desea editar? (-1 para salir)");
        String intakeName = QueEditar.nextLine();
        if (intakeName.equals("-1")) {
            isEditing = false;
        } else {
            editSpecificIntake(intakeName);
        }
    }
}

public void editSpecificIntake(String intakeName) {
    for (Intake intake : intakeList) {
        if (intake.getName().equals(intakeName)) {
            System.out.println("Editando la ingesta: " + intakeName);
            System.out.println("¿Qué quieres editar?");
            System.out.println("|1 Nombre de la ingesta | 2 Un alimento dentro de la ingesta | 3 Salir|");
            Scanner userInput = new Scanner(System.in);
            String option = userInput.nextLine();
            switch (option) {
                case "1":
                    System.out.println("Nuevo nombre de la ingesta");
                    String newName = userInput.nextLine();
                    intake.setName(newName);
                    break;
                case "2":
                    intake.editIntake();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
            return;
        }
    }
    System.out.println("Ingesta no encontrada");
}

    public void deleteIntake() {
        boolean isDeleting = true;
        Scanner QueBorrar = new Scanner(System.in);
        while (isDeleting) {
            System.out.println("¿Qué ingesta desea eliminar? (-1 para salir)");
            String intakeName = QueBorrar.nextLine();
            if (intakeName.equals("-1")) {
                isDeleting = false;
            } else {
                deleteSpecificIntake(intakeName);
            }
        }
    }

    public void deleteSpecificIntake(String intakeName) {
        for (int i = 0; i < intakeList.size(); i++) {
            Intake intake = intakeList.get(i);
            if (intake.getName().equals(intakeName)) {
                System.out.println("¿Qué quieres eliminar?");
                System.out.println("| 1 La ingesta | 2 Un alimento | 3 Salir |");
                Scanner userInput = new Scanner(System.in);
                String option = userInput.nextLine();
                switch (option) {
                    case "1":
                        System.out.println("¿Estás seguro de que quieres eliminar la ingesta? (s/n)");
                        Scanner confirmation = new Scanner(System.in);
                        if (confirmation.nextLine().equals("s")) {
                            intakeList.remove(i);
                            System.out.println("Ingesta eliminada: " + intakeName);
                        }
                        return;
                    case "2":
                        intake.deleteFood();
                        break;
                    case "3":
                        return;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            }
        }
        System.out.println("Ingesta no encontrada");
    }

    public void deleteDay() {
        Scanner confirmación = new Scanner(System.in);
        System.out.println("¿Estás seguro de que quieres eliminar el día? (s/n)");
        if (confirmación.nextLine().equals("s")) {
            intakeList.clear();
        } else{}
        return;
    }

    public static void main(String[] args) {

        Day monday = new Day();
        Boolean Editing = true;
        while (Editing){
        System.out.println("Estás en el registro de Días");
        System.out.println("¿Que desea hacer?");
        System.out.println("1 Crear un día");
        System.out.println("2 Leer el día");
        System.out.println("3 Editar un día");
        System.out.println("4 Eliminar datos");
        System.out.println("5 Eliminar El registro");
        System.out.println("Para Salir introduzca [-1]");
        Scanner userInput = new Scanner(System.in);
        String option = userInput.nextLine();
        switch (option) {
            case "1":
                System.out.println("Creando Día");
                monday.createIntakes();
                monday.printIntakeListing();
                break;
            case "2":
                System.out.println("Mostrando Día");
                monday.printIntakeListing();
                break;
            case "3":
                System.out.println("Editando Día");
                monday.editDay();
                monday.printIntakeListing();
                break;
            case "4":
                System.out.println("Eliminando datos");
                monday.deleteIntake();
                monday.printIntakeListing();
                break;
            case "5":
                System.out.println("Eliminando Día");
                monday.deleteDay();
                monday.printIntakeListing();
                break;
            case "-1":
                System.out.println("Saliendo");
                Editing = false;
                System.out.println("Esto es el día que has registrado:");
                monday.printIntakeListing();
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
        
    }
        
    }
}