import java.util.Scanner;

public class Intake {
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
        if(first == null) {
            first = newFoodNode;
        } else {
            FoodNode current = first;
            while(current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newFoodNode);
        }
    }

    public void printFoodListing() {
        System.out.println(this.toString());
    }

    public void createIntake() {
        boolean active = true;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre del alimento (-1 para terminar)");
        while(active) {
            String foodName = sc.nextLine();
            if(foodName.equals("-1")) {
                active = !active;
            } else {
                Food food = new Food(foodName);
                addFood(food);
            }
        }
    }

    public void deleteIntake() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre del alimento que quieres eliminar");
        String toRemove = sc.nextLine();
        FoodNode current = first;
        FoodNode previous = null;
        while(current != null) {
            if(current.getFood().getName().equals(toRemove)) {
                if(previous == null) {
                    first = current.getNext();
                } else {
                    previous.setNext(current.getNext());
                }
                return;
            }
            previous = current;
            current = current.getNext();
        }
    }

    public void updateIntake() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre del alimento que quieres modificar");
        String toUpdate = sc.nextLine();
        FoodNode current = first;
        while(current != null) {
            if(current.getFood().getName().equals(toUpdate)) {
                System.out.println("Nuevo nombre del alimento");
                String newFoodName = sc.nextLine();
                current.getFood().setName(newFoodName);
                return;
            }
            current = current.getNext();
        }
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        System.out.println(">>>BIENVENIDO AL MENU<<< \n");
        while(running) {
            System.out.println("1. Agregar alimento");
            System.out.println("2. Eliminar alimento");
            System.out.println("3. Modificar alimento");
            System.out.println("4. Mostrar alimentos");
            System.out.println("5. Salir");
            int option = sc.nextInt();
            switch(option) {
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
                    running = !running;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }
    
    @Override
    public String toString() {
        String foodListing = "";
        FoodNode current = first;
        while(current != null) {
            foodListing = foodListing + current.getFood().toString() + "\n";
            current = current.getNext();
        }
        return foodListing;
    }

    public static void main(String[] args) {
        Intake breakfast = new Intake();
        breakfast.menu();
    }
}