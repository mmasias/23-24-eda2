import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ManejadorBiblioteca {

    public static void ejecutar() {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenú de la Biblioteca:");
            System.out.println("1. Añadir libro");
            System.out.println("2. Añadir autor a un libro");
            System.out.println("3. Listar todos los libros");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1: // Añadir libro
                    System.out.print("Ingrese el título del libro: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Ingrese el nombre del autor (para varios, sepárelos por coma): ");
                    String autoresStr = scanner.nextLine();
                    List<String> autores = new ArrayList<>(Arrays.asList(autoresStr.split("\\s*,\\s*")));

                    System.out.print("Ingrese el año de publicación: ");
                    int anio = scanner.nextInt();
                    scanner.nextLine(); // Limpiar buffer

                    System.out.print("Ingrese el tipo de documento (LIBRO, REVISTA, ARTICULO, PAPER): ");
                    String tipo = scanner.nextLine().toUpperCase();

                    System.out.print("Ingrese palabras clave (para varias, sepárelas por coma): ");
                    String palabrasClaveStr = scanner.nextLine();
                    List<String> palabrasClave = new ArrayList<>(Arrays.asList(palabrasClaveStr.split("\\s*,\\s*")));

                    // Asume que Biblioteca tiene un método que acepta estos parámetros para añadir un libro
                    biblioteca.agregarLibro(new Libro(titulo, autores, anio, TipoLibro.valueOf(tipo.toUpperCase()), palabrasClave));
                    System.out.println("Libro añadido con éxito.");
                    break;

                case 2: // Añadir autor a un libro
                    System.out.print("Ingrese el título del libro al cual desea añadir un autor: ");
                    titulo = scanner.nextLine();

                    // Asume que Biblioteca tiene un método para buscar un libro por título
                    Libro libroEncontrado = biblioteca.buscarLibroPorTitulo(titulo);

                    if (libroEncontrado != null && libroEncontrado.getAutores().isEmpty()) {
                        System.out.print("Ingrese el nombre del nuevo autor: ");
                        String nuevoAutor = scanner.nextLine();
                        libroEncontrado.getAutores().add(nuevoAutor);
                        System.out.println("Autor añadido con éxito.");
                    } else if (libroEncontrado != null) {
                        System.out.println("Este libro ya tiene autor(es). No se pueden añadir más autores.");
                    } else {
                        System.out.println("No se encontró el libro con el título proporcionado.");
                    }
                    break;

                case 3: // Listar todos los libros
                    biblioteca.mostrarLibros();
                    break;

                case 4: // Salir
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return; // Salir del método ejecutar

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }
}
