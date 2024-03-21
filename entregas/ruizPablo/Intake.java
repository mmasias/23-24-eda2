import java.util.Scanner;

class Intake {
    private FoodNode first; 

    public Intake() {
        first = null;
    }

    // Añade un nuevo alimento al final de la lista de alimentos de la ingesta
    public void addFood(Food food) {
        FoodNode newFoodNode = new FoodNode(food);
        if (first == null) {
            first = newFoodNode; // Si la lista está vacía el nuevo nodo se convierte en el primer nodo
        } else {
            FoodNode current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newFoodNode); // Si la lista no está vacía se agrega el nuevo nodo al final
        }
    }

    // Imprime la lista 
    public void printFoodListing() {
        System.out.println(this.toString());
    }

    // Crear una nueva ingesta solicitando al usuario que ingrese alimentos
    @SuppressWarnings("resource")
    public void createIntake() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("Nombre del alimento por crear (-1 para terminar)");
            String foodName = userInput.nextLine();
            if (foodName.equals("-1")) {
                creating = !creating; // Se sale del bucle si el usuario escribe "-1"
            } else {
                Food food = new Food(foodName);
                addFood(food); // Se agrega el nuevo alimento a la lista de la ingesta
            }
        }
    }

    // Editar alimentos en la lista de la ingesta
    @SuppressWarnings("resource")
    private void editIntake() {
        boolean editing = true;
        Scanner userInput = new Scanner(System.in);
        while (editing) {
            System.out.println("Nombre del alimento por editar (-1 para terminar)");
            String foodName = userInput.nextLine();
            if (foodName.equals("-1")) {
                editing = !editing; // Se sale del bucle si el usuario ingresa "-1"
            } else {
                editFood(foodName);
            }
        }
    }

    // Eliminar alimentos de la lista de la ingesta
    @SuppressWarnings("resource")
    private void deleteIntake() {
        Scanner userInput = new Scanner(System.in);
        boolean deleting = true;
        while (deleting) {
            System.out.println("Nombre del alimento por eliminar (-1 para terminar)");
            String foodName = userInput.nextLine();
            if (foodName.equals("-1")) {
                deleting = !deleting; // Se sale del bucle si el usuario ingresa "-1"
            } else {
                removeFood(foodName);
            }
        }
    }

    // Eliminar un alimento específico de la lista
    private void removeFood(String foodName) {
        if (first.getFood().getName().equals(foodName)) {
            first = first.getNext();
            return;
        } else {
            FoodNode current = first;
            while (current.getNext() != null && !current.getNext().getFood().getName().equals(foodName)) {
                current = current.getNext();
            }
            if (current.getNext() != null) {
                current.setNext(current.getNext().getNext());
            }
        }
    }

    // Editar el nombre de un alimento en la lista
    @SuppressWarnings("resource")
    private void editFood(String foodName) {
        Scanner userInput = new Scanner(System.in);
        FoodNode current = first;
        while (current != null) {
            if (current.getFood().getName().equals(foodName)) {
                System.out.println("Nuevo nombre de [" + foodName + "]");
                String newFoodName = userInput.nextLine();
                current.getFood().setName(newFoodName);
                return;
            }
            current = current.getNext();
        }
        System.out.println("Alimento no encontrado");
    }

    // Eliminar todos los alimentos de la lista de la ingesta
    private void deleteAllIntake() {
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
        breakfast.createIntake();
        breakfast.printFoodListing();

        breakfast.editIntake();
        breakfast.printFoodListing();

        breakfast.deleteIntake();
        breakfast.printFoodListing();

        breakfast.deleteAllIntake();
        breakfast.printFoodListing();
    }
}
