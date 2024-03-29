import java.util.LinkedList;
import java.util.Scanner;

public class Diet {

    private String name;
    private LinkedList<Day> days;

    public Diet(String name) {
        this.name = name;
        days = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addDay(String date){
        days.add(new Day(date));
    }

    public void deteleDay(String date){
        for(Day day : days){
            if(day.getDate().equals(date)){
                days.remove(day);
            }
        }
    }

    public void editDay(String date){
        for(Day day : days){
            if(day.getDate().equals(date)){
                Scanner scanner = new Scanner(System.in);
                String newName = scanner.nextLine();
                day.setDate(newName);
                break;
            }
        }
    }

    public void readIntakeListing() {
        System.out.println(this.toString());
    }

    public String toString(){
        String intakeList = "---> diet: " + name + " \n";
        for (Day day : days){
            day.toString();
        }
        return intakeList;
    }
}
