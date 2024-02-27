import java.util.ArrayList;
import java.util.Scanner;

class Diet {
    private ArrayList<Day> days;

    public Diet() {
        days = new ArrayList<>();
    }

    public void addDay(Day day){
        days.add(day);
    }

    public void printDayListing(){
        System.out.println(this.toString());
    }

    public void createDays() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while(creating){
            System.out.println("Nombre del dia (-1 para terminar)");
            String dayName = userInput.nextLine();
            if(dayName.equals("-1")) {
                creating = false;
            } else {
                Day day = new Day();
                day.createIntakes();
                addDay(day);
            }
        }
    }

    public void deleteDay(int dayIndex){
        days.remove(dayIndex - 1);
    }

    public void editDay(int dayIndex){
        deleteDay(dayIndex - 1);
        createDays();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < days.size(); i++) {
            result.append("Day ").append(i + 1).append(":\n").append(days.get(i)).append("\n");
        }
        return result.toString();
    }

    public static void main(String[] args) {

        Diet diet = new Diet();
        diet.createDays();
        diet.printDayListing();
        System.out.println("Número del dia a editar: ");
        int dayEdit = Integer.parseInt(new Scanner(System.in).nextLine());
        diet.editDay(dayEdit);
        diet.printDayListing();
        System.out.println("Número del dia a eliminar: ");
        int dayDelete = Integer.parseInt(new Scanner(System.in).nextLine());
        diet.deleteDay(dayDelete);
        diet.printDayListing();
    }
}
