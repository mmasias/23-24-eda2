
class OrdenCartas {

    public static void sort(Carta[] cartas, boolean ordenarPorPalo) {
        boolean swapped;
        int passIndex = 0;
        do {
            swapped = false;
            for (int j = 0; j < cartas.length - 1 - passIndex; j++) {
                if (ordenarPorPalo) {
                    if (compararPorPalo(cartas[j], cartas[j + 1]) > 0) {
                        cambiar(cartas, j, j + 1);
                        swapped = true;
                    }
                } else {
                    if (compararNumero(cartas[j], cartas[j + 1]) > 0) {
                        cambiar(cartas, j, j + 1);
                        swapped = true;
                    }
                }
            }
            passIndex++;
        } while (swapped);
    }

    private static int compararPorPalo(Carta carta1, Carta carta2) {
        if (carta1.devolverPalo() == carta2.devolverPalo()) {
            return carta1.devolverNumero() - carta2.devolverNumero();
        } else {
            return carta1.devolverPalo() - carta2.devolverPalo();
        }
    }

    private static int compararNumero(Carta carta1, Carta carta2) {
        if (carta1.devolverNumero() == carta2.devolverNumero()) {
            return carta1.devolverPalo() - carta2.devolverPalo();
        } else {
            return carta1.devolverNumero() - carta2.devolverNumero();
        }
    }

    private static void cambiar(Carta[] cartas, int i, int j) {
        Carta temp = cartas[i];
        cartas[i] = cartas[j];
        cartas[j] = temp;
    }
}