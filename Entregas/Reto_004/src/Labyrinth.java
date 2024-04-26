import java.util.Scanner;

public class Labyrinth {

    private static final int FREE = 0;
    private static final int WALL = 1;
    private static final int PATH = 2;
    private static final int VISITED = 3;

    private static String[] celda = {" · ", "[ ]", " * ", " x "};

    public static boolean solveMaze(int[][] maze, int x, int y) {
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length) {
            return false;
        }
        if (maze[x][y] != FREE) {
            printMaze(maze);
            return false;
        }
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            maze[x][y] = PATH;
            printMaze(maze);
            return true;
        }
        maze[x][y] = PATH;

        if (solveMaze(maze, x + 1, y) || solveMaze(maze, x, y + 1) ||
            solveMaze(maze, x - 1, y) || solveMaze(maze, x, y - 1)) {
            return true;
        }

        maze[x][y] = VISITED; 
        return false;
    }

    public static void printMaze(int[][] maze) {
        System.out.println("TRAZABILIDAD: imprime el laberinto añadiendole un borde de igual tamaño al laberinto con el caracter '='.");
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

        System.out.println("TRAZABILIDAD: imprime el laberinto");

        printMaze(maze);
        
        System.out.println("Pulse una tecla para intentar resolver el laberinto...");
        new Scanner(System.in).nextLine();
        System.out.println("TRAZABILIDAD: Pide una tecla cualquiera para resolver el laberinto comenzar a resolver el laberinto");

        if (solveMaze(maze, 0, 0)) {
            System.out.println("Ruta de escape:");
            printMaze(maze);
            System.out.println("TRAZABILIDAD: imprime la ruta de escape en caso de existir una solución., sino indica que no se puede escapar con el mensaje 'No se puede escapar!!!.'");
        } else {
            System.out.println("No se puede escapar!!!.");
        }
    }
}
