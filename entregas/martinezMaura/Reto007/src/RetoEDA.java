lass RetoEDA {

    private Baraja baraja;

    public static void main(String[] args) {

        Baraja baraja = new Baraja();

        // 
        OrdenadorDeBaraja.ordenarBarajaPorPalo(baraja);
        OrdenadorDeBaraja.imprimirBaraja(baraja);
        OrdenadorDeBaraja.ordenarBarajaPorRango(baraja);
        OrdenadorDeBaraja.imprimirBaraja(baraja);

        //
        Carta carta;
        do {
            carta = baraja.sacar();
            carta.voltear();
            carta.mostrar();
        } while (!baraja.vacia());
    }
}   
