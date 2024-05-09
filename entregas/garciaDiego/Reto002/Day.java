package entregas.garciaDiego.Reto002;

import java.util.ArrayList;
import java.util.Scanner;

class Day {
    private ArrayList<Intake> intakeList;
    private String name;

    public String getName() {
        return name;
    }

    public  void setName(String name) {
        this.name = name;
    }

    public Day() {
        intakeList = new ArrayList<Intake>();

    }

    public void addIntake(Intake intake) {
        intakeList.add(intake);
    }

    public void printIntakeListing() {
        System.out.println(this.toString());
    }

    public void createIntakes() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("Nombre de la ingesta (-1 para terminar)");
            String dayName = userInput.nextLine();
            if (dayName.equals("-1")) {
                creating = !creating;
            } else {
                Intake intake = new Intake();
                intake.setName(dayName);
                intake.createIntake();
                addIntake(intake);
            }
        }
    }

    @Override
    public String toString() {
        String intakeListing = name+"\n";
        for (Intake intake : intakeList) {
            intakeListing = intakeListing + intake.toString() + "\n";
        }
        return intakeListing;
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
        for(int i=0; i<this.intakeList.size();i++){
            if (this.intakeList.get(i).getName().equalsIgnoreCase(intakeName)) {
                this.intakeList.remove(i);
            }
        }        
    }

    public void updateIntakes() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombrame el nombre de la ingesta que quieres actualizar");
        String intakeName = userInput.nextLine();
        for(int i=0; i<this.intakeList.size();i++){
            if (this.intakeList.get(i).getName().equalsIgnoreCase(intakeName)) {
                System.out.println("Nombrame el nombre de la ingesta que quieres añadir");
                String newintakeName = userInput.nextLine();

                Intake intake= new Intake();
                intake.setName(newintakeName);
                intake.createIntake(); 

                intakeList.set(i, intake);

            }
        }       

    }


}