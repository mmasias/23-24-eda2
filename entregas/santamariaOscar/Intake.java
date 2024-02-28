import java.util.ArrayList;
import java.util.Scanner;

class Intake {
    private ArrayList<Food> foods;

    public Intake() {
        foods = new ArrayList<>();
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
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("Nombre del alimento (-1 para terminar)");
            String foodName = userInput.nextLine();
            if (foodName.equals("-1")) {
                creating = false;
            } else {
                Food food = new Food(foodName);
                addFood(food);
            }
        }
    }

    public void repleaceIntake() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del alimento a reemplazar, 0 para cancelar");
        String foodName = userInput.nextLine();

        if (foodName.equals("0")) {
            return;
        }

        for (Food food : foods) {
            if (food.getName().equals(foodName)) {
                System.out.println("Nuevo nombre del alimento");
                String newFoodName = userInput.nextLine();
                food.setName(newFoodName);
            }
        }
    }

    public void updateIntake() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del alimento a modificar, 0 para cancelar");
        String foodName = userInput.nextLine();

        if (foodName.equals("0")) {
            return;
        }

        for (Food food : foods) {
            if (food.getName().equals(foodName)) {
                System.out.println("Nuevo nombre del alimento");
                String newFoodName = userInput.nextLine();
                food.setName(newFoodName);
            }
        }
    }

    public void deleteIntake() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del alimento a eliminar, 0 para cancelar");
        String foodName = userInput.nextLine();

        if (foodName.equals("0")) {
            return;
        }

        foods.removeIf(food -> food.getName().equals(foodName));
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("Ingesta: ");
        if (!foods.isEmpty()) {
            result.append(foods.get(0).getName());
            for (int i = 1; i < foods.size(); i++) {
                result.append(", ").append(foods.get(i).getName());
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Intake intake = new Intake();
        intake.createIntake();
        intake.printFoodListing();
        intake.repleaceIntake();
        intake.printFoodListing();
        intake.updateIntake();
        intake.printFoodListing();
        intake.deleteIntake();
        intake.printFoodListing();
    }

}
