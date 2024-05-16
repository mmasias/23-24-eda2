import java.util.ArrayList;

class Diet {
    private ArrayList<Day> days;

    public Diet() {
        this.days = new ArrayList<>();
    }

    public void addDay(Day day) {
        days.add(day);
    }

    public Day findDay(String identifier) {
        for (Day day : days) {
            if (day.getIdentifier().equals(identifier)) {
                return day;
            }
        }
        return null;
    }

    public boolean updateDay(String identifier, Day newDayDetails) {
        for (int i = 0; i < days.size(); i++) {
            if (days.get(i).getIdentifier().equals(identifier)) {
                days.set(i, newDayDetails);
                return true;
            }
        }
        return false;
    }

    public boolean deleteDay(String identifier) {
        return days.removeIf(day -> day.getIdentifier().equals(identifier));
    }
    
    public void printDayListing() {
        System.out.println(this.toString());
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
