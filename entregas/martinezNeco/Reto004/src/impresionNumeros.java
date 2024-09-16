package src;


public class impresionNumeros {

    public static void main(String[] args) {
        mostrarNumerosCrecientes(0, 10);
        mostrarNumerosDecrecientes(0, 10);
    }

    static void mostrarNumerosCrecientes(int comienzo, int limite) {
        if (comienzo <= limite) {
            System.out.println("Creciente: " + comienzo + " (comienzo: " + comienzo + ", limite: " + limite + ")");
            mostrarNumerosCrecientes(comienzo + 1, limite);
        }
    }

    static void mostrarNumerosDecrecientes(int comienzo, int limite) {
        if (comienzo <= limite) {
            int valorActual = limite - comienzo;
            System.out.println("Decreciente: " + valorActual + " (comienzo: " + comienzo + ", limite: " + limite + ")");
            mostrarNumerosDecrecientes(comienzo + 1, limite);
        }
    }
}
