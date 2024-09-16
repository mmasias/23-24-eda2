import java.util.Scanner;

public class Ejercicios {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("ingrese un numero");
        int x = s.nextInt();
        System.out.println("=".repeat(60));
        System.out.println("numeros del 1 al " + x);
        System.out.println("-".repeat(60));
        imprimirNumeros(x);
        System.out.println("=".repeat(60));

        System.out.println("numeros del 1 al " + x + " al reves");
        System.out.println("-".repeat(60));
        imprimirNumeros2(x);
        System.out.println("=".repeat(60));

        System.out.println("suma de los numeros del 1 al " + x);
        System.out.println("-".repeat(60));
        System.out.println("El resultado final de la suma es: " + sumarNumeros(x));
        s.close();
    }

    public static void imprimirNumeros(int x) {
        System.out.println("Entra con x = " + x);
        if (x > 0) {
            System.out.println("llamada recursiva con x - 1 = " + (x - 1));
            imprimirNumeros(x - 1);
            System.out.println("Salida con x = " + x);
        }
        
    }
    

    public static void imprimirNumeros2(int x) {
        System.out.println("Entra con x = " + x);
        if (x > 0) {
            System.out.println("Imprime el valor de x: " + x);
            System.out.println("Calcula x - 1 = " + (x - 1));
            imprimirNumeros2(x - 1);

        }

    }

    public static int sumarNumeros(int x) {

        if (x > 0) {
            int resultado = x + sumarNumeros(x - 1);
            System.out.println("El resultado para x = " + x + " es " + resultado);
            return resultado;
        } else {
            System.out.println("La suma para x = 0 es 0");
            return 0;
        }
    }

}
