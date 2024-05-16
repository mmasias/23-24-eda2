import java.util.Scanner;

class RetoEDA {

    private static class OrdenadorCartas {
        public static void sort(Carta[] cartas, boolean ordenarPorPalo) {
            boolean swapped;
            int passIndex = 0;
            do {
                swapped = false;
                for (int j = 0; j < cartas.length - 1 - passIndex; j++) {
                    if (ordenarPorPalo) {
                        if (compararPorPalo(cartas[j], cartas[j + 1]) > 0) {
                            intercambiar(cartas, j, j + 1);
                            swapped = true;
                        }
                    } else {
                        if (compararPorNumero(cartas[j], cartas[j + 1]) > 0) {
                            intercambiar(cartas, j, j + 1);
                            swapped = true;
                        }
                    }
                }
                passIndex++;
            } while (swapped);
        }

        private static int compararPorPalo(Carta carta1, Carta carta2) {
            if (carta1.getPalo() == carta2.getPalo()) {
                return carta1.getNumero() - carta2.getNumero();
            } else {
                return carta1.getPalo() - carta2.getPalo();
            }
        }

        private static int compararPorNumero(Carta carta1, Carta carta2) {
            if (carta1.getNumero() == carta2.getNumero()) {
                return carta1.getPalo() - carta2.getPalo();
            } else {
                return carta1.getNumero() - carta2.getNumero();
            }
        }

        private static void intercambiar(Carta[] cartas, int i, int j) {
            Carta temp = cartas[i];
            cartas[i] = cartas[j];
            cartas[j] = temp;
        }
    }

    public static void main(String[] args) {

        Baraja baraja = new Baraja();

        Scanner scanner = new Scanner(System.in);
        System.out.println("¿Cómo deseas ordenar las cartas?");
        System.out.println("1. Por palo");
        System.out.println("2. Por número");
        int opcion = scanner.nextInt();

        boolean ordenarPorPalo = opcion == 1;

        Carta[] cartas = new Carta[Baraja.TOTAL_CARTAS];
        for (int i = 0; i < Baraja.TOTAL_CARTAS; i++) {
            cartas[i] = baraja.sacar();
        }

        OrdenadorCartas.sort(cartas, ordenarPorPalo);

        for (Carta carta : cartas) {
            carta.voltear();
            carta.mostrar();
        }
    }
}