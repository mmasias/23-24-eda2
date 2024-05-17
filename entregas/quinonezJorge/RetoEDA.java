class RetoEDA {

  private Baraja baraja;

  public static void main(String[] args) {

    Baraja baraja = new Baraja();
    Ordenador ordenadorDeCartas = new Ordenador();

    ordenadorDeCartas.ordenarPorPalo(baraja);

    Carta carta;
    do {
      carta = baraja.sacar();
      carta.voltear();
      carta.mostrar();
    } while (!baraja.vacia());
  }
}