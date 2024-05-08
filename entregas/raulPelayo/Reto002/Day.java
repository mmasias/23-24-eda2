import java.util.ArrayList;
import java.util.Scanner;

public class Day {
    private ArrayList<Intake> intakes;
    private String name;

    public Day() {
        
        intakes = new ArrayList<>();
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
                creating = false;
            } else {
                Intake intake = new Intake();
                intake.setName(intakeName);
                intake.createIntake();
                addIntake(intake);
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
        monday.createIntakes();
        monday.printIntakeListing();
        monday.deleteIntakes();
        monday.printIntakeListing();
        monday.updateIntakes();
        monday.printIntakeListing();
    }

    public void deleteIntakes() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombrame el nombre de la ingesta que quieres eliminar");
        String intakeName = userInput.nextLine();
        int index = -1;
        for (int i = 0; i < intakes.size(); i++) {
            if (intakes.get(i).getName().equalsIgnoreCase(intakeName)) {
                index = i;
                break;
            }
        }
        if (index != -1) {
            intakes.remove(index);
        } else {
            System.out.println("La ingesta no existe.");
        }
    }

    public void updateIntakes() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombrame el nombre de la ingesta que quieres actualizar");
        String intakeName = userInput.nextLine();
        for (Intake intake : intakes) {
            if (intake.getName().equalsIgnoreCase(intakeName)) {
                System.out.println("Dime la comida que quieres insertar en " + intake.getName());
                String foodName = userInput.nextLine();
                intake.addFood(new Food(foodName));
            }
        }
    }
}