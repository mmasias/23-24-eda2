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

    public void deleteIntakeFunctionality(FoodNode nodeToDelete) {
        if (nodeToDelete == null) {
            return;
        }
        
        FoodNode previous = null;
        FoodNode current = first;
        
        while (current != null && current != nodeToDelete) {
            previous = current;
            current = current.getNext();
        }
        
        if (current == null) {
            return;
        }
        

        if (previous != null) {
            previous.setNext(current.getNext());
        } else {
            first = current.getNext();
        }
    }

    public void editIntakeFunctionality(FoodNode node) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Ingresa el nuevo alimento");
        String newFoodName = userInput.nextLine();
        node.getFood().setName(newFoodName);
    }

    public void deleteAllIntake(){
        first = null;
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
                FoodNode current = first;
                while (current != null) {
                    System.out.println("El alimento actual es: " + current.getFood().toString());
                    System.out.println("1) Eliminar");
                    System.out.println("2) Siguiente\n");
                    String optionDelete = userInput.nextLine();
    
                    if (optionDelete.equals("1")) {
                        System.out.println("Eliminando un alimento");
                        deleteIntakeFunctionality(current);
                        break;
                    } else if (optionDelete.equals("2")) {
                        System.out.println("Siguiente alimento\n");
                    }
                    current = current.getNext();
                }
            } else if (o.equals("2")) {
                System.out.println("Eliminando todos los alimentos");
                deleteAllIntake();
            } else if (o.equals("3")) {
                deleteIntake = false;
            }
        }
    }

    public void editIntake() {
        boolean editing = true;
        Scanner userInput = new Scanner(System.in);
        
        while (editing) {
            System.out.println("1) Editar alimentos");
            System.out.println("2) Guardar Alimentos\n");
            String o = userInput.nextLine();
            
            if (o.equals("1")) {
                FoodNode current = first;
                while (current != null) {
                    System.out.println("El alimento actual es: " + current.getFood().toString());
                    System.out.println("1) Editar");
                    System.out.println("2) Siguiente\n");
                    String optionEditing = userInput.nextLine();
                    
                    if (optionEditing.equals("1")) {
                        System.out.println("Editando");
                        editIntakeFunctionality(current);
                    } else if (optionEditing.equals("2")) {
                        System.out.println("Guardado exitosamente!");
                    }
                    current = current.getNext();
                }
            } else if (o.equals("2")) {
                editing = false;
            }
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

    public static void main(String[] args) {

        Intake breakfast = new Intake();
        breakfast.createIntake();
        breakfast.editIntake();
        breakfast.deleteIntake();
        breakfast.printFoodListing();

    }
}
