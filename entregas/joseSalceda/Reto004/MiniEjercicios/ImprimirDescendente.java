package entregas.joseSalceda.Reto004.MiniEjercicios;

import java.util.Scanner;

public class ImprimirDescendente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número inicial (x): ");
        int x = scanner.nextInt();

        System.out.print("Ingrese el número final (y): ");
        int y = scanner.nextInt();

        System.out.println("Imprimiendo números del " + x + " al " + y + " en orden descendente utilizando recursividad:");
        imprimirNumerosDescendente(x, y);
    }

    public static void imprimirNumerosDescendente(int actual, int y) {
        if (actual >= y) {
            System.out.println("Imprimiendo número: " + actual);
            imprimirNumerosDescendente(actual - 1, y);
        } else {
            System.out.println("Se alcanzó el número límite " + y + ". Terminando recursividad.");
        }
    }
}