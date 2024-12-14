package entregas.lopesBrenda.Reto002;

import java.util.Scanner;
import java.util.ArrayList;


class Intake {
    private ArrayList<Food> foods;
    private String name;

    public Intake (String name) {
        this.name = name;
        foods = new ArrayList<>();
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void menu() {
        Scanner scanner = new Scanner(System.in);
        String option;
        do {
            System.out.println("1. Add Food");
            System.out.println("2. Delete Food");
            System.out.println("3. Update Food");
            System.out.println("4. List Foods");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextLine();

            switch (option) {
                case "1":
                    System.out.print("Enter food name: ");
                    String foodName = scanner.nextLine();
                    addFood(new Food(foodName));
                    break;
                case "2":
                    System.out.print("Enter food name to delete: ");
                    foodName = scanner.nextLine();
                    deleteFood(foodName);
                    break;
                case "3":
                    System.out.print("Enter food name to update: ");
                    foodName = scanner.nextLine();
                    System.out.print("Enter new name: ");
                    String newName = scanner.nextLine();
                    updateFood(foodName, newName);
                    break;
                case "4":
                    printFoodListing();
                    break;
            }
        } while (!option.equals("5"));
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public void printFoodListing() {
        System.out.println(this.toString());
    }

    public void updateFood(String foodName, String newName) {
        for (Food food : foods) {
            if (food.getName().equals(foodName)) {
                food.setName(newName);
                break;
            }
        }
    }

    private void deleteFood(String foodName) {
        foods.removeIf(food -> food.getName().equals(foodName));
    }
    
    public static void main(String[] args) {

        Intake intake = new Intake("Sample Intake");
        intake.menu();
    }
}