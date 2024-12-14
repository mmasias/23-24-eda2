import java.util.Scanner;
import java.util.ArrayList;

class Intake {
    private ArrayList<Food> foodList;
    private String name;

    public Intake(String name) {
        this.name = name;
        foodList = new ArrayList<Food>();
    }
    
    public Intake() {
        
        foodList = new ArrayList<Food>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addFood(Food food) {
        foodList.add(food);
    }

    public void printFoodListing() {
        if (foodList.size() == 0) {
            System.out.println("No hay alimentos registrados");
        } else {
            for (Food food : foodList) {
                System.out.println(food);
            }
    }
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
        boolean isediting = true;
        Scanner QueEditar = new Scanner(System.in);
        while (isediting) {
            System.out.println("¿Que alimento desea editar? (-1 para salir)");
            String foodName = QueEditar.nextLine();
            if (foodName.equals("-1")){
                isediting = !isediting;
            } else {
                editaskedfood(foodName);
            }
                
            
        }
    }

public void editaskedfood(String foodName) {
    for (Food food : foodList) {
        if (food.getName().equals(foodName)) {
            Scanner userInput = new Scanner(System.in);
            System.out.println("Nuevo nombre del alimento " + foodName);
            String newFoodName = userInput.nextLine();
            food.setName(newFoodName);
            return;
        }
    }
    System.out.println("Alimento no encontrado");
}

public void deleteFood() {
    boolean isdeleting = true;
        Scanner QueBorrar = new Scanner(System.in);
        while (isdeleting) {
            System.out.println("¿Que alimento desea eliminar? (-1 para salir)");
            String foodName = QueBorrar.nextLine();
            if (foodName.equals("-1")){
                isdeleting = !isdeleting;
            } else {
                deleteaskedfood(foodName);
            }
                
            
        }
}

public void deleteaskedfood(String foodName) {
    for (int i = 0; i < foodList.size(); i++) {
        Food food = foodList.get(i);
        if (food.getName().equals(foodName)) {
            Scanner confirmation = new Scanner(System.in);
            System.out.println("¿Estás seguro de que quieres eliminar el alimento? (s/n)");
            if (confirmation.nextLine().equals("s")) {
                foodList.remove(i);
                System.out.println("Alimento eliminado: " + foodName);
            }
            return;
        }
    }
    System.out.println("Alimento no encontrado");
}

public void deleteIntake() {
    Scanner confirmación = new Scanner(System.in);
        System.out.println("¿Estás seguro de que quieres eliminar la ingesta? (s/n)");
        if (confirmación.nextLine().equals("s")) {
            foodList.clear();
        }
    return;
}
    public static void main(String[] args) {

    Intake breakfast = new Intake();
        Boolean Editing = true;
        while (Editing){
        System.out.println("Estás en el registro de ingestas");
        System.out.println("¿Que desea hacer?");
        System.out.println("1 Crear una ingesta");
        System.out.println("2 Leer la ingesta");
        System.out.println("3 Editar una ingesta");
        System.out.println("4 Eliminar datos");
        System.out.println("5 eliminar el registro");
        System.out.println("Para Salir introduzca [-1]");
        Scanner userInput = new Scanner(System.in);
        String option = userInput.nextLine();
        switch (option) {
            case "1":
                System.out.println("Creando ingesta");
                breakfast.createIntake();
                breakfast.printFoodListing();
                break;
            case "2":
                System.out.println("Mostrando ingesta");
                breakfast.printFoodListing();
                break;
            case "3":
                System.out.println("Editando ingesta");
                breakfast.editIntake();
                breakfast.printFoodListing();
                break;
            case "4":
                System.out.println("Eliminando alimento");
                breakfast.deleteFood();
                breakfast.printFoodListing();
            case "5":
                System.out.println("Eliminando ingesta");
                breakfast.deleteIntake();
                breakfast.printFoodListing();
            break;
            case "-1":
                System.out.println("Saliendo");
                Editing = false;
                System.out.println("Estas son las ingestas que has registrado:");
                breakfast.printFoodListing();
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
        
    }
     

    }
}