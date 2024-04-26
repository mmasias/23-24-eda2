package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Day {
    private List<Intake> intakes;
    private String name;

    public Day(String name) {
        this.name = name;
        this.intakes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        String option;
        do {
            System.out.println("1. Add Intake");
            System.out.println("2. Delete Intake");
            System.out.println("3. Update Intake");
            System.out.println("4. List Intakes");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.print("Enter intake name: ");
                    String intakeName = scanner.nextLine();
                    addIntake(new Intake(intakeName));
                    break;
                case "2":
                    System.out.print("Enter intake name to delete: ");
                    intakeName = scanner.nextLine();
                    deleteIntake(intakeName);
                    break;
                case "3":
                    System.out.print("Enter intake name to update: ");
                    intakeName = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    updateIntake(intakeName, newName);
                    break;
                case "4":
                    printIntakeListing();
                    break;
            }
        } while (!option.equals("5"));
    }

    public void addIntake(Intake intake) {
        intakes.add(intake);
    }

    public void deleteIntake(String intakeName) {
        intakes.removeIf(intake -> intake.getName().equals(intakeName));
    }

    public void updateIntake(String intakeName, String newName) {
        for (Intake intake : intakes) {
            if (intake.getName().equals(intakeName)) {
                intake.setName(newName);
                break;
            }
        }
    }

    public void printIntakeListing() {
        for (Intake intake : intakes) {
            System.out.println(intake.getName());
        }
    }

    public static void main(String[] args) {
        Day day = new Day("Sample Day");
        day.menu();
    }

}