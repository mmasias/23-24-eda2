class RetoEDA {

    private Baraja baraja;

    public static void main(String[] args) {

        Baraja baraja = new Baraja();

        // 
        OrdenadorDeBaraja.ordenarBarajaPorPalo(baraja);
        OrdenadorDeBaraja.mostrarBaraja(baraja);
        OrdenadorDeBaraja.ordenarBarajaPorNumero(baraja);
        OrdenadorDeBaraja.mostrarBaraja(baraja);
        
        //
        Carta carta;
        do {
            carta = baraja.sacar();
            carta.voltear();
            carta.mostrar();
        } while (!baraja.vacia());
    }
}   