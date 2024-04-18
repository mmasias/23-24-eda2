import java.util.Scanner;

public class Laberinto {

    private static final int FREE = 0;
    private static final int WALL = 1;
    private static final int PATH = 2;
    private static final int VISITED = 3;

    private static String[] celda = {" · ", "[#]", " * ", " x "};

    public static boolean solveMaze(int[][] maze, int x, int y) {
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length) {
            System.out.println("Moviendo a la posición (" + x + "," + y + ") fuera de los límites del laberinto.");
            return false;
        }
        if (maze[x][y] != FREE) {
            System.out.println("Moviendo a la posición (" + x + "," + y + ") que no es un espacio libre.");
            return false;
        }
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            maze[x][y] = PATH;
            System.out.println("Moviendo a la posición (" + x + "," + y + ") que es la salida del laberinto.");
            return true;
        }
        maze[x][y] = PATH;
        System.out.println("Moviendo a la posición (" + x + "," + y + ") que es un espacio libre.");
        printMaze(maze);

        if (solveMaze(maze, x + 1, y) || solveMaze(maze, x, y + 1) ||
            solveMaze(maze, x - 1, y) || solveMaze(maze, x, y - 1)) {   
            return true;
        }

        maze[x][y] = VISITED; 
        System.out.println("Moviendo a la posición (" + x + "," + y + ") que es un espacio visitado.");
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

        System.out.println("Pulsa una tecla...");
        new Scanner(System.in).nextLine();
    }

    static void cleanScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        int[][] maze = {
            {0,1,0,0,1,0,0,1,0,0,1,0,0,0},
            {0,1,0,1,1,0,1,1,0,1,1,0,1,0},
            {0,0,0,1,0,0,1,0,0,1,0,0,1,0},
            {1,1,0,0,0,0,0,0,0,1,0,0,1,0},
            {0,1,0,1,1,0,1,1,0,1,1,0,1,0},
            {0,0,0,1,0,0,1,0,0,0,0,0,1,0},
            {1,1,0,1,0,0,1,1,0,1,0,0,1,0},
            {0,0,0,1,0,1,0,0,0,0,0,1,0,0}
        };

        
        System.out.println("Laberinto:");
        System.out.println("Orden de movimientos: abajo, derecha, arriba, izquierda");
        System.out.println("Si hay dos espacios libres prioriza el orden expliciado antes");
        printMaze(maze);

        if (solveMaze(maze, 0, 0)) {
            System.out.println("Ruta de escape:");
            printMaze(maze);
        } else {
            System.out.println("No se puede escapar!!!.");
        }
    }
}
