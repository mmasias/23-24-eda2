import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Document> documents;

    public Library() {
        this.documents = new ArrayList<>();
    }

    public void addDocument(Document document) {
        documents.add(document);
    }

    public Document findDocumentByTitle(String title) {
        for (Document doc : documents) {
            if (doc.getTitle().equalsIgnoreCase(title)) {
                return doc;
            }
        }
        return null;
    }

    public void updateDocument(String title, Document updatedDocument) {
        for (int i = 0; i < documents.size(); i++) {
            Document doc = documents.get(i);
            if (doc.getTitle().equalsIgnoreCase(title)) {
                documents.set(i, updatedDocument);
                return;
            }
        }
        System.out.println("Document not found.");
    }

    public void deleteDocument(String title) {
        documents.removeIf(doc -> doc.getTitle().equalsIgnoreCase(title));
    }

    public List<Document> searchByKeyword(String keyword) {
        List<Document> results = new ArrayList<>();
        for (Document doc : documents) {
            if (doc.getKeyWords().contains(keyword)) {
                results.add(doc);
            }
        }
        return results;
    }
}
