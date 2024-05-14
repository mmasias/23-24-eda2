class RetoEDA {

    public static void main(String[] args) {

        Baraja baraja = new Baraja();

        //
        Ordenar.ordenarMazo(baraja.getCartas());
        //
        Carta carta;
        do {
            carta = baraja.sacar();
            carta.voltear();
            carta.mostrar();
        } while (!baraja.vacia());
    }
}
