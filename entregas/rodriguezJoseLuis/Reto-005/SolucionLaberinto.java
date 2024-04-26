import java.util.*;

public class SolucionLaberinto {
    static int[] posicionPersonaje = { 30, 33 };
    static int[] puntoFinal = { 9, 10  };
    static final int FILA = 0;
    static final int COLUMNA = 1;
    private static final int PATH = 2;
    static final int ARRIBA = 0;
    static final int ABAJO = 1;
    static final int IZQUIERDA = 2;
    static final int DERECHA = 3;
    static final int SALIR = 4;
    static final int NADA = 999;
    static final int VISUALIZACION_NORMAL = 0;
    static final int VISUALIZACION_COLISIONES = 3;
    private static final String VISITED = "Z";
    static final int[][] MOVIMIENTO = {
            { -1, 0 },
            { 1, 0 },
            { 0, -1 },
            { 0, 1 }
    };

    static int modoVisualizacion = VISUALIZACION_NORMAL;
    static int minFila, minColumna, maxFila, maxColumna;
    static boolean estaJugando = true;
    static int alcanceDeVision;
    static double hora = 9.0;
    static int alcanceVision;
    static String[] castilloLB = {
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

    public static void main(String[] args) {
        iniciarLaberinto(castilloLB);
        imprimirBusqueda();
    }

    private static void imprimirBusqueda() {
        if (buscandoCamino(posicionPersonaje, castilloLB)) {
            System.out.println("Se encontró un camino hacia el final:");
            imprimirMundo(castilloLB, posicionPersonaje);
        } else {
            System.out.println("No se encontró un camino hacia el final.");
        }

    }

    private static void iniciarLaberinto(String[] mundo) {
        alcanceDeVision = 7;
        alcanceVision = alcanceDeVision / 2;
        minFila = 0 + alcanceDeVision;
        minColumna = 0 + alcanceDeVision;
        maxFila = mundo.length - (alcanceDeVision + 1);
        maxColumna = mundo[0].length() - (alcanceDeVision + 1);
    }

    static void imprimirMundo(String[] castillo, int[] personaje) {
        actualizarTiempo();

        String elemento;
        limpiarConsola();
        imprimirCielo();
        for (int fila = personaje[FILA] - alcanceDeVision; fila <= personaje[FILA] + alcanceDeVision; fila++) {
            for (int columna = personaje[COLUMNA] - alcanceDeVision; columna <= personaje[COLUMNA]
                    + alcanceDeVision; columna++) {

                elemento = mapear('P', modoVisualizacion);
                if (!(fila == personaje[FILA] && columna == personaje[COLUMNA])) {
                    elemento = mapear(castillo[fila].charAt(columna), modoVisualizacion);
                }

                if (!(Math.pow((fila - personaje[FILA]), 2)
                        + Math.pow((columna - personaje[COLUMNA]), 2) <= alcanceVision * alcanceVision)) {
                    elemento = mapear('D', modoVisualizacion);
                }
                System.out.print(elemento);
            }
            System.out.println();
        }
        imprimirEstado(personaje);
    }

    private static void imprimirEstado(int[] personaje) {
        imprimirLinea();
        System.out.print("HORA: [" + (int) hora + "] ");
        System.out.println("/ (" + personaje[FILA] + "," + personaje[COLUMNA] + ")");
    }

    static String mapear(char elemento, int modoVisualizacion) {
        switch (modoVisualizacion) {
            case VISUALIZACION_NORMAL:
                return mapearNormal(elemento);
            case VISUALIZACION_COLISIONES:
                System.out.println("Colision");
                return tipoTerreno(elemento);
        }
        return "";
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
        tiles.put("Z", "3");

        return tiles.get("" + elemento);
    }

    static void mover(int[] unPersonaje, int direccion, String[] mapa) {

        int oldFila = unPersonaje[FILA];
        int oldColumna = unPersonaje[COLUMNA];

        unPersonaje[FILA] += MOVIMIENTO[direccion][FILA];
        unPersonaje[COLUMNA] += MOVIMIENTO[direccion][COLUMNA];

        if (!tipoTerreno(mapa[unPersonaje[FILA]].charAt(unPersonaje[COLUMNA])).equals("0")) {
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

    static boolean buscandoCamino(int[] unPersonaje, String[] mapa) {
        int fila = unPersonaje[FILA];
        int columna = unPersonaje[COLUMNA];

        if (fila < 0 || fila >= mapa.length || columna < 0 || columna >= mapa[0].length()) {
            return false;
        }

        if (fila == puntoFinal[FILA] && columna == puntoFinal[COLUMNA]) {
            System.out.println("Llegaste al final del laberinto!!!");
            mapa[fila] = mapa[fila].substring(0, columna) + (char) PATH + mapa[fila].substring(columna + 1);
            System.out.println("Se encontró un camino hacia el final:");
            imprimirMundo(mapa, unPersonaje);
            return true;
        }

        if (!tipoTerreno(mapa[fila].charAt(columna)).equals("0")) {
            System.out.println("Intentando mover a (" + fila + "," + columna + "): Celda bloqueada o ya visitada.");
            return false;
        }

        System.out.println("Moviendo a (" + fila + "," + columna + "): Marcando como parte del camino");
        imprimirMundo(mapa, unPersonaje);
        new Scanner(System.in).nextLine();
        mapa[fila] = mapa[fila].substring(0, columna) + VISITED + mapa[fila].substring(columna + 1);

        boolean caminoEncontrado = buscandoCamino(new int[] { fila + 1, columna }, mapa) ||
                buscandoCamino(new int[] { fila - 1, columna }, mapa) ||
                buscandoCamino(new int[] { fila, columna + 1 }, mapa) ||
                buscandoCamino(new int[] { fila, columna - 1 }, mapa);

        if (caminoEncontrado) {
            mapa[fila] = mapa[fila].substring(0, columna) + (char) PATH + mapa[fila].substring(columna + 1);
        }

        return caminoEncontrado;
    }

    static void verAccion(int[] posicionPersonaje, String[] elMundo) {
        switch (capturarMovimiento()) {
            case ARRIBA:
                mover(posicionPersonaje, ARRIBA, elMundo);
                break;
            case ABAJO:
                mover(posicionPersonaje, ABAJO, elMundo);
                break;
            case IZQUIERDA:
                mover(posicionPersonaje, IZQUIERDA, elMundo);
                break;
            case DERECHA:
                mover(posicionPersonaje, DERECHA, elMundo);
                break;
            case SALIR:
                estaJugando = !estaJugando;
                break;
            case NADA:
                break;
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
        }
        return NADA;
    }

    static char pedirChar() {
        Scanner entrada = new Scanner(System.in);
        String inputUsuario = entrada.nextLine() + "x";
        return inputUsuario.charAt(0);
    }

    static void limpiarConsola() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void imprimirCielo() {
        imprimirLinea();
        for (int i = 0; i < alcanceDeVision * 2 + 1; i = i + 1) {
            if ((hora > 6) && (hora <= 18)
                    && (i == (int) (((alcanceDeVision * 2)) - ((hora - 7) * (alcanceDeVision * 2) / 12)))) {
                System.out.print(mapear('S', modoVisualizacion));
            } else {
                System.out.print(mapear('C', modoVisualizacion));
            }
        }
        System.out.println();
        imprimirLinea();
    }

    static void actualizarTiempo() {
        hora = hora + 0.2;
        if (hora >= 24) {
            hora = 0;
        }
        calculaAlcanceVision();
    }

    static void calculaAlcanceVision() {

        alcanceVision = alcanceDeVision * 2;

        if (hora < 1 || hora > 23) {
            alcanceVision = 1;
        } else if (hora < 3 || hora > 21) {
            alcanceVision = alcanceVision / 5;
        } else if (hora < 4 || hora > 20) {
            alcanceVision = alcanceVision / 5 * 2;
        } else if (hora < 5 || hora > 19) {
            alcanceVision = alcanceVision / 5 * 3;
        } else if (hora < 6 || hora > 18) {
            alcanceVision = alcanceVision / 5 * 4;
        }
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
        tiles.put("Z", RED_BACKGROUND + "    " + RESET);
        return tiles.get("" + elemento);
    }

    static void imprimirLinea() {
        System.out.println(SolucionLaberinto.mapear('B', modoVisualizacion).repeat(alcanceDeVision * 2 + 1));
    }

    public static final String RESET = "\033[0m";
    public static final String BLACK = "\033[0;30m";
    public static final String RED = "\033[0;31m";
    public static final String YELLOW = "\033[0;33m";
    public static final String BLUE = "\033[0;34m";
    public static final String WHITE = "\033[0;37m";
    public static final String GREEN_BOLD = "\033[1;32m";
    public static final String RED_UNDERLINED = "\033[4;31m";
    public static final String RED_BACKGROUND = "\033[41m";
    public static final String GREEN_BACKGROUND = "\033[42m";
    public static final String YELLOW_BACKGROUND = "\033[43m";
    public static final String BLUE_BACKGROUND = "\033[44m";
    public static final String WHITE_BACKGROUND = "\033[47m";
    public static final String RED_BRIGHT = "\033[0;91m";
    public static final String YELLOW_BRIGHT = "\033[0;93m";
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";
}