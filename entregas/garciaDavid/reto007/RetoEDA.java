import java.util.Comparator;
import java.util.Scanner;

class RetoEDA {

    private Baraja baraja;

    public static void main(String[] args) {

        Baraja baraja = new Baraja();

        //
        Comparator comparadorPorPalo = new Comparator<Carta>() {
            @Override
            public int compare(Carta carta1, Carta carta2) {
                if (carta1.igualPalo(carta2)) {
                    if (carta1.getNumero() < carta2.getNumero()) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else {
                    if (carta1.getPalo() < carta2.getPalo()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        };

        Comparator comparadorPorNumero = new Comparator<Carta>() {
            @Override
            public int compare(Carta carta1, Carta carta2) {
                if (carta1.getNumero() == carta2.getNumero()) {
                    if (carta1.getPalo() < carta2.getPalo()) {
                        return 1;
                    } else {
                        return -1;
                    }
                } else {
                    if (carta1.getNumero() < carta2.getNumero()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        };

        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione el comparador a utilizar:");
        System.out.println("1. Ordenar por Palo");
        System.out.println("2. Ordenar por Número");
        int opcion = scanner.nextInt();

        Comparator<Carta> comparador;

        if (opcion == 1) {
            comparador = comparadorPorPalo;
        } else if (opcion == 2) {
            comparador = comparadorPorNumero;
        } else {
            System.out.println("Opción inválida. Se utilizará el comparador por Palo por defecto.");
            comparador = comparadorPorPalo;
        }

        Carta[] array = baraja.getCartas();
        int n = array.length;
        for (int i = 0; i < n - 1; i++) { // i es el número de pasadas completas
            for (int j = 0; j < n - 1; j++) { // j es el índice para comparar elementos adyacentes
                if (comparador.compare(array[j], array[j + 1]) > 0) {
                    // Intercambio de elementos
                    Carta temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        
        //
        Carta carta;
        do {
            carta = baraja.sacar();
            carta.voltear();
            carta.mostrar();
        } while (!baraja.vacia());
    }
}
