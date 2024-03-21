import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DigitalLibrary {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DocumentCollection collection = new DocumentCollection();

        performOperations(collection, scanner);
    }

    private static void performOperations(DocumentCollection collection, Scanner scanner) {
        int choice;
        do {
            System.out.println("\n---- Biblioteca Digital ----");
            System.out.println("1. Agregar documento");
            System.out.println("2. Buscar por título");
            System.out.println("3. Buscar por autor");
            System.out.println("4. Buscar por palabras clave");
            System.out.println("5. Mostrar todos los documentos");
            System.out.println("6. Editar documento");
            System.out.println("7. Eliminar documento");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: \n");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addDocument(collection, scanner);
                    break;
                case 2:
                    searchByTitle(collection, scanner);
                    break;
                case 3:
                    searchByAuthor(collection, scanner);
                    break;
                case 4:
                    searchByKeywords(collection, scanner);
                    break;
                case 5:
                    collection.displayDocuments();
                    break;
                case 6:
                    editDocument(collection, scanner);
                    break;
                case 7:
                    removeDocument(collection, scanner);
                    break;
            }
        } while (choice != 0);
    }

    private static void addDocument(DocumentCollection collection, Scanner scanner) {
        System.out.println("Ingrese el título del nuevo documento:\n");
        String title = scanner.nextLine();

        List<Author> authors = new ArrayList<>();
        System.out.println("Ingrese los autores del nuevo documento (separe los nombres con comas):\n");
        String[] authorNames = scanner.nextLine().split(",");
        for (String authorName : authorNames) {
            authors.add(new Author(authorName.trim()));
        }

        System.out.println("Ingrese el año de publicación del nuevo documento:\n");
        int publicationYear = scanner.nextInt();
        scanner.nextLine();

        List<Keywords> keywords = new ArrayList<>();
        System.out.println("Ingrese las palabras clave del nuevo documento (separe las palabras con comas):\n");
        String[] keywordList = scanner.nextLine().split(",");
        for (String keyword : keywordList) {
            keywords.add(new Keywords(keyword.trim()));
        }

        System.out.println("Ingrese el tipo de documento del nuevo documento *en MAYÚSCULA* (LIBRO, REVISTA, ARTICULO, PAPER_CIENTIFICO):\n");
        String input = scanner.nextLine().toUpperCase();

        try {
            DocumentType documentType = DocumentType.valueOf(input);
            Document newDocument = new Document(title, authors, publicationYear, documentType, keywords);
            collection.addDocument(newDocument);
            System.out.println("Documento agregado exitosamente.\n");
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de documento no válido. Por favor, ingrese uno de los siguientes: LIBRO, REVISTA, ARTICULO, PAPER_CIENTIFICO.\n");
        }
        System.out.println("Documento agregado exitosamente.\n");
    }

    private static void searchByTitle(DocumentCollection collection, Scanner scanner) {
        System.out.println("Ingrese el título a buscar:\n");
        String title = scanner.nextLine();
        List<Document> results = collection.searchByTitle(title);

        System.out.println("Resultados de la búsqueda por título:\n");
        displaySearchResults(results);
    }

    private static void searchByAuthor(DocumentCollection collection, Scanner scanner) {
        System.out.println("Ingrese el nombre del autor a buscar:\n");
        String authorName = scanner.nextLine();
        List<Document> results = collection.searchByAuthor(authorName);

        System.out.println("Resultados de la búsqueda por autor:\n");
        displaySearchResults(results);
    }

    private static void searchByKeywords(DocumentCollection collection, Scanner scanner) {
        System.out.println("Ingrese la palabra clave a buscar:\n");
        String keyword = scanner.nextLine();
        List<Document> results = collection.searchByKeywords(keyword);

        System.out.println("Resultados de la búsqueda por palabras clave:\n");
        displaySearchResults(results);
    }

    private static void editDocument(DocumentCollection collection, Scanner scanner) {
        System.out.println("Ingrese el título del documento que desea editar:\n");
        String titleToEdit = scanner.nextLine();

        List<Document> results = collection.searchByTitle(titleToEdit);

        if (results.isEmpty()) {
            System.out.println("No se encontraron documentos con el título proporcionado.\n");
        } else {
            System.out.println("Resultados de la búsqueda:\n");
            displaySearchResults(results);

            System.out.println("Ingrese el número del documento que desea editar:\n");
            int selectedIndex = scanner.nextInt();
            scanner.nextLine();

            if (selectedIndex >= 1 && selectedIndex <= results.size()) {
                Document selectedDocument = results.get(selectedIndex - 1);
                editDocumentDetails(selectedDocument, scanner);
            } else {
                System.out.println("Selección no válida.\n");
            }
        }
    }

    private static void editDocumentDetails(Document document, Scanner scanner) {
        System.out.println("¿Qué detalle desea editar?");
        System.out.println("1. Título");
        System.out.println("2. Año de publicación");
        System.out.println("3. Tipo de documento");
        System.out.println("0. Volver\n");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {
            case 1:
                System.out.println("Ingrese el nuevo título:\n");
                String newTitle = scanner.nextLine();
                document.setTitle(newTitle);
                break;
            case 2:
                System.out.println("Ingrese el nuevo año de publicación:\n");
                int newPublicationYear = scanner.nextInt();
                document.setPublicationYear(newPublicationYear);
                scanner.nextLine();
                break;
            case 3:
                System.out.println("Ingrese el nuevo tipo de documento (LIBRO, REVISTA, ARTICULO, PAPER_CIENTIFICO):\n");
                DocumentType newDocumentType = DocumentType.valueOf(scanner.nextLine().toUpperCase());
                document.setDocumentType(newDocumentType);
                break;
            case 0:
                break;
            default:
                System.out.println("Opción no válida.\n");
        }
    }

    private static void removeDocument(DocumentCollection collection, Scanner scanner) {
        System.out.println("Ingrese el título del documento que desea eliminar:\n");
        String titleToRemove = scanner.nextLine();
        collection.removeDocument(titleToRemove);
        System.out.println("Documento eliminado exitosamente.\n");
    }

    private static void displaySearchResults(List<Document> results) {
        int index = 1;
        for (Document result : results) {
            System.out.println(index + ". " + result.getTitle());
            index++;
        }
    }
}
