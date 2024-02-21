import java.util.Scanner;

class Intake {
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
        if (first == null) {
            System.out.println("No hay alimentos registrados");
            return;
        } else {
        System.out.println(this.toString());
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
            System.out.println("Método por hacer");
        }

        public void deleteIntake() {
            first = null;
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
        Boolean Editing = true;
        while (Editing){
        System.out.println("¿Que desea hacer?");
        System.out.println("1 Crear una ingesta");
        System.out.println("2 Leer la ingesta");
        System.out.println("3 Editar una ingesta");
        System.out.println("4 Eliminar una ingesta");
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

                breakfast.printFoodListing();
                break;
            case "4":
                System.out.println("Eliminando ingesta");
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