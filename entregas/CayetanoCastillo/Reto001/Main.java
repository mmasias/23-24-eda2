package entregas.CayetanoCastillo.Reto001;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Diet diet = new Diet();
        boolean running = true;

        while (running) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Añadir día a la dieta");
            System.out.println("2. Mostrar días de la dieta");
            System.out.println("3. Actualizar día en la dieta");
            System.out.println("4. Eliminar día de la dieta");
            System.out.println("5. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:

                    Day newDay = new Day();
                    newDay.createIntakes();
                    diet.addDay(newDay);
                    System.out.println("Día añadido a la dieta.");
                    break;
                case 2:

                    diet.printDayListing();
                    break;
                case 3:

                    System.out.println("Ingrese la posición del día que desea actualizar empezando en 0: ");
                    int updatePosition = scanner.nextInt();
                    scanner.nextLine();
                    Day updatedDay = new Day();
                    updatedDay.createIntakes();
                    boolean updated = diet.updateDay(updatePosition, updatedDay);
                    if (updated) {
                        System.out.println("Día actualizado correctamente.");
                    } else {
                        System.out.println("Error al actualizar el día. Verifique la posición.");
                    }
                    break;
                case 4:

                    System.out.println("Ingrese la posición del día que desea eliminar empezando en 0:");
                    int deletePosition = scanner.nextInt();
                    boolean deleted = diet.deleteDay(deletePosition);
                    if (deleted) {
                        System.out.println("Día eliminado correctamente.");
                    } else {
                        System.out.println("Error al eliminar el día. Verifique la posición.");
                    }
                    break;
                case 5:

                    System.out.println("Saliendo...");
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
                    break;
            }
        }

        scanner.close();
    }
}