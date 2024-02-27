import java.util.ArrayList;
import java.util.Scanner;

class Diet {
    private ArrayList<Day> days;

    public Diet() {
        days = new ArrayList<>();
    }

    public void addDay(Day day) {
        days.add(day);
    }

    public void printDayListing() {
        for (Day day : days) {
            System.out.println(day);
        }
    }

    public void createDays() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("Nombre del día (-1 para terminar)");
            String dayName = userInput.nextLine();
            if (dayName.equals("-1")) {
                creating = false;
            } else {
                Day day = new Day();
                day.createIntakes();
                addDay(day);
            }
        }
        userInput.close();
    }

    public boolean updateDay(int position, Day newDay) {
        if (position >= 0 && position < days.size()) {
            days.set(position, newDay);
            return true;
        }
        return false;
    }

    public boolean deleteDay(int position) {
        if (position >= 0 && position < days.size()) {
            days.remove(position);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Diet diet = new Diet();
        diet.createDays();
        diet.printDayListing();
    }
}
