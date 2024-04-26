package entregas.garciaLydia.reto004.parte1;

import java.util.Scanner;

public class ejercicio {
    public static void printNumbers(int x) {
        if (x > 0) {
            printNumbers(x - 1);
            System.out.println(x);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número: ");
        int x = scanner.nextInt();

        printNumbers(x);
    }
}
