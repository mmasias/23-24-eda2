package Crud;

import java.util.ArrayList;
import java.util.Scanner;

class Intake {

    private String name;
    private ArrayList<Food> foods;

    public Intake(String name) {
        this.name = name;
        this.foods = new ArrayList<>();
        this.manage();
    }

    private void addFood(Food food) {
        foods.add(food);
    }

    private void createFood() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
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

    private void editFood() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del alimento por editar:");
        String foodName = userInput.nextLine();
        for (Food food : foods) {
            if (food.getName().equals(foodName)) {
                System.out.println("Nuevo nombre de [" + foodName + "]");
                String newFoodName = userInput.nextLine();
                food.setName(newFoodName);
                return;
            }
        }
        System.out.println("Alimento no encontrado");
    }

    private void deleteFood() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del alimento por eliminar:");
        String foodName = userInput.nextLine();
        foods.removeIf(food -> food.getName().equals(foodName));
    }

    private void renameIntake() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nuevo nombre de [" + this.name + "]");
        String newName = userInput.nextLine();
        this.name = newName;
    }

    public void manage() {
        boolean managing = true;
        Scanner userInput = new Scanner(System.in);
        while (managing) {
            System.out.println("Gestionando [" + this.name.toUpperCase() + "]");
            System.out.println("[C]reate / [R]ead / Re[N]ame  / [U]pdate / [D]elete / e[X]it");
            switch (userInput.nextLine().toUpperCase().charAt(0)) {
                case 'C':
                    createFood();
                    break;
                case 'R':
                    System.out.println(toString());
                    break;
                case 'U':
                    editFood();
                    break;
                case 'N':
                    renameIntake();
                    break;
                case 'D':
                    deleteFood();
                    break;
                case 'X':
                    managing = !managing;
                    break;
                default:
                    System.out.println("El carácter ingresado es inválido.");
                    break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder foodListing = new StringBuilder();
        for (Food food : foods) {
            foodListing.append(food.toString()).append("\n");
        }
        return this.name + "\n" + foodListing.toString();
    }

    public String getName() {
        return this.name;
    }

    public static void main(String[] args) {
        Intake breakfast = new Intake("breakfast");
        breakfast.manage();
        System.out.println(breakfast.toString());
    }
}
