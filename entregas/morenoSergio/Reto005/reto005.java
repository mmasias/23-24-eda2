import java.util.Scanner;

public class reto005 {
    static final int FILA = 0;
    static final int COLUMNA = 1;
    static final int ARRIBA = 0;
    static final int ABAJO = 1;
    static final int IZQUIERDA = 2;
    static final int DERECHA = 3;
    static final int SALIR = 4;
    static final int CAMBIA_VISUALIZACION = 5;
    static final int BUSCAR_CAMINO = 6;
    static final int NADA = 999;

    static final int[][] MOVIMIENTO = {
        { -1, 0 },
        { 1, 0 },
        { 0, -1 },
        { 0, 1 }
    };

    static boolean jugando = true;
    static int modoVisualizacion = 0; 

    public static void main(String[] args) {
        String[] castillo = {
            "..............................................................................",
            "..............................................................................",
            "...#########################################################################...",
            "...#.......................................................................#...",
            "...#.......................................................................#...",
            "...#.....................................................###################...",
            "...#.....................................................#.....................",
            "...#####################################################.....................",
            "...#.....................................................#####################...",
            "...#.....................................................#.....................",
            "...#####################.................................#.....................",
            "...#..................#.................................#####################...",
            "...#..................#........................................................",
            "...#..................############################################################",
            "...#............................................................................",
            "...#########################################################################...",
            "..............................................................................",
            ".............................................................................."
        };

        int[] elPersonaje = { 5, 3 };
        Scanner scanner = new Scanner(System.in);

        while (jugando) {
            imprimirMundo(castillo, elPersonaje);
            System.out.println("Usa W/A/S/D para moverte, F para salir, V para cambiar visualización, B para buscar camino a la salida.");
            verAccion(elPersonaje, castillo, scanner);
        }
    }

    static void verAccion(int[] elPersonaje, String[] elMundo, Scanner scanner) {
        switch (capturarMovimiento(scanner)) {
            case ARRIBA:
            case ABAJO:
            case IZQUIERDA:
            case DERECHA:
                mover(elPersonaje, MOVIMIENTO[capturarMovimiento(scanner)], elMundo);
                break;
            case SALIR:
                jugando = false;
                break;
            case CAMBIA_VISUALIZACION:
                modoVisualizacion = (modoVisualizacion + 1) % 4;
                break;
            case BUSCAR_CAMINO:
                if (buscarCamino(elMundo, elPersonaje[FILA], elPersonaje[COLUMNA], 5, 66)) {
                    System.out.println("Camino encontrado y marcado en el mapa.");
                } else {
                    System.out.println("No hay camino disponible.");
                }
                break;
        }
    }

    static int capturarMovimiento(Scanner scanner) {
        char c = scanner.nextLine().toUpperCase().charAt(0);
        switch (c) {
            case 'W': return ARRIBA;
            case 'S': return ABAJO;
            case 'A': return IZQUIERDA;
            case 'D': return DERECHA;
            case 'F': return SALIR;
            case 'V': return CAMBIA_VISUALIZACION;
            case 'B': return BUSCAR_CAMINO;
            default: return NADA;
        }
    }

    static void mover(int[] personaje, int[] movimiento, String[] mundo) {
        int nuevaFila = personaje[FILA] + movimiento[FILA];
        int nuevaColumna = personaje[COLUMNA] + movimiento[COLUMNA];
        if (mundo[nuevaFila].charAt(nuevaColumna) == '.') {
            personaje[FILA] = nuevaFila;
            personaje[COLUMNA] = nuevaColumna;
        }
    }

    static boolean buscarCamino(String[] mundo, int fila, int columna, int filaDestino, int columnaDestino) {
        if (fila < 0 || fila >= mundo.length || columna < 0 || columna >= mundo[0].length() || mundo[fila].charAt(columna) == '#') {
            return false;
        }
        if (fila == filaDestino && columna == columnaDestino) {
            mundo[fila] = mundo[fila].substring(0, columna) + 'X' + mundo[fila].substring(columna + 1);
            return true;
        }
        char temp = mundo[fila].charAt(columna);
        mundo[fila] = mundo[fila].substring(0, columna) + '*' + mundo[fila].substring(columna + 1);
        int[][] direcciones = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] direccion : direcciones) {
            if (buscarCamino(mundo, fila + direccion[0], columna + direccion[1], filaDestino, columnaDestino)) {
                return true;
            }
        }
        mundo[fila] = mundo[fila].substring(0, columna) + temp + mundo[fila].substring(columna + 1);
        return false;
    }

    static void imprimirMundo(String[] castillo, int[] personaje) {
        for (int i = 0; i < castillo.length; i++) {
            for (int j = 0; j < castillo[i].length(); j++) {
                if (i == personaje[FILA] && j == personaje[COLUMNA]) {
                    System.out.print('P');
                } else {
                    System.out.print(castillo[i].charAt(j));
                }
            }
            System.out.println();
        }
    }
}
