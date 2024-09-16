import java.util.LinkedList;
import java.util.Scanner;

public class Day {
    private String date;
    private LinkedList<Intake> intakes;

    public Day(String date) {
        this.date = date;
        intakes = new LinkedList<>();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void addIntake(String intakeName){
        intakes.add(new Intake(intakeName));
    }

    public void deteleIntake(String intakeName){
        for(Intake intake : intakes){
            if(intake.getName().equals(intakeName)){
                intakes.remove(intake);
            }
        }
    }

    public void editIntake(String intakeName){
        for(Intake intake : intakes){
            if(intake.getName().equals(intakeName)){
                Scanner scanner = new Scanner(System.in);
                String newName = scanner.nextLine();
                intake.setName(newName);
                break;
            }
        }
    }

    public void readIntakeListing() {
        System.out.println(this.toString());
    }

    public String toString(){
        String intakeList = "--> day: " + date + " \n";
        for (Intake intake : intakes){
            intake.toString();
        }
        return intakeList;
    }
}
