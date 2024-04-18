package Reto004;

import java.util.Scanner;

public class Trabazilidad {

    // Método recursivo para imprimir números desde 1 hasta x
    public static void printOnes(int x) {
        // Registro de llamada a la función
        System.out.println("printOnes(" + x + ")");
        
        if (x >= 1) {
            // Llamada recursiva con x-1
            printOnes(x - 1);
            // Imprimir el número actual
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Registro de entrada de datos
        System.out.print("Ingresa el número máximo: ");
        
        // Leer el número máximo
        int x = scanner.nextInt();
        
        // Cerrar el scanner
        scanner.close();
        
        // Llamada a la función principal
        printOnes(x);
    }
}

