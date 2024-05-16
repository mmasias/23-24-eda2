import java.util.Arrays;

public class OrdenadaBaraja {
    public static void main(String[] args) {
        Baraja baraja = new Baraja();
        ordenarBarajaPorPalo(baraja);
        imprimirBaraja(baraja);
        ordenarBarajaPorRango(baraja);
        imprimirBaraja(baraja);
    }

    public static void ordenarBarajaPorPalo(Baraja baraja) {
        Carta[] cartas = baraja.getCartas();
        mergeSort(cartas, 0, cartas.length - 1, true);
    }

    public static void ordenarBarajaPorRango(Baraja baraja) {
        Carta[] cartas = baraja.getCartas();
        mergeSort(cartas, 0, cartas.length - 1, false);
    }

    public static void mergeSort(Carta[] cartas, int inicio, int fin, boolean porPalo) {
        if (inicio < fin) {
            int medio = (inicio + fin) / 2;
            mergeSort(cartas, inicio, medio, porPalo);
            mergeSort(cartas, medio + 1, fin, porPalo);
            merge(cartas, inicio, medio, fin, porPalo);
        }
    }

    public static void merge(Carta[] cartas, int inicio, int medio, int fin, boolean porPalo) {
        Carta[] temp = new Carta[fin - inicio + 1];
        int i = inicio, j = medio + 1, k = 0;

        while (i <= medio && j <= fin) {
            if (porPalo) {
                if (cartas[i].getPalo() < cartas[j].getPalo() || (cartas[i].getPalo() == cartas[j].getPalo() && cartas[i].getRango() < cartas[j].getRango())) {
                    temp[k++] = cartas[i++];
                } else {
                    temp[k++] = cartas[j++];
                }
            } else {
                if (cartas[i].getRango() < cartas[j].getRango() || (cartas[i].getRango() == cartas[j].getRango() && cartas[i].getPalo() < cartas[j].getPalo())) {
                    temp[k++] = cartas[i++];
                } else {
                    temp[k++] = cartas[j++];
                }
            }
        }

        while (i <= medio) {
            temp[k++] = cartas[i++];
        }

        while (j <= fin) {
            temp[k++] = cartas[j++];
        }

        for (i = 0; i < temp.length; i++) {
            cartas[inicio + i] = temp[i];
        }
    }

    public static void imprimirBaraja(Baraja baraja) {
        Carta[] cartas = baraja.getCartas();
        System.out.println("Baraja ordenada:");
        for (Carta carta : cartas) {
            carta.mostrar();
        }
        System.out.println();
    }
}
