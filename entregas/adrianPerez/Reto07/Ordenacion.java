public class Ordenacion {

    // Sort by suit (♥️, ♦️, ♣️, ♠️) without considering numbers
    public void ordenarPorPalo1(Baraja baraja) {
        Carta[] cartas = baraja.getCartas();
        for (int i = 0; i < cartas.length - 1; i++) {
            for (int j = 0; j < cartas.length - 1 - i; j++) {
                if (cartas[j].getPalo() > cartas[j + 1].getPalo()) {
                    Carta temp = cartas[j];
                    cartas[j] = cartas[j + 1];
                    cartas[j + 1] = temp;
                }
            }
        }
    }

    // Sort by suit (♠️, ♣️, ♦️, ♥️) without considering numbers
    public void ordenarPorPalo2(Baraja baraja) {
        Carta[] cartas = baraja.getCartas();
        for (int i = 0; i < cartas.length - 1; i++) {
            for (int j = 0; j < cartas.length - 1 - i; j++) {
                if (cartas[j].getPalo() < cartas[j + 1].getPalo()) {
                    Carta temp = cartas[j];
                    cartas[j] = cartas[j + 1];
                    cartas[j + 1] = temp;
                }
            }
        }
    }

    // Sort by numbers in ascending order without considering suits
    public void ordenarPorNumeroAsc(Baraja baraja) {
        Carta[] cartas = baraja.getCartas();
        for (int i = 0; i < cartas.length - 1; i++) {
            for (int j = 0; j < cartas.length - 1 - i; j++) {
                if (cartas[j].getNumero() > cartas[j + 1].getNumero()) {
                    Carta temp = cartas[j];
                    cartas[j] = cartas[j + 1];
                    cartas[j + 1] = temp;
                }
            }
        }
    }

    // Sort by numbers in descending order without considering suits
    public void ordenarPorNumeroDesc(Baraja baraja) {
        Carta[] cartas = baraja.getCartas();
        for (int i = 0; i < cartas.length - 1; i++) {
            for (int j = 0; j < cartas.length - 1 - i; j++) {
                if (cartas[j].getNumero() < cartas[j + 1].getNumero()) {
                    Carta temp = cartas[j];
                    cartas[j] = cartas[j + 1];
                    cartas[j + 1] = temp;
                }
            }
        }
    }
}