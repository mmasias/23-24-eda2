import java.util.Scanner;

public class Parte1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("ingrese un numero");
        int x = s.nextInt();
        System.out.println("numeros del 1 al " + x);
        imprimirNumeros(1, x);
        System.out.println("numeros del 1 al " + x + " al reves");
        imprimirNumeros2(x);
        System.out.println("suma de los numeros del 1 al " + x);
        System.out.println(sumarNumeros(x));
    }

    public static void imprimirNumeros(int inicio, int x) {
        System.out.println("Llamada a imprimirNumeros con inicio = " + inicio + " y x = " + x + " (mientras inicio sea menor o igual a x)");
        if (inicio <= x) {
            System.out.println(inicio); 
            imprimirNumeros(inicio + 1, x);
        }
    }

    public static void imprimirNumeros2(int x) {
        System.out.println("Llamada a imprimirNumeros2 con x = " + x + " (mientras sea mayor a 0)");
        if (x > 0) {
            System.out.println(x);
            imprimirNumeros2(x - 1);
        }
    }

    public static int sumarNumeros(int x) {
        System.out.println("Llamada a sumarNum con x = " + x + " (mientras sea mayor a 0)");
        if (x > 0) {
            return x + sumarNumeros(x - 1);
        } else {
            return 0;
        }
    }
}