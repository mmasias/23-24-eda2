package Parte1;
public class Programa {

    public static void main(String[] args) {
        System.out.println("Inicio de imprimirNumero desde 1 hasta 20");
        imprimirNumero(1, 20);
        System.out.println("Fin de imprimirNumero desde 1 hasta 20");

        System.out.println("Inicio de ordenDescendente desde 1 hasta 20");
        ordenDescendente(1, 20);
        System.out.println("Fin de ordenDescendente desde 1 hasta 20");
    }

    static void imprimirNumero(int inicio, int numero) {
        if (inicio <= numero) {
            System.out.println("imprimirNumero - Inicio: " + inicio + ", Numero: " + numero);
            System.out.println(inicio);
            imprimirNumero(inicio + 1, numero);
        }
    }

    static void ordenDescendente(int inicio, int numero) {
        if (inicio <= numero) {
            System.out.println("ordenDescendente - Inicio: " + inicio + ", Numero: " + numero);
            System.out.println(numero - inicio + 1);
            ordenDescendente(inicio + 1, numero);
        }
    }
}
