import java.util.Scanner;

public class Menu {

    private final String[] TITULOS = {
            "1. Mover de Descarte a Palo",
            "2. Mover de Descarte a Columna",
            "3. Mover de Columna a Palo",
            "4. Mover de Columna a Columna",
            "5. Mover de Palo a Columna",
            "6. Barajar Descarte en Baraja",
            "7. Mostrar Cartas",
            "8. Voltear Descarte en Baraja",
            "9. Ordenar Baraja",
            "10. Salir"
    };

    private final Intervalo OPCIONES = new Intervalo(1, 10);

    public void mostrar() {
        System.out.println("OPCIONES>");
        for (String titulo : TITULOS) {
            System.out.println(titulo);
        }
    }

    public int getOpcion() {
        int opcion;
        boolean error;
        do {
            System.out.println("Elige una opción [1-10]");
            opcion = new Scanner(System.in).nextInt();
            error = !OPCIONES.incluye(opcion);
        } while (error);
        return opcion;
    }
}
