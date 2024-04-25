import java.util.*;

public class ArrayAsociativo009 {

    static final int FREE = 0;
    static final int PATH = 1;
    static final int VISITED = 2;

    static final int FILA = 0;
    static final int COLUMNA = 1;

    static final int ARRIBA = 0;
    static final int ABAJO = 1;
    static final int IZQUIERDA = 2;
    static final int DERECHA = 3;
    static final int SALIR = 4;
    static final int CAMBIA_VISUALIZACION = 5;
    static final int NADA = 999;

    static final int VISUALIZACION_NORMAL = 0;
    static final int VISUALIZACION_SIN_COLOR = 1;
    static final int VISUALIZACION_RAW = 2;
    static final int VISUALIZACION_COLISIONES = 3;

    static final int[][] MOVIMIENTO = {
            { -1, 0 },
            { 1, 0 },
            { 0, -1 },
            { 0, 1 }
    };

    static double hora = 9.0;
    static int alcanceVision;
    static int viewPort;
    static int modoVisualizacion = VISUALIZACION_NORMAL;

    static int minFila, minColumna, maxFila, maxColumna;

    static boolean jugando = true;

    public static void main(String[] args) {

        String[] castilloLB = {
                "..............................................................................",
                "..............................................................................",
                "..............................................................................",
                "..............................................................................",
                "..............................................................................",
                "..............................................................................",
                "..............................................................................",
                "..............................................................................",
                "..............................................................................",
                "..............                                                   .............",
                "............                                                       ...........",
                "...........                                                         ..........",
                "..........      ..................................                   .........",
                "..........    .....................................          ....    .........",
                ".........    .......................................        ......    ........",
                ".........    ..|-----|..........|-------------|.....    .|-----|..    ........",
                ".........   ...|::+::|..........O+++++++++++++|....    ..|::+::|...   ........",
                ".........   ...|:+++:|..........|+++++++++++++|...    ...|:+++:|...   ........",
                ".........   ...|+++++------------++|-------|++------------+++++|...   ........",
                ".........   ...|:++++++++++++++++++|#######|++++++++++++++++++:|...   ........",
                ".........   ...|::+++++++++++++++++|::###::|+++++++++++++++++::|...   ........",
                ".........   ...---|++|-------|-+++-|:*#*#*:|-----|---|---|++|---...   ........",
                ".........   ......|++|---O---|+++++|*******|#####|+++-$$$|++|......   ........",
                ".........   ......|++|*#***#*|+++++|*******|#####-+++O*$$|++|......   ........",
                ".........    .....|++|*#***#*|+++++|*******|+++++X+++|**$|++|......   ........",
                ".........    .....|++|*#####*|+++++O*******|+++++X+++|---|++|......   ........",
                ".........     ....|++|*******|--+--|--***--|+++++X+++-**$|++|......   ........",
                ".........      ...|++|--***--|+++++|::+++::|+++++|+++O*$$|++|......   ........",
                ".........       ..|++|+++++++|+++++|:+++++:|+++++|+++|$$$|++|......   ........",
                "..........      ..|++|+##+##+|------+++++++--+++|---|----|++|......   ........",
                "...........      .|++|+++++++|++++++++++++++++++|***|**#*|++|......   ........",
                "...........       |++|+##+##+|++++++++++++++++++|---|**##|++|......   ........",
                "............      |++|+++++++|++++++++++++++++++|********|++|......   ........",
                "............      |++|+##+##+--++|----+++----|++|***|****|++|......   ........",
                "...........      .|++|+++++++++++|:::+++++:::|++-------**|++|......   ........",
                "...........     ..|++|++++++++++:|::+++++++::|+++++++++++|++|......   ........",
                "..........      ..|++|-------|+::|:+++++++++:|+++++++++++|++|......   ........",
                "..........     ...|++|*******|----++++   ++++-------|----|++|......   ........",
                ".........      ...|++|**|---*|+++++++     ++++++++++|++++|++|......   ........",
                ".........     ....|++|**|*#**|+++++++     ++++++++++O++++|++|......   ........",
                ".........     ....|++|**|*#**|+++++++     ++++++++++|++++|++|......   ........",
                ".........    .....|++|**--|**|++++++++   ++++|-------++++|++|......   ........",
                ".........    .....|++|****|**|++++++++++++++:|+++++++++++|++|......   ........",
                ".........   ......|++|--**----+++++++++++++::|+-+++++++++|++|......   ........",
                ".........   ......|++|++++++++++++++++++++:::|+++++++++++|++|......   ........",
                ".........   ......|++|-------------|--+++--|----|+++|----|++|......   ........",
                ".........   ......|++|XXXXXXXXXXXXX|::+++::|#***|+++|***#|++|......   ........",
                ".........   ......|++|X+++++++++++X| :+++: |****|+++|****|++|......   ........",
                ".........   ......|++|X++XXXXXXXX+X|  +++  |--O--+++--O--|++|......   ........",
                ".........   ......|++|X++|-----|X+X|  +++  |+++++++++++++|++|......   ........",
                ".........   ......|++|X++|%%%%%|X+X| :+++: |--O-|+++|-O--|++|......   ........",
                ".........   ......|++|X++|*****|X+X|::+++::|****|+++|****|++|......   ........",
                ".........   ......|++|X++|#####|X+X| :+++: |#***|+++|***#|++|......   ........",
                ".........   ......|++|X++|*****|X+X|  +++  |-----+++-----|++|......   ........",
                ".........   ......|++|X++----**|X+X|  +++  |X+++++++++++%|++|......   ........",
                ".........   ......|++|X++++++++|X+X|  +++  |XX+++++++++%%|++|......   ........",
                ".........   ......|++|XXXXXXXXX|X+X| :+++: |XXX+++++++%%%|++|......   ........",
                ".........   ...|---++-----------X+X|::+++::|XXXX+++++%%%%|XX---|...   ........",
                ".........   ...|::++++++++++++++++X| :+++: |XXXXX+++%%%%%|***$$|...   ........",
                ".........   ...|:+++++++++++++++++X|  +++  |#############|****$|...   ........",
                ".........   ...|+++++|-------------|  +++  |-------------|*****|...   ........",
                ".........   ...|:+++:|.............| :+++: |.............|$***$|...   ........",
                ".........   ...|::+::|.............|::+++::|.............|$$*$$|...   ........",
                ".........    ..-------.............---+++---.............-------..    ........",
                ".........    .....................................................    ........",
                "..........    ...................................................    .........",
                "..........      ......................+++......................      .........",
                "...........                           +++                           ..........",
                "............                          +++                          ...........",
                "..............                        +++                        .............",
                "......................................+++.....................................",
                "..............................................................................",
                "..............................................................................",
                "..............................................................................",
                "..............................................................................",
                "..............................................................................",
                "..............................................................................",
                ".............................................................................."
        };

        int[] elPersonaje = { 14, 15 };

        inicializarMundo(castilloLB);

        do {
            actualizarTiempo();
            imprimirMundo(castilloLB, elPersonaje);
            verAccion(elPersonaje, castilloLB);
        } while (jugando);
    }

    private static void inicializarMundo(String[] mundo) {

        viewPort = 7;
        alcanceVision = viewPort / 2;

        minFila = 0 + viewPort;
        minColumna = 0 + viewPort;
        maxFila = mundo.length - (viewPort + 1);
        maxColumna = mundo[0].length() - (viewPort + 1);
    }

    static void actualizarTiempo() {

        hora = hora + 0.2;
        if (hora >= 24) {
            hora = 0;
        }
        calculaAlcanceVision();
    }

    static void calculaAlcanceVision() {

        alcanceVision = viewPort * 2;
    }

    static void imprimirMundo(String[] castillo, int[] personaje) {
        String elemento;
        limpiarPantalla();
        imprimirElCielo();
        for (int fila = personaje[FILA] - viewPort; fila <= personaje[FILA] + viewPort; fila++) {
            for (int columna = personaje[COLUMNA] - viewPort; columna <= personaje[COLUMNA] + viewPort; columna++) {
                elemento = mapear('P', modoVisualizacion);
                if (!(fila == personaje[FILA] && columna == personaje[COLUMNA])) {
                    elemento = mapear(castillo[fila].charAt(columna), modoVisualizacion);
                }

                if (!(Math.pow((fila - personaje[FILA]), 2)+ Math.pow((columna - personaje[COLUMNA]), 2) <= alcanceVision * alcanceVision)) {
                    elemento = mapear('D', modoVisualizacion);
                }
                System.out.print(elemento);
            }
            System.out.println();
        }
        imprimirStatus(personaje);
    }

    private static void imprimirStatus(int[] personaje) {
        imprimirLinea();
        System.out.print("HORA: [" + (int) hora + "] ");
        System.out.print("/ (" + personaje[FILA] + "," + personaje[COLUMNA] + ")");
        System.out.println(" / SKIN[" + modoVisualizacion + "]");
        imprimirLinea();
    }

    static void imprimirLinea() {
        System.out.println(mapear('B', modoVisualizacion).repeat(viewPort * 2 + 1));
    }

    static String mapear(char elemento, int modoVisualizacion) {

        switch (modoVisualizacion) {
            case VISUALIZACION_NORMAL:
                return mapearNormal(elemento);
            case VISUALIZACION_SIN_COLOR:
                return mapearSinColor(elemento);
            case VISUALIZACION_RAW:
                return mapearRaw(elemento);
            case VISUALIZACION_COLISIONES:
                return tipoTerreno(elemento);
        }
        return "";
    }

    private static String mapearRaw(char elemento) {

        HashMap<String, String> tiles = new HashMap<>();

        tiles.put(" ", " ");
        tiles.put(".", ".");
        tiles.put("-", "-");
        tiles.put("=", "=");
        tiles.put("|", "|");
        tiles.put(":", ":");
        tiles.put("+", "+");
        tiles.put("O", "O");
        tiles.put("#", "#");
        tiles.put("*", "*");
        tiles.put("$", "$");
        tiles.put("X", "X");
        tiles.put("%", "%");
        tiles.put("_", "_");
        tiles.put("~", "~");
        tiles.put("B", "B");
        tiles.put("P", "P");
        tiles.put("D", "D");
        tiles.put("S", "S");
        tiles.put("C", "C");

        return tiles.get("" + elemento);
    }

    static String mapearSinColor(char elemento) {

        HashMap<String, String> tiles = new HashMap<>();

        tiles.put(" ", " ~~ ");
        tiles.put(".", " . .");
        tiles.put("-", "[##]");
        tiles.put("=", "||||");
        tiles.put("|", "[##]");
        tiles.put(":", "oO*o");
        tiles.put("+", "..:.");
        tiles.put("O", "[  ]");
        tiles.put("#", "::::");
        tiles.put("*", "    ");
        tiles.put("$", "$$$$");
        tiles.put("X", "||||");
        tiles.put("%", "%%%%");
        tiles.put("_", "____");
        tiles.put("~", " ~ ~");
        tiles.put("B", "====");
        tiles.put("P", "_()_");
        tiles.put("D", "    ");
        tiles.put("S", " () ");
        tiles.put("C", "    ");

        return tiles.get("" + elemento);
    }

    static String mapearNormal(char elemento) {

        HashMap<String, String> tiles = new HashMap<>();

        tiles.put(" ", BLUE_BOLD_BRIGHT + BLUE_BACKGROUND_BRIGHT + " ~~ " + RESET);
        tiles.put(".", YELLOW_BRIGHT + GREEN_BACKGROUND + " . ." + RESET);
        tiles.put("-", WHITE + WHITE_BACKGROUND + "[##]" + RESET);
        tiles.put("=", BLACK_BACKGROUND_BRIGHT + "||||" + RESET);
        tiles.put("|", WHITE + WHITE_BACKGROUND + "[##]" + RESET);
        tiles.put(":", YELLOW_BRIGHT + GREEN_BACKGROUND + "oO*o" + RESET);
        tiles.put("+", GREEN_BOLD + YELLOW_BACKGROUND + "..:." + RESET);
        tiles.put("O", WHITE_BACKGROUND_BRIGHT + "[  ]" + RESET);
        tiles.put("#", BLACK + RED_BACKGROUND + "::::" + RESET);
        tiles.put("*", YELLOW + YELLOW_BACKGROUND + "    " + RESET);
        tiles.put("$", RED_BRIGHT + YELLOW_BACKGROUND + "$$$$" + RESET);
        tiles.put("X", RED_UNDERLINED + YELLOW_BACKGROUND + "||||" + RESET);
        tiles.put("%", GREEN_BOLD + YELLOW_BACKGROUND + "%%%%" + RESET);
        tiles.put("_", BLACK + "____" + RESET);
        tiles.put("~", BLUE_BACKGROUND_BRIGHT + " ~ ~" + RESET);
        tiles.put("B", BLUE + BLUE_BACKGROUND + "====" + RESET);
        tiles.put("P", RED + "_()_" + RESET);
        tiles.put("D", BLACK_BACKGROUND_BRIGHT + "    " + RESET);
        tiles.put("S", YELLOW_BOLD_BRIGHT + BLUE_BACKGROUND + " () " + RESET);
        tiles.put("C", BLUE_BACKGROUND + "    " + RESET);

        return tiles.get("" + elemento);
    }

    static String tipoTerreno(char elemento) {

        HashMap<String, String> tiles = new HashMap<>();

        tiles.put(" ", "1");
        tiles.put(".", "0");
        tiles.put("-", "1");
        tiles.put("=", "0");
        tiles.put("|", "1");
        tiles.put(":", "0");
        tiles.put("+", "0");
        tiles.put("O", "0");
        tiles.put("#", "0");
        tiles.put("*", "0");
        tiles.put("$", "0");
        tiles.put("X", "0");
        tiles.put("%", "0");
        tiles.put("_", "0");
        tiles.put("~", "1");
        tiles.put("B", "0");
        tiles.put("P", "*");
        tiles.put("D", "0");
        tiles.put("S", "0");
        tiles.put("C", "0");

        return tiles.get("" + elemento);
    }

    static void mover(int[] unPersonaje, int derecha2, String[] castillo) {

        int oldFila = unPersonaje[FILA];
        int oldColumna = unPersonaje[COLUMNA];

        unPersonaje[FILA] += MOVIMIENTO[derecha2][FILA];
        unPersonaje[COLUMNA] += MOVIMIENTO[derecha2][COLUMNA];

        if (!tipoTerreno(castillo[unPersonaje[FILA]].charAt(unPersonaje[COLUMNA])).equals("0")) {
            unPersonaje[FILA] = oldFila;
            unPersonaje[COLUMNA] = oldColumna;
        }

        if (unPersonaje[FILA] < minFila) {
            unPersonaje[FILA] = unPersonaje[FILA] + 1;
        }
        if (unPersonaje[FILA] > maxFila) {
            unPersonaje[FILA] = unPersonaje[FILA] - 1;
        }
        if (unPersonaje[COLUMNA] < minColumna) {
            unPersonaje[COLUMNA] = unPersonaje[COLUMNA] + 1;
        }
        if (unPersonaje[COLUMNA] > maxColumna) {
            unPersonaje[COLUMNA] = unPersonaje[COLUMNA] - 1;
        }
    }

    static void printMaze(int[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == PATH) {
                    System.out.print("X ");
                } else if (maze[i][j] == FREE) {
                    System.out.print(". ");
                } else {
                    System.out.print("# ");
                }
            }
            System.out.println();
        }
        System.out.println();
        try {
            Thread.sleep(500); 
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static boolean solveMaze(int[][] maze, int x, int y, String[] elMundo, int[]elPersonaje) {
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length) {
            System.out.println("Intentando mover a (" + y + ", " + x + "): Fuera de los límites del laberinto.");
            return false;
        }
        if (maze[x][y] != FREE) {
            System.out.println("Intentando mover a (" + y + ", " + x + "): Celda bloqueada o ya visitada.");
            return false;
        }
        if (x == maze.length - 1 && y == maze[0].length - 1) {
            maze[x][y] = PATH;
            System.out.println("Moviendo a (" + y + ", " + x + "): ¡Ruta encontrada!");
            printMaze(maze);
            return true;
        }

        maze[x][y] = PATH;
        System.out.println("Moviendo a (" + y + ", " + x + "): Marcando como parte del camino.");
        printMaze(maze);

        if (solveMaze(maze, x + 1, y, elMundo, elPersonaje)) {
            return true;
        }
        if (solveMaze(maze, x, y + 1, elMundo, elPersonaje)) {
            return true;
        }
        if (solveMaze(maze, x - 1, y, elMundo, elPersonaje)) {
            return true;
        }
        if (solveMaze(maze, x, y - 1, elMundo, elPersonaje)) {
            return true;
        }

        maze[x][y] = VISITED;
        System.out.println("Moviendo a (" + y + ", " + x + "): Marcando como visitado y retrocediendo.");
        printMaze(maze);
        return false;
    }

    
    static void verAccion(int[] elPersonaje, String[] elMundo) {
        switch (capturarMovimiento()) {
            case ARRIBA:
                mover(elPersonaje, ARRIBA, elMundo);
                break;
            case ABAJO:
                mover(elPersonaje, ABAJO, elMundo);
                break;
            case IZQUIERDA:
                mover(elPersonaje, IZQUIERDA, elMundo);
                break;
            case DERECHA:
                mover(elPersonaje, DERECHA, elMundo);
                break;
            case SALIR:
                jugando = false;
                break;
            case CAMBIA_VISUALIZACION:
                cambiaVisualizacion();
                break;
            case 'P':
                moverHaciaDestino(elPersonaje, elMundo, 40, 42);
                break;
            case NADA:
                break;
        }
    }

    static void moverHaciaDestino(int[] elPersonaje, String[] elMundo, int filaDestino, int columnaDestino) {
        int[][] maze = new int[elMundo.length][elMundo[0].length()];
        for (int i = 0; i < elMundo.length; i++) {
            for (int j = 0; j < elMundo[i].length(); j++) {
                maze[i][j] = (elMundo[i].charAt(j) == '.') ? FREE : NADA;
            }
        }


        maze[elPersonaje[FILA]][elPersonaje[COLUMNA]] = FREE;

        if (solveMaze(maze, elPersonaje[COLUMNA], elPersonaje[FILA], elMundo, elPersonaje)) {
            for (int i = 1; i < maze.length; i++) {
                for (int j = 1; j < maze[i].length; j++) {
                    if (maze[i][j] == PATH) {
                        elPersonaje[FILA] = i;
                        elPersonaje[COLUMNA] = j;
                        imprimirMundo(elMundo, elPersonaje); 
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        } else {
            System.out.println("No se encontró una ruta hacia el destino.");
        }
    }

    static boolean esPosicionValida(int fila, int columna, String[] elMundo) {
        return fila >= 0 && fila < elMundo.length && columna >= 0 && columna < elMundo[0].length() && elMundo[fila].charAt(columna) == '.';
    }

    static void cambiaVisualizacion() {
        modoVisualizacion++;
        if (modoVisualizacion > 3) {
            modoVisualizacion = 0;
        }
    }

    static int capturarMovimiento() {

        switch (pedirChar()) {
            case 's', 'S', '8':
                return ABAJO;
            case 'w', 'W', '2':
                return ARRIBA;
            case 'a', 'A', '4':
                return IZQUIERDA;
            case 'd', 'D', '6':
                return DERECHA;
            case 'f', 'F':
                return SALIR;
            case 'v', 'V':
                return CAMBIA_VISUALIZACION;
            case 'P', 'p':
                return 'P';
        }
        return NADA;
    }

    static char pedirChar() {

        Scanner entrada = new Scanner(System.in);
        String inputUsuario = entrada.nextLine() + "x"; // Este es un caso que justifica un comentario!
        return inputUsuario.charAt(0); // Lo comentamos en clase ;)
    }

    static void limpiarPantalla() {

        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void imprimirElCielo() {

        imprimirLinea();
        for (int i = 0; i < viewPort * 2 + 1; i = i + 1) {
            if ((hora > 6) && (hora <= 18) && (i == (int) (((viewPort * 2)) - ((hora - 7) * (viewPort * 2) / 12)))) {
                System.out.print(mapear('S', modoVisualizacion));
            } else {
                System.out.print(mapear('C', modoVisualizacion));
            }
        }
        System.out.println();
        imprimirLinea();
    }

    
    
    
    public static final String RESET = "\033[0m";

    public static final String BLACK = "\033[0;30m";
    public static final String RED = "\033[0;31m";
    public static final String GREEN = "\033[0;32m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    public static final String PURPLE = "\033[0;35m";
    public static final String CYAN = "\033[0;36m";
    public static final String WHITE = "\033[0;37m";

    public static final String BLACK_BOLD = "\033[1;30m";
    public static final String RED_BOLD = "\033[1;31m";
    public static final String GREEN_BOLD = "\033[1;32m";
    public static final String YELLOW_BOLD = "\033[1;33m";
    public static final String BLUE_BOLD = "\033[1;34m";
    public static final String PURPLE_BOLD = "\033[1;35m";
    public static final String CYAN_BOLD = "\033[1;36m";
    public static final String WHITE_BOLD = "\033[1;37m";

    public static final String BLACK_UNDERLINED = "\033[4;30m";
    public static final String RED_UNDERLINED = "\033[4;31m";
    public static final String GREEN_UNDERLINED = "\033[4;32m";
    public static final String YELLOW_UNDERLINED = "\033[4;33m";
    public static final String BLUE_UNDERLINED = "\033[4;34m";
    public static final String PURPLE_UNDERLINED = "\033[4;35m";
    public static final String CYAN_UNDERLINED = "\033[4;36m";
    public static final String WHITE_UNDERLINED = "\033[4;37m";

    public static final String BLACK_BACKGROUND = "\033[40m";
    public static final String RED_BACKGROUND = "\033[41m";
    public static final String GREEN_BACKGROUND = "\033[42m";
    public static final String YELLOW_BACKGROUND = "\033[43m";
    public static final String BLUE_BACKGROUND = "\033[44m";
    public static final String PURPLE_BACKGROUND = "\033[45m";
    public static final String CYAN_BACKGROUND = "\033[46m";
    public static final String WHITE_BACKGROUND = "\033[47m";

    public static final String BLACK_BRIGHT = "\033[0;90m";
    public static final String RED_BRIGHT = "\033[0;91m";
    public static final String GREEN_BRIGHT = "\033[0;92m";
    public static final String YELLOW_BRIGHT = "\033[0;93m";
    public static final String BLUE_BRIGHT = "\033[0;94m";
    public static final String PURPLE_BRIGHT = "\033[0;95m";
    public static final String CYAN_BRIGHT = "\033[0;96m";
    public static final String WHITE_BRIGHT = "\033[0;97m";

    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m";
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m";
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m";

    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m";
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";
}