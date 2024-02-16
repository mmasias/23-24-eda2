package src;

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
        System.out.println(this.toString());
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

    public void deleteIntake() {
        Scanner userInput = new Scanner(System.in);
        if (first == null) {
            System.out.println("La lista de alimentos está vacía.");
            return;
        }

        System.out.println("Que alimento deseas eliminar?");
        String foodName = userInput.nextLine();
        boolean found = false;
        
        if (first.getFood().getName().equals(foodName)) {
            first = first.getNext();
            found = true;
            return;
        }

        FoodNode current = first;
        FoodNode previous = null;

        while (current != null) {
            if (current.getFood().getName().equals(foodName)) {
                previous.setNext(current.getNext());
                found = true;
                return;
            }
            previous = current;
            current = current.getNext();
        }
        if(found = false) {
            System.out.println("No se encontró el alimento a eliminar.");
        }
    }

    private void deleteAllIntake() {
        first = null;
        System.out.println("\nTodos los alimentos han sido eliminados con exito!");
    }

    public void updateIntake() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("Que alimento deseas actualizar?");
        String name = userInput.nextLine();

        System.out.println("Nombre del alimento nuevo");
        String updatedFood = userInput.nextLine();

        FoodNode current = first;

        boolean found = false; 
        while (current != null) {
            if (current.getFood().getName().equals(name)) {
                current.getFood().setName(updatedFood);;
                found = true;
                return;
            }
            current = current.getNext();
        }

        if(found = false) {
            System.out.println("No se encontró el alimento a actualizar.");
        }
        
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

    public void menu() {
        Scanner userInput = new Scanner(System.in);
        boolean finish = false;
        System.out.println(">>OPCIONES<< \n");
        while (finish == false) {
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
                    deleteIntake();
                    break;
                case 3:
                    updateIntake();
                    break;
                case 4:
                    printFoodListing();
                    break;
                case 5:
                    deleteAllIntake();
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
