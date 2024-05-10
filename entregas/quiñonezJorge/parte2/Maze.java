package parte2;

import java.util.Scanner;

public class Maze {
  private static final int FREE = 0;
  private static final int WALL = 1;
  private static final int PATH = 2;
  private static final int VISITED = 3;

  private static String[] celda = { " · ", "[ ]", " * ", " x " };

  public static boolean solveMaze(int[][] maze, int x, int y) {
    if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length) {
      System.out.println("Intentando moverse a (" + y + "," + x + "): Fuera de los limites");
      return false;
    }
    if (maze[x][y] != FREE) {
      System.out.println("Intentando moverse a (" + y + "," + x + "): Celda no disponible");
      return false;
    }
    if (x == maze.length - 1 && y == maze[0].length - 1) {
      maze[x][y] = PATH;
      return true;
    }

    maze[x][y] = PATH;

    System.out.println("Moviendose a (" + y + "," + x + "): Marcando camino");
    printMaze(maze);
    new Scanner(System.in).nextLine();

    if (solveMaze(maze, x + 1, y) || solveMaze(maze, x, y + 1) ||
        solveMaze(maze, x - 1, y) || solveMaze(maze, x, y - 1)) {
      return true;
    }

    maze[x][y] = VISITED;
    System.out.println("Marcando celda (" + y + "," + x + ") como visitada");
    printMaze(maze);
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
        { 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0 },
        { 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0 },
        { 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0 },
        { 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0 },
        { 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0 },
        { 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0 },
        { 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0 },
        { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1 }
    };

    System.out.println("Laberinto:");
    printMaze(maze);

    System.out.println("Pulse una tecla para intentar resolver el laberinto...");
    new Scanner(System.in).nextLine();

    if (solveMaze(maze, 0, 0)) {
      System.out.println("Ruta de escape:");
      printMaze(maze);
    } else {
      System.out.println("No se puede escapar!!!.");
    }
  }
}
