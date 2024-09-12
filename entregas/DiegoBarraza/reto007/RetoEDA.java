package entregas.DiegoBarraza.reto007;

import java.util.Scanner;
public class RetoEDA {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String continuar;

        do {
            Baraja baraja = new Baraja(); 
            int opcion = obtenerOpcion(scanner);

            boolean ordenarPorPalo = opcion == 1;

            Carta[] cartas = extraerCartasDeBaraja(baraja);

            OrdenadorCartas.sort(cartas, ordenarPorPalo);

            mostrarCartas(cartas);

            System.out.println("Presiona 'q' para salir o cualquier otra tecla para continuar...");
            continuar = scanner.next();

        } while (!continuar.equalsIgnoreCase("q"));

        scanner.close();
    }

    private static int obtenerOpcion(Scanner scanner) {
        int opcion;
        do {
            System.out.println("¿Cómo deseas ordenar las cartas?");
            System.out.println("1. Por palo");
            System.out.println("2. Por número");
            while (!scanner.hasNextInt()) {
                System.out.println("Opción inválida. Intenta de nuevo.");
                scanner.next();
            }
            opcion = scanner.nextInt();
        } while (opcion < 1 || opcion > 2);
        return opcion;
    }

    private static Carta[] extraerCartasDeBaraja(Baraja baraja) {
        Carta[] cartas = new Carta[Baraja.TOTAL_CARTAS];
        for (int i = 0; i < Baraja.TOTAL_CARTAS; i++) {
            cartas[i] = baraja.sacar();
        }
        return cartas;
    }

    private static void mostrarCartas(Carta[] cartas) {
        for (Carta carta : cartas) {
            carta.voltear();
            carta.mostrar();
            System.out.println();
        }
    }
}