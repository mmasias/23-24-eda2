public class Ordenar {

    public static void ordenarPorPalo(Carta[] cartas) {
        int n = cartas.length;
        boolean swapped;
        
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                if (compare(cartas[i], cartas[i + 1]) > 0) {
                    Carta temp = cartas[i];
                    cartas[i] = cartas[i + 1];
                    cartas[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    private static int compare(Carta c1, Carta c2) {
        if (c1.getPalo() != c2.getPalo()) {
            return c1.getPalo() - c2.getPalo();
        } 
        return c1.getNumero() - c2.getNumero();
    }

    public static void ordenarPorNumero(Carta[] cartas) {
        int n = cartas.length;
        boolean swapped;
        
        do {
            swapped = false;
            for (int i = 0; i < n - 1; i++) {
                int numero1 = cartas[i].getNumero();
                int numero2 = cartas[i + 1].getNumero();
    
                if (numero1 > numero2) {
                    Carta temp = cartas[i];
                    cartas[i] = cartas[i + 1];
                    cartas[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }
    
}
