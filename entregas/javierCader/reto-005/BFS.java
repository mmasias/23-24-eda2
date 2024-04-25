import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    private static final int FREE = 0;
    private static final int WALL = 1;
    private static final int PATH = 2;
    private static final int VISITED = 3;

    private static final String[] CELL_SYMBOLS = {" · ", "[ ]", " * ", " x "};

    private static boolean solveMaze(int[][] maze, int startX, int startY, int targetX, int targetY) {
        if (maze[startX][startY] == WALL || maze[targetX][targetY] == WALL) {
            return false;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});

        while (!queue.isEmpty()) {
            int[] current = queue.remove();
            int x = current[0];
            int y = current[1];
            
            if (x == targetX && y == targetY) {
                return true;
            }

            maze[x][y] = VISITED;
            printMaze(maze);

            int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
            for (int[] dir : directions) {
                int newX = x + dir[0];
                int newY = y + dir[1];

                if (isInBoundsAndFree(maze, newX, newY)) {
                    maze[newX][newY] = PATH;
                    queue.add(new int[]{newX, newY});
                }
            }
        }

        return false;
    }

    private static boolean isInBoundsAndFree(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && maze[x][y] == FREE;
    }

    private static void printMaze(int[][] maze) {
        final String ANSI_RESET = "\u001B[0m";
        final String ANSI_BLACK = "\u001B[30m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_GREEN = "\u001B[32m";
        final String ANSI_YELLOW = "\u001B[33m";

        final String[] CELL_COLORS = {
            ANSI_GREEN,  
            ANSI_BLACK,  
            ANSI_YELLOW, 
            ANSI_RED    
        };

        System.out.println("===".repeat(maze[0].length));
        for (int[] row : maze) {
            for (int col : row) {
                System.out.print(CELL_COLORS[col] + CELL_SYMBOLS[col] + ANSI_RESET);
            }
            System.out.println();
        }
        System.out.println("===".repeat(maze[0].length));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] maze = {
            {FREE, WALL, FREE, FREE, WALL, FREE, FREE, WALL, FREE, FREE, WALL, FREE, FREE, FREE},
            {FREE, WALL, FREE, WALL, WALL, FREE, WALL, WALL, FREE, WALL, WALL, FREE, WALL, FREE},
            {FREE, FREE, FREE, WALL, FREE, FREE, WALL, FREE, FREE, WALL, FREE, FREE, WALL, FREE},
            {WALL, WALL, FREE, WALL, FREE, FREE, FREE, FREE, FREE, WALL, FREE, FREE, WALL, FREE},
            {FREE, WALL, FREE, WALL, WALL, FREE, WALL, WALL, FREE, WALL, WALL, FREE, WALL, FREE},
            {FREE, FREE, FREE, WALL, FREE, FREE, WALL, FREE, FREE, FREE, FREE, FREE, WALL, FREE},
            {WALL, WALL, FREE, WALL, FREE, FREE, WALL, WALL, FREE, WALL, FREE, FREE, WALL, FREE},
            {FREE, FREE, FREE, FREE, FREE, WALL, FREE, FREE, FREE, FREE, FREE, WALL, FREE, FREE}
        };

        System.out.println("Maze:");
        printMaze(maze);

        System.out.println("Enter target x coordinate:");
        int targetX = scanner.nextInt();
        System.out.println("Enter target y coordinate:");
        int targetY = scanner.nextInt();

        System.out.println("Starting maze solver...");
        if (solveMaze(maze, 0, 0, targetX, targetY)) {
            System.out.println("Found a path to the target!");
            printMaze(maze);
        } else {
            System.out.println("No path to the target possible!");
        }

        scanner.close();
    }
}
