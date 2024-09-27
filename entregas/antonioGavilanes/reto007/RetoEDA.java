class RetoEDA {

    private Baraja baraja;

    public static void main(String[] args) {

        Baraja baraja = new Baraja();

        //
        OrdenCartas.ordenarBarajaPorPalo(baraja);
        OrdenCartas.mostrarBaraja(baraja);
        OrdenCartas.ordenarBarajaPorNumero(baraja);
        OrdenCartas.mostrarBaraja(baraja);
        //
        Carta carta;
        do {
            carta = baraja.sacar();
            carta.voltear();
            carta.mostrar();
        } while (!baraja.vacia());
    }
}
