import java.util.Scanner;

public class Parte1 {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Ingrese un número:");
        int x = s.nextInt();
        s.close();

        System.out.println("Numeros del 1 al " + x + ":");
        imprimirNumeros(x);

        System.out.println("Numeros del " + x + " al 1 al reves:");
        imprimirNumeros2(x);

        System.out.println("Suma de los numeros del 1 al " + x + ":");
        int suma = sumarNumeros(x);
        System.out.println(suma);
    }

    public static void imprimirNumeros(int x) {
        if (x > 0) {
            System.out.println("Imprimiendo " + x);
            imprimirNumeros(x - 1);
        }
    }

    public static void imprimirNumeros2(int x) {
        if (x > 0) {
            imprimirNumeros2(x - 1);
            System.out.println("Imprimiendo " + x);
        }
    }

    public static int sumarNumeros(int x) {
        if (x > 0) {
            int sumaParcial = x + sumarNumeros(x - 1);
            System.out.println("Sumando " + x + ", Suma parcial: " + sumaParcial);
            return sumaParcial;
        } else {
            return 0;
        }
    }
}