import java.util.ArrayList;
import java.util.Scanner;

class Diet {
    private ArrayList<Day> dayList;

    public Diet() {
        dayList = new ArrayList<Day>();
    }

    public void addDay(Day day){
        dayList.add(day);
    }

    public void printDayListing(){
        if (dayList.isEmpty()){
            System.out.println("No hay Ingestas registradas");
            return;
        } else {
            for (Day day : dayList){
                System.out.println("Día " + day.getName() + ":");
                day.printIntakeListing();
            }
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
        for (Day day : dayList) {
            if (day.getName().equals(dayName)) {
                System.out.println("Editando " + dayName);
                System.out.println("¿Qué deseas hacer?");
                System.out.println("| 1 Editar el nombre del día | 2 Editar una ingesta | 3 Salir |");
                Scanner userInput = new Scanner(System.in);
                String option = userInput.nextLine();
                switch (option) {
                    case "1":
                        System.out.println("Nuevo nombre del día");
                        String newDayName = userInput.nextLine();
                        day.setName(newDayName);
                        break;
                    case "2":
                        day.editDay();
                        break;
                    case "3":
                        return;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
                return;
            }
        }
        System.out.println("Día no encontrado");
    }

    public void deleteDay() {
        boolean isDeleting = true;
        Scanner QueBorrar = new Scanner(System.in);
        while (isDeleting) {
            System.out.println("¿Qué día desea eliminar? (-1 para salir)");
            String dayName = QueBorrar.nextLine();
            if (dayName.equals("-1")) {
                isDeleting = false;
            } else {
                deleteSpecificDay(dayName);
            }
        }
    }

    public void deleteSpecificDay(String dayName) {
        for (Day day : dayList) {
            if (day.getName().equals(dayName)) {
                System.out.println("¿Qué deseas hacer?");
                System.out.println("| 1 Eliminar el día | 2 Eliminar una ingesta | 3 Salir |");
                Scanner userInput = new Scanner(System.in);
                String option = userInput.nextLine();
                switch (option) {
                    case "1":
                        dayList.remove(day);
                        System.out.println("Día eliminado: " + dayName);
                        return;
                    case "2":
                        day.deleteIntake();
                        break;
                    case "3":
                        return;
                    default:
                        System.out.println("Opción no válida");
                        break;
                }
            }
        }
        System.out.println("Día no encontrado");
    }

    public void deleteDiet() {
        Scanner confirmación = new Scanner(System.in);
        System.out.println("¿Estás seguro de que quieres eliminar la dieta? (s/n)");
        if (confirmación.nextLine().equals("s")) {
            dayList.clear();
        } else{}
        return;
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
        System.out.println("4 Eliminar datos");
        System.out.println("5 Eliminar el registro");
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
                System.out.println("Eliminando datos");
                diet.deleteDay();
                diet.printDayListing();
                case "5":
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