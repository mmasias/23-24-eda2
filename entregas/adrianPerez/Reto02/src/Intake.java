import java.util.ArrayList;
import java.util.Scanner;

class Intake {
    private ArrayList<Food> foods;
    String name;

    public Intake(String name) {
        foods = new ArrayList<Food>();
        this.name = name;        
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

    public void printFoods() {
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

    @Override
    public String toString() {
        String foodListing = "";
        for (Food food : foods) {
            foodListing = foodListing + food.toString() + "\n";
        }
        return foodListing;
    }

    public void deleteFoods() {
        Scanner scanner = new Scanner(System.in);
        boolean deleting = true;
        
        while(deleting == true) {

            System.out.println("Quiere borrar una comida (1) o todas las comidas (2)? Pulse (3) para salir");

            String userInput = scanner.nextLine();

            if (userInput.equals("1")){
                System.out.println("Indique la comida que quiere borrar:");
                userInput = scanner.nextLine();
                deleteFood(userInput);
            }
            else if (userInput.equals("2")) {
                deleting = false;
                deleteAllFoods();
            }
            else if (userInput.equals("3")) {
                deleting = false;
            }
        }
    }

    private void deleteFood(String food) {
        boolean found = false;
        for (int i = 0; i < foods.size(); i++) {
            if (foods.get(i).getName().equals(food)) {
                foods.remove(i);
                found = true;
                System.out.println("Borrado :)");
                break;
            }
        }
        if (!found) {
            System.out.println("No se encontró ninguna comida con ese nombre.");
        }
    }   
        
    private void deleteAllFoods() {
        foods.clear();
    }

    public void editFoods() {
        Scanner scanner = new Scanner(System.in);
        boolean editing = true;

        while (editing) {
            System.out.println("¿Desea editar un alimento? (1) Sí, (2) No");
            String userInput = scanner.nextLine();

            if (userInput.equals("1")) {
                System.out.println("Ingrese el nombre del alimento que desea editar:");
                String foodName = scanner.nextLine();

                boolean found = false;
                for (Food food : foods) {
                    if (food.getName().equals(foodName)) {
                        System.out.println("Ingrese el nuevo nombre del alimento:");
                        String newFoodName = scanner.nextLine();
                        food.setName(newFoodName);
                        found = true;
                        System.out.println("Alimento editado exitosamente.");
                        break;
                    }
                }

                if (!found) {
                    System.out.println("No se encontró ningún alimento con ese nombre.");
                }
            } else if (userInput.equals("2")) {
                editing = false;
            }
        }
        
    }

    public static void main(String[] args) {

        Intake breakfast = new Intake("Mandarina");
        breakfast.createFoods();
        breakfast.printFoods();

    }
}