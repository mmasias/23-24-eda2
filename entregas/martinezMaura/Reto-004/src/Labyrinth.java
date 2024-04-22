import java.util.Scanner;

public class Labyrinth {

    private static final int FREE = 0;
    private static final int WALL = 1;
    private static final int PATH = 2;
    private static final int VISITED = 3;

    private static String[] celda = { " · ", "[ ]", " * ", " x " };

    public static boolean solveMaze(int[][] maze, int x, int y) {
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length) {
            System.out.println("Fuera de los límites: (" + x + ", " + y + ")");
            return false;
        }
        if (maze[x][y] != FREE && maze[x][y] != PATH) {
            System.out.println("Intentando mover a (" + x + ", " + y + "): Celda bloqueada o ya visitada.");
            return false;
        }
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            System.out.println("¡Salida encontrada en: (" + x + ", " + y + ")!");
            maze[x][y] = PATH;
            printMaze(maze);
            return true;
        }
        System.out.println("Moviendo a (" + x + ", " + y + "): Marcando como parte del camino.");
        maze[x][y] = PATH;
        printMaze(maze);

        if (solveMaze(maze, x + 1, y) || solveMaze(maze, x, y + 1) ||
                solveMaze(maze, x - 1, y) || solveMaze(maze, x, y - 1)) {
            return true;
        }

        System.out.println("No se puede avanzar desde: (" + x + ", " + y + ")");
        maze[x][y] = VISITED;
        printMaze(maze);
        return false;
    }

    public static void printMaze(int[][] maze) {
        System.out.println("Laberinto:");
        for (int[] row : maze) {
            for (int col : row) {
                System.out.print(celda[col]);
            }
            System.out.println();
        }
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

        System.out.println("Laberinto inicial:");
        printMaze(maze);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Pulse Enter para intentar resolver el laberinto...");
        scanner.nextLine();

        System.out.println("Resolviendo laberinto...");
        if (solveMaze(maze, 0, 0)) {
            System.out.println("Ruta de escape encontrada:");
        } else {
            System.out.println("No se puede escapar...");
        }

        scanner.close();
    }
}
