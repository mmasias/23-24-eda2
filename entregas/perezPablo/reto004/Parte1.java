package reto004;

public class Parte1 {

    public static void main(String[] args) {
        int x = 1;
        int y = 20;
        System.out.println("Comienza a escribir desde x = " + x + " hasta y = " + y);

        imprimirNumero(x,y);
        System.out.println("Comienza a escribir desde y = " + y + " hasta x = " + x);

        ordenDescendente(x,y);
        
    }
     
    static void imprimirNumero(int inicio, int numero) {
        if (inicio <= numero) {
            System.out.println(inicio + " y al número " + inicio + " le sumo 1" );
            imprimirNumero(inicio + 1, numero);
        }
    }

    static void ordenDescendente(int inicio, int numero) {
        if (inicio <= numero) {
            int var = numero - inicio + 1;
            System.out.println(var + " y al número " + var + " le resto 1");
            ordenDescendente(inicio + 1, numero);
        }
    }
}