

import java.util.ArrayList;
import java.util.Scanner;

class Day {
    private ArrayList<Intake> food;
    String nombredia="";

    public Day(String dia) {
        this.nombredia=dia;
    }

    public String getNombreDia()
    {
        return this.nombredia;
    }
    public void addIntake(Intake intake) {
        food.add(intake);
    }

    public void printIntakeListing() {
        System.out.println(this.toString());
    }

    public void createIntakes() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("Nombre de la ingesta (-1 para terminar)");
            String intakeName = userInput.nextLine();
            if (intakeName.equals("-1")) {
                creating = !creating;
            } else {
                Intake intake = new Intake(intakeName);
                intake.createIntake();
                addIntake(intake);
            }
        }       
    }
    public void deleteIntake()
    {
        boolean borrado=false;
        Scanner userInput = new Scanner(System.in);       
        System.out.println("Nombre de la ingesta a borrar (-1 para terminar)");
        String intakeName = userInput.nextLine();
        if (intakeName.equals("-1")) 
            borrado = !borrado;
        else{
            for (int i=0; i<food.size(); i++)
            {
                if (food.get(i).getNombre().equals(intakeName))
                {
                    food.remove(i);
                    borrado=!borrado;
                }
            }
        }       
        if (!borrado)
            System.out.println("Comida no encontrada");
    }

    public void UpdateIntake()
    {
        boolean actualizado=false;

        Scanner userInput = new Scanner(System.in);       
        System.out.println("Nombre de la ingesta a actualizar (-1 para terminar)");
        String intakeName = userInput.nextLine();
        if (intakeName.equals("-1")) 
            actualizado = !actualizado;
        else{
            for (int i=0; i<food.size(); i++)
            {
                if (food.get(i).getNombre().equals(intakeName))
                {
                    food.get(i).actualizaIntakeAll();
                    actualizado=!actualizado;
                }
            }


        }       
        if (!actualizado)
            System.out.println("Ingesta no encontrada para poder actualizarla. Créela.");
    }

    public void leeIngesta()
    {
        boolean encontrada = false;
        Scanner userInput = new Scanner(System.in);       
        System.out.println("Nombre de la ingesta a leer (-1 para terminar)");
        String intakeName = userInput.nextLine();
        if (intakeName.equals("-1")) 
            encontrada = !encontrada;
        else {            
            for (int i=0; i<food.size(); i++)
            {
                if (food.get(i).getNombre().equals(intakeName))
                {
                    food.get(i).printFoodListing();
                    encontrada=!encontrada;
                }
            }
            if (!encontrada)
                System.out.println("No se puede leer la ingesta:"+intakeName+" porque no se ha encontrado.");            
        }        
    }    



    public static void main(String[] args) {

        Day monday = new Day("monday");
        monday.createIntakes();
        monday.printIntakeListing();
        monday.UpdateIntake();
        monday.deleteIntake();
        monday.printIntakeListing();
    }
}
