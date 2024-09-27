package entregas.garciaLydia.reto004.parte2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LabyrinthTrazasbility {
    private static final int FREE = 0;
    private static final int WALL = 1;
    private static final int PATH = 2;
    private static final int VISITED = 3;

    private static String[] celda = {" · ", "[ ]", " * ", " x "};
    private static List<int[]> path = new ArrayList<>();

    public static boolean solveMaze(int[][] maze, int x, int y) {
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length) {
            return false;
        }
        if (maze[x][y] != FREE) {
            return false;
        }
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            maze[x][y] = PATH;
            path.add(new int[]{x, y});
            return true;
        }
        maze[x][y] = PATH;
        path.add(new int[]{x, y});

        if (solveMaze(maze, x + 1, y) || solveMaze(maze, x, y + 1) ||
                solveMaze(maze, x - 1, y) || solveMaze(maze, x, y - 1)) {
            return true;
        }

        maze[x][y] = VISITED;
        path.remove(path.size() - 1);
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

    public static void printPath() {
        System.out.println("Ruta de escape:");
        for (int[] pos : path) {
            System.out.println("(" + pos[0] + ", " + pos[1] + ")");
        }
    }

    public static void main(String[] args) {
        int[][] maze = {
                {0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0},
                {0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0},
                {1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0},
                {0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0},
                {0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0},
                {1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0}
        };

        System.out.println("Laberinto:");
        printMaze(maze);

        System.out.println("Pulse una tecla para intentar resolver el laberinto...");
        new Scanner(System.in).nextLine();

        if (solveMaze(maze, 0, 0)) {
            printMaze(maze);
            printPath();
        } else {
            System.out.println("No se puede escapar!!!");
        }
    }
}
