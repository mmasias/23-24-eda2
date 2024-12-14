import java.util.Scanner;

public class Menu {
    private final String[] OPCIONES_KLONDIKE = new String[] {
            "1. Mover de Baraja a Descarte",
            "2. Mover de Descarte a Palo",
            "3. Mover de Descarte a Columna",
            "4. Mover de Palo a Columna",
            "5. Mover de Columna a Palo",
            "6. Mover de Columna a Columna",
            "7. Voltear carta de Columna",
            "8. Voltear Descarte en Baraja",
            "9. Salir"
    };

    private final String[] OPCIONES_INICIO = new String[] {
            "1. Jugar klondike",
            "2. Ordenar Baraja [RETO-007]",
            "3. Salir",
    };

    private final String[] OPCIONES_BARAJA = new String[] {
            "1. Ordenar por numeros",
            "2. Ordenar por palos",
            "3. Salir"
    };

    private final Intervalo OPCIONES_KLON = new Intervalo(1, 9);
    private final Intervalo OPCIONES = new Intervalo(1,3);

    private void mostrarMenu(String[] opciones) {
        System.out.println("OPCIONES>");
        for (String titulo : opciones) {
            System.out.println(titulo);
        }
    }

    public void mostrarKlondike() {
        mostrarMenu(OPCIONES_KLONDIKE);
    }

    public void mostrarInicio() {
        mostrarMenu(OPCIONES_INICIO);
    }

    public void mostrarBaraja() {
        mostrarMenu(OPCIONES_BARAJA);
    }

    public int getOpcionKlondike() {
        return getOpcion(OPCIONES_KLON);
    }

    public int getOpcion() {
        return getOpcion(OPCIONES);
    }

    private int getOpcion(Intervalo intervalo) {
        int opcion;
        boolean error;
        do {
            System.out.println("Elige una opción  [" + (int) intervalo.getInferior() + "-" + (int) intervalo.getSuperior() + "]");
            opcion = new Scanner(System.in).nextInt();
            error = !intervalo.incluye(opcion);
        } while (error);
        return opcion;
    }
}
