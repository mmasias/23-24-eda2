import java.util.Scanner;

public class Labyrinth {

    private static final int FREE = 0;
    private static final int WALL = 1;
    private static final int PATH = 2;
    private static final int VISITED = 3;

    private static String[] celda = {" · ", "[ ]", " * ", " x "};

    public static boolean solveMaze(int[][] maze, int x, int y) {
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length) {
            System.out.println("Intento ir a (" + x + ", " + y + "): Me saldría del laberinto.");
            return false;
        }
        if (maze[x][y] != FREE) {
            System.out.println("Intento ir a (" + x + ", " + y + "): Si voy me choco.");
            return false;
        }
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            maze[x][y] = PATH;
            return true;
        }
        maze[x][y] = PATH;

        System.out.println("voy a (" + x + ", " + y + "): Por aquí creo que voy bien, lo marco");
        printMazeWithPosition(maze, x, y);
        new Scanner(System.in).nextLine();

        if (solveMaze(maze, x + 1, y) || solveMaze(maze, x, y + 1) ||
            solveMaze(maze, x - 1, y) || solveMaze(maze, x, y - 1)) {
            return true;
        }

        maze[x][y] = VISITED; 
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

    public static void printMazeWithPosition(int[][] maze, int x, int y) {
        System.out.println("===".repeat(maze[0].length));
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (i == x && j == y) {
                    System.out.print(" @ ");
                } else {
                    System.out.print(celda[maze[i][j]]);
                }
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
        printMazeWithPosition(maze, 0, 0);
        
        System.out.println("Pulse una tecla para intentar resolver el laberinto...");
        new Scanner(System.in).nextLine();

        if (solveMaze(maze, 0, 0)) {
            System.out.println("Ruta de escape:");
            printMazeWithPosition(maze, maze.length - 1, maze[0].length - 1);
        } else {
            System.out.println("No se puede escapar!!!.");
        }
    }
}
