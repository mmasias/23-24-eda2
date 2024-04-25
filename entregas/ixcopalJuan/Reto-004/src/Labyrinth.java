import java.util.Scanner;

public class Labyrinth {

    private static final int FREE = 0;
    private static final int WALL = 1;
    private static final int PATH = 2;
    private static final int VISITED = 3;

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_BLACK = "\u001B[30m";
    private static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
    private static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    private static final String ANSI_RED_BACKGROUND = "\u001B[41m";

    private static String[] celda = {
            ANSI_BLACK + " · " + ANSI_RESET,  // FREE
            ANSI_WHITE_BACKGROUND + "[ ]" + ANSI_RESET, // WALL
            ANSI_YELLOW_BACKGROUND + " * " + ANSI_RESET, // PATH
            ANSI_RED_BACKGROUND + " x " + ANSI_RESET // VISITED
    };

    //private static String[] celda = {" · ", "[ ]", " * ", " x "};

    public static boolean solveMaze(int[][] maze, int x, int y) {
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length) {
            System.out.println("Intentando mover a (" + y + ", " + x + "): Fuera de los límites del laberinto.");
            return false;
        }
        if (maze[x][y] != FREE) {
            System.out.println("Intentando mover a (" + y + ", " + x + "): Celda bloqueada o ya visitada.");
            return false;
        }
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            maze[x][y] = PATH;
            return true;
        }

        System.out.println("Moviendo a (" + y + ", " + x + "): Marcando como parte del camino.");
        maze[x][y] = PATH;
        printMaze(maze);

        if (solveMaze(maze, x + 1, y)) {
            return true;
        }
        if (solveMaze(maze, x, y + 1)) {
            return true;
        }
        if (solveMaze(maze, x - 1, y)) {
            return true;
        }
        if (solveMaze(maze, x, y - 1)) {
            return true;
        }

        maze[x][y] = VISITED;
        System.out.println("Moviendo a (" + y + ", " + x + "): Marcando como visitado y retrocediendo.");
        printMaze(maze);
        return false;
    }

    public static void printMaze(int[][] maze) {
        System.out.println("===".repeat(maze[0].length));
        for (int[] row : maze) {
            for (int col : row) {
                System.out.print(celda[col]);
            }
            System.out.println();
        }
        System.out.println("===".repeat(maze[0].length));
        System.out.println("Pulse una tecla para continuar...");
        new Scanner(System.in).nextLine();
    }

    public static void main(String[] args) {
        int[][] maze = {
                {0,1,0,0,1,0,0,1,0,0,1,0,0,0,0,1,0,0,1,0,0,1,0,0},
                {0,1,0,1,1,0,1,1,0,1,1,0,1,0,1,1,0,1,1,0,1,1,0,0},
                {0,0,0,1,0,0,1,0,0,1,0,0,1,0,0,0,0,0,1,0,0,1,0,0},
                {1,1,0,1,0,0,0,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0},
                {0,1,0,1,1,0,1,1,0,1,1,0,1,0,0,1,0,0,1,0,0,1,0,0},
                {0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,1,0,0,1,0,0,1,0,0},
                {1,1,0,1,0,0,1,1,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0},
                {0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,0,1,1,0,0,1,0,0,0,0,1,0,0,1,0,0,1,0,0},
                {0,1,0,1,1,0,1,1,0,1,1,0,1,0,1,1,0,1,1,0,1,1,0,0},
                {0,0,0,1,0,0,1,0,0,1,0,0,1,0,0,0,0,0,1,0,0,1,0,0},
                {1,1,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0},
                {0,1,0,1,1,0,1,1,0,1,1,0,1,0,0,1,0,0,1,0,0,1,0,0},
                {0,0,0,1,0,0,1,0,0,0,0,0,1,0,0,1,0,0,1,0,0,1,0,0},
                {1,1,0,1,0,0,1,1,0,1,0,0,1,0,0,1,0,0,1,0,0,1,0,0},
                {0,0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0}
        };

        System.out.println("Laberinto:");
        printMaze(maze);


        if (solveMaze(maze, 0, 0)) {
            System.out.println("Ruta de escape:");
            printMaze(maze);
        } else {
            System.out.println("No se puede escapar!!!.");
        }
    }
}
