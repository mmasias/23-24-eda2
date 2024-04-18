package Reto004;

import java.util.Scanner;

public class Labyrinth {

    private static final int FREE = 0;
    private static final int WALL = 1;
    private static final int PATH = 2;
    private static final int VISITED = 3;

    private static String[] celda = {" · ", "[ ]", " * ", " x "};

    public static boolean solveMaze(int[][] maze, int x, int y) {
        // Registro de intento de movimiento con coordenadas actuales
        System.out.println("Intentando moverse a la posición (" + x + ", " + y + ")");
        
        // Verificar si las coordenadas están dentro del laberinto
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length) {
            return false;
        }
        // Verificar si la celda actual es un obstáculo
        if (maze[x][y] != FREE) {
            return false;
        }
        // Verificar si se ha llegado a la salida del laberinto
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            maze[x][y] = PATH;
            return true;
        }
        
        // Marcar la celda actual como parte del camino
        maze[x][y] = PATH;

        // Intentar moverse en todas las direcciones posibles recursivamente
        if (solveMaze(maze, x + 1, y) || solveMaze(maze, x, y + 1) ||
            solveMaze(maze, x - 1, y) || solveMaze(maze, x, y - 1)) {
            return true;
        }

        // Si ninguna dirección lleva a la salida, marcar la celda como visitada
        maze[x][y] = VISITED; 
        return false;
    }

    public static void printMaze(int[][] maze) {
        for (int[] row : maze) {
            for (int col : row) {
                System.out.print(celda[col]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] maze = {
            {0,1,0,0,1,0,0,1,0,0,1,0,0,0},
            {0,1,0,1,1,0,1,1,0,1,1,0,1,0},
            {0,0,0,1,0,0,1,0,0,1,0,0,1,0},
            {1,1,0,1,0,0,0,0,0,1,0,0,1,0},
            {0,1,0,1,1,0,1,1,0,1,1,0,1,0},
            {0,0,0,1,0,0,1,0,0,0,0,0,1,0},
            {1,1,0,1,0,0,1,1,0,1,0,0,1,0},
            {0,0,0,0,0,1,0,0,0,0,0,1,0,0}
        };

        System.out.println("Laberinto:");
        printMaze(maze);
        
        // Esperar a que el usuario presione una tecla antes de intentar resolver el laberinto
        System.out.println("Pulse una tecla para intentar resolver el laberinto...");
        new Scanner(System.in).nextLine();

        // Intentar resolver el laberinto desde la posición inicial (0, 0)
        if (solveMaze(maze, 0, 0)) {
            System.out.println("Ruta de escape:");
            printMaze(maze);
        } else {
            System.out.println("No se puede escapar!!!.");
        }
    }
}
