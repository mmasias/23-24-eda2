import java.util.Scanner;

class Intake {
    private FoodNode first;
    private String name;

    public Intake(String name) {
        this.name = name;
        first = null;
    }
    
    public Intake() {
        this.name = name;
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
    FoodNode current = first;
    while (current != null) {
        if (current.getFood().getName().equals(foodName)) {
            System.out.println("Nuevo nombre del alimento " + foodName);
            Scanner userInput = new Scanner(System.in);
            String newFoodName = userInput.nextLine();
            current.getFood().setName(newFoodName);
            return;
        }
        current = current.getNext();
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
    FoodNode previous = null;
    FoodNode current = first;
    while (current != null) {
        if (current.getFood().getName().equals(foodName)) {
            System.out.println("¿Estás seguro de que quieres eliminar el alimento? (s/n)");
            Scanner confirmation = new Scanner(System.in);
            if (confirmation.nextLine().equals("s")) {
                if (previous == null) {
                    first = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                System.out.println("Alimento eliminado: " + foodName);
                return;
            } else {
                return;
            }
        }
        previous = current;
        current = current.getNext();
    }
    System.out.println("Alimento no encontrado");
}

public void deleteIntake() {
    Scanner confirmación = new Scanner(System.in);
    System.out.println("¿Estás seguro de que quieres eliminar la ingesta? (s/n)");
    if (confirmación.nextLine().equals("s")) {
        first = null;
    } else{}
    return;
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