import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryManager {
    private List<Book> books = new ArrayList<>();
    private List<Author> authors = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    private int bookIdCounter = 1;
    private int authorIdCounter = 1;

    public void startLibraryManager() {
        System.out.println("Bienvenido al Gestor de Biblioteca");
        boolean isWorking = true;
        while (isWorking) {
            System.out.println("\nElige una opción:");
            System.out.println("1. Agregar un nuevo libro");
            System.out.println("2. Listar libros");
            System.out.println("3. Listar autores");
            System.out.println("9. Salir");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addBook();
                    break;
                case "2":
                    listBooks();
                    break;
                case "3":
                    listAuthors();
                    break;
                case "9":
                    System.out.println("Saliendo del gestor de biblioteca...");
                    isWorking = false;
                    break;
                default:
                    System.out.println("Opción no válida, intenta de nuevo.");
                    break;
            }
        }
    }

    private void addBook() {
        System.out.println("Introduce el título del libro:");
        String title = scanner.nextLine();
        System.out.println("Introduce el año de publicación:");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.println("Introduce el tipo de libro:");
        String type = scanner.nextLine();

        Book newBook = new Book(bookIdCounter++, title, year, type);
        books.add(newBook);
        System.out.println("Libro añadido. ¿Deseas añadir autores a este libro? (s/n)");
        String response = scanner.nextLine();
        if ("s".equalsIgnoreCase(response)) {
            addAuthorToBook(newBook);
        }
    }

    private void addAuthorToBook(Book book) {
        boolean addingAuthors = true;
        while (addingAuthors) {
            System.out.println("Introduce el nombre del autor:");
            String name = scanner.nextLine();

            Author author = findAuthorByName(name);
            if (author == null) { // Si el autor no existe, se crea uno nuevo.
                author = new Author(authorIdCounter++, name);
                authors.add(author);
            }
            book.addAuthor(author);

            System.out.println("Autor añadido. ¿Deseas añadir otro autor a este libro? (s/n)");
            addingAuthors = "s".equalsIgnoreCase(scanner.nextLine());
        }
    }

    private Author findAuthorByName(String name) {
        for (Author author : authors) {
            if (author.getName().equalsIgnoreCase(name)) {
                return author;
            }
        }
        return null;
    }

    private void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No hay libros en la biblioteca.");
        } else {
            books.forEach(System.out::println);
        }
    }

    private void listAuthors() {
        if (authors.isEmpty()) {
            System.out.println("No hay autores disponibles.");
        } else {
            authors.forEach(System.out::println);
        }
    }

}