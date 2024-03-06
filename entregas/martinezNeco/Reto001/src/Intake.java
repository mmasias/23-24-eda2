import java.util.Scanner;

class Intake {

    private String name;
    private FoodNode first;

    public Intake (String name) {
        this.name = name;
        first = null;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void deleteFood(String food) {
        FoodNode current = first;
        FoodNode previous = null;
        while (current != null && !current.getFood().getName().equals(food)) {
            previous = current;
            current = current.getNext();
        }
        if (current != null) {
            if (previous == null) {
                first = current.getNext();
            }
            else {
                previous.setNext(current.getNext());
            }
        }
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

    public void updateIntake(String food) {

        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del alimento que desea sustituir por " + food);
        String comida = userInput.nextLine();
        deleteFood(food);
        Food c = new Food(comida);
        addFood(c);

    }

    public void createIntake() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre de la ingesta\n");
        String nombre = userInput.nextLine();
        this.setName(nombre);
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


    public void deleteFood() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("Nombre del alimento a eliminar (-1 para terminar)");
            String foodName = userInput.nextLine();
            if (foodName.equals("-1")) {
                creating = !creating;
            } else {
                deleteFood(foodName);
            }
        }
    }
    public void deleteIntake() {
        setName("Ingesta eliminada");
        System.out.println(getName());
        this.first = null;

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


        Intake breakfast = new Intake("Desayuno");
        Food bread = new Food("Pan");
        Food milk = new Food("Leche");
        Food cheese = new Food("Queso");

        breakfast.createIntake();
        breakfast.printFoodListing();
        System.out.println("Se añade pan\n");
        breakfast.addFood(bread);
        breakfast.printFoodListing();
        System.out.println();
        breakfast.updateIntake(bread.getName());
        breakfast.printFoodListing();
        System.out.println();
        breakfast.deleteIntake();
        breakfast.printFoodListing();
        System.out.println();


    }

}