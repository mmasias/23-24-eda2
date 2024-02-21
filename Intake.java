package vEDA.v003;

import java.util.Scanner;

class Intake {
    private FoodNode first;
    private String name;

    public Intake() {
        first = null;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    
    public void updateFood(String oldName, String newName) {
        FoodNode current = first;
        while (current != null) {
            if (current.getFood().getName().equals(oldName)) {
                current.getFood().setName(newName);
                System.out.println("Alimento actualizado exitosamente.");
                return;
            }
            current = current.getNext();
        }
        System.out.println("No se encontró el alimento con el nombre proporcionado.");
    }
   


public void deleteFood(String name) {
    if (first == null) {
        System.out.println("La lista de alimentos está vacía.");
        return;
    }
    if (first.getFood().getName().equals(name)) {
        first = first.getNext();
        System.out.println("Alimento eliminado exitosamente.");
        return;
    }
    FoodNode previous = first;
    FoodNode current = first.getNext();
    while (current != null) {
        if (current.getFood().getName().equals(name)) {
            previous.setNext(current.getNext());
            System.out.println("Alimento eliminado exitosamente.");
            return;
        }
        previous = current;
        current = current.getNext();
    }
    System.out.println("No se encontró el alimento con el nombre proporcionado.");
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

         
         Scanner scanner = new Scanner(System.in);
         System.out.println("\n¿Desea actualizar o eliminar algún alimento? (A/E/N)");
         String option = scanner.nextLine().toUpperCase();
 
         
         switch (option) {
             case "A":
                 System.out.println("Ingrese el nombre del alimento que desea actualizar: ");
                 String oldName = scanner.nextLine();
                 System.out.println("Ingrese el nuevo nombre del alimento: ");
                 String newName = scanner.nextLine();
                 breakfast.updateFood(oldName, newName);
                 breakfast.printFoodListing();
                 break;
             case "E":
                 System.out.println("Ingrese el nombre del alimento que desea eliminar: ");
                 String nameToDelete = scanner.nextLine();
                 breakfast.deleteFood(nameToDelete);
                 breakfast.printFoodListing();
                 break;
             default:
                 System.out.println("Operación no reconocida.");
                 break;
         }
 
         scanner.close();
    }
    
}

