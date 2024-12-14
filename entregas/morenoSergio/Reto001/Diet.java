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

    public void CreateDiets(){
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating){
            System.out.println("Nombre del dia (-1 para terminar)");
            String dayName = userInput.nextLine();
            if (dayName.equals("-1")){
                creating = !creating;
            } else {
                Day day = new Day(dayName);
                day.createDay();
                addDay(day);
            }
        }
    }
    public void updateDiets(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del dia que quieres actualizar");
        String dayNameToUpdate = userInput.nextLine();
        DayNode current = first;
        while (current != null){
            if (current.getDay().getName().equals(dayNameToUpdate)){
                System.out.println("Nuevo nombre del dia");
                String newDayName = userInput.nextLine();
                current.getDay().setName(newDayName);
                return;
            }
            current = current.getNext();
        }
    }
    public void DeleteDiets(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("Nombre del dia que quieres eliminar");
        String dayNameToRemove = userInput.nextLine();
        DayNode current = first;
        DayNode previous = null;
        while (current != null){
            if (current.getDay() != null && current.getDay().getName() != null && current.getDay().getName().equals(dayNameToRemove)){
                if (previous == null){
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


    public void menu(){
        Scanner userInput = new Scanner(System.in);
        boolean menu = true;
        while (menu){
            System.out.println("1. Crear dieta");
            System.out.println("2. Ver dieta");
            System.out.println("3. Actualizar dieta");
            System.out.println("4. Eliminar dieta");
            System.out.println("5. Salir");
            System.out.println("Opcion: ");
            int option = userInput.nextInt();
            switch (option){
                case 1:
                    CreateDiets();
                    break;
                case 2:
                    printDayListing();
                    break;
                case 3:
                    updateDiets();
                    break;
                case 4:
                    DeleteDiets();
                    break;
                case 5:
                    menu = !menu;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
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
        diet.menu();
    }
}