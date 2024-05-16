import java.util.Arrays;

public class OrdenacionBaraja {

    public static void main(String[] args) {
        Baraja baraja = new Baraja();
        ordenarBarajaPorPalo(baraja);
        mostrarBaraja(baraja);
        ordenarBarajaPorNumero(baraja);
        mostrarBaraja(baraja);
    }

    public static void ordenarBarajaPorPalo(Baraja baraja) {
        Carta[] cartas = baraja.getCartas();
        mergeSortPorPalo(cartas, 0, cartas.length - 1);
    }

    public static void ordenarBarajaPorNumero(Baraja baraja) {
        Carta[] cartas = baraja.getCartas();
        mergeSortPorNumero(cartas, 0, cartas.length - 1);
    }

    public static void mergeSortPorPalo(Carta[] cartas, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSortPorPalo(cartas, left, middle);
            mergeSortPorPalo(cartas, middle + 1, right);
            mergePorPalo(cartas, left, middle, right);
        }
    }

    public static void mergeSortPorNumero(Carta[] cartas, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSortPorNumero(cartas, left, middle);
            mergeSortPorNumero(cartas, middle + 1, right);
            mergePorNumero(cartas, left, middle, right);
        }
    }

    public static void mergePorPalo(Carta[] cartas, int left, int middle, int right) {
        Carta[] temp = new Carta[right - left + 1];
        int i = left, j = middle + 1, k = 0;

        while (i <= middle && j <= right) {
            if (cartas[i].getPalo() < cartas[j].getPalo() ||
                    (cartas[i].getPalo() == cartas[j].getPalo() && cartas[i].getNumero() < cartas[j].getNumero())) {
                temp[k++] = cartas[i++];
            } else {
                temp[k++] = cartas[j++];
            }
        }

        while (i <= middle) {
            temp[k++] = cartas[i++];
        }

        while (j <= right) {
            temp[k++] = cartas[j++];
        }

        for (i = 0; i < temp.length; i++) {
            cartas[left + i] = temp[i];
        }
    }

    public static void mergePorNumero(Carta[] cartas, int left, int middle, int right) {
        Carta[] temp = new Carta[right - left + 1];
        int i = left, j = middle + 1, k = 0;

        while (i <= middle && j <= right) {
            if (cartas[i].getNumero() < cartas[j].getNumero() ||
                    (cartas[i].getNumero() == cartas[j].getNumero() && cartas[i].getPalo() < cartas[j].getPalo())) {
                temp[k++] = cartas[i++];
            } else {
                temp[k++] = cartas[j++];
            }
        }

        while (i <= middle) {
            temp[k++] = cartas[i++];
        }

        while (j <= right) {
            temp[k++] = cartas[j++];
        }

        for (i = 0; i < temp.length; i++) {
            cartas[left + i] = temp[i];
        }
    }

    public static void mostrarBaraja(Baraja baraja) {
        Carta[] cartas = baraja.getCartas();
        System.out.println("Ordenando Baraja:");
    
        for (int i = 0; i < 4; i++) {
            cartas[i].mostrar();
            System.out.print(" ");
        }
        System.out.println();
    
        for (int i = 4; i < cartas.length; i++) {
            if (i % 4 == 0) {
                System.out.println();
            }
            cartas[i].mostrar();
            System.out.print(" ");
            if ((i + 1) % 4 == 0) {
                System.out.println();
            }
        }
        System.out.println("+-------------------------------------------------------------------+");
    
        for (int i = cartas.length - 1; i >= 0; i--) {
            if ((cartas.length - 1 - i) % 4 == 0) {
                System.out.println();
            }
            cartas[i].mostrar();
            System.out.print(" ");
            if ((cartas.length - i) % 4 == 0) {
                System.out.println();
            }
        }
        System.out.println("+-------------------------------------------------------------------+");
    }
}