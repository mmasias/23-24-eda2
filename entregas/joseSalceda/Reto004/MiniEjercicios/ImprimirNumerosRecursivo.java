package entregas.joseSalceda.Reto004.MiniEjercicios;

import java.util.Scanner;

public class ImprimirNumerosRecursivo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número hasta el cual desea imprimir: ");
        int x = scanner.nextInt();

        System.out.println("Imprimiendo números del 1 al " + x + " utilizando recursividad:");
        imprimirNumeros(1, x);
    }

    public static void imprimirNumeros(int actual, int x) {
        if (actual <= x) {
            System.out.println("Imprimiendo número: " + actual);
            imprimirNumeros(actual + 1, x);
        } else {
            System.out.println("Se alcanzó el número límite " + x + ". Terminando recursividad.");
        }
    }
}