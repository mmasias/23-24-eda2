import java.util.Comparator;
import java.util.Scanner;

class RetoEDA {

    private Baraja baraja;

    public static void main(String[] args) {

        Baraja baraja = new Baraja();

        //
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Menú de Opciones ---");
        System.out.println("1. Ordenar por número (Comparador 1)");
        System.out.println("2. Ordenar por palo (Comparador 2)");
        System.out.println("Por favor, ingresa el número correspondiente a la opción que deseas elegir:");

        int opcion = scanner.nextInt();
        Comparator<Carta> comparador;

        if (opcion == 1) {
            comparador = new Comparator<Carta>() {
                @Override
                public int compare(Carta carta1, Carta carta2) {
                    if (carta1.igualPalo(carta2)) {
                        return Integer.compare(carta2.getNumero(), carta1.getNumero());
                    } else {
                        return Integer.compare(carta2.getPalo(), carta1.getPalo());
                    }
                }
            };
        } else if (opcion == 2) {
            comparador = new Comparator<Carta>() {
                @Override
                public int compare(Carta carta1, Carta carta2) {
                    if (carta1.getNumero() == carta2.getNumero()) {
                        return Integer.compare(carta2.getPalo(), carta1.getPalo());
                    } else {
                        return Integer.compare(carta2.getNumero(), carta1.getNumero());
                    }
                }
            };
        } else {
            System.out.println("Opción inválida. Saliendo del programa.");
            return;
        }

        Carta[] array = baraja.getCartas();
        int n = array.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (comparador.compare(array[j], array[j + 1]) > 0) {
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
