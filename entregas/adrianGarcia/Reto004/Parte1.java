import java.util.Scanner;

public class Parte1 {
    public static void main(String[] args) {
        // Crea un objeto Scanner para leer desde la entrada estándar
        Scanner s = new Scanner(System.in);

        // Solicita al usuario que ingrese un número
        System.out.println("Ingrese un número:");
        int x = s.nextInt();

        // Imprime los números desde 1 hasta x
        System.out.println("Números del 1 al " + x + ":");
        imprimirNumeros(x, 0);

        // Imprime los números desde x hasta 1
        System.out.println("Números del 1 al " + x + " al revés:");
        imprimirNumeros2(x, 0);

        // Calcula y muestra la suma de los números desde 1 hasta x
        System.out.println("Suma de los números del 1 al " + x + ":");
        System.out.println(sumarNumeros(x, 0));

        // Cierra el objeto Scanner
        s.close();
    }

    // Método recursivo para imprimir números de 1 a x con trazabilidad
    public static void imprimirNumeros(int x, int level) {
        if (x > 0) {
            imprimirNumeros(x - 1, level + 1); // Llamada recursiva para avanzar hacia el caso base
            System.out.println("Level " + level + ": " + x); // Imprime el número después de la recursión
        }
    }

    // Método recursivo para imprimir números de x a 1 con trazabilidad
    public static void imprimirNumeros2(int x, int level) {
        if (x > 0) {
            System.out.println("Level " + level + ": " + x); // Imprime el número antes de la recursión
            imprimirNumeros2(x - 1, level + 1); // Llamada recursiva para avanzar hacia el caso base
        }
    }

    // Método recursivo para sumar números de 1 a x con trazabilidad
    public static int sumarNumeros(int x, int level) {
        System.out.println("Sumar Level " + level + ": llamada con x = " + x); // Trazabilidad de la llamada
        if (x > 0) {
            int result = x + sumarNumeros(x - 1, level + 1); // Llamada recursiva y suma el resultado
            System.out.println("Sumar Level " + level + ": retorno de " + result); // Trazabilidad del retorno
            return result;
        } else {
            return 0; // Caso base: retorna 0
        }
    }
}
