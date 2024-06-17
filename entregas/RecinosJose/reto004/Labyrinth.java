package entregas.RecinosJose.reto004;

import java.util.Scanner;

public class Labyrinth {

    private static final int FREE = 0;
    private static final int WALL = 1;
    private static final int PATH = 2;
    private static final int VISITED = 3;
    static int pasos = 0;

    private static String[] celda = { " · ", "[ ]", " * ", " x " };

    public static boolean solveMaze(int[][] maze, int x, int y) {
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length) {
            System.out.println("Intentando mover a (" + y + ", " + x + "): Fuera de los límites del laberinto.");
            System.out.println("Se a llegado a el borde de la matriz, se reconoce como espacio restringido para el camino.");
            return false;
        }
        if (maze[x][y] != FREE) {
            System.out.println("Intentando mover a (" + y + ", " + x + "): Celda bloqueada o ya visitada.");
            System.out.println("Ocupa recursividad en si mismo para revisar que si a pasado por ahi o no o si no se puede pasar, marca con una x adonde ya a pasado .");
            System.out.println("Se a llegado a una pared o a un espacio ya visitado, se reconoce como espacio bloqueado.");
            return false;
        }
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            maze[x][y] = PATH;
            System.out.println("Moviendo a (" + y + ", " + x + "): ¡Ruta encontrada!");
            System.out.println("Se a llegado a la salida, se reconoce como espacio libre.");
            System.out.println("Una vez llegado a el final, termina el laberinto.");
            printMaze(maze);
            return true;
        }

        maze[x][y] = PATH;
        System.out.println("Moviendo a (" + y + ", " + x + "): Marcando como parte del camino.");
        System.out.println("Se marca con un * la ruta que se esta siguiendo.");
        System.out.println("Mantiene en cuenta su posicion,recordando que en esa posicion ya pasó y se reconoce como MARCADO.");
        printMaze(maze);

        if (solveMaze(maze, x + 1, y)) {
            return true;
        }
        if (solveMaze(maze, x, y + 1)) {
            return true;
        }
        if (solveMaze(maze, x - 1, y)) {
            return true;
        }
        if (solveMaze(maze, x, y - 1)) {
            return true;
        }

        maze[x][y] = VISITED;
        System.out.println("Moviendo a (" + y + ", " + x + "): Marcando como visitado y retrocediendo.");
        System.out.println("Se marca con una x la ruta que ya no se puede seguir.");
        System.out.println("Recuerda con esa x que ya no puede pasar por ahi y vuelve a la ultima vez adonde tuvo que decidir entre dos caminos.");
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
        System.out.println("Pulse una tecla...");
        System.out.println("Se moverá una vez que se presione una tecla, siguiendo el camino y visualizando por donde puede pasar y por donde no.");
        new Scanner(System.in).nextLine();
    }

    static void cleanScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void main(String[] args) {
        int[][] maze = {
                
                 {0,0,0,1,0,0,0,0},
                 {0,1,0,0,0,0,0,0},
                 {0,1,0,1,1,1,1,0},
                 {0,1,0,0,0,0,1,0},
                 {0,0,0,1,0,0,1,0},
                /*
                { 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0 },
                { 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0 },
                { 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0 },
                { 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0 },
                { 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
                { 0, 1, 0, 0, 1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0 },
                { 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0 },
                { 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0 },
                { 0, 1, 0, 1, 1, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0 },
                { 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0 },
                { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }*/
        };

        
        cleanScreen();
        System.out.println("Laberinto:");

        if (solveMaze(maze, 0, 0)) {
            System.out.println("Ruta de escape:");
            System.out.println("Se muestra toda la ruta que siguio para escapar del laberinto, incluyendo los lugares adonde no pudo salir, marcandolos con una x.");
            printMaze(maze);
        } else {
            System.out.println("No se puede escapar!!!.");
            System.out.println("No hay salida por ninguno de los caminos disponibles.El laberinto acaba!!!");
        }
    }
}