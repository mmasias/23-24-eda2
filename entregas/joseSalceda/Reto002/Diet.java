package entregas.joseSalceda.Reto002;

import java.util.Scanner;
import java.util.ArrayList;

class Diet {
    String name;
    private ArrayList<Day> Days;

    public Diet(String name) {
        this.name = name;
        this.Days = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addDay(Day Day) {
        Days.add(Day);
    }

    public void printDayListing() {
        System.out.println(this.toString());
    }

    public void createDays() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("Nombre del alimento (-1 para terminar)");
            String DayName = userInput.nextLine();
            if (DayName.equals("-1")) {
                creating = !creating;
            } else {
                Day Day = new Day(DayName);
                addDay(Day);
            }
        }
    }

    public void editDay(int index, String newName) {
        Days.get(index).setName(newName);
    }

    public void editDays() {
        boolean editing = true;
        Scanner userInput = new Scanner(System.in);
        while(editing){
            System.out.println("Nombre del alimento a editar (-1 para terminar)");
            printDayListing();
            String DayName = userInput.nextLine();
            if(DayName.equals("-1")){
                editing = !editing;
            } else {
                for (int i = 0; i < Days.size(); i++) {
                    if (Days.get(i).getName().equals(DayName)) {
                        System.out.println("Nuevo nombre del alimento");
                        String newDayName = userInput.nextLine();
                        editDay(i, newDayName);
                    } else {
                        System.out.println("Alimento no encontrado");
                    }
                }
            }
        }       
    }

    public void deleteDay(int index) {
        Days.remove(index);
    }

    public void deleteAllDays() {
        Days.clear();
    }

    public void deleteDays(){
        boolean deleting = true;
        Scanner userInput = new Scanner(System.in);
        while(deleting){
            System.out.println("1) Eliminar todos los alimentos\n2) Eliminar un alimento\n3) Salir");                 
            int option = userInput.nextInt();
            switch (option) {
                case 1:
                    deleteAllDays();
                    break;
                case 2:
                    System.out.println("Nombre del alimento a eliminar");
                    printDayListing();
                    String DayName = userInput.nextLine();
                    for (int i = 0; i < Days.size(); i++) {
                        if (Days.get(i).getName().equals(DayName)) {
                            deleteDay(i);
                        } else {
                            System.out.println("Alimento no encontrado");
                        }
                    }
                    break;
                case 3:
                    deleting = !deleting;
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }

    @Override
    public String toString() {
        String DayListing = "";
        for (Day Day : Days) {
            DayListing = DayListing + Day.toString() + "\n";
        }
        return DayListing;
    }

    public static void main(String[] args) {
        Diet diet = new Diet("Chema");
        diet.createDays();
        diet.printDayListing();
        diet.editDays();
        diet.deleteDays();
    }
}