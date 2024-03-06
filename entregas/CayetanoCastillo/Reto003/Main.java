import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BibliotecaDigital biblioteca = new BibliotecaDigital();
        List<Usuario> usuarios = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Agregar documento");
            System.out.println("2. Eliminar documento por título");
            System.out.println("3. Buscar documento por título");
            System.out.println("4. Listar todos los documentos");
            System.out.println("5. Prestar documento a usuario");
            System.out.println("6. Devolver documento por usuario");
            System.out.println("7. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:

                    System.out.println("Introduzca el título:");
                    String titulo = scanner.nextLine();
                    System.out.println("Introduzca el año de publicación:");
                    int fechaPublicacion = scanner.nextInt();
                    scanner.nextLine();
                    System.out.println("Introduzca los autores separados por coma:");
                    String autoresStr = scanner.nextLine();
                    ArrayList<String> autores = new ArrayList<>(Arrays.asList(autoresStr.split("\\s*,\\s*")));
                    System.out.println("Introduzca el tipo de documento (libro, revista, artículo, paper):");
                    String tipo = scanner.nextLine();
                    System.out.println("Introduzca palabras clave separadas por coma:");
                    String palabrasClaveStr = scanner.nextLine();
                    ArrayList<String> palabrasClave = new ArrayList<>(
                            Arrays.asList(palabrasClaveStr.split("\\s*,\\s*")));
                    System.out.println("Introduzca la cantidad que desea agregar de ejemplares");
                    int cantidad = scanner.nextInt();

                    Documento nuevoDocumento = new Documento(titulo, autores, fechaPublicacion, tipo, palabrasClave,
                            cantidad) {

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
                            System.out.println(doc.getTitulo() + " - " + doc.getCantidad());
                        }
                    } else {
                        System.out.println("No se encontraron documentos.");
                    }
                    break;
                case 4:
                    System.out.println("Documentos en la biblioteca:");
                    for (Documento doc : biblioteca.getDocumentos()) {
                        System.out.println(doc.getTitulo() + " - " + doc.getCantidad());
                    }
                    break;
                case 5:
                    System.out.println("Ingrese el nombre del usuario:");
                    String nombreUsuario = scanner.nextLine();
                    Usuario usuario = usuarios.stream()
                            .filter(u -> u.getNombre().equals(nombreUsuario))
                            .findFirst()
                            .orElseGet(() -> {
                                Usuario nuevoUsuario = new Usuario(nombreUsuario);
                                usuarios.add(nuevoUsuario);
                                return nuevoUsuario;
                            });

                    System.out.println("Ingrese el título del documento a prestar:");
                    String tituloPrestar = scanner.nextLine();

                    System.out.println("Ingrese la fecha de devolución (formato: YYYY-MM-DD):");
                    String fecha = scanner.nextLine();
                    LocalDate fechaDevolucion = LocalDate.parse(fecha);

                    if (biblioteca.prestarDocumentoAUsuario(usuario, tituloPrestar, fechaDevolucion)) {
                        System.out.println("Documento prestado con éxito.");
                    } else {
                        System.out.println("No se pudo prestar el documento.");
                    }
                    break;
                case 6:
                    System.out.println("Ingrese el nombre del usuario que devuelve el documento:");
                    String nombreUsuarioDevuelve = scanner.nextLine();
                    Usuario usuarioDevuelve = usuarios.stream()
                            .filter(u -> u.getNombre().equals(nombreUsuarioDevuelve))
                            .findFirst()
                            .orElse(null);

                    if (usuarioDevuelve == null) {
                        System.out.println("Usuario no encontrado.");
                        break;
                    }

                    System.out.println("Ingrese el título del documento a devolver:");
                    String tituloDevolver = scanner.nextLine();

                    biblioteca.recibirDocumentoDeUsuario(usuarioDevuelve, tituloDevolver);
                    System.out.println("Documento devuelto con éxito.");
                    break;
                case 7:
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
