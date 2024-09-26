import java.util.ArrayList;
import java.util.Scanner;

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

    public String getDetails() {
        return "]> Ingesta: " + name;
    }

    public void addFood(Food food) {
        foods.add(food);
    }

    public void printFoodListing() {
        System.out.println(this.toString());
    }

    public void createIntake() {
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

    public void deleteFood(int index) {
        foods.remove(index);
    }

    public void editFood(int index, String newName) {
        foods.get(index).setName(newName);
    }

    public void deleteAllFoods() {
        foods.clear();
    }

    public void editIntake() {
        boolean editing = true;
        Scanner userInput = new Scanner(System.in);

        while (editing) {
            System.out.println("1) Editar alimentos");
            System.out.println("2) Guardar Alimentos\n");
            String o = userInput.nextLine();

            if (o.equals("1")) {
                for (int i = 0; i < foods.size(); i++) {
                    System.out.println("El alimento actual es: " + foods.get(i).toString());
                    System.out.println("1) Editar");
                    System.out.println("2) Siguiente\n");
                    String optionEditing = userInput.nextLine();

                    if (optionEditing.equals("1")) {
                        System.out.println("Ingresa el nuevo alimento");
                        String newFoodName = userInput.nextLine();
                        editFood(i, newFoodName);
                    } else if (optionEditing.equals("2")) {
                        System.out.println("Guardado exitosamente!");
                    }
                }
            } else if (o.equals("2")) {
                editing = false;
            }
        }
    }

    public void deleteIntake() {
        boolean deleteIntake = true;
        Scanner userInput = new Scanner(System.in);

        while (deleteIntake) {
            System.out.println("1) Eliminar un alimento");
            System.out.println("2) Eliminar todos los alimentos");
            System.out.println("3) Guardar Alimentos\n");
            String o = userInput.nextLine();

            if (o.equals("1")) {
                for (int i = 0; i < foods.size(); i++) {
                    System.out.println("El alimento actual es: " + foods.get(i).toString());
                    System.out.println("1) Eliminar");
                    System.out.println("2) Siguiente\n");
                    String optionDelete = userInput.nextLine();

                    if (optionDelete.equals("1")) {
                        System.out.println("Eliminando un alimento");
                        deleteFood(i);
                        break;
                    } else if (optionDelete.equals("2")) {
                        System.out.println("Siguiente alimento\n");
                    }
                }
            } else if (o.equals("2")) {
                System.out.println("Eliminando todos los alimentos");
                deleteAllFoods();
            } else if (o.equals("3")) {
                deleteIntake = false;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder foodListing = new StringBuilder();
        for (Food food : foods) {
            foodListing.append(food.toString()).append("\n");
        }
        return foodListing.toString();
    }

    public static void main(String[] args) {
        Intake breakfast = new Intake("Banana");
        breakfast.createIntake();
        System.out.println(breakfast.toString());
    }
}