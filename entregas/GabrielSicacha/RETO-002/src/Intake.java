import java.util.LinkedList;
import java.util.Scanner;

public class Intake {
    private String name;
    private LinkedList<Food> foods;

    public Intake(String name) {
        this.name = name;
        foods = new LinkedList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addFood(String foodName){
        foods.add(new Food(foodName));
    }

    public void removeFood(String foodName){
       for (Food food : foods) {
            if(food.getName().equals(food)){
                foods.remove(food);
                break;
            }
        }
    }

    public void editFood(String foodName){
        for (Food food : foods) {
            if(food.getName().equals(food)){
                Scanner scanner = new Scanner(System.in);
                String newName = scanner.nextLine();
                food.setName(newName);
                break;
            }
        }
    }

    public void readFoodIntake(){
        System.out.println(this.toString());
    }

    public String toString(){
        String foodList = "-> intake: " + name + " \n";
        for (Food food : foods){
            food.toString();
        }
        return foodList;
    }

}
