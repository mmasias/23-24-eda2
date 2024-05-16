package entregas.lavinDaniel.reto007;

import java.lang.reflect.Field;
import java.util.Comparator;

public class OrdenarCartas {
    public static void clasificarNumero(Carta[] cartas){
        ordenarBurbuja(cartas, Comparator.comparingInt(c -> obtenerValor(c, "numero")));
    }
    public static void clasificarPaloYNumero(Carta[] cartas) {
        ordenarBurbuja(cartas, new Comparator<Carta>() {
            @Override
            public int compare(Carta c1, Carta c2) {
                int paloCompare = Integer.compare(obtenerValor(c1, "palo"), obtenerValor(c2, "palo"));
                if (paloCompare != 0) {
                    return paloCompare;
                } else {
                    return Integer.compare(obtenerValor(c1, "numero"), obtenerValor(c2, "numero"));
                }
            }
        });
    }
    private static void ordenarBurbuja(Carta[] cartas, Comparator<Carta> comparator) {
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

    private static int obtenerValor(Carta carta, String fieldName) {
        try {
            Field field = Carta.class.getDeclaredField(fieldName);
            field.setAccessible(true);
            return (int) field.get(carta);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}

