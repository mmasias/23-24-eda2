import java.util.Comparator;

public class CartaOrdenador {

    public static void ordenarPorNumero(Carta[] cartas) {
        bubbleSort(cartas, Comparator.comparingInt(c -> c.numero));
    }

    public static void ordenarPorPaloYNumero(Carta[] cartas) {
        bubbleSort(cartas, new Comparator<Carta>() {
            @Override
            public int compare(Carta c1, Carta c2) {
                int paloCompare = Integer.compare(c1.palo, c2.palo);
                if (paloCompare != 0) {
                    return paloCompare;
                } else {
                    return Integer.compare(c1.numero, c2.numero);
                }
            }
        });
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
