package entregas.quiñonezJorge;

import java.util.Scanner;

public class Intake {
  private String name;
  private GenericNode<Food> first;

  public Intake(String name) {
    this.name = name;
    first = null;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void addFood(Food food) {
    GenericNode<Food> newFoodNode = new GenericNode<Food>(food);
    if (first == null) {
      first = newFoodNode;
    } else {
      GenericNode<Food> current = first;
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
        GenericNode<Food> current = first;
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
        GenericNode<Food> current = first;
        GenericNode<Food> previous = null;
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
    GenericNode<Food> current = first;
    foodListing = "]> Ingesta: " + name + "\n";
    while (current != null) {
      foodListing = foodListing + current.getData().toString() + "\n";
      current = current.getNext();
    }
    return foodListing;
  }
}
