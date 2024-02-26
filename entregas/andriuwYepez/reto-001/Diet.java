import java.util.Scanner;

class Diet {
    private DayNode first;

    public Diet() {
        first = null;
    }

    public void addDay(Day day){
        DayNode newDayNode = new DayNode(day);
        if (first == null){
            first = newDayNode;
        } else {
            DayNode current = first;
            while(current.getNext()!=null){
                current = current.getNext();
            }
            current.setNext(newDayNode);
        }
    }

    public void printDayListing(){
        System.out.println(this.toString());
    }

    public void createDays() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while(creating){
            System.out.println("Nombre del dia (-1 para terminar)");
            String dayName = userInput.nextLine();
            if(dayName.equals("-1")) {
                creating=!creating;
            } else {
                Day day = new Day(dayName);
                day.createIntakes();
                addDay(day);
            }
        }        
    }

    public void deleteDietFunctionality(DayNode nodeToDelete) {
        if (nodeToDelete == null) {
            return;
        }
        
        DayNode previous = null;
        DayNode current = first;
        
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

    public void editDietFunctionality(DayNode node) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Ingresa el nuevo dia");
        String newDietName = userInput.nextLine();
        node.getDay().setName(newDietName);
    }

    public void deleteAllDiet(){
        first = null;
    }

    public void deleteDiet() {
        boolean deleteDiet = true;
        Scanner userInput = new Scanner(System.in);
        
        while (deleteDiet) {
            System.out.println("1) Eliminar un dia");
            System.out.println("2) Eliminar todos los dias");
            System.out.println("3) Guardar Dias\n");
            String o = userInput.nextLine();
            
            if (o.equals("1")) {
                DayNode current = first;
                while (current != null) {
                    System.out.println("El dia actual es: " + current.getDay().getDetailsDiet()); // crear un toString para intake
                    System.out.println("1) Eliminar");
                    System.out.println("2) Siguiente\n");
                    String optionDelete = userInput.nextLine();
    
                    if (optionDelete.equals("1")) {
                        System.out.println("Eliminando un dia");
                        deleteDietFunctionality(current);
                        break;
                    } else if (optionDelete.equals("2")) {
                        System.out.println("Siguiente dia\n");
                    }
                    current = current.getNext();
                }
            } else if (o.equals("2")) {
                System.out.println("Eliminando todos los dias");
                deleteAllDiet();
            } else if (o.equals("3")) {
                deleteDiet = false;
            }
        }
    }

    public void editDiet() {
        boolean editing = true;
        Scanner userInput = new Scanner(System.in);
        
        while (editing) {
            System.out.println("1) Editar un dia");
            System.out.println("2) Guardar Dias\n");
            String o = userInput.nextLine();
            
            if (o.equals("1")) {
                DayNode current = first;
                while (current != null) {
                    System.out.println("El dia actual es: " + current.getDay().getDetailsDiet());
                    System.out.println("1) Editar");
                    System.out.println("2) Siguiente\n");
                    String optionEditing = userInput.nextLine();
                    
                    if (optionEditing.equals("1")) {
                        System.out.println("Editando");
                        editDietFunctionality(current);
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
        String daysListing = "";
        DayNode current = first;
        while (current != null) {
            daysListing = daysListing + current.getDay().getDetailsDiet() + "\n";
            current = current.getNext();
        }
        return daysListing;
    }    

    public static void main(String[] args) {

        Diet diet = new Diet();
        diet.createDays();
        diet.editDiet();
        diet.deleteDiet();
        diet.printDayListing();
    }      
}