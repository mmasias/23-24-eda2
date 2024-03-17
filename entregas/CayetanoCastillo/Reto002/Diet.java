package entregas.CayetanoCastillo.Reto002;

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
        System.out.println(this.toString());
    }

    public void createDays() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("Nombre del dia (-1 para terminar)");
            String dayName = userInput.nextLine();
            if (dayName.equals("-1")) {
                creating = false;
            } else {
                Day day = new Day();
                day.createIntakes();
                addDay(day);
            }
        }
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

    @Override
    public String toString() {
        StringBuilder daysListing = new StringBuilder();
        for (Day day : days) {
            daysListing.append(day.toString()).append("\n");
        }
        return daysListing.toString();
    }
}
