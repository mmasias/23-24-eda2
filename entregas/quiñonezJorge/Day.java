package entregas.quiñonezJorge;

import java.util.Scanner;

public class Day {
  private String name;
  private GenericNode<Intake> first;

  public Day(String name) {
    this.name = name;
    first = null;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void addDay(Intake intake) {
    GenericNode<Intake> newIntakeNode = new GenericNode<Intake>(intake);
    if (first == null) {
      first = newIntakeNode;
    } else {
      GenericNode<Intake> current = first;
      while (current.getNext() != null) {
        current = current.getNext();
      }
      current.setNext(newIntakeNode);
    }

  }

  public void printIntakeListing() {
    System.out.println(this.toString());
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
        intake.createIntake();
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
        GenericNode<Intake> current = first;
        while (current != null) {
          if (current.getData().getName().equals(intakeName)) {
            System.out.println("Ingrese el nuevo nombre de la ingesta");
            String newIntakeName = userInput.nextLine();
            current.getData().setName(newIntakeName);
            current.getData().editIntake();
          }
          current = current.getNext();
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
        GenericNode<Intake> current = first;
        GenericNode<Intake> previous = null;
        while (current != null) {
          if (current.getData().getName().equals(intakeName)) {
            if (previous == null) {
              first = current.getNext();
            } else {
              previous.setNext(current.getNext());
            }
          }
          previous = current;
          current = current.getNext();
        }
      }
    }
  }

  @Override
  public String toString() {
    String intakeListing = "";
    GenericNode<Intake> current = first;
    intakeListing = "]> Dia: " + name + "\n";
    while (current != null) {
      intakeListing = intakeListing + current.getData().toString() + "\n";
      current = current.getNext();
    }
    return intakeListing;
  }
}
