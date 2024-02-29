package perezPablo.reto002;
import java.util.Scanner;
import java.util.LinkedList;

class Day {
    
    private LinkedList<Intake> intakeList;
    private String name;

    public Day(String name) {
        this.name = name;
        intakeList = new LinkedList<>();
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void addIntake(Intake intake) {
        intakeList.add(intake);
    }

    public void printIntakeListing() {
        System.out.println(this.toString());
    }

    public void createDay() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("Nombre de la ingesta (-1 para terminar)");
            String name = userInput.nextLine();
            if (name.equals("-1")) {
                creating = !creating;
            } else {
                Intake intake = new Intake(name);
                intake.createIntake();
                addIntake(intake);
            }
        }
    }

    public void editIntake(String intakeName) {
        Scanner userInput = new Scanner(System.in);
        for (Intake intake : intakeList) {
            if (intake.getName().equals(intakeName)) {
                System.out.println("Nuevo nombre de [" + intakeName + "]");
                String newName = userInput.nextLine();
                intake.setName(newName);
                return;
            }
        }
        System.out.println("Alimento no encontrado.");
    }

    public void editDay() {
        boolean editing = true;
        Scanner userInput = new Scanner(System.in);
        while (editing) {
            System.out.println("Ingrese el nombre de la ingesta a editar (-1 para terminar):");
            String intake = userInput.nextLine();
            if (intake.equals("-1")) {
                editing = !editing;
            } else {
                editIntake(intake);
            }
        }
    }

    public void deleteAll() {
        intakeList.clear();
    }

    public void deleteIntake(String intake) {
        boolean removed = intakeList.removeIf(f -> f.getName().equals(intake));
        if (!removed) {
            System.out.println("Ingesta no encontrado.");
        }
    }

    public void deleteIntake() {
        Scanner userInput = new Scanner(System.in);
        boolean deleting = true;
        while (deleting) {
            System.out.println("Nombre de la ingesta por eliminar (-1 para terminar)");
            String intake = userInput.nextLine();
            if (intake.equals("-1")) {
                deleting = !deleting;
            } else {
                deleteIntake(intake);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder intakeListing = new StringBuilder();
        intakeListing.append("]> ").append(name).append("\n");
        for (Intake intake : intakeList) {
            intakeListing.append(intake.toString()).append("\n");
        }
        return intakeListing.toString();
    }

    public static void main(String[] args) {

        Day monday = new Day("Lunes");
        monday.createDay();
        System.out.println("Se crea el dia lunes");
        monday.printIntakeListing();
        Intake breakfast = new Intake("Desayuno");
        Intake lunch = new Intake("Comida");
        monday.addIntake(breakfast);
        monday.addIntake(lunch);
        System.out.println("Se añade desayuno y comida");
        monday.printIntakeListing();
        System.out.println("Se elimina desayuno");
        monday.deleteIntake("Desayuno");
        monday.printIntakeListing();
        monday.deleteIntake();
        monday.printIntakeListing();


    }
}