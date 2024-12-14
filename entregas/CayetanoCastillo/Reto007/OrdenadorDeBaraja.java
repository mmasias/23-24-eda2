package entregas.CayetanoCastillo.Reto007;

import java.util.Comparator;

public class OrdenadorDeBaraja {

    public static void ordenarPorNumero(Carta[] cartas) {
        Comparator<Carta> byNumero = Comparator.comparingInt(Carta::getNumero);
        bubbleSort(cartas, byNumero);
    }

    public static void ordenarPorPalo(Carta[] cartas) {
        Comparator<Carta> byPalo = Comparator.comparingInt(Carta::getPalo);
        bubbleSort(cartas, byPalo);
    }

    private static void bubbleSort(Carta[] cartas, Comparator<Carta> comparator) {
        boolean swapped;
        int n = cartas.length;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (comparator.compare(cartas[i - 1], cartas[i]) > 0) {
                    Carta temp = cartas[i];
                    cartas[i] = cartas[i - 1];
                    cartas[i - 1] = temp;
                    swapped = true;
                }
            }
            n--;
        } while (swapped);
    }
}
