package LinkedListSolution;

import java.util.LinkedList;
import java.util.Scanner;

public class Day {
  private String name;
  private LinkedList<Intake> intakes;

  public Day(String name) {
    this.name = name;
    intakes = new LinkedList<Intake>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void addDay(Intake intake) {
    intakes.add(intake);
    intake.createIntake();
  }

  public void printIntakeListing() {
    intakes.forEach(intake -> System.out.println(intake.toString()));
  }

  public void createDay() {
    boolean creating = true;
    Scanner userInput = new Scanner(System.in);
    while (creating) {
      System.out.println("Nombre de la Ingesta (-1 para terminar)");
      String intakeName = userInput.nextLine();
      if (intakeName.equals("-1")) {
        creating = !creating;
      } else {
        Intake intake = new Intake(intakeName);
        addDay(intake);
      }
    }
  }

  public void editDay() {
    boolean editing = true;
    Scanner userInput = new Scanner(System.in);
    while (editing) {
      System.out.println("Nombre de la ingesta a editar (-1 para terminar)");
      String intakeName = userInput.nextLine();
      if (intakeName.equals("-1")) {
        editing = !editing;
      } else {
        for (Intake intake : intakes) {
          if (intake.getName().equals(intakeName)) {
            System.out.println("Ingrese el nuevo nombre de la ingesta");
            String newIntakeName = userInput.nextLine();
            intake.setName(newIntakeName);
            intake.editIntake();
          }
        }
      }
    }
  }

  public void deleteDay() {
    boolean deleting = true;
    Scanner userInput = new Scanner(System.in);
    while (deleting) {
      System.out.println("Nombre de la ingesta a eliminar (-1 para terminar)");
      String intakeName = userInput.nextLine();
      if (intakeName.equals("-1")) {
        deleting = !deleting;
      } else {
        intakes.removeIf(intake -> intake.getName().equals(intakeName));
      }
    }
  }

  @Override
  public String toString() {
    String intakeList = "]> Day: " + name + "\n";
    for (Intake intake : intakes) {
      intakeList += intake.toString() + "\n";
    }
    return intakeList;
  }
}
