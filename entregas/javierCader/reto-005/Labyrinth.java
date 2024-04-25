import java.util.Scanner;

public class Labyrinth {

    private static final int FREE = 0;
    private static final int WALL = 1;
    private static final int PATH = 2;
    private static final int VISITED = 3;

    private static final String[] CELL_SYMBOLS = {" · ", "[ ]", " * ", " x "};

    private static boolean solveMaze(int[][] maze, int x, int y) {
        if (!isInBoundsAndFree(maze, x, y)) {
            return false;
        }

        System.out.println("Moving to (" + x + ", " + y + "): Marking as part of the path.");
        maze[x][y] = PATH;
        printMaze(maze);

        if (isAtExit(maze, x, y)) {
            return true;
        }

        if (solveMaze(maze, x + 1, y) || solveMaze(maze, x, y + 1) ||
            solveMaze(maze, x - 1, y) || solveMaze(maze, x, y - 1)) {
            return true;
        }

        maze[x][y] = VISITED;
        System.out.println("Backtracking from (" + x + ", " + y + "): Marking as visited.");
        printMaze(maze);
        return false;
    }

    private static boolean isInBoundsAndFree(int[][] maze, int x, int y) {
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length) {
            System.out.println("Moving to (" + x + ", " + y + "): Out of bounds.");
            return false;
        }
        if (maze[x][y] != FREE) {
            System.out.println("Moving to (" + x + ", " + y + "): Blocked or already visited.");
            return false;
        }
        return true;
    }

    private static boolean isAtExit(int[][] maze, int x, int y) {
        return x == maze.length - 1 && y == maze[0].length - 1;
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
    
        Scanner scanner = new Scanner(System.in);
        System.out.println("Press any key to attempt to solve the maze...");
        scanner.nextLine();  
        scanner.close();  
    
        if (solveMaze(maze, 0, 0)) {
            System.out.println("Escape route:");
            printMaze(maze);
        } else {
            System.out.println("No escape possible!!!");
        }
    }
    
}
