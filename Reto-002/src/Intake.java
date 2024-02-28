
import java.util.ArrayList;
import java.util.Scanner;

class Intake {
    private ArrayList<Food> x ;

    public Intake() {
        x=new ArrayList<>();
    }

    public void addFood(Food food) {


        x.add(food);

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
        return x.toString();

    }

    public static void main(String[] args) {

        Intake breakfast = new Intake();
        breakfast.createIntake();
        breakfast.printFoodListing();

    }
}
