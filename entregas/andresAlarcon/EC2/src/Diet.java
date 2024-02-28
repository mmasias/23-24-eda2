import java.util.ArrayList;

class Diet {
  private ArrayList<Day> days;

  public Diet() {
      days = new ArrayList<>();
  }

  public void addDay(Day day){
      days.add(day);
  }

  public void updateDay(Day day, int index) {
      days.set(index, day);
  }

  public void deleteDay(int index) {
      days.remove(index);
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