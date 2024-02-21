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

    public void createIntakeFunctionality(String foodName) {
        Food food = new Food(foodName);
        addFood(food);
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
                createIntakeFunctionality(foodName);
            }
        }
    }

    public void deleteIntakeFunctionality(Food current, Food previous) {
        if (previous == null) {
            first = current.getNext();
        } else {
            previous.setNext(current.getNext());
        }
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
            System.out.println("3) Guardar" + "\n");
            String o = userInput.nextLine();
            if(o.equals("1")) {
                FoodNode current = first;
                FoodNode previous = null;
                while (current != null) {
                    System.out.println("El alimento actual es: " + current.getFood().toString());
                    System.out.println("1) Eliminar");
                    System.out.println("2) Siguiente" + "\n");
                    String optionDelete = userInput.nextLine();

                    if(optionDelete.equals("1")) {
                        System.out.println("Eliminando un alimento");
                        deleteIntakeFunctionality(current, previous);
                    } else if(optionDelete.equals("2")) {
                        previous = current;
                        current = current.getNext();
                    }
                }
            } else if (o.equals("2")) {
                System.out.println("Eliminando todos");
                deleteAllIntake();
            } else if (o.equals("3")) {
                deleteIntake = !deleteIntake;
            }
        }
    }

    // public void editIntake() {
    //     boolean editing = true;
    //     Scanner userInput = new Scanner(System.in);

    //     while (editing) {
    //         System.out.println("1) Editar alimentos");
    //         System.out.println("2) Guardar Alimentos" + "\n");
    //         String o = userInput.nextLine();
    //         if(o.equals("1")) {
    //             FoodNode current = first;

    //             while (current != null) {
    //                 System.out.println("El alimento actual es: " + current.getFood().toString());
    //                 System.out.println("1) Editar");
    //                 System.out.println("2) Siguiente" + "\n");
    //                 String optionEditing = userInput.nextLine();
    //                 if(optionEditing.equals("1")) {
    //                     System.out.println("Editando");
    //                     deleteIntake();
    //                     createIntake();
    //                 } else if(optionEditing.equals("2")){
    //                     System.out.println("Guardado exitosamente!");
    //                     Food food = current.getFood();
    //                     addFood(food);
    //                 }
    //                 current = current.getNext();
    //             }
    //         } else if (o.equals("2")) {
    //             editing = !editing;
    //         }
    //     }
    // }


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
        // breakfast.editIntake();
        breakfast.deleteIntake();
        breakfast.printFoodListing();

    }
}

// tengo que dejar ahi solo las funcionalides y los textos en otro porque si reutilizo funciones me saldra os textos siempre
// tambien se ejecuta repetidamente, no hasta que se acaben los elementos
