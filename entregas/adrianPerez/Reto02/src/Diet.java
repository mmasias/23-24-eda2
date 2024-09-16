import java.util.ArrayList;
import java.util.Scanner;

class Diet {
    private ArrayList<Day> days;
    String name;

    public Diet(String name) {
        days = new ArrayList<Day>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addDay(Day day){
        days.add(day);
    }

    public void printDietListing(){
        System.out.println(this.toString());
    }

    public void createDiets() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while(creating){
            System.out.println("Nombre de la dieta (-1 para terminar)");
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

    public void deleteDiets() {
        Scanner scanner = new Scanner(System.in);
        boolean deleting = true;
        
        while(deleting == true) {

            System.out.println("Quiere borrar un día (1) o todos los días (2)? Pulse (3) para salir");

            String userInput = scanner.nextLine();

            if (userInput.equals("1")){
                System.out.println("Indique el día que quiere borrar:");
                userInput = scanner.nextLine();
                deleteDay(userInput);
            }
            else if (userInput.equals("2")) {
                deleteAllDays();
                deleting = !deleting;
            }
            else if (userInput.equals("3")) {
                deleting = !deleting;
            }
        }
    }

    private void deleteDay(String dayName) {
        for (Day day : days) {
            if (day.getName().equals(dayName)) {
                days.remove(day);
                System.out.println("Día borrado");
                break;
            }
        }
    }

    private void deleteAllDays() {
        days.clear();
    }

    public void editDays() {
        Scanner scanner = new Scanner(System.in);
        boolean editing = true;

        while (editing) {
            System.out.println("¿Desea editar un día? (1) Sí, (2) No");
            String userInput = scanner.nextLine();

            if (userInput.equals("1")) {
                System.out.println("Ingrese el nombre del día que desea editar:");
                String nameDia = scanner.nextLine();

                boolean found = false;
                for (Day day : days) {
                    if (day.getName().equals(nameDia)) {
                        System.out.println("Ingrese el nuevo nombre de la ingesta:");
                        String newNameIngesta = scanner.nextLine();
                        day.setName(newNameIngesta);
                        found = true;
                        System.out.println("Ingesta editada exitosamente.");
                        break;
                    }
                }

                if (!found) {
                    System.out.println("No se encontró ningúna ingesta con ese nombre.");
                }
            } else if (userInput.equals("2")) {
                editing = false;
            }
        }
    }

    @Override
    public String toString() {
        String dayListing = "";
        for (Day day : days) {
            dayListing = dayListing + day.toString() + "\n";
        }
        return dayListing   ;
    }    

    public static void main(String[] args) {

        Diet diet = new Diet("Adrian");
        diet.createDiets();
        diet.printDietListing();
    }      
}