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
        if (first == null) {
            System.out.println("No hay Ingestas registradas");
            return;
        } else {
        System.out.println(this.toString());
        }
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

    public void editDiet() {
        boolean isEditing = true;
        Scanner QueEditar = new Scanner(System.in);
        while (isEditing) {
            System.out.println("¿Qué día desea editar? (-1 para salir)");
            String dayName = QueEditar.nextLine();
            if (dayName.equals("-1")) {
                isEditing = false;
            } else {
                editSpecificDay(dayName);
            }
        }
    }

        public void editSpecificDay(String dayName) {
        DayNode current = first;
        while (current != null) {
            if (current.getDay().getName().equals(dayName)) {
                current.getDay().editDay();
                return;
            }
            current = current.getNext();
        }
    }

    public void deleteDiet() {
        Scanner confirmación = new Scanner(System.in);
        System.out.println("¿Estás seguro de que quieres eliminar la dieta? (s/n)");
        if (confirmación.nextLine().equals("s")) {
            first = null;
        } else{}
        return;
    }

    @Override
    public String toString() {
        String daysListing = "";
        DayNode current = first;
        while (current != null) {
            daysListing = daysListing + current.getDay().toString() + "\n";
            current = current.getNext();
        }
        return daysListing;
    }    

    public static void main(String[] args) {

        Diet diet = new Diet();
        Boolean Editing = true;
        while (Editing){
        System.out.println("Estás en el registro de Días");
        System.out.println("¿Que desea hacer?");
        System.out.println("1 Crear un dieta");
        System.out.println("2 Leer la dieta");
        System.out.println("3 Editar la dieta");
        System.out.println("4 Eliminar la dieta");
        System.out.println("Para Salir introduzca [-1]");
        Scanner userInput = new Scanner(System.in);
        String option = userInput.nextLine();
        switch (option) {
            case "1":
                System.out.println("Creando Dieta");
                diet.createDays();
                diet.printDayListing();
                break;
            case "2":
                System.out.println("Mostrando Dieta");
                diet.printDayListing();
                break;
            case "3":
                System.out.println("Editando Día");
                diet.editDiet();
                diet.printDayListing();
                break;
            case "4":
                System.out.println("Eliminando Día");
                diet.deleteDiet();
                diet.printDayListing();
                break;
            case "-1":
                System.out.println("Saliendo");
                Editing = false;
                System.out.println("Esta es el dieta que has registrado:");
                diet.printDayListing();
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
        
    }
        
    }
}