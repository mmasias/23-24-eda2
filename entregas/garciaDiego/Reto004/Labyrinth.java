import java.util.Scanner;

public class Labyrinth {

    private static final int FREE = 0;
    private static final int PATH = 2;
    private static final int VISITED = 3;

    private static String[] celda = { " · ", "[ ]", " * ", " x " };

    public static boolean solveMaze(int[][] maze, int x, int y, Scanner s) {
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length) {
            System.out.println("Intentando mover a (" + x + ", " + y + "): Fuera de los límites del laberinto.");
            return false;
        }
        if (maze[x][y] != FREE) {
            System.out.println("Intentando mover a (" + x + ", " + y + "): Celda bloqueada o ya visitada.");
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

        System.out.println("Pulse una tecla para continuar...");
        s.nextLine();

        if (solveMaze(maze, x + 1, y, s) || solveMaze(maze, x, y + 1, s) ||
                solveMaze(maze, x - 1, y, s) || solveMaze(maze, x, y - 1, s)) {
            return true;
        }

        maze[x][y] = VISITED;
        System.out.println("Moviendo a (" + x + ", " + y + "): Marcando como visitado y retrocediendo.");
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
    }

    public static void main(String[] args) {
        int[][] maze = {
                { 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0 },
                { 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0 },
                { 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0 },
                { 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0 },
                { 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0 },
                { 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0 },
                { 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0 },
                { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0 }
        };

        System.out.println("Laberinto:");
        printMaze(maze);

        System.out.println("Pulse una tecla para intentar resolver el laberinto...");
        Scanner s = new Scanner(System.in);
        s.nextLine();

        if (solveMaze(maze, 0, 0, s)) {
            System.out.println("Ruta de escape:");
            printMaze(maze);
        } else {
            System.out.println("No se puede escapar!!!.");
        }

        s.close();
    }
}