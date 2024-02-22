package ArrayListSolution;

import java.util.ArrayList;
import java.util.Scanner;

public class Intake {

  private String name;
  private ArrayList<Food> foodList;

  public Intake(String name) {
    this.name = name;
    foodList = new ArrayList<Food>();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void addFood(Food food) {
    foodList.add(food);
  }

  public void printFoodListing() {
    foodList.forEach(food -> System.out.println(food.toString()));
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
        foodList.forEach(food -> {
          if (food.getName().equals(foodName)) {
            System.out.println("Ingrese el nuevo nombre del alimento");
            String newFoodName = userInput.nextLine();
            food.setName(newFoodName);
          }
        });
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
        foodList.removeIf(food -> food.getName().equals(foodName));
      }
    }
  }

  @Override
  public String toString() {
    String foodListing = "]> Ingesta: " + name + "\n";
    for (Food food : foodList) {
      foodListing += food.toString();
    }
    return foodListing;
  }
}
