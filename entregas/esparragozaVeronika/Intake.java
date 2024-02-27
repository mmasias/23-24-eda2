import java.util.ArrayList;
import java.util.Scanner;

class Intake {
    private ArrayList<Food> foods;

    public Intake() {
        this.foods = new ArrayList<>();
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public void deleteFood(String foodName) {
        boolean removed = false;
        for (int i = 0; i < foods.size(); i++) {
            if (foods.get(i).getName().equals(foodName)) {
                foods.remove(i);
                removed = true;
                break;
            }
        }
        if (removed) {
            System.out.println("Comida eliminada");
        } else {
            System.out.println("No se encontró la comida a eliminar");
        }
    }

    public void editFood(Food food) {
        System.out.println("Nuevo nombre para " + food.getName() + ": ");
        String newFoodName = new Scanner(System.in).nextLine();
        food.setName(newFoodName);
        System.out.println("Nombre del alimento actualizado correctamente.");
    }

    public void printFoodListing() {
        for (Food food : foods) {
            System.out.println(food);
        }
    }

    public void createIntake() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("Nombre del alimento (-1 para terminar): ");
            String foodName = userInput.nextLine();
            if (foodName.equals("-1")) {
                creating = !creating;
            } else {
                Food food = new Food(foodName);
                addFood(food);
            }
        }
    }

    public void deleteIntake() {
        System.out.println("Nombre del alimento a eliminar: ");
        String foodNameDelete = new Scanner(System.in).nextLine();
        deleteFood(foodNameDelete);
    }

    public void editIntake() {
        System.out.println("Nombre del alimento a editar: ");
        String foodNameEdit = new Scanner(System.in).nextLine();

        boolean found = false;
        for (Food food : foods) {
            if (food.getName().equals(foodNameEdit)) {
                editFood(food);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No se encontró el alimento: " + foodNameEdit);
        }
    }

    @Override
    public String toString() {
        StringBuilder foodListing = new StringBuilder();
        for (Food food : foods) {
            foodListing.append(food.toString()).append("\n");
        }
        return foodListing.toString();
    }

    public static void main(String[] args) {
        Intake breakfast = new Intake();
        breakfast.createIntake();
        breakfast.editIntake();
        breakfast.deleteIntake();
        breakfast.printFoodListing();
    }
}