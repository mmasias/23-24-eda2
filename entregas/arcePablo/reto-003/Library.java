import java.util.ArrayList;
import java.util.Date;
public class Library {
    private ArrayList<Document> documents;
    private ArrayList<Document> foundDocuments;

    public Library() {
        documents = new ArrayList<>();
    }

    public void addDocument(Document document) {
        documents.add(document);
    }

    public Document readDocument(int index) {
        if (index >= 0 && index < documents.size()) {
            return documents.get(index);
        }
        return null;
    }

    public void updateDocument(int index, Document updatedDocument) {
        if (index >= 0 && index < documents.size()) {
            documents.set(index, updatedDocument);
        }
    }

    public void deleteDocument(int index) {
        if (index >= 0 && index < documents.size()) {
            documents.remove(index);
        }
    }

    
    public void listDocuments() {
        System.out.println("=== Lista de Documentos ===");
        System.out.println("|   Title           |   Author          |   Date Published   |");

        for (Document document : documents) {
            String title = document.getTitle();
            String author = document.getAuthor();
            Date datePublished = document.getDatePublished();

            String formattedDate = new java.text.SimpleDateFormat("dd/MM/yyyy").format(datePublished);

            System.out.format("| %-18s | %-18s | %-18s |\n", title, author, formattedDate);
        }
    }

}
