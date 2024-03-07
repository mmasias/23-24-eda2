package entregas.mayenSergio.Reto_003;

import java.util.List;
import java.util.Scanner;

public class Menu {

    private static Scanner scanner = new Scanner(System.in);

    public static void mostrarMenu(List<Documento> documentos) {
        int opcion;
        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Editar documento");
            System.out.println("2. Eliminar documento");
            System.out.println("3. Buscar documento");
            System.out.println("4. Mostrar lista de documentos");
            System.out.println("5. Salir");

            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    GeneradorDocumentos.editarDocumento(documentos);
                    break;
                case 2:
                    GeneradorDocumentos.eliminarDocumento(documentos);
                    break;
                case 3:
                    GeneradorDocumentos.buscarDocumento(documentos);
                    break;
                case 4:
                    System.out.println("\nLista de documentos:");
                    for (Documento documento : documentos) {
                        System.out.println(documento);
                    }
                    System.out.println();
                    break;
                case 5:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.\n");
            }
        } while (opcion != 5);
    }
}