import java.util.Scanner;

public class Labyrinth {

    private static final int FREE = 0;
    private static final int WALL = 1;
    private static final int PATH = 2;
    private static final int VISITED = 3;

    private static String[] celda = {" · ", "[ ]", " * ", " x "};

    public static boolean solveMaze(int[][] maze, int x, int y) {
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length) {
            return false; // Fuera de límites
        }
        if (maze[x][y] == WALL || maze[x][y] == VISITED) {
            System.out.println("Intentando mover a (" + x + ", " + y + "): Celda bloqueada o ya visitada.");
            return false; // Pared o bloqueo
        }
        if (maze[x][y] != FREE) {
            return false; // Celda y/o parte del camino
        }
        if (x == maze.length - 1 && y == maze[0].length - 1) { // Llegada a la meta
            maze[x][y] = PATH;
            printMaze(maze); // Imprimir el mapa
            return true;
        }

        // Marcar el camino
        System.out.println("Moviendo a (" + x + ", " + y + "): Marcando como parte del camino.");
        maze[x][y] = PATH;
        printMaze(maze); // Imprimir el mapa

        System.out.println("Pulse Enter para continuar...");
        new Scanner(System.in).nextLine();

        // Exploración recursiva
        if (solveMaze(maze, x + 1, y) || solveMaze(maze, x, y + 1) ||
            solveMaze(maze, x - 1, y) || solveMaze(maze, x, y - 1)) {
            return true;
        }

        // Retroceso
        maze[x][y] = VISITED;
        System.out.println("Moviendo a (" + x + ", " + y + "): Marcando como visitado y retrocediendo.");
        printMaze(maze); // Imprimir el mapa
        System.out.println("Pulse Enter para continuar...");
        new Scanner(System.in).nextLine();

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
            {0,1,0,0,1,0,0,1,0,0,0,0,0,0},
            {0,1,0,1,1,0,1,1,0,1,1,1,1,0},
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
            System.out.println("Ruta de escape encontrada:");
            printMaze(maze);
        } else {
            System.out.println("No se puede escapar!!!");
        }
    }
}