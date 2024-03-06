import java.util.Scanner;

class Diet {
    private DayNode first;
    private String name;

    public Diet(String name) {
        first = null;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
    public void setName(String nombre) {
        this.name = nombre;
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

    public void deleteDay(String name) {
        DayNode current = first;
        DayNode previous = null;
        while (current != null && !current.getDay().equals(name)) {
            previous = current;
            current = current.getNext();
        }
        if (current == null) return;
        if (previous == null) first = current.getNext();
        else previous.setNext(current.getNext());
    }

    public void updateDay(String name) {

        deleteDay(name);
        System.out.println("Nombre del dia");
        Scanner userInput = new Scanner(System.in);
        String newName = userInput.nextLine();
        Day dia = new Day(name);
        addDay(dia);
    }

    public void updateDiet() {
        System.out.println("Nombre del dia a editar");
        Scanner userInput = new Scanner(System.in);
        String name = userInput.nextLine();
        updateDay(name);
    }

    public void createDiet() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {

            System.out.println("Nombre de los dias (-1 para terminar)");
            String name = userInput.nextLine();
            if (name.equals("-1")) {
                creating = !creating;
            } else {
                Day dia = new Day(name);
                addDay(dia);
            }
        }
    }

    public void deleteDiet() {
        setName("Día eliminado");
        System.out.println(getName());
        this.first = null;
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

        Diet diet = new Diet("Dieta mediterranea");
        diet.createDiet();
        diet.printDayListing();
        System.out.println();
        diet.updateDiet();
        diet.printDayListing();
        System.out.println();
        diet.deleteDiet();
        diet.printDayListing();
        System.out.println();


    }
}
