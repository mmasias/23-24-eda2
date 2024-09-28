package entregas.alvaroLostal.reto004;

import java.util.Scanner;

public class Laberinto {

    private static final int FREE = 0;
    private static final int WALL = 1;
    private static final int PATH = 2;
    private static final int VISITED = 3;

    private static String[] cell = {" · ", "[ ]", " * ", " x "};

    public static boolean solveMaze(int[][] maze, int x, int y) {
        System.out.println("Explorando celda: (" + x + ", " + y + ")");
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length) {
            System.out.println("Celda fuera del laberinto.");
            return false;
        }
        if (maze[x][y] != FREE) {
            System.out.println("Celda bloqueada o visitada.");
            return false;
        }
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            System.out.println("¡Salida encontrada en la celda: (" + x + ", " + y + ")!");
            maze[x][y] = PATH;
            return true;
        }
        maze[x][y] = PATH;
        printMaze(maze);

        if (solveMaze(maze, x + 1, y) || solveMaze(maze, x, y + 1) ||
            solveMaze(maze, x - 1, y) || solveMaze(maze, x, y - 1)) {
            return true;
        }

        maze[x][y] = VISITED;
        System.out.println("Celda sin salida: (" + x + ", " + y + ")");
        return false;
    }

    public static void printMaze(int[][] maze) {
        System.out.println("===".repeat(maze[0].length));
        for (int[] row : maze) {
            for (int col : row) {
                System.out.print(cell[col]);
            }
            System.out.println();
        }
        System.out.println("===".repeat(maze[0].length));
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
        
        System.out.println("Pulse una tecla para intentar resolver el laberinto...");
        new Scanner(System.in).nextLine();

        if (solveMaze(maze, 0, 0)) {
            System.out.println("Ruta de escape:");
            printMaze(maze);
        } else {
            System.out.println("No se puede escapar del laberinto.");
        }
    }
}

