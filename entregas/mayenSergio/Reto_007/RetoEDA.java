package entregas.mayenSergio.Reto_007;

import java.util.Arrays;
import java.util.Comparator;

public class RetoEDA {

    private Baraja baraja;

    public static void main(String[] args) {

        Baraja baraja = new Baraja();

        Carta[] cartas = new Carta[52];
        int index = 0;

        while (!baraja.vacia()) {
            cartas[index] = baraja.sacar();
            index++;
        }

        Arrays.sort(cartas, 0, index, new Comparator<Carta>() {
            @Override
            public int compare(Carta c1, Carta c2) {
                int palo1 = getOrdenPalo(c1);
                int palo2 = getOrdenPalo(c2);

                if (palo1 != palo2) {
                    return Integer.compare(palo1, palo2);
                } else {
                    return Integer.compare(getNumero(c2), getNumero(c1));
                }
            }

            private int getOrdenPalo(Carta carta) {
                if (carta.igualPalo(new Carta(2, 0))) {
                    return 0;
                } else if (carta.igualPalo(new Carta(1, 0))) {
                    return 1;
                } else if (carta.igualPalo(new Carta(0, 0))) {
                    return 2;
                } else {
                    return 3;
                }
            }

            private int getNumero(Carta carta) {
                for (int i = 0; i < 13; i++) {
                    if (carta.siguiente(new Carta(0, i))) {
                        return i;
                    }
                }
                return 12;
            }
        });

        for (int i = 0; i < index; i++) {
            cartas[i].voltear();
            cartas[i].mostrar();
        }
    }
}