import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        
        List<Document> searchResults;
        
        List<String> authors01 = new ArrayList<>();
        authors01.add("Jose Luis");
        authors01.add("Antonie Delmonte");

        Document doc01 = new Document("Compiling gnu/linux for normies", authors01, 2024, "Book");
        doc01.addKeyword("Linux");
        doc01.addKeyword("Technology");
        library.addDocument(doc01);

        List<String> authors02 = new ArrayList<>();
        authors02.add("Walter White");
        
        Document doc02 = new Document("Cooking for science", authors02, 2024, "Paper");
        doc02.addKeyword("Science");
        library.addDocument(doc02);

        System.out.println("Searching document 'Compiling gnu':");
        Document searchDocument = library.searchDocumentByTitle("Compiling gnu/linux for normies");
        if (searchDocument != null) {
            System.out.println(" - Document Found: ");
            System.out.println(" - Title: " + searchDocument.getTitle());
            System.out.println(" - Authors: " + String.join(", ", searchDocument.getAuthors()));
            System.out.println(" - Publishing Year: " + searchDocument.getPublishingYear());
            System.out.println(" - Type: " + searchDocument.getType());
            System.out.println(" - Keywords: " + String.join(", ", searchDocument.getKeyWords()));
        } else {
            System.out.println("No document found");
        }
   

        System.out.println("Searching keyword 'Linux':");
        searchResults = library.searchByKeyword("Linux");
        for (Document doc : searchResults) {
            System.out.println("Found: " + doc.getTitle() + " By: " + String.join(", ", doc.getAuthors()));
        }

        System.out.println("Searching year 2024:");
        searchResults = library.searchByYear(2024);
        for (Document doc : searchResults) {
            System.out.println("Found: " + doc.getTitle() + " By: " + String.join(", ", doc.getAuthors()));
        }

        System.out.println("Searching books:");
        searchResults = library.searchByType("paper");
        for (Document doc : searchResults) {
            System.out.println("Found: " + doc.getTitle() + " By: " + String.join(", ", doc.getAuthors()));
        }

    }
}
