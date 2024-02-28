

import java.util.ArrayList;
import java.util.Scanner;

class Intake {
    private ArrayList<Food> food;
    private String nombreingesta;

    public Intake(String ingesta) {
        this.nombreingesta=ingesta;
    }
    public String getNombre()
    {
        return this.nombreingesta;
    }
    public void addFood(Food food) {
        this.food.add(food);
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
    public void actualizaIntakeAll() {
        boolean updating = true;
        Scanner userInput = new Scanner(System.in);
        while (updating) {
            System.out.println("Nombre del alimento a modificar (-1 para terminar)");
            String foodNameOld = userInput.nextLine();
            if (foodNameOld.equals("-1")) {
                updating = !updating;
            } else {
                System.out.println("Nombre del alimento nuevo (-1 para terminar)");
                String foodNameNew = userInput.nextLine();
                for (int i = 0; i < food.size(); i++) {
                    if (food.get(i).getName().equals(foodNameOld)) {
                        food.get(i).setName(foodNameNew);
                    }
                }
            }
        }
        this.createIntake();
    }
    
    public void deleteIngesta()
    {
        boolean borrado=false;


        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del alimento a borrar(-1 para terminar)");
        String foodName = userInput.nextLine();
        if (foodName.equals("-1"))
            borrado = !borrado;
        else{
            for (int i=0; i<food.size(); i++)
            {
                if (food.get(i).getName().equals(foodName))
                {
                    food.remove(i);
                    borrado=!borrado;
                }
            }
        }
        if (!borrado)
            System.out.println("Alimento no encontrado. No se ha podido borrar.");
    }

    public void updateIntake()
    {
        boolean actualizado=false;


        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del alimento escrito(-1 para terminar)");
        String foodNameOld = userInput.nextLine();
        System.out.println("Nombre del alimento nuevo(-1 para terminar)");
        String foodNameNew = userInput.nextLine();
        if (foodNameOld.equals("-1"))
            actualizado = !actualizado;
        else{
            for (int i=0; i<food.size(); i++)
            {
                if (food.get(i).getName().equals(foodNameOld))
                {
                    food.get(i).setName(foodNameNew);
                    actualizado=!actualizado;
                }
            }
        }
        if (!actualizado)
            System.out.println("Alimento no encontrado. No ha sido posible actualizarlo");
    }

    public String readIntake()
    {
        String foodListing = "";
        for (int i=0; i<food.size(); i++)
        {
            foodListing = foodListing + food.get(i).toString() + "\n";
        }
        return foodListing;
    }

    public static void main(String[] args) {

        Intake breakfast = new Intake("Desayuno");
        breakfast.createIntake();
        breakfast.printFoodListing();
        

    }
}
