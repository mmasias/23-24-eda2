package entregas.garciaLydia.parcial;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class LibraryManager {
    private List<Book> books;
    private List<Author> authors;
    private List<BookAuthor> bookAuthors;
    private Scanner scanner;

    public LibraryManager() {
        this.books = new ArrayList<>();
        this.authors = new ArrayList<>();
        this.bookAuthors = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void startLibraryManager() {
        boolean running = true;
        while (running) {
            System.out.println("1. List Books");
            System.out.println("2. Add Book");
            System.out.println("3. List Authors");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            try {
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (choice) {
                    case 1:
                        listBooks();
                        break;
                    case 2:
                        addBook();
                        break;
                    case 3:
                        listAuthors();
                        break;
                    case 4:
                        running = false;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid command. Please enter a numeric value.");
                scanner.nextLine(); // Clear the input buffer
            }
        }
        scanner.close();
    }

    private void listBooks() {
        System.out.println("Books:");
        for (Book book : books) {
            System.out.println(book);
        }
        System.out.println();
    }

    private void addBook() {
        System.out.println("Enter book details:");
        int id;
        String title;
        int publicationYear;
        String type;
        do {
            try {
                System.out.print("ID: ");
                id = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value for ID.");
                scanner.nextLine(); // Clear the input buffer
            }
        } while (true);

        System.out.print("Title: ");
        title = scanner.nextLine();

        do {
            try {
                System.out.print("Publication Year: ");
                publicationYear = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                break;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a numeric value for Publication Year.");
                scanner.nextLine(); // Clear the input buffer
            }
        } while (true);

        System.out.print("Type: ");
        type = scanner.nextLine();

        Book book = new Book(id, title, publicationYear, type);

        // Ask for the author and associate it with the book
        System.out.print("Enter author's name: ");
        String authorName = scanner.nextLine();
        Author author = findOrCreateAuthor(authorName);
        BookAuthor bookAuthor = new BookAuthor(author, book);
        bookAuthors.add(bookAuthor);
        book.addBookAuthor(bookAuthor);
        books.add(book);

        System.out.println("Book added successfully.\n");
    }

    private Author findOrCreateAuthor(String name) {
        for (Author author : authors) {
            if (author.getName().equals(name)) {
                return author;
            }
        }
        Author newAuthor = new Author(authors.size() + 1, name);
        authors.add(newAuthor);
        return newAuthor;
    }

    private void listAuthors() {
        System.out.println("Authors:");
        for (Author author : authors) {
            System.out.println(author);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LibraryManager libraryManager = new LibraryManager();
        libraryManager.startLibraryManager();
    }
}

