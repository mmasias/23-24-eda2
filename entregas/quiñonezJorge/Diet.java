
import java.util.ArrayList;
import java.util.Scanner;

public class Diet {
  private ArrayList<Day> days;

  public Diet() {
    days = new ArrayList<Day>();
  }

  public void addDiet(Day day) {
    days.add(day);
  }

  public void printDayListing() {
    days.forEach(day -> System.out.println(day.toString()));
  }

  public void createDiet() {
    boolean creating = true;
    Scanner userInput = new Scanner(System.in);
    while (creating) {
      System.out.println("Nombre del dia (-1 para terminar)");
      String dayName = userInput.nextLine();
      if (dayName.equals("-1")) {
        creating = !creating;
      } else {
        Day day = new Day(dayName);
        days.add(day);
        day.createDay();
      }
    }
  }

  public void editDiet() {
    boolean editing = true;
    Scanner userInput = new Scanner(System.in);
    while (editing) {
      System.out.println("Nombre del dia a editar (-1 para terminar)");
      String dayName = userInput.nextLine();
      if (dayName.equals("-1")) {
        editing = !editing;
      } else {
        days.forEach(day -> {
          if (day.getName().equals(dayName)) {
            System.out.println("Ingrese el nuevo nombre del dia");
            String newdayName = userInput.nextLine();
            day.setName(newdayName);
            day.editDay();
          }
        });
      }
    }
  }

  public void deleteDiet() {
    boolean deleting = true;
    Scanner userInput = new Scanner(System.in);
    while (deleting) {
      System.out.println("Nombre del dia a eliminar (-1 para terminar)");
      String dayName = userInput.nextLine();
      if (dayName.equals("-1")) {
        deleting = !deleting;
      } else {
        days.removeIf(day -> day.getName().equals(dayName));
      }
    }
  }

  @Override
  public String toString() {
    String dayList = "";
    for (Day day : days) {
      dayList += day.toString() + "\n";
    }
    return dayList;
  }

  public static void main(String[] args) {

    Diet diet = new Diet();
    diet.createDiet();
    diet.editDiet();
    diet.deleteDiet();
    diet.printDayListing();

  }
}
