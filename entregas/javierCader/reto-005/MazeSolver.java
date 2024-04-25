import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;

public class MazeSolver {

    private static final int FREE = 0;
    private static final int WALL = 1;
    private static final int PATH = 2;
    private static final int VISITED = 3;

    private static final String[] CELL_SYMBOLS = {" · ", "[ ]", " * ", " x "};

    private static void initializeMaze(int[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                maze[i][j] = WALL;
            }
        }
    }

    private static void generateMaze(int[][] maze) {
        Random rand = new Random();
        List<int[]> frontiers = new LinkedList<>();
        int startX = 1;
        int startY = 1;
        maze[startX][startY] = FREE;
        addFrontiers(maze, startX, startY, frontiers);

        while (!frontiers.isEmpty()) {
            int[] f = frontiers.remove(rand.nextInt(frontiers.size()));
            int x = f[0];
            int y = f[1];

            List<int[]> neighbors = getNeighbors(maze, x, y);
            if (!neighbors.isEmpty()) {
                int[] n = neighbors.get(rand.nextInt(neighbors.size()));
                maze[n[0]][n[1]] = FREE;
                maze[x][y] = FREE;
                addFrontiers(maze, x, y, frontiers);
            }
        }
    }

    private static void addFrontiers(int[][] maze, int x, int y, List<int[]> frontiers) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : directions) {
            int nx = x + 2 * dir[0];
            int ny = y + 2 * dir[1];
            if (nx >= 0 && ny >= 0 && nx < maze.length && ny < maze[0].length && maze[nx][ny] == WALL) {
                frontiers.add(new int[]{nx, ny});
            }
        }
    }

    private static List<int[]> getNeighbors(int[][] maze, int x, int y) {
        List<int[]> neighbors = new LinkedList<>();
        int[][] directions = {{2, 0}, {-2, 0}, {0, 2}, {0, -2}};
        for (int[] dir : directions) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx > 0 && ny > 0 && nx < maze.length && ny < maze[0].length && maze[nx][ny] == FREE) {
                neighbors.add(new int[]{x + dir[0]/2, y + dir[1]/2});
            }
        }
        return neighbors;
    }

    private static int bfs(int[][] maze, int startX, int startY, int targetX, int targetY) {
        if (maze[startX][startY] == WALL || maze[targetX][targetY] == WALL) {
            return 0;  
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        maze[startX][startY] = PATH;

        int moves = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.remove();
            int x = current[0];
            int y = current[1];

            moves++;

            if (x == targetX && y == targetY) {
                return moves; 
            }

            maze[x][y] = VISITED;

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

        return moves; 
    }

    private static int dfs(int[][] maze, int startX, int startY, int targetX, int targetY) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{startX, startY});

        int moves = 0;

        while (!stack.isEmpty()) {
            int[] current = stack.pop();
            int x = current[0];
            int y = current[1];

            if (x < 0 || y < 0 || x >= maze.length || y >= maze[0].length || maze[x][y] != FREE) {
                continue;
            }

            maze[x][y] = PATH;
            moves++;

            if (x == targetX && y == targetY) {
                return moves; 
            }

            stack.push(new int[]{x + 1, y});
            stack.push(new int[]{x - 1, y});
            stack.push(new int[]{x, y + 1});
            stack.push(new int[]{x, y - 1});
        }

        return moves; 
    }
    

    private static boolean isInBoundsAndFree(int[][] maze, int x, int y) {
        return x >= 0 && x < maze.length && y >= 0 && y < maze[0].length && (maze[x][y] == FREE || maze[x][y] == PATH);
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
        System.out.println("Maze dimensions (rows cols):");
        int rows = scanner.nextInt();
        int cols = scanner.nextInt();
        int[][] originalMaze = new int[rows][cols];

        initializeMaze(originalMaze);
        generateMaze(originalMaze);

        System.out.println("Generated Maze:");
        printMaze(originalMaze);

        System.out.println("Enter start coordinates (x y):");
        int startX = scanner.nextInt();
        int startY = scanner.nextInt();

        System.out.println("Enter target coordinates (x y):");
        int targetX = scanner.nextInt();
        int targetY = scanner.nextInt();

        long startTime, endTime;
        int bfsMoves, dfsMoves;
        double bfsEfficiency, dfsEfficiency;
        long bfsTime, dfsTime;

        int[][] mazeForBFS = deepCopy(originalMaze);
        System.out.println("Starting BFS...");
        startTime = System.currentTimeMillis();
        bfsMoves = bfs(mazeForBFS, startX, startY, targetX, targetY);
        endTime = System.currentTimeMillis();
        bfsTime = endTime - startTime;
        bfsEfficiency = calculateEfficiency(bfsTime, bfsMoves);
        System.out.println("BFS found a path! Time taken: " + bfsTime + " ms");
        printMaze(mazeForBFS);


        int[][] mazeForDFS = deepCopy(originalMaze);
        System.out.println("Starting DFS...");
        startTime = System.currentTimeMillis();
        dfsMoves = dfs(mazeForDFS, startX, startY, targetX, targetY);
        endTime = System.currentTimeMillis();
        dfsTime = endTime - startTime;
        dfsEfficiency = calculateEfficiency(dfsTime, dfsMoves);
        System.out.println("DFS found a path! Time taken: " + dfsTime + " ms");
        printMaze(mazeForDFS);



        System.out.println("\nResults:");
        System.out.println("Algorithm | Time (ms) | Moves | Efficiency");
        System.out.println("-------------------------------------------");
        System.out.printf("BFS       | %9.5f | %5d | %9.8f\n", (double)bfsTime, bfsMoves, bfsEfficiency);
        System.out.printf("DFS       | %9.5f | %5d | %9.8f\n", (double)dfsTime, dfsMoves, dfsEfficiency);

        scanner.close();
    }

    private static double calculateEfficiency(long time, int moves) {
        if (time == 0 || moves == 0) {
            return 0; 
        }
        return 1.0 - (1.0 / (time * moves));
    }
    

    private static int[][] deepCopy(int[][] original) {
        if (original == null) {
            return null;
        }
        final int[][] result = new int[original.length][];
        for (int i = 0; i < original.length; i++) {
            result[i] = original[i].clone();
        }
        return result;
    }

}
