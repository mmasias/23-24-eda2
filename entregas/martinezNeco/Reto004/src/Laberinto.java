package src;

import java.util.Scanner;

public class Laberinto {

    private static final int LIBRE = 0;
    private static final int MURO = 1;
    private static final int CAMINO = 2;
    private static final int VISITADO = 3;

    private static String[] simbolos = {" · ", "[ ]", " * ", " x "};

    public static boolean explorarLaberinto(int[][] laberinto, int x, int y) {
        if (x < 0 || x >= laberinto.length || y < 0 || y >= laberinto[0].length) {
            System.out.println("Intento de moverse a: (" + x + ", " + y + ") - Fuera de límites.");
            return false;
        }
        if (laberinto[x][y] != LIBRE) {
            System.out.println("Intento de moverse a: (" + x + ", " + y + ") - Bloqueado.");
            return false;
        }
        if (x == laberinto.length - 1 && y == laberinto[0].length - 1) {
            System.out.println("Movimiento a: (" + x + ", " + y + ") - Salida encontrada.");
            laberinto[x][y] = CAMINO;
            return true;
        }
        laberinto[x][y] = CAMINO;
        System.out.println("Movimiento a: (" + x + ", " + y + "): Marcando camino.");
        mostrarLaberinto(laberinto);

        if (explorarLaberinto(laberinto, x + 1, y)) {
            return true;
        }
        if (explorarLaberinto(laberinto, x, y + 1)) {
            return true;
        }
        if (explorarLaberinto(laberinto, x - 1, y)) {
            return true;
        }
        if (explorarLaberinto(laberinto, x, y - 1)) {
            return true;
        }

        laberinto[x][y] = VISITADO;
        System.out.println("Movimiento a: (" + y + ", " + x + "): Marcado como visitado y modificado.");
        mostrarLaberinto(laberinto);
        return false;
    }

    public static void mostrarLaberinto(int[][] laberinto) {
        for (int[] fila : laberinto) {
            for (int celda : fila) {
                System.out.print(simbolos[celda]);
            }
            System.out.println();
        }
        System.out.println("Presione enter para continuar...");
        new Scanner(System.in).nextLine();
    }

    public static void main(String[] args) {
        int[][] laberinto = {
                {0,1,0,0,1,0,0,1,0,0,1,0,0,0},
                {0,1,0,1,1,0,1,1,0,1,1,0,1,0},
                {0,0,0,1,0,0,1,0,0,1,0,0,1,0},
                {1,1,0,1,0,0,0,0,0,1,0,0,1,0},
                {0,1,0,1,1,0,1,1,0,1,1,0,1,0},
                {0,0,0,1,0,0,1,0,0,0,0,0,1,0},
                {1,1,0,1,0,0,1,1,0,1,0,0,1,0},
                {0,0,0,0,0,1,0,0,0,0,0,1,0,0}
        };

        System.out.println("Laberinto inicial:");
        mostrarLaberinto(laberinto);

        if (explorarLaberinto(laberinto, 0, 0)) {
            System.out.println("Ruta de escape encontrada:");
            mostrarLaberinto(laberinto);
        } else {
            System.out.println("Escape imposible.");
        }
    }
}
