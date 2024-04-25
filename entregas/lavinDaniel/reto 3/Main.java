import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        BibliotecaDigital biblioteca = new BibliotecaDigital();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Agregar nuevo documento");
            System.out.println("2. Buscar documentos");
            System.out.println("3. Listar documentos");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    Documento nuevoDocumento = ingresarNuevoDocumento(scanner);
                    biblioteca.agregarDocumento(nuevoDocumento);
                    System.out.println("Documento agregado con éxito.");
                    break;
                case 2:
                    System.out.print("Ingrese el criterio de búsqueda (titulo/autor/año/tipo/palabraclave): ");
                    String criterio = scanner.nextLine();

                    System.out.print("Ingrese el valor de búsqueda: ");
                    String valor = scanner.nextLine();

                    List<Documento> resultadosBusqueda = biblioteca.buscarDocumentos(criterio, valor);
                    if (!resultadosBusqueda.isEmpty()) {
                        System.out.println("Resultados de la búsqueda:");
                        for (Documento documento : resultadosBusqueda) {
                            System.out.println("Título: " + documento.titulo + ", Autores: " + documento.autores +
                                    ", Año: " + documento.añoPublicacion + ", Tipo: " + documento.tipoDocumento +
                                    ", Palabras Clave: " + documento.palabrasClave);
                        }
                    } else {
                        System.out.println("No se encontraron documentos que coincidan con la búsqueda.");
                    }
                    break;
                case 3:
                    System.out.println("Listado de documentos:");
                    for (Documento documento : biblioteca.documentos) {
                        System.out.println("Título: " + documento.titulo + ", Autores: " + documento.autores +
                                ", Año: " + documento.añoPublicacion + ", Tipo: " + documento.tipoDocumento +
                                ", Palabras Clave: " + documento.palabrasClave);
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static Documento ingresarNuevoDocumento(Scanner scanner) {
        System.out.print("Ingrese el título del documento: ");
        String titulo = scanner.nextLine();

        System.out.print("Ingrese los autores del documento (separados por comas): ");
        String autoresString = scanner.nextLine();
        List<String> autores = Arrays.asList(autoresString.split(", "));

        System.out.print("Ingrese el año de publicación del documento: ");
        int añoPublicacion = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese el tipo de documento (Libro/Artículo): ");
        String tipoDocumento = scanner.nextLine();

        System.out.print("Ingrese las palabras clave del documento (separadas por comas): ");
        String palabrasClaveString = scanner.nextLine();
        List<String> palabrasClave = Arrays.asList(palabrasClaveString.split(", "));

        return new Documento(titulo, autores, añoPublicacion, tipoDocumento, palabrasClave);
    }
}
