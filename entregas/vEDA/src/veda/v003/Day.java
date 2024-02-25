package veda.v003;

import java.util.Scanner;

class Day {
    private IntakeNode first;
    String nombredia="";

    public Day(String dia) {
        first = null;
        this.nombredia=dia;
    }

    public String getNombreDia()
    {
        return this.nombredia;
    }
    public void addIntake(Intake intake) {
        IntakeNode newIntakeNode = new IntakeNode(intake);
        if (first == null) {
            first = newIntakeNode;
        } else {
            IntakeNode current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newIntakeNode);
        }
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
        IntakeNode current=this.first;
        IntakeNode sgte=null;

        Scanner userInput = new Scanner(System.in);       
        System.out.println("Nombre de la ingesta a borrar (-1 para terminar)");
        String intakeName = userInput.nextLine();
        if (intakeName.equals("-1")) 
            borrado = !borrado;
        else{
            if (current.getIntake().getNombre().equals(intakeName)) // El primer nodo es la comida a borrar
            {
                this.first=current.getNext();
                borrado=!borrado;
            }
            while(!borrado)
            {
                sgte=current.getNext();
                if (sgte!=null)
                {
                   if (sgte.getIntake().getNombre().equals(intakeName))
                    {
                        current.setNext(sgte.getNext());
                        borrado=!borrado;
                    }
                }
                current=current.getNext();
            }
        }       
        if (!borrado)
            System.out.println("Comida no encontrada");
    }

    public void UpdateIntake()
    {
        boolean actualizado=false;
        IntakeNode current=this.first;
        IntakeNode sgte=null;

        Scanner userInput = new Scanner(System.in);       
        System.out.println("Nombre de la ingesta a actualizar (-1 para terminar)");
        String intakeName = userInput.nextLine();
        if (intakeName.equals("-1")) 
            actualizado = !actualizado;
        else{
            if (current.getIntake().getNombre().equals(intakeName)) // El primer nodo es la comida a actualizar
            {
                this.first.getIntake().actualizaIntakeAll();
                actualizado=!actualizado;
            }
            while(!actualizado)
            {
                sgte=current.getNext();
                if (sgte!=null)
                {
                   if (sgte.getIntake().getNombre().equals(intakeName))
                    {
                        sgte.getIntake().actualizaIntakeAll();
                        actualizado=!actualizado;
                    }
                }
                current=sgte;                
            }
        }       
        if (!actualizado)
            System.out.println("Ingesta no encontrada para poder actualizarla. Créela.");
    }

    public void leeIngesta()
    {
        boolean encontrada = false;
        IntakeNode current=this.first;
        Scanner userInput = new Scanner(System.in);       
        System.out.println("Nombre de la ingesta a leer (-1 para terminar)");
        String intakeName = userInput.nextLine();
        if (intakeName.equals("-1")) 
            encontrada = !encontrada;
        else {            
            while (!encontrada)
            {  
                if(current.getIntake().getNombre().equals(intakeName))   
                {                 
                    System.out.println(current.getIntake().readIntake());
                    encontrada=!encontrada;    
                }                
                else
                    current=current.getNext();
            } 
            if (!encontrada)
                System.out.println("No se puede leer la ingesta:"+intakeName+" porque no se ha encontrado.");            
        }        
    }    

    @Override
    public String toString() {
        String intakeListing = this.nombredia+"\n";
        IntakeNode current = first;
        while (current != null) {
            intakeListing = intakeListing + current.getIntake().toString() + "\n";
            current = current.getNext();
        }
        return intakeListing;
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
