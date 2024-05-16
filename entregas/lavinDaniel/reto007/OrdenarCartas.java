package entregas.lavinDaniel.reto007;

import java.lang.reflect.Field;
import java.util.Comparator;

public class OrdenarCartas {
    public static void ordenarPorNumero(Carta[] cartas){
        bubbleSort(cartas, Comparator.comparingInt(c -> getFieldValue(c, "numero")));
    }
    public static void ordenarPorPaloYNumero(Carta[] cartas) {
        bubbleSort(cartas, new Comparator<Carta>() {
            @Override
            public int compare(Carta c1, Carta c2) {
                int paloCompare = Integer.compare(getFieldValue(c1, "palo"), getFieldValue(c2, "palo"));
                if (paloCompare != 0) {
                    return paloCompare;
                } else {
                    return Integer.compare(getFieldValue(c1, "numero"), getFieldValue(c2, "numero"));
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

    private static int getFieldValue(Carta carta, String fieldName) {
        try {
            Field field = Carta.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            return (int) field.get(carta);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

