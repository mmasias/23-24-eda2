public class NumerosImpresos {
    public static void main(String[] args) {
        System.out.println("Imprimiendo números en orden ascendente:");
        imprimirAscendente(0, 10);
        System.out.println("\nImprimiendo números en orden descendente:");
        imprimirDescendente(0, 10);
    }
    
    static void imprimirAscendente(int inicio, int numero) {
        if (inicio <= numero) {
            System.out.println("Número ascendente: " + inicio);
            imprimirAscendente(inicio + 1, numero);
        }
    }

    static void imprimirDescendente(int inicio, int numero) {
        if (inicio <= numero) {
            int numDescendente = numero - inicio + 1;
            System.out.println("Número descendente: " + numDescendente);
            imprimirDescendente(inicio + 1, numero);
        }
    }
}
