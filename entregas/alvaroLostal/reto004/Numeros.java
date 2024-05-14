package entregas.alvaroLostal.reto004;

import java.util.Scanner;

public class Numeros {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Ingresa un número:");
        int x = s.nextInt();
        System.out.println("Números del 1 al " + x + ":");
        imprimirNumeros(x);
        System.out.println("Números del " + x + " al 1 al revés:");
        imprimirNumeros2(x);
        System.out.println("Suma de números del 1 al " + x + ":");
        System.out.println("La suma es: " + sumarNum(x));
        s.close();
    }

    public static void imprimirNumeros(int x) {
        System.out.println("Llamada a imprimirNumeros con x = " + x);
        if (x > 0) {
            imprimirNumeros(x - 1);
            System.out.println(x);
        }
    }

    public static void imprimirNumeros2(int x) {
        System.out.println("Llamada a imprimirNumeros2 con x = " + x);
        if (x > 0) {
            System.out.println(x);
            imprimirNumeros2(x - 1);
        }
    }

    public static int sumarNum(int x) {
        System.out.println("Llamada a sumarNum con x = " + x);
        if (x > 0) {
            return x + sumarNum(x - 1);
        } else {
            return 0;
        }
    }
}

