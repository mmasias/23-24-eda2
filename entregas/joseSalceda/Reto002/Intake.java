package entregas.joseSalceda.Reto002;

import java.util.Scanner;
import java.util.ArrayList;

class Intake {
    String name;
    private ArrayList<Food> foods;

    public Intake(String name) {
        this.name = name;
        this.foods = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public void printFoodListing() {
        System.out.println(this.toString());
    }

    public void createFoods() {
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

    public void editFood(int index, String newName) {
        foods.get(index).setName(newName);
    }

    public void editFoods() {
        boolean editing = true;
        Scanner userInput = new Scanner(System.in);
        while(editing){
            System.out.println("Nombre del alimento a editar (-1 para terminar)");
            printFoodListing();
            String foodName = userInput.nextLine();
            if(foodName.equals("-1")){
                editing = !editing;
            } else {
                for (int i = 0; i < foods.size(); i++) {
                    if (foods.get(i).getName().equals(foodName)) {
                        System.out.println("Nuevo nombre del alimento");
                        String newFoodName = userInput.nextLine();
                        editFood(i, newFoodName);
                    } else {
                        System.out.println("Alimento no encontrado");
                    }
                }
            }
        }       
    }

    public void deleteFood(int index) {
        foods.remove(index);
    }

    public void deleteAllFoods() {
        foods.clear();
    }

    public void deleteFoods(){
        boolean deleting = true;
        Scanner userInput = new Scanner(System.in);
        while(deleting){
            System.out.println("1) Elimiar todas las comidas\n2) Elimiar una comida especifica\n3) Salir");
            int option = userInput.nextInt();
            switch (option) {
                case 1:
                    deleteAllFoods();
                    break;
                case 2:
                    System.out.println("Nombre del alimento a eliminar");
                    printFoodListing();
                    String foodName = userInput.nextLine();
                    for (int i = 0; i < foods.size(); i++) {
                        if (foods.get(i).getName().equals(foodName)) {
                            deleteFood(i);
                        } else {
                            System.out.println("Alimento no encontrado");
                        }
                    }
                    break;
                case 3:
                    deleting = !deleting;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }

    @Override
    public String toString() {
        String foodListing = "";
        for (Food food : foods) {
            foodListing = foodListing + food.toString() + "\n";
        }
        return foodListing;
    }

    public static void main(String[] args) {
        Intake intake = new Intake("Desayuno");
        intake.createFoods();
        intake.printFoodListing();
        intake.editFoods();
        intake.deleteFoods();
    }
}
