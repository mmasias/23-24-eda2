import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BibliotecaDigital biblioteca = new BibliotecaDigital();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar documento");
            System.out.println("2. Eliminar documento por título");
            System.out.println("3. Buscar documento por título");
            System.out.println("4. Listar todos los documentos");
            System.out.println("5. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:

                    System.out.println("Introduzca el título:");
                    String titulo = scanner.nextLine();
                    System.out.println("Introduzca el año de publicación:");
                    int anoPublicacion = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.println("Introduzca los autores separados por coma:");
                    String autoresStr = scanner.nextLine();
                    ArrayList<String> autores = new ArrayList<>(Arrays.asList(autoresStr.split("\\s*,\\s*")));
                    System.out.println("Introduzca el tipo de documento (libro, revista, artículo, paper):");
                    String tipo = scanner.nextLine();
                    System.out.println("Introduzca palabras clave separadas por coma:");
                    String palabrasClaveStr = scanner.nextLine();
                    ArrayList<String> palabrasClave = new ArrayList<>(
                            Arrays.asList(palabrasClaveStr.split("\\s*,\\s*")));

                    Documento nuevoDocumento = new Documento(titulo, autores, anoPublicacion, tipo, palabrasClave) {

                    };
                    biblioteca.agregarDocumento(nuevoDocumento);
                    System.out.println("Documento agregado exitosamente.");
                    break;
                case 2:
                    System.out.println("Introduzca el título del documento a eliminar:");
                    String tituloEliminar = scanner.nextLine();
                    if (biblioteca.eliminarDocumento(tituloEliminar)) {
                        System.out.println("Documento eliminado.");
                    } else {
                        System.out.println("Documento no encontrado.");
                    }
                    break;
                case 3:
                    System.out.println("Introduzca el título del documento a buscar:");
                    String tituloBuscar = scanner.nextLine();
                    var resultados = biblioteca.buscarPorCriterio("titulo", tituloBuscar);
                    if (!resultados.isEmpty()) {
                        System.out.println("Documentos encontrados:");
                        for (Documento doc : resultados) {
                            System.out.println(doc.getTitulo() + " - " + doc.getFechaPublicacion());
                        }
                    } else {
                        System.out.println("No se encontraron documentos.");
                    }
                    break;
                case 4:
                    System.out.println("Documentos en la biblioteca:");
                    for (Documento doc : biblioteca.getDocumentos()) {
                        System.out.println(doc.getTitulo() + " - " + doc.getFechaPublicacion());
                    }
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
    }
}
