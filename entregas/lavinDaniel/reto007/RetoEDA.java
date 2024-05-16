package entregas.lavinDaniel.reto007;

import java.util.Scanner;

class RetoEDA {

    private Baraja baraja;

    public static void main(String[] args) {

        Baraja baraja = new Baraja();

        //
        Scanner scanner = new Scanner(System.in);
        System.out.println("Escoge una opción para ordenar la baraja:");
        System.out.println("1. Ordenar por palo");
        System.out.println("2. Ordenar por número");
        System.out.print("Introduce tu elección:");
        int eleccion = scanner.nextInt();
        //
        Carta carta;
        do {
            carta = baraja.sacar();
            carta.voltear();
            carta.mostrar();
        } while (!baraja.vacia());
    }
}