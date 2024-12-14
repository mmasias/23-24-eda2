public class ImprimirNumeros {

    public static void main(String[] args) {
        imprimirNumeroAscendente(0, 10);
        imprimirNumeroDescendente(0, 10);
    }
    
    static void imprimirNumeroAscendente(int inicio, int numero) {
        if (inicio <= numero) {
            System.out.println("Ascendente: " + inicio + " (numero inicial: " + inicio + ", objetivo: " + numero + ")");
            imprimirNumeroAscendente(inicio + 1, numero);
        }
    }

    static void imprimirNumeroDescendente(int inicio, int numero) {
        if (inicio <= numero) {
            int numeroActual = numero - inicio;
            System.out.println("Descendente: " + numeroActual + " (numero inicial: " + inicio + ", objetivo: " + numero + ")");
            imprimirNumeroDescendente(inicio + 1, numero);
        }
    }
}
