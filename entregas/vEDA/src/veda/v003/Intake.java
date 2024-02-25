package veda.v003;

import java.util.Scanner;

class Intake {
    private FoodNode first;
    private String nombreingesta;

    public Intake(String ingesta) {
        first = null;
        this.nombreingesta=ingesta;
    }
    public String getNombre()
    {
        return this.nombreingesta;
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
    public void actualizaIntakeAll() {
        boolean updating = true;
        Scanner userInput = new Scanner(System.in);
        this.first=null;
        this.createIntake();
    }
    
    public void deleteIngesta()
    {
        boolean borrado=false;
        FoodNode current=this.first;
        FoodNode sgte=null;

        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del alimento a borrar(-1 para terminar)");
        String foodName = userInput.nextLine();
        
        if ((this.first.getFood()).getName().equals(foodName))
        {    
            if (this.first.getNext()!=null)        
                this.first=this.first.getNext();
            else
                this.first=null; /*Caso sólo tengo un nodo*/
            borrado=true;
        }       
        while (!borrado)
        {
            if (current.getNext()!=null)
            {
                sgte=current.getNext();
                if ((sgte.getFood()).getName().equals(foodName))
                {
                    current.setNext(sgte.getNext());
                    borrado=true;
                }
                else
                    current=sgte;
            }
        }
        if (!borrado)
            System.out.println("Alimento no encontrado. No se ha podido borrar.");
    }

    public void updateIntake()
    {
        boolean actualizado=false;
        FoodNode current=this.first;       

        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del alimento escrito(-1 para terminar)");
        String foodNameOld = userInput.nextLine();
        System.out.println("Nombre del alimento nuevo(-1 para terminar)");
        String foodNameNew = userInput.nextLine();
        
        if ((current.getFood()).getName().equals(foodNameOld))
        {    
            current.getFood().setName(foodNameNew);
            actualizado=!actualizado;
        }       
        while (!actualizado && current!=null)
        {            
            if ((current.getFood()).getName().equals(foodNameOld))
            {    
                current.getFood().setName(foodNameNew);
                actualizado=!actualizado;
            }
            else
                current=current.getNext();
        }
        if (!actualizado)
            System.out.println("Alimento no encontrado. No ha sido posible actualizarlo");
    }

    public String readIntake()
    {
        String res="";       
        if (this.first!=null)
        {   
            res=this.nombreingesta+":\n";
            res=res+(this.first.getFood()).toString();
            FoodNode nodo=this.first.getNext();
            while (nodo!=null)
            {
                res=res+"\n"+nodo.getFood().toString();
                nodo=nodo.getNext();
            }
        }
        return res;
    }
    

    @Override
    public String toString() {
        String foodListing = "*"+this.nombreingesta+"\n";
        FoodNode current = first;
        while (current != null) {
            foodListing = foodListing + current.getFood().toString() + "\n";
            current = current.getNext();
        }
        return foodListing;
    }

    public static void main(String[] args) {

        Intake breakfast = new Intake("Desayuno");
        breakfast.createIntake();
        breakfast.printFoodListing();
        

    }
}
