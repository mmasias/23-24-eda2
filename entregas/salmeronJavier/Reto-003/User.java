import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {
    private Library library;
    private Document selectedDocument = null;

    public User(Library library) {
        this.library = library;
    }

    public void start() {
        boolean running = true;
        while (running) {
            System.out.println("\n ~~~| Library Management System |~~~");
            System.out.println("  1. Add Document");
            System.out.println("  2. Delete Document");
            System.out.println("  3. Update Document");
            System.out.println("  4. Search Documents");
            System.out.println("  5. Detail Selected Document");
            System.out.println("  6. Deselect Document");
            System.out.println("  7. List Documents by Author");
            System.out.println("  8. List Authors by Documents");
            System.out.println("  0. Exit");

            String choice = UserIO.getInput(" Choose an option: ");

            switch (choice) {
                case "1":
                    addDocument();
                    break;
                case "2":
                    deleteDocumentByTitle();
                    break;
                case "3":
                    updateDocument();
                    break;
                case "4":
                    searchDocuments();
                    break;
                case "5":
                    showSelectedDocument();
                    break;
                case "6":
                    deselectDocument();
                    break;
                case "7":
                    ListDocuments();
                    break;
                case "8":
                    ListAuthors();
                    break;
                case "0":
                    running = false;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }

    private void addDocument() {
        String title = UserIO.getInput("Enter document title: ");

        String authorsStr = UserIO.getInput("Enter authors (comma-separated): ");
        List<String> authors = new ArrayList<>(Arrays.asList(authorsStr.split("\\s*,\\s*")));

        int year = Integer.parseInt(UserIO.getInput("Enter publishing year: "));

        String type = UserIO.getInput("Enter document type: ");

        String keywordsStr = UserIO.getInput("Enter keywords (comma-separated): ");
        List<String> keywords = new ArrayList<>(Arrays.asList(keywordsStr.split("\\s*,\\s*")));

        Document newDocument = new Document(title, year, type);
        for (String keyword : keywords) {
            newDocument.addKeyword(keyword);
        }
        library.addDocument(title, authors, year, type, keywords);
        System.out.println("Document added successfully.");

        selectedDocument = newDocument;
    }

    private void deleteDocumentByTitle() {
        String title = UserIO.getInput("Enter the title of the document to delete: ");
        library.deleteDocument(title);
        System.out.println("Document deleted.");
    }

    private void updateDocument() {
        String title = UserIO.getInput("Enter the title of the document you want to update: ");
        Document existingDocument = library.searchDocByTitle(title);
        if (existingDocument == null) {
            System.out.println("Document not found.");
            return;
        }

        String newTitle = UserIO.getInput("Enter new document title (or press Enter to keep '" + existingDocument.getTitle() + "''): ");
        if (newTitle.isEmpty()) {
            newTitle = existingDocument.getTitle();
        }

        String modifyAuthors = UserIO.getInput("Do you want to modify authors? (yes/no): ");
        if ("yes".equalsIgnoreCase(modifyAuthors)) {
            System.out.println("Current document authors: " + String.join(", ", existingDocument.getAuthorNames()));
            while (true) {
                String authorModification = UserIO.getInput("Add or remove authors (+ AuthorName / - AuthorName). Type 'done' to finish: ");
                if ("done".equalsIgnoreCase(authorModification)) {
                    break;
                } else if (authorModification.startsWith("+ ")) {
                    String authorName = authorModification.substring(2);
                    Author author = library.searchAuthorByName(authorName);
                    existingDocument.addAuthor(author);
                } else if (authorModification.startsWith("- ")) {
                    String authorName = authorModification.substring(2);
                    Author author = library.searchAuthorByName(authorName);
                    existingDocument.removeAuthor(author);
                }
            }
        }

        String yearStr = UserIO.getInput("Enter new publishing year (or press Enter to keep '" + existingDocument.getPublishingYear() + "''): ");
        int year = yearStr.isEmpty() ? existingDocument.getPublishingYear() : Integer.parseInt(yearStr);

        String type = UserIO.getInput("Enter new document type (or press Enter to keep '" + existingDocument.getType() + "''): ");
        if (type.isEmpty()) {
            type = existingDocument.getType();
        }

        String keywordsStr = UserIO.getInput("Enter new keywords (comma-separated, or press Enter to keep existing): ");
        List<String> keywords = keywordsStr.isEmpty() ? existingDocument.getKeyWords() : new ArrayList<>(Arrays.asList(keywordsStr.split("\\s*,\\s*")));
    
        Document updatedDocument = new Document(newTitle, year, type);
        for (String keyword : keywords) {
            updatedDocument.addKeyword(keyword);
        }
        
        library.updateDocument(title, updatedDocument);
        System.out.println("Document updated successfully.");
    }
    
    private void searchDocuments() {
        List<Document> searchResults;
        String searchType = UserIO.getInput("Search by (title/author/year/type/keyword): ");
        switch (searchType.toLowerCase()) {
            case "title":
                String title = UserIO.getInput("Enter title: ");
                Document document = library.searchDocByTitle(title);
                if (document != null) {
                    System.out.println(" Document found: " + document);
                    System.out.println(" - Title: " + document.getTitle());
                    System.out.println(" - Authors: " + String.join(", ", document.getAuthorNames()));
                    System.out.println(" - Publishing Year: " + document.getPublishingYear());
                    System.out.println(" - Type: " + document.getType());
                    System.out.println(" - Keywords: " + String.join(", ", document.getKeyWords()));
                    selectedDocument = document;

                } else {
                    System.out.println("No document found with the title '" + title + "'");
                }
                break;
            case "author":
                String author = UserIO.getInput("Enter author: ");
                searchResults = library.searchDocByAuthor(author);
                for (Document doc : searchResults) {
                    System.out.println("Found: " + doc.getTitle() + " By: " + String.join(", ", doc.getAuthorNames()));
                }
                break;
            case "year":
                int year = UserIO.getInt("Enter year: ");
                searchResults = library.searchDocByYear(year);
                for (Document doc : searchResults) {
                    System.out.println("Found: " + doc.getTitle() + " By: " + String.join(", ", doc.getAuthorNames()));
                }
                break;
            case "type":
                String type = UserIO.getInput("Enter document type: ");
                searchResults = library.searcDocByType(type);
                for (Document doc : searchResults) {
                    System.out.println("Found: " + doc.getTitle() + " By: " + String.join(", ", doc.getAuthorNames()));
                }
                break;
            case "keyword":
                String keyword = UserIO.getInput("Enter keyword: ");
                searchResults = library.searchDocByKeyword(keyword);
                for (Document doc : searchResults) {
                    System.out.println("Found: " + doc.getTitle() + " By: " + String.join(", ", doc.getAuthorNames()));
                }
                break;
            default:
                System.out.println("Invalid search type.");
                break;
        }
    } 

    private void ListDocuments() {
        System.out.println("Available Documents, listed by Author:");
        for (Author author : library.getAllAuthors()) {
            System.out.println("  - " + author.getName() + ":");
            for (Document document : author.getDocuments()){
                System.out.println("    * " + document.getTitle());
            }
        }
    }

    private void ListAuthors() {
        System.out.println("Available Authors, listed by Document:");
        for (Document document : library.getAllDocuments()) {
            System.out.println("  - " + document.getTitle() + ":");
            for (Author author : document.getAuthors()){
                System.out.println("    * " + author.getName());
            }
        }
    }
    
    private void showSelectedDocument() {
        if (selectedDocument != null){
            System.out.println("Currently Selected Document: " + selectedDocument.getTitle());
        } else System.out.println("No Document Selected.");
    }

    private void deselectDocument() {
        selectedDocument = null;
        System.out.println("Document Deselected.");
    }
    
}
