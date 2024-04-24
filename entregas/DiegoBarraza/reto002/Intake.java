package entregas.DiegoBarraza.reto002;

import java.util.ArrayList;
import java.util.Scanner;

class Intake {
    private String name;
    private ArrayList<Food> foods;

    public Intake() {
        foods = new ArrayList<>();
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public void printFoodListing() {
        for (Food food : foods) {
            System.out.println(food);
        }
    }

    public void createIntake() {
        Scanner userInput = new Scanner(System.in);
        while (true) {
            System.out.println("Nombre del alimento (-1 para terminar)");
            String foodName = userInput.nextLine();
            if (foodName.equals("-1")) {
                break;
            } else {
                Food food = new Food(foodName);
                addFood(food);
            }
        }
    }

    public void editIntake() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del alimento a editar(-1 para terminar)");
        String foodName = userInput.nextLine();
        for (Food food : foods) {
            if (food.getName().equals(foodName)) {
                System.out.println("Nuevo nombre del alimento");
                String newFoodName = userInput.nextLine();
                food.setName(newFoodName);
                return;
            }
        }
        System.out.println("El alimento no existe");
    }

    public void deleteAllIntake() {
        foods.clear();
    }

    public void deleteIntake() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del alimento a eliminar(-1 para terminar)");
        String foodName = userInput.nextLine();
        for (int i = 0; i < foods.size(); i++) {
            if (foods.get(i).getName().equals(foodName)) {
                foods.remove(i);
                return;
            }
        }
        System.out.println("El alimento no existe");
    }

    @Override
    public String toString() {
        StringBuilder foodListing = new StringBuilder();
        for (Food food : foods) {
            foodListing.append(food).append("\n");
        }
        return foodListing.toString();
    }
}