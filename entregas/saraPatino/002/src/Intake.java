package src;

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

    public void deleteFood() {
        Scanner userInput = new Scanner(System.in);
        if (foods.isEmpty()) {
            System.out.println("La lista de alimentos está vacía.");
            return;
        }

        System.out.println("¿Qué alimento deseas eliminar?");
        String foodName = userInput.nextLine();

        boolean found = false;
        for (Food food : foods) {
            if (food.getName().equals(foodName)) {
                foods.remove(food);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No se encontró el alimento a eliminar.");
        }
    }

    private void deleteAllFoods() {
        foods.clear();
        System.out.println("\nTodos los alimentos han sido eliminados con éxito!");
    }

    public void updateFood() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("¿Qué alimento deseas actualizar?");
        String name = userInput.nextLine();

        System.out.println("Nombre del nuevo alimento");
        String updatedFood = userInput.nextLine();

        boolean found = false;
        for (Food food : foods) {
            if (food.getName().equals(name)) {
                food.setName(updatedFood);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No se encontró el alimento a actualizar.");
        }
    }

    public void menu() {
        Scanner userInput = new Scanner(System.in);
        boolean finish = false;
        System.out.println(">>OPCIONES INGESTA<< \n");
        while (!finish) {
            System.out.println("1. Agregar");
            System.out.println("2. Eliminar");
            System.out.println("3. Modificar");
            System.out.println("4. Mostrar");
            System.out.println("5. Eliminar todo");
            System.out.println("6. Salir");
            int option = userInput.nextInt();
            switch (option) {
                case 1:
                    createIntake();
                    break;
                case 2:
                    deleteFood();
                    break;
                case 3:
                    updateFood();
                    break;
                case 4:
                    printFoodListing();
                    break;
                case 5:
                    deleteAllFoods();
                    break;
                case 6:
                    finish = true;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

    public static void main(String[] args) {

        Intake breakfast = new Intake();
        
        breakfast.menu();

    }
}