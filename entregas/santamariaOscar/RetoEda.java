package entregas.santamariaOscar;

import java.util.Comparator;

class RetoEDA {

    private Baraja baraja;

    public static void main(String[] args) {

        Baraja baraja = new Baraja();

        //
        Comparator comparador = new Comparator<Carta>() {

            @Override
            public int compare(Carta c1, Carta c2) {

                if (c1.igualPalo(c2)) {
                    if (c1.getNumero() < c2.getNumero()) {
                        return 1;
                    } else {
                        return -1;
                    }

                } else {
                    if (c1.getPalo() < c2.getPalo()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        };

        Carta[] array=baraja.getCartas();
        int n = array.length;
        for (int i = 0; i < n - 1; i++) { // i es el número de pasadas completas
            for (int j = 0; j < n - 1; j++) { // j es el índice para comparar elementos adyacentes
                if (comparador.compare(array[j], array[j + 1])>0) {
                    // Intercambio de elementos
                    Carta temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }

        Comparator comparador2 = new Comparator<Carta>() {

            @Override
            public int compare(Carta c1, Carta c2) {

                if (c1.getNumero()==c2.getNumero()) {
                    if (c1.getPalo() < c2.getPalo()) {
                        return 1;
                    } else {
                        return -1;
                    }

                } else {
                    if (c1.getNumero() < c2.getNumero()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        };

        Carta[] array1=baraja.getCartas();
        int f = array.length;
        for (int i = 0; i < f - 1; i++) { // i es el número de pasadas completas
            for (int j = 0; j < f - 1; j++) { // j es el índice para comparar elementos adyacentes
                if (comparador2.compare(array1[j], array1[j + 1])>0) {
                    // Intercambio de elementos
                    Carta temp = array1[j];
                    array1[j] = array1[j + 1];
                    array1[j + 1] = temp;
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
