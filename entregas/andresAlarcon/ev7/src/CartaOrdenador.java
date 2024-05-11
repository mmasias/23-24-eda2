import java.util.Comparator;

public class CartaOrdenador {

    public static void ordenarPorPalo(Carta[] cartas) {
        bubbleSort(cartas, Comparator.comparingInt(c -> c.palo));
    }

    public static void ordenarPorNumero(Carta[] cartas) {
        bubbleSort(cartas, Comparator.comparingInt(c -> c.numero));
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
        } while (swapped);
    }
}
