import java.util.Scanner;

public class Intake {
    String name;
    FoodNode first;

    public Intake(String name) {
        this.name = name;
        this.first = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public FoodNode getFirst() {
        return first;
    }

    public void setFirst(FoodNode first) {
        this.first = first;
    }

    public void addFood(Food food){
        FoodNode newFoodNode = new FoodNode(food);
        if (first == null) {
            first = newFoodNode;
        } else {
            FoodNode current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newFoodNode);
        }
    }

    public void deleteFood(String foodName){
        FoodNode iterator=this.first;
        while ((iterator.getNext().getFood()!=null)||(iterator.getNext().getFood().getName().equals(foodName))){
            iterator=iterator.getNext();
        }
        if (iterator.getFood()!=null){
            iterator.setNext(iterator.getNext().getNext());
        }
    }

    public void editFood(String foodName){
        FoodNode iterator=this.first;
        while ((iterator.getNext().getFood()!=null)||(iterator.getNext().getNext().getFood().getName().equals(foodName))){
            iterator=iterator.getNext();
        }
        if (iterator.getFood()!=null){
            Scanner scanner = new Scanner(System.in);
            String newName = scanner.nextLine();
            iterator.getFood().setName(newName);
        }
    }
    public void readFoodIntake() {
        System.out.println(this.toString());
    }

    public String toString() {
        String foodListing = "";
        FoodNode current = first;
        while (current != null) {
            foodListing = foodListing + current.getFood().toString() + "\n";
            current = current.getNext();
        }
        return foodListing;
    }
}
