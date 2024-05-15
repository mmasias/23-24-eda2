class Reto {

    private static void ordenarCartas(Carta[] cartas, boolean porNumero) {
        boolean sorted = false;
        int passIndex = 0;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < cartas.length - 1 - passIndex; i++) {
                if (porNumero ? cartas[i].getNumero() > cartas[i + 1].getNumero() : cartas[i].getPalo() > cartas[i + 1].getPalo()) {
                    Carta temp = cartas[i];
                    cartas[i] = cartas[i + 1];
                    cartas[i + 1] = temp;
                    sorted = false;
                }
            }
            passIndex++;
        }
    }

    private static void mostrarBaraja(Baraja baraja, String mensaje) {
        System.out.println("\n" + mensaje);
        while (!baraja.vacia()) {
            Carta carta = baraja.sacar();
            carta.voltear();
            carta.mostrar();
        }
    }

    public static void main(String[] args) {
        Baraja baraja = new Baraja();
        Baraja baraja2 = new Baraja();

        Carta[] cartasOrdenadasNumero = new Carta[52];
        Carta[] cartasOrdenadasPalo = new Carta[52];

        for (int i = 0; i < 52; i++) {
            cartasOrdenadasNumero[i] = baraja.sacar();
            cartasOrdenadasPalo[i] = baraja2.sacar();
        }

        ordenarCartas(cartasOrdenadasNumero, true);
        ordenarCartas(cartasOrdenadasPalo, false);

        for (int i = 0; i < 52; i++) {
            baraja.poner(cartasOrdenadasNumero[i]);
            baraja2.poner(cartasOrdenadasPalo[i]);
        }

        mostrarBaraja(baraja, "\u001B[34mBARAJA ORDENADA POR NÚMEROS\u001B[0m");
        mostrarBaraja(baraja2, "\u001B[34mBARAJA ORDENADA POR PALOS\u001B[0m");
    }
}

