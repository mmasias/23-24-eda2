import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        List<String> authors = new ArrayList<>();
        authors.add("Jose Luis");
        authors.add("Antonie Delmonte");

        Document doc01 = new Document("Compiling gnu/linux for normies", authors, 2024, "Book");
        doc01.addKeyword("Linux");
        doc01.addKeyword("Technology");
        library.addDocument(doc01);

        System.out.println("Searching keyword 'Linux':");
        List<Document> searchResults = library.searchByKeyword("Linux");
        for (Document doc : searchResults) {
            System.out.println("Found: " + doc.getTitle() + "By: " + doc.getAuthors());
        }
    }
}
