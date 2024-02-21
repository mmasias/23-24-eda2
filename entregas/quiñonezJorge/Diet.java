package entregas.quiñonezJorge;

import java.util.Scanner;

public class Diet {
  private GenericNode<Day> first;

  public Diet() {
    first = null;
  }

  public void addDiet(Day day) {
    GenericNode<Day> newDayNode = new GenericNode<Day>(day);
    if (first == null) {
      first = newDayNode;
    } else {
      GenericNode<Day> current = first;
      while (current.getNext() != null) {
        current = current.getNext();
      }
      current.setNext(newDayNode);
    }

  }

  public void printDayListing() {
    System.out.println(this.toString());
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
        addDiet(day);
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
        GenericNode<Day> current = first;
        while (current != null) {
          if (current.getData().getName().equals(dayName)) {
            System.out.println("Ingrese el nuevo nombre del dia");
            String newDayName = userInput.nextLine();
            current.getData().setName(newDayName);
            current.getData().editDay();
          }
          current = current.getNext();
        }
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
        GenericNode<Day> current = first;
        GenericNode<Day> previous = null;
        while (current != null) {
          if (current.getData().getName().equals(dayName)) {
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
    String dayListing = "";
    GenericNode<Day> current = first;
    while (current != null) {
      dayListing = dayListing + current.getData().toString() + "\n";
      current = current.getNext();
    }
    return dayListing;
  }
}
