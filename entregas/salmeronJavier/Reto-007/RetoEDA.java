import java.util.Arrays;
import java.util.Comparator;

class RetoEDA {

    private Baraja baraja;

    public static void main(String[] args) {

        Baraja baraja = new Baraja();

        //

        Carta[] cartas = new Carta[52];
        for (int i = 0; i < cartas.length; i++) {
            cartas[i] = baraja.sacar();
        }

        boolean cambioCompletado;
        for (int i = 0; i < cartas.length - 1; i++) {
            cambioCompletado = false;
            for (int j = 0; j < cartas.length - 1 - i; j++) {
                boolean c1IsRed = cartas[j].distintoColor(new Carta(2, 0));
                boolean c2IsRed = cartas[j + 1].distintoColor(new Carta(2, 0));

                if ((c1IsRed && !c2IsRed) || (c1IsRed == c2IsRed && cartas[j].numero() > cartas[j + 1].numero())) {
                    Carta cambio = cartas[j];
                    cartas[j] = cartas[j + 1];
                    cartas[j + 1] = cambio;
                    cambioCompletado = true;
                }
            }
            if (!cambioCompletado) break;
        }

        for (Carta carta : cartas) {
            baraja.poner(carta);
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
