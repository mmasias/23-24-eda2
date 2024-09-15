import java.util.ArrayList;
import java.util.Scanner;

class Day {
    String name;
    private ArrayList<Intake> intakes;

    public Day(String name) {
        this.name = name;
        this.intakes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetailsDiet() {
        return "]> Dia: " + name;
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
                intake.createIntake();
                addIntake(intake);
            }
        }
    }

    public void deleteIntake(int index) {
        intakes.remove(index);
    }

    public void editIntake(int index, String newName) {
        intakes.get(index).setName(newName);
    }

    public void deleteAllIntakes() {
        intakes.clear();
    }

    public void deleteDay() {
        Scanner userInput = new Scanner(System.in);
        boolean deleteDay = true;
        
        while (deleteDay) {
            System.out.println("1) Eliminar una ingesta");
            System.out.println("2) Eliminar todas las ingestas");
            System.out.println("3) Guardar Ingestas\n");
            String o = userInput.nextLine();
            
            if (o.equals("1")) {
                System.out.println("Lista de ingestas:");
                for (int i = 0; i < intakes.size(); i++) {
                    System.out.println((i + 1) + ") " + intakes.get(i).getDetails());
                }
                System.out.println("Selecciona el número de la ingesta a eliminar:");
                int index = Integer.parseInt(userInput.nextLine()) - 1;
                if (index >= 0 && index < intakes.size()) {
                    System.out.println("Eliminando la ingesta seleccionada...");
                    deleteIntake(index);
                } else {
                    System.out.println("Índice inválido.");
                }
            } else if (o.equals("2")) {
                System.out.println("Eliminando todas las ingestas...");
                deleteAllIntakes();
            } else if (o.equals("3")) {
                deleteDay = false;
            }
        }
    }

    public void editDay() {
        Scanner userInput = new Scanner(System.in);
        boolean editing = true;
        
        while (editing) {
            System.out.println("1) Editar una ingesta");
            System.out.println("2) Guardar Ingestas\n");
            String o = userInput.nextLine();
            
            if (o.equals("1")) {
                System.out.println("Lista de ingestas:");
                for (int i = 0; i < intakes.size(); i++) {
                    System.out.println((i + 1) + ") " + intakes.get(i).getDetails());
                }
                System.out.println("Selecciona el número de la ingesta a editar:");
                int index = Integer.parseInt(userInput.nextLine()) - 1;
                if (index >= 0 && index < intakes.size()) {
                    System.out.println("Ingresa el nuevo nombre para la ingesta:");
                    String newName = userInput.nextLine();
                    System.out.println("Editando la ingesta seleccionada...");
                    editIntake(index, newName);
                } else {
                    System.out.println("Índice inválido.");
                }
            } else if (o.equals("2")) {
                editing = false;
            }
        }
    }
    

    @Override
    public String toString() {
        StringBuilder intakeListing = new StringBuilder();
        for (Intake intake : intakes) {
            intakeListing.append(intake.getDetails()).append("\n");
        }
        return intakeListing.toString();
    }

    public static void main(String[] args) {
        Day monday = new Day("Lunes");
        monday.createIntakes();
        System.out.println(monday.toString());
    }
}