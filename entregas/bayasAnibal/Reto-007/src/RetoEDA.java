import java.util.Comparator;


class RetoEDA {

    private Baraja baraja;

    public static void main(String[] args) {

        Baraja baraja = new Baraja();

        //

        Comparator comparador = new Comparator<Carta>() {
            @Override
            public int compare(Carta carta1, Carta carta2) {
                if (carta1.igualPalo(carta2)) {
                    if (carta1.getNumero() < carta2.getNumero()) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else {
                    if (carta1.getPalo() < carta2.getPalo()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        };
        Carta[] array = baraja.getCartas();
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (comparador.compare(array[j], array[j + 1]) > 0) {
                    Carta temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        Comparator comparador2 = new Comparator<Carta>() {
            @Override
            public int compare(Carta carta1, Carta carta2) {
                if (carta1.getNumero() == carta2.getNumero()) {
                    if (carta1.getPalo() < carta2.getPalo()) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else {
                    if (carta1.getNumero() < carta2.getNumero()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        };
        Carta[] array2 = baraja.getCartas();
        int m = array2.length;
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < m - 1; j++) {
                if (comparador2.compare(array2[j], array2[j + 1]) > 0) {
                    Carta temp = array2[j];
                    array2[j] = array2[j + 1];
                    array2[j + 1] = temp;
                }
            }
        }
        //
        Carta carta;
        do {
            carta = baraja.sacar();
            carta.voltear();
            carta.mostrar();
        } while (!baraja.vacia());
    }
}
