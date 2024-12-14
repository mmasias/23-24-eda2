package entregas.lopesBrenda.Reto007;

import java.util.Scanner;

public class RetoEDA {
    
    private static void ordenarCartas(Carta[] cartas, boolean porNumero) {
        boolean sorted = false;
        int passIndex = 0;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < cartas.length - 1 - passIndex; i++) {
                if (porNumero ? cartas[i].getNumero() > cartas[i + 1].getNumero() : cartas[i].getPalo() > cartas[i + 1].getPalo()) {
                    Carta temp = cartas[i];
                    cartas[i] = cartas[i + 1];
                    cartas[i + 1] = temp;
                    sorted = false;
                }
            }
            passIndex++;
        }
    }

    private static void mostrarBaraja(Baraja baraja, String mensaje) {
        System.out.println("\n" + mensaje);
        while (!baraja.vacia()) {
            Carta carta = baraja.sacar();
            carta.voltear();
            carta.mostrar();
        }
    }

    public static void main(String[] args) {
        Baraja baraja = new Baraja();
        Baraja baraja2 = new Baraja();

        Carta[] ordenadasNumero = new Carta[Baraja.TOTAL_CARTAS];
        Carta[] ordenadasPalo = new Carta[Baraja.TOTAL_CARTAS];

        for (int i = 0; i < Baraja.TOTAL_CARTAS; i++) {
            ordenadasNumero[i] = baraja.sacar();
            ordenadasPalo[i] = baraja2.sacar();
        }

        ordenarCartas(ordenadasNumero, true);
        ordenarCartas(ordenadasPalo, false);

        for (int i = 0; i < Baraja.TOTAL_CARTAS; i++) {
            baraja.poner(ordenadasNumero[i]);
            baraja2.poner(ordenadasPalo[i]);
        }

        int opcion;
        System.out.println("Pulse 1 para ordenar la baraja por Números!");
        System.out.println("Pulse 2 para ordenar la baraja por Palos!");
        opcion = new Scanner(System.in).nextInt();

        if (opcion == 1) {
            mostrarBaraja(baraja, "BARAJA ORDENADA POR NÚMEROS");
        }else{
            mostrarBaraja(baraja2, "BARAJA ORDENADA POR PALOS");
        }
    }
}
