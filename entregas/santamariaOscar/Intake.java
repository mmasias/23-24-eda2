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
        userInput.close();
    }

    public void removeIntake() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del alimento a eliminar, 0 para cancelar");
        String foodName = userInput.nextLine();

        if (foodName.equals("0")) {
            return;
        }

        foods.removeIf(food -> food.getName().equals(foodName));
        
    }

    public void continueAdding() {
        Scanner userInput = new Scanner(System.in);
        String input;

        do {
            removeIntake();
            System.out.println("¿Desea continuar agregando alimentos? (S/N)");
            input = userInput.nextLine();

            if (!input.equalsIgnoreCase("S")) {
                printFoodListing();
            } else {
                createIntake();
            }
        } while (input.equalsIgnoreCase("S"));

        if (!input.equalsIgnoreCase("N")) {
            printFoodListing();
        }

        userInput.close();
    }

    public static void main(String[] args) {
        Intake breakfast = new Intake();
        breakfast.createIntake();
        breakfast.printFoodListing();
        breakfast.continueAdding();
    }
}
