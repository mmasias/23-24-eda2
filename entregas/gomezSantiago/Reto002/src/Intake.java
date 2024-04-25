import java.util.ArrayList;
import java.util.Scanner;

class Intake {
    private ArrayList<Food> foodList;

    public Intake() {
        foodList = new ArrayList<>();
    }

    public void addFood(Food food) {
        foodList.add(food);
    }

    public void printFoodListing() {
        for (Food food : foodList){
            System.out.println(this.toString());
        }
    }

    public void createIntake() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("+-----------------------------------------+");
            System.out.println("| Nombre del alimento (-1 para terminar): |");
            System.out.println("+-----------------------------------------+");
            String foodName = userInput.nextLine();
            if (foodName.equals("-1")) {
                creating = !creating;
            } else {
                Food food = new Food(foodName);
                addFood(food);
            }
        }
    }

    public void deleteIntake(){
        System.out.println("+-----------------------------------------+");
        System.out.println("| Ingrese el alimento que desea eliminar: |");
        System.out.println("+-----------------------------------------+");
        Scanner userInput = new Scanner(System.in);
        if (foodList.isEmpty()) {
            System.out.println("+----------------------------------+");
            System.out.println("| La lista de alimentos esta vacía |");
            System.out.println("+----------------------------------+");
            return;
        }
        String foodNameDelete = userInput.nextLine();
        System.out.println("+-----------------------------------------+");
        System.out.println("| Se ha eliminado " + foodNameDelete + " correctamente |" + "\n");
        System.out.println("+-----------------------------------------+");
         boolean foodInList = false;
         for (Food food : foodList) {
             if (food.getName().equals(foodNameDelete)) {
                 foodList.remove(food);
                 foodInList = true;
                 break;
             }
         }

         if (!foodInList) {
             System.out.println("+------------------------------------+");
             System.out.println("| No se ha encontrado ninguna comida |");
             System.out.println("+------------------------------------+");
         }
    }
    public void modifyIntake(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("+---------------------------------------+");
        System.out.println("| Ingrese el alimento que desea editar: |");
        System.out.println("+---------------------------------------+");
        String foodNameEdit = new Scanner(System.in).nextLine();
        System.out.println("+-------------------------------------------------+");
        System.out.println("| Se ha editado el alimento: " + foodNameEdit + " |"+ "\n");
        System.out.println("+-------------------------------------------------+");

        boolean foodToEdit = false;
        for (Food food : foodList) {
            if (food.getName().equals(foodNameEdit)){
                food.setName(foodNameEdit);
                foodToEdit = true;
                break;
            }
        }

        if (!foodToEdit) {
            System.out.println("+------------------------------------+");
            System.out.println("| No se ha encontrado ninguna comida |");
            System.out.println("+------------------------------------+");
        }
    }

    public void optionsMenu() {
        Scanner userInput = new Scanner(System.in);
        boolean options = false;
        System.out.println("+---------------------+");
        System.out.println("| Opciones de Ingesta |");
        System.out.println("+---------------------+");
        while (!options) {
            System.out.println("+-----------------------+");
            System.out.println("| Agregar ingesta (1)   |");
            System.out.println("| Eliminar ingesta (2)  |");
            System.out.println("| Modificar ingesta (3) |");
            System.out.println("| Mostrar ingesta (4)   |");
            System.out.println("| Salir de ingesta (0)  |");
            System.out.println("+-----------------------+");
            int option = userInput.nextInt();
            switch (option) {
                case 1:
                    createIntake();
                    break;
                case 2:
                    deleteIntake();
                    break;
                case 3:
                    modifyIntake();
                    break;
                case 4:
                    printFoodListing();
                    break;
                case 0:
                    options = true;
                    break;
                default:
                    System.out.println("+------------------+");
                    System.out.println("| Opción no válida |");
                    System.out.println("+------------------+");
                    break;
            }
        }
    }

    public static void main(String[] args) {

        Intake breakfast = new Intake();

        breakfast.optionsMenu();

    }
}