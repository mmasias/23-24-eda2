class RetoEDA {

    private Baraja baraja;

    public static void main(String[] args) {

        Baraja baraja = new Baraja();

        //
        OrdenacionBaraja.ordenarBarajaPorPalo(baraja);
        OrdenacionBaraja.mostrarBaraja(baraja);
        OrdenacionBaraja.ordenarBarajaPorNumero(baraja);
        OrdenacionBaraja.mostrarBaraja(baraja);
        //
        Carta carta;
        do {
            carta = baraja.sacar();
            carta.voltear();
            carta.mostrar();
        } while (!baraja.vacia());
    }
}