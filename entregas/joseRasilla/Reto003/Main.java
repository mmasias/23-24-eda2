import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Add Document");
            System.out.println("2. Search Document");
            System.out.println("3. Delete Document");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addDocument(scanner, library);
                    break;
                case 2:
                    searchDocument(scanner, library);
                    break;
                case 3:
                    deleteDocument(scanner, library);
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice! Please enter a number between 1 and 4.");
            }
        }
    }

    private static void addDocument(Scanner scanner, Library library) {
        System.out.println("Adding Document");
        System.out.print("Enter document title: ");
        String title = scanner.nextLine();
        System.out.print("Enter author(s) (separated by commas): ");
        List<Author> authors = new ArrayList<>();
        String[] authorNames = scanner.nextLine().split(",");
        for (String authorName : authorNames) {
            String[] nameParts = authorName.trim().split(" ");
            authors.add(new Author(nameParts[0], nameParts[1]));
        }
        System.out.print("Enter publication year: ");
        int year = scanner.nextInt();
        scanner.nextLine();  // consume newline
        System.out.print("Enter document type: ");
        String type = scanner.nextLine();
        System.out.print("Enter keywords (separated by commas): ");
        List<String> keywords = List.of(scanner.nextLine().split(","));

        // Add document to library
        Document document = new Document(title, authors, year, type, keywords);
        library.addDocument(document);
        System.out.println("Document added successfully!");
    }

    private static void searchDocument(Scanner scanner, Library library) {
        System.out.println("Search Document");
        System.out.println("1. By Title");
        System.out.println("2. By Author");
        System.out.println("3. By Year");
        System.out.println("4. By Type");
        System.out.println("5. By Keyword");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();  // consume newline

        List<Document> results = new ArrayList<>();
        switch (choice) {
            case 1:
                System.out.print("Enter document title to search: ");
                results = library.findByTitle(scanner.nextLine());
                break;
            case 2:
                System.out.print("Enter author name to search: ");
                results = library.findByAuthor(scanner.nextLine());
                break;
            case 3:
                System.out.print("Enter publication year to search: ");
                results = library.findByYear(scanner.nextInt());
                break;
            case 4:
                System.out.print("Enter document type to search: ");
                results = library.findByType(scanner.nextLine());
                break;
            case 5:
                System.out.print("Enter keyword to search: ");
                results = library.findByKeyWord(scanner.nextLine());
                break;
            default:
                System.out.println("Invalid choice! Please enter a number between 1 and 5.");
                return;
        }

        if (results.isEmpty()) {
            System.out.println("No documents found!");
        } else {
            System.out.println("Search Results:");
            for (Document doc : results) {
                System.out.println(doc.getTitulo() + " by " + doc.getAuthors() + ", Year: " + doc.getPublicationYear());
            }
        }
    }

    private static void deleteDocument(Scanner scanner, Library library) {
        System.out.println("Delete Document");
        System.out.print("Enter document title to delete: ");
        String title = scanner.nextLine();

        List<Document> documents = library.findByTitle(title);
        if (documents.isEmpty()) {
            System.out.println("Document not found!");
        } else if (documents.size() == 1) {
            library.deleteDocument(documents.get(0));
            System.out.println("Document deleted successfully!");
        } else {
            System.out.println("Multiple documents found with the same title. Please refine your search.");
        }
    }
}
