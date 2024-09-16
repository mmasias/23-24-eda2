import java.util.Scanner;

public class Labyrinth {

    private static final int FREE = 0;
    private static final int WALL = 1;
    private static final int PATH = 2;
    private static final int VISITED = 3;

    private static String[] celda = {" · ", "[ ]", " * ", " x "};

    public static boolean solveMaze(int[][] maze, int x, int y) {
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length) {
            System.out.println("Moviendo a (" + x + ", " + y + "): Fuera de los límites del laberinto.");
            return false;
        }
        if (maze[x][y] != FREE) {
            System.out.println("Moviendo a (" + x + ", " + y + "): Celda bloqueada o ya visitada.");
            return false;
        }
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            maze[x][y] = PATH;
            System.out.println("Moviendo a (" + x + ", " + y + "): Marcando como parte del camino.");
            printMaze(maze);
            return true;
        }
        maze[x][y] = PATH;
        System.out.println("Moviendo a (" + x + ", " + y + "): Marcando como parte del camino.");
        printMaze(maze);

        if (solveMaze(maze, x + 1, y) || solveMaze(maze, x, y + 1) ||
            solveMaze(maze, x - 1, y) || solveMaze(maze, x, y - 1)) {
            return true;
        }

        maze[x][y] = VISITED;
        System.out.println("Moviendo a (" + x + ", " + y + "): Sin salida, marcando como visitado.");
        printMaze(maze);
        return false;
    }

    public static void printMaze(int[][] maze) {
        System.out.println("Estado actual del laberinto:");
        System.out.println("========================================================================");
        for (int[] row : maze) {
            for (int col : row) {
                System.out.print(celda[col]);
            }
            System.out.println();
        }
        System.out.println("========================================================================");
        System.out.println("Pulse una tecla para continuar...");
        new Scanner(System.in).nextLine();
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

        System.out.println("Laberinto inicial:");
        printMaze(maze);

        if (solveMaze(maze, 0, 0)) {
            System.out.println("Ruta de escape encontrada:");
            printMaze(maze);
        } else {
            System.out.println("No se puede escapar del laberinto.");
        }
    }
}
