package perezPablo.reto002;
import java.util.Scanner;
import java.util.LinkedList;

class Diet {
    private String name;
    private LinkedList<Day> dayList;
    public Diet(String name) {
        dayList = new LinkedList<>();
        this.name = name;
    }

    public void addDay(Day day){
        dayList.add(day);
    }

    public void printDayListing(){
        System.out.println(this.toString());
    }

    public void createDiet() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while(creating){
            System.out.println("Nombre del dia (-1 para terminar)");
            String dayName = userInput.nextLine();
            if(dayName.equals("-1")) {
                creating=!creating;
            } else {
                Day day = new Day(dayName);
                day.createDay();
                addDay(day);
            }
        }        
    }

    public void editDay(String dayName) {
        Scanner userInput = new Scanner(System.in);
        for (Day day : dayList) {
            if (day.getName().equals(dayName)) {
                System.out.println("Nuevo nombre de [" + dayName + "]");
                String newName = userInput.nextLine();
                day.setName(newName);
                return;
            }
        }
        System.out.println("Dia no encontrado.");
    }

    public void editDiet() {
        boolean editing = true;
        Scanner userInput = new Scanner(System.in);
        while (editing) {
            System.out.println("Ingrese el nombre del dia a editar (-1 para terminar):");
            String day = userInput.nextLine();
            if (day.equals("-1")) {
                editing = !editing;
            } else {
                editDay(day);
            }
        }
    }

    public void deleteAll() {
        dayList.clear();
    }

    public void deleteDay(String day) {
        boolean removed = dayList.removeIf(f -> f.getName().equals(day));
        if (!removed) {
            System.out.println("Dia no encontrado.");
        }
    }

    public void deleteDay() {
        Scanner userInput = new Scanner(System.in);
        boolean deleting = true;
        while (deleting) {
            System.out.println("Nombre del día por eliminar (-1 para terminar)");
            String day = userInput.nextLine();
            if (day.equals("-1")) {
                deleting = !deleting;
            } else {
                deleteDay(day);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder dayListing = new StringBuilder();
        for (Day day: dayList) {
            dayListing.append(day.toString()).append("\n");
        }
        return dayListing.toString();
    }    

    public static void main(String[] args) {

        Diet mediterranean = new Diet("Mediterranea");
        mediterranean.createDiet();
        System.out.println("Se crea la dieta");
        mediterranean.printDayListing();
        Day monday = new Day("Lunes");
        Day tuesday = new Day("Martes");
        mediterranean.addDay(monday);
        mediterranean.addDay(tuesday);
        System.out.println("Se añade lunes y martes");
        mediterranean.printDayListing();
        System.out.println("Se elimina lunes");
        mediterranean.deleteDay("Lunes");
        mediterranean.printDayListing();
        mediterranean.deleteDay();
        mediterranean.printDayListing();
    }      
}