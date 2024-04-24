package entregas.garciaDiego.Reto002;

import java.util.ArrayList;
import java.util.Scanner;

class Intake {

    private ArrayList<Food> foodList;
    private String name; 

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Intake() {
        foodList = new ArrayList<Food>();

    }

    public void addFood(Food food) {        
        foodList.add(food);
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

    @Override
    public String toString() {
        String foodListing = name+"\n";
        for (Food food : foodList) {
            foodListing = foodListing + food.toString() + "\n";
        }
        return foodListing;
    }

    public static void main(String[] args) {

        Intake breakfast = new Intake();
        breakfast.createIntake();
        breakfast.printFoodListing();
        breakfast.deleteIntake();
        breakfast.printFoodListing();
        breakfast.updatefood();
        breakfast.printFoodListing();


    }

    public void deleteIntake() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del alimento que quieres eliminar");
        String foodName = userInput.nextLine();
        for (Food food : foodList) {
            if (food.getName().equalsIgnoreCase(foodName)) {
                this.foodList.remove(food);
            }
        }

    }

    public void updatefood() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del alimento que quieres actualizar");
        String foodName = userInput.nextLine();
        System.out.println("Nombre del nuevo alimento");
        String newfoodName = userInput.nextLine();
        for (int i=0; i<this.foodList.size();i++) {
            if (this.foodList.get(i).getName().equalsIgnoreCase(foodName)) {
                this.foodList.set(i, new Food(newfoodName));
            }
        }

    }
}
