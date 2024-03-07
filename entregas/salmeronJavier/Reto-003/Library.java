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

    public Document searchDocumentByTitle(String title) {
        for (Document doc : documents) {
            if (doc.getTitle().equalsIgnoreCase(title)) {
                return doc;
            }
        }
        return null;
    }

    public List<Document> searchByAuthor(String author) {
        List<Document> results = new ArrayList<>();
        for (Document doc : documents) {
            for (String docAuthor : doc.getAuthors()) {
                if (docAuthor.equalsIgnoreCase(author)) {
                    results.add(doc);
                    break;
                }
            }
        }
        return results;
    }

    public List<Document> searchByType(String type) {
        List<Document> results = new ArrayList<>();
        for (Document doc : documents) {
            if (doc.getType().equalsIgnoreCase(type)) {
                results.add(doc);
            }
        }
        return results;
    }

    public List<Document> searchByYear(int year) {
        List<Document> results = new ArrayList<>();
        for (Document doc : documents) {
            if (doc.getPublishingYear() == year) {
                results.add(doc);
            }
        }
        return results;
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

    public void updateDocument(String title, Document updatedDocument) {
        for (int i = 0; i < documents.size(); i++) {
            Document doc = documents.get(i);
            if (doc.getTitle().equalsIgnoreCase(title)) {
                documents.set(i, updatedDocument);
                return;
            }
        }
        // Change to return null or just ignore?
    }

    public void deleteDocument(String title) {
        documents.removeIf(doc -> doc.getTitle().equalsIgnoreCase(title));
    }

}
