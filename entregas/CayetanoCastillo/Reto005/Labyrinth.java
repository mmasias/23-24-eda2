package entregas.CayetanoCastillo.Reto005;
import java.util.Scanner;

public class Labyrinth {

    private static final int FREE = 0;
    private static final int WALL = 1;
    private static final int PATH = 2;
    private static final int VISITED = 3;
    private static final int REVISITED = 4;

    private static String[] celda = {" · ", "[ ]", " * ", " x "};

    public static boolean findPath(int[][] maze, int x, int y) {
        if (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length || maze[x][y] == WALL || maze[x][y] == PATH) {
            return false;
        }
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            maze[x][y] = PATH;
            printMaze(maze);
            return true;
        }

        maze[x][y] = PATH;
        printMaze(maze);

        if (findPath(maze, x, y + 1) || findPath(maze, x + 1, y) ||
            findPath(maze, x, y - 1) || findPath(maze, x - 1, y)) {
            return true;
        }

        maze[x][y] = VISITED; 
        return false;
    }

    public static void printMaze(int[][] maze) {
        System.out.println("==========================================");
        for (int[] row : maze) {
            for (int col : row) {
                System.out.print(celda[col]);
            }
            System.out.println();
        }
        System.out.println("==========================================");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
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

        System.out.println("¿Desea resolver el laberinto automáticamente? (s/n)");
        String auto = scanner.nextLine();

        if (auto.equalsIgnoreCase("s")) {
            if (!findPath(maze, 0, 0)) {
                System.out.println("No se encontró una salida.");
            }
        } else {
            manualMode(maze, scanner);
        }
    }

    public static void manualMode(int[][] maze, Scanner scanner) {
        int x = 0, y = 0; 
        maze[x][y] = PATH; 
        printMaze(maze);

        while (x != maze.length - 1 || y != maze[0].length - 1) {
            System.out.println("Ingrese su movimiento (w = arriba, s = abajo, a = izquierda, d = derecha):");
            String move = scanner.nextLine();
            int newX = x, newY = y;

            switch (move) {
                case "w": newX--; break;
                case "s": newX++; break;
                case "a": newY--; break;
                case "d": newY++; break;
                default: System.out.println("Movimiento no válido."); continue;
            }

            if (newX < 0 || newX >= maze.length || newY < 0 || newY >= maze[0].length || maze[newX][newY] == WALL) {
                System.out.println("Movimiento inválido! Trate de nuevo.");
            } else {
                if (maze[newX][newY] == PATH) {
                    maze[newX][newY] = REVISITED;
                }
                if (maze[x][y] == PATH) {
                    maze[x][y] = VISITED;
                } else if (maze[x][y] == VISITED) {
                    maze[x][y] = REVISITED;
                }
                x = newX;
                y = newY;
                if (maze[x][y] == FREE) {
                    maze[x][y] = PATH;
                }
                printMaze(maze);
            }
        }
        System.out.println("¡Felicidades! Ha escapado del laberinto.");
    }
}
