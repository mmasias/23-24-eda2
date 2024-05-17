import java.util.ArrayList;

public class Ordenador {

  public void ordenarPorPalo(Baraja baraja) {
    ordenarPorNumero(baraja);
    ArrayList<Carta> cartas = crearArrayDeCartas(baraja);
    for (int i = 0; i < 4; i++) {
      for (int j = cartas.size() - 1; j >= 0; j--) {
        if (cartas.get(j).getPalo() == i) {
          baraja.poner(cartas.get(j));
        }
      }
    }
  }

  public void ordenarPorNumero(Baraja baraja) {
    ArrayList<Carta> cartas = crearArrayDeCartas(baraja);

    sort(cartas, 0, cartas.size() - 1);

    for (int i = cartas.size() - 1; i >= 0; i--) {
      baraja.poner(cartas.get(i));
    }
  }

  private ArrayList<Carta> crearArrayDeCartas(Baraja baraja) {
    ArrayList<Carta> cartas = new ArrayList<>();
    while (!baraja.vacia()) {
      cartas.add(baraja.sacar());
    }
    return cartas;
  }

  private void sort(ArrayList<Carta> cartas, int left, int right) {
    if (left < right) {
      int middle = (left + right) / 2;

      sort(cartas, left, middle);
      sort(cartas, middle + 1, right);

      merge(cartas, left, middle, right);
    }
  }

  private void merge(ArrayList<Carta> cartas, int left, int middle, int right) {
    int sizeL = middle - left + 1;
    int sizeR = right - middle;

    ArrayList<Carta> L = new ArrayList<>(sizeL);
    ArrayList<Carta> R = new ArrayList<>(sizeR);

    for (int i = 0; i < sizeL; i++) {
      L.add(cartas.get(left + i));
    }
    for (int j = 0; j < sizeR; j++) {
      R.add(cartas.get(middle + 1 + j));
    }

    int i = 0, j = 0;
    int k = left;

    while (i < sizeL && j < sizeR) {
      if (L.get(i).getNumero() <= R.get(j).getNumero()) {
        cartas.set(k, L.get(i));
        i++;
      } else {
        cartas.set(k, R.get(j));
        j++;
      }
      k++;
    }

    while (i < sizeL) {
      cartas.set(k, L.get(i));
      i++;
      k++;
    }

    while (j < sizeR) {
      cartas.set(k, R.get(j));
      j++;
      k++;
    }
  }
}
