package entregas.CayetanoCastillo.Reto002;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Diet diet = new Diet();
        boolean running = true;

        while (running) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Añadir ingesta a la dieta");
            System.out.println("2. Mostrar ingestas de la dieta");
            System.out.println("3. Actualizar ingestas en la dieta");
            System.out.println("4. Eliminar ingesta de la dieta");
            System.out.println("5. Salir");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:

                    Day newDay = new Day();
                    newDay.createIntakes();
                    diet.addDay(newDay);
                    System.out.println("Ingesta añadida a la dieta.");
                    break;
                case 2:

                    diet.printDayListing();
                    break;
                case 3:

                    System.out.println("Ingrese la posición de la ingesta que desea actualizar empezando en 0: ");
                    int updatePosition = scanner.nextInt();
                    scanner.nextLine();
                    Day updatedDay = new Day();
                    updatedDay.createIntakes();
                    boolean updated = diet.updateDay(updatePosition, updatedDay);
                    if (updated) {
                        System.out.println("Ingesta actualizada correctamente.");
                    } else {
                        System.out.println("Error al actualizar de la Ingesta. Verifique la posición.");
                    }
                    break;
                case 4:

                    System.out.println("Ingrese la posición de la ingesta que desea eliminar empezando en 0:");
                    int deletePosition = scanner.nextInt();
                    boolean deleted = diet.deleteDay(deletePosition);
                    if (deleted) {
                        System.out.println("Ingesta eliminada correctamente.");
                    } else {
                        System.out.println("Error al eliminar la Ingesta. Verifique la posición.");
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