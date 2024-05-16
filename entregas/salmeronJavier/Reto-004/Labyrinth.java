import java.util.Scanner;

public class Labyrinth {

    private static final int FREE = 0;
    private static final int WALL = 1;
    private static final int PATH = 2;
    private static final int VISITED = 3;

    private static String[] celda = {" · ", "[ ]", " * ", " x "};
    private static Scanner scanner = new Scanner(System.in);

    public static boolean solveMaze(int[][] maze, int x, int y) {
        System.out.println("Attempting to visit cell " + x + "," + y + "\n");
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length) {
            System.out.println("Out of bounds.");
            printMaze(maze);
            promptEnterKey();
            return false;
        }

        switch (maze[x][y]) {
            case WALL:
                System.out.println("Wall found.");
                printMaze(maze);
                promptEnterKey();
                return false;
            case PATH:
            case VISITED:
                System.out.println("Already visited.");
                printMaze(maze);
                promptEnterKey();
                return false;
            case FREE:
                System.out.println("Free path found, moving forward.");
                printMaze(maze);
                promptEnterKey();
                break;
        }

        if (x == maze.length - 1 && y == maze[0].length - 1) {
            maze[x][y] = PATH;
            System.out.println("Finished!");
            printMaze(maze);
            promptEnterKey();
            return true;
        }

        maze[x][y] = PATH;

        if (solveMaze(maze, x + 1, y) || solveMaze(maze, x, y + 1) ||
            solveMaze(maze, x - 1, y) || solveMaze(maze, x, y - 1)) {
            return true;
        }

        maze[x][y] = VISITED;
        System.out.printf("Backtracking from cell (%d, %d)\n", x, y);
        printMaze(maze);
        promptEnterKey();

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

    private static void promptEnterKey(){
        System.out.println("Press ENTER to continue...");
        scanner.nextLine();
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
        printMaze(maze);
        
        System.out.println("Pulse una tecla para intentar resolver el laberinto...");
        scanner.nextLine();

        if (solveMaze(maze, 0, 0)) {
            System.out.println("Ruta de escape:");
            printMaze(maze);
        } else {
            System.out.println("No se puede escapar!!!");
        }
    }
}
