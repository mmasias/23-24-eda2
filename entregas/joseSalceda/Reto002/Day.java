package entregas.joseSalceda.Reto002;

import java.util.Scanner;
import java.util.ArrayList;

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

    public void addIntake(Intake intake) {
        intakes.add(intake);
    }

    public void printIntakeListing() {
        System.out.println(this.toString());
    }

    public void createIntakes(){
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while(creating){
            System.out.println("Nombre de la ingesta (-1 para terminar)");
            String intakeName = userInput.nextLine();
            if(intakeName.equals("-1")) {
                creating=!creating;
            } else {
                Intake intake = new Intake(intakeName);
                intake.createFoods();
                addIntake(intake);
            }
        }
    }

    public void editIntake(int index, String newName) {
        intakes.get(index).setName(newName);
    }

    public void editIntake() {
        boolean editing = true;
        Scanner userInput = new Scanner(System.in);
        while(editing){
            System.out.println("Que ingesta quieres editar? (-1 para terminar)");
            printIntakeListing();
            int intakeIndex = userInput.nextInt();
            if(intakeIndex == -1){
                editing = !editing;
            } else {
                for (int i = 0; i < intakes.size(); i++) {
                    if (intakes.get(i).getName().equals(intakeIndex)) {
                        intakes.get(i).editFoods();
                    } else {
                    System.out.println("No existe esa ingesta");
                    }
                }
            }
        }
    }                                                           
        
    public void deleteIntake(int index) {
        intakes.remove(index);
    }

    public void deleteAllIntakes() {
        intakes.clear();
    }

    public void deleteIntakes(){
        boolean deleting = true;
        Scanner userInput = new Scanner(System.in);
        while(deleting){
            System.out.println("1) Eliminar todas las ingestas\n2) Eliminar una ingesta\n3) Salir");
            int option = userInput.nextInt();
            switch (option) {
                case 1:
                    deleteAllIntakes();
                    break;
                case 2:
                    System.out.println("Que ingesta quieres eliminar? (-1 para terminar)");
                    printIntakeListing();
                    int intakeIndex = userInput.nextInt();
                    if(intakeIndex == -1){
                        deleting = !deleting;
                    } else {
                        deleteIntake(intakeIndex);
                    }
                    break;
                case 3:
                    deleting = !deleting;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }
 
    @Override
    public String toString() {
        String intakesListing = "";
        for (int i = 0; i < intakes.size(); i++) {
            intakesListing = intakesListing + intakes.get(i).toString() + "\n";
        }
        return intakesListing;
    }
    
    public static void main(String[] args) {
        Day day = new Day("Lunes");
        day.createIntakes();
        day.printIntakeListing();
        day.editIntake();
        day.deleteIntakes();
        
    }
}

