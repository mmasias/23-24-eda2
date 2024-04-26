package entregas.DiegoBarraza.reto001;

import java.util.Scanner;

public class Intake {
    private FoodNode first;

    public Intake() {
        first = null;
    }

    public void addFood(Food food) {
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

    public void editIntake() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del alimento a editar(-1 para terminar)");
        String foodName = userInput.nextLine();
        FoodNode current = first;
        while (current != null) {
            if (current.getFood().getName().equals(foodName)) {
                System.out.println("Nuevo nombre del alimento");
                String newFoodName = userInput.nextLine();
                current.getFood().setName(newFoodName);
                break;
            }
            if(current.getNext() == null){
                System.out.println("El alimento no existe");
            }
            if(foodName.equals("-1")){
                break;
            }
            current = current.getNext();
        }
    }
    public void deleteAllIntake(){
        first = null;
    }

    public void deleteIntake(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del alimento a eliminar(-1 para terminar)");
        String foodName = userInput.nextLine();
        FoodNode current = first;
        FoodNode previous = null;
        while (current != null) {
            if (current.getFood().getName().equals(foodName)) {
                if(previous == null){
                    first = current.getNext();
                }else{
                    previous.setNext(current.getNext());
                }
                break;
            }
            if(current.getNext() == null){
                System.out.println("El alimento no existe");
            }
            if(foodName.equals("-1")){
                break;
            }
            previous = current;
            current = current.getNext();
        }
    }

   
    @Override
    public String toString() {
        String foodListing = "";
        FoodNode current = first;
        while (current != null) {
            foodListing = foodListing + current.getFood().toString() + "\n";
            current = current.getNext();
        }
        return foodListing;
    }

    public static void main(String[] args) {

        Intake breakfast = new Intake();
        breakfast.createIntake();
        breakfast.printFoodListing();
        breakfast.editIntake();
        breakfast.deleteIntake();
        breakfast.printFoodListing();
        breakfast.createIntake();
        breakfast.editIntake();
        breakfast.deleteIntake();
        breakfast.printFoodListing();
        

    }

}
