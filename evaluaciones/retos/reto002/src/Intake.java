import java.util.ArrayList;
import java.util.Scanner;

public class Intake {
    private String name;
    private ArrayList<Food> foods;
    Scanner userInput = new Scanner(System.in);

    public Intake(String name) {
        this.name = name;
        foods = new ArrayList<>();
    }

    public String getIntakeName() {
        return name;
    }

    public void setIntakeName(String name) {
        this.name = name;
    }

    public Food searchFood(String foodName) {
        for(Food f: foods) {
            if(f.getName().equals(foodName)) {
                return f;
            }
        }
        return null;
    }

    private void addFood(Food food) {
        foods.add(food);
    }

    public void printFoodListing() {
        System.out.println(this.toString());
    }

    public void createFoods() {
        boolean creating = true;
        while (creating) {
            System.out.println("Nombre del alimento por crear (-1 para terminar)");
            String foodName = userInput.nextLine();
            if (foodName.equals("-1")) {
                creating = !creating;
            } else {
                Food food = new Food(foodName);
                addFood(food);
            }
        }
    }

    private void deleteFood(String foodName) {
        Food wantedFood = searchFood(foodName);
        foods.remove(wantedFood);
    }

    public void deleteFoods() {
        boolean deleting = true;

        while (deleting) {
            System.out.println("Nombre del alimento por eliminar (-1 para terminar)");
            String foodName = userInput.nextLine();

            if (foodName.equals("-1")) {
                deleting = !deleting;
            } else {
                deleteFood(foodName);
            }
        }
    }

    public void deleteAllIntake() {
        foods.clear();
    }

    private void updateFood(String oldName, String newName) {
        Food foodToEdit = searchFood(oldName);
        foodToEdit.setName(newName);
    }

    public void updateFoods() {
        boolean updating = true;
        while(updating) {
            System.out.println("Nombre del alimento a editar (-1 para terminar): ");
            String oldName = userInput.nextLine();

            if (oldName.equals("-1")) {
                updating = !updating;
            } else {
                System.out.println("Nuevo nombre del alimento:" );
                String newName = userInput.nextLine();
                updateFood(oldName, newName);
            }

        }
    }

    @Override
    public String toString() {
        StringBuilder foodListing = new StringBuilder();
        for (Food f : foods) {
            foodListing.append(f.toString()).append("\n");
        }

        return foodListing.toString();
    }

    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Introduce el nombre del intake: ");
        String intakeName = userInput.nextLine();
        Intake breakfast = new Intake(intakeName);

        breakfast.createFoods();
        breakfast.printFoodListing();

        breakfast.updateFoods();
        breakfast.printFoodListing();

        breakfast.deleteFoods();
        breakfast.printFoodListing();

        breakfast.deleteAllIntake();
        breakfast.printFoodListing();
    }


    
}
