package entregas.oteroJorge.Reto001;

import java.util.Scanner;

class Intake {
    private FoodNode first;
    private String name;


    public Intake(String name) {
        first = null;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void addFood(Food food) {
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

    public void printIntakeListing() {
        System.out.println(this.toString());
    }

    private void deleteFood(String foodName) {
        FoodNode current = first;
        FoodNode previous = null;
        while (current != null && !current.getFood().getName().equals(foodName)) {
            previous = current;
            current = current.getNext();
        }
        if (current != null) {
            if (previous == null) {
                first = current.getNext();
            } else {
                previous.setNext(current.getNext());
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

    public void deleteIntake() {
        boolean deleting = true;
        Scanner userInput = new Scanner(System.in);
        while (deleting) {
            System.out.println("Nombre del alimento a eliminar (-1 para terminar)");
            String foodName = userInput.nextLine();
            if (foodName.equals("-1")) {
                deleting = !deleting;
            } else {
                deleteFood(foodName);
            }
        }
    }

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

    public void deleteAll() {
        System.out.println("Eliminando todos los alimentos");
        first = null;
    }

    public void editIntake() {
        boolean editing = true;
        Scanner userInput = new Scanner(System.in);
        while (editing) {
            System.out.println("Nombre del alimento a editar (-1 para terminar)");
            String foodName = userInput.nextLine();
            if (foodName.equals("-1")) {
                editing = !editing;
            } else {
                editFood(foodName);
            }
        }
    }

    @Override
    public String toString() {
        String result = "]>> " + name + "\n";
        FoodNode current = first;
        while (current != null) {
            result += current.getFood().toString() + "\n";
            current = current.getNext();
        }
        return result;
    }

    public static void main(String[] args) {

        Intake breakfast = new Intake("Desayuno");
        breakfast.createIntake();
        breakfast.printIntakeListing();
        System.out.println();
        breakfast.editIntake();
        breakfast.printIntakeListing();
        System.out.println();
        breakfast.deleteIntake();
        breakfast.printIntakeListing();
        breakfast.deleteAll();
        breakfast.printIntakeListing();

    }
}
