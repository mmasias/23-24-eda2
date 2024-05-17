import java.util.ArrayList;

public class Ordenador {

  public void ordenarPorPalo(Baraja baraja) {
    ArrayList<Carta> cartas = new ArrayList<Carta>();
    while (!baraja.vacia()) {
      cartas.add(baraja.sacar());
    }

    sortByPalo(cartas, 0, cartas.size() - 1);
  }

  private void sortByPalo(ArrayList<Carta> cartas, int left, int right) {
    if (left < right) {
      int middle = (left + right) / 2;

      sortByPalo(cartas, left, middle);
      sortByPalo(cartas, middle + 1, right);

      merge(cartas, left, middle, right);
    }
  }

  private void merge(ArrayList<Carta> cartas, int left, int middle, int right) {

  }
}
