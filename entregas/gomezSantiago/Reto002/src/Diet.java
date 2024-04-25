import java.util.ArrayList;
import java.util.Scanner;

class Diet {
    private ArrayList<Day> dayList;

    public Diet() {
        dayList = new ArrayList<>();
    }

    public void addDay(Day day){
        dayList.add(day);
    }

    public void printDayListing(){
        for (Day day : dayList){
            System.out.println(this.toString());
        }
    }

    public void createDay() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while(creating){
            System.out.println("+-----------------------------------+");
            System.out.println("| Nombre del dia (-1 para terminar) |");
            System.out.println("+-----------------------------------+");
            String dayName = userInput.nextLine();
            if(dayName.equals("-1")) {
                creating=!creating;
            } else {
                Day day = new Day();
                addDay(day);
            }
        }
    }

    public void deleteDay(){
        Scanner userInput = new Scanner(System.in);
        if (dayList.isEmpty()) {
            System.out.println("+-----------------------------+");
            System.out.println("| La lista de dias esta vacía |");
            System.out.println("+-----------------------------+");
            return;
        }

        System.out.println("+------------------------------------+");
        System.out.println("| Ingrese el dia que desea eliminar: |");
        System.out.println("+------------------------------------+");
        String dayNameDelete = userInput.nextLine();
        System.out.println("+-----------------------------------------+");
        System.out.println("| Se ha eliminado " + dayNameDelete + " correctamente |" + "\n");
        System.out.println("+-----------------------------------------+");

        boolean dayInList = false;
        for (Day day : dayList) {
            if (day.toString().equals(dayNameDelete)) {
                dayList.remove(day);
                dayInList = true;
                break;
            }
        }

        if (!dayInList) {
            System.out.println("+--------------------------------+");
            System.out.println("| No se ha encontrado ningun dia |");
            System.out.println("+--------------------------------+");
        }
    }
    public void modifyDay(){
        Scanner userInput = new Scanner(System.in);
        System.out.println("+--------------------------------------+");
        System.out.println("| Ingrese el dia que desea editar: |");
        System.out.println("+--------------------------------------+");
        String dayNameEdit = userInput.nextLine();
        System.out.println("+-------------------------------------------------+");
        System.out.println("| Se ha editado el dia: " + dayNameEdit + " |"+ "\n");
        System.out.println("+-------------------------------------------------+");

        boolean dayToEdit = false;
        for (Day day : dayList) {
            if (day.toString().equals(dayNameEdit)) {
                day.modifyIntake();
                dayToEdit = true;
                break;
            }
        }

        if (!dayToEdit) {
            System.out.println("+-------------------------------------+");
            System.out.println("| No se pudo encontrar el dia deseado |");
            System.out.println("+-------------------------------------+");
        }

    }

    public void optionsMenu() {
        Scanner userInput = new Scanner(System.in);
        boolean options = false;
        System.out.println("+-----------------+");
        System.out.println("| Opciones de Dia |");
        System.out.println("+-----------------+");
        while (!options) {
            System.out.println("+-------------------+");
            System.out.println("| Agregar dia (1)   |");
            System.out.println("| Eliminar dia (2)  |");
            System.out.println("| Modificar dia (3) |");
            System.out.println("| Mostrar dia (4)   |");
            System.out.println("| Salir de dia (0)  |");
            System.out.println("+-------------------+");
            int option = userInput.nextInt();
            switch (option) {
                case 1:
                    createDay();
                    break;
                case 2:
                    deleteDay();
                    break;
                case 3:
                    modifyDay();
                    break;
                case 4:
                    printDayListing();
                    break;
                case 0:
                    options = true;
                    break;
                default:
                    System.out.println("+------------------+");
                    System.out.println("| Opción no válida |");
                    System.out.println("+------------------+");
                    break;
            }
        }
    }

    public static void main(String[] args) {

        Diet diet = new Diet();

        diet.optionsMenu();

    }
}