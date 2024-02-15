package entregas.quiñonezJorge;

import java.util.Scanner;

public class Intake {
  private genericNode<Food> first;

  public Intake() {
    first = null;
  }

  public void addFood(Food food) {
    genericNode<Food> newFoodNode = new genericNode<Food>(food);
    if (first == null) {
      first = newFoodNode;
    } else {
      genericNode<Food> current = first;
      while (current.getNext() != null) {
        current = current.getNext();
      }
      current.setNext(newFoodNode);
    }
  }

  public void printFoodListing() {
    System.out.println(this.toString());
  }

  public void createIntake() {
    boolean creating = true;
    Scanner userInput = new Scanner(System.in);
    while (creating) {
      System.out.println("Nombre del alimento (-1 para terminar)");
      String foodName = userInput.nextLine();
      if (foodName.equals("-1")) {
        creating = !creating;
      } else {
        Food food = new Food(foodName);
        addFood(food);
      }
    }
  }

  public void editIntake() {
    boolean editing = true;
    Scanner userInput = new Scanner(System.in);
    while (editing) {
      System.out.println("Nombre del alimento a editar (-1 para terminar)");
      String foodName = userInput.nextLine();
      if (foodName.equals("-1")) {
        editing = !editing;
      } else {
        genericNode<Food> current = first;
        while (current != null) {
          if (current.getData().getName().equals(foodName)) {
            System.out.println("Ingrese el nuevo nombre del alimento");
            String newFoodName = userInput.nextLine();
            current.getData().setName(newFoodName);
          }
          current = current.getNext();
        }
      }
    }
  }

  public void deleteIntake() {
    boolean deleting = true;
    Scanner userInput = new Scanner(System.in);
    while (deleting) {
      System.out.println("Nombre del alimento a eliminar (-1 para terminar)");
      String foodName = userInput.nextLine();
      if (foodName.equals("-1")) {
        deleting = !deleting;
      } else {
        genericNode<Food> current = first;
        genericNode<Food> previous = null;
        while (current != null) {
          if (current.getData().getName().equals(foodName)) {
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
    String foodListing = "";
    genericNode<Food> current = first;
    while (current != null) {
      foodListing = foodListing + current.getData().toString() + "\n";
      current = current.getNext();
    }
    return foodListing;
  }

  public static void main(String[] args) {

    Intake breakfast = new Intake();
    breakfast.createIntake();
    breakfast.editIntake();
    breakfast.deleteIntake();
    breakfast.printFoodListing();

  }
}
