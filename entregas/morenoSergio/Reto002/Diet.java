import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Diet {
    private List<Day> days;
    private String name;

    public Diet(String name) {
        this.name = name;
        this.days = new ArrayList<>();
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        String option;
        do {
            System.out.println("1. Add Day");
            System.out.println("2. Delete Day");
            System.out.println("3. Update Day");
            System.out.println("4. List Days");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.print("Enter day name: ");
                    String dayName = scanner.nextLine();
                    addDay(new Day(dayName));
                    break;
                case "2":
                    System.out.print("Enter day name to delete: ");
                    dayName = scanner.nextLine();
                    deleteDay(dayName);
                    break;
                case "3":
                    System.out.print("Enter day name to update: ");
                    dayName = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    updateDay(dayName, newName);
                    break;
                case "4":
                    printDayListing();
                    break;
            }
        } while (!option.equals("5"));
    }

    public void addDay(Day day) {
        days.add(day);
    }

    public void deleteDay(String dayName) {
        days.removeIf(day -> day.getName().equals(dayName));
    }

    public void updateDay(String dayName, String newName) {
        for (Day day : days) {
            if (day.getName().equals(dayName)) {
                day.setName(newName);
                break;
            }
        }
    }

    public void printDayListing() {
        for (Day day : days) {
            System.out.println(day.getName());
        }
    }

    public static void main(String[] args) {
        Diet diet = new Diet("Sample Diet");
        diet.menu();
    }
}