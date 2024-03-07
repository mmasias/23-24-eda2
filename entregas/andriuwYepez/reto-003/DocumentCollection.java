import java.util.ArrayList;
import java.util.List;

public class DocumentCollection {
    private List<Document> documents;

    public DocumentCollection() {
        documents = new ArrayList<>();
    }

    public void addDocument(Document document) {
        documents.add(document);
    }

    public List<Document> searchByTitle(String title) {
        List<Document> results = new ArrayList<>();
        for (Document document : documents) {
            if (document.getTitle().toLowerCase().contains(title.toLowerCase())) {
                results.add(document);
            }
        }
        return results;
    }

    public List<Document> searchByAuthor(String authorName) {
        List<Document> results = new ArrayList<>();
        for (Document document : documents) {
            for (Author author : document.getAuthors()) {
                if (author.getName().toLowerCase().contains(authorName.toLowerCase())) {
                    results.add(document);
                    break;
                }
            }
        }
        return results;
    }

    public List<Document> searchByKeywords(String keyword) {
        List<Document> results = new ArrayList<>();
        for (Document document : documents) {
            for (Keywords keywords : document.getKeywords()) {
                if (keywords.getKeyword().toLowerCase().contains(keyword.toLowerCase())) {
                    results.add(document);
                    break;
                }
            }
        }
        return results;
    }

    public void editDocument(String title, Document newDocument) {
        for (int i = 0; i < documents.size(); i++) {
            if (documents.get(i).getTitle().equals(title)) {
                documents.set(i, newDocument);
                break;
            }
        }
    }

    public void removeDocument(String title) {
        documents.removeIf(document -> document.getTitle().equals(title));
    }

    public void displayDocuments() {
        for (Document document : documents) {
            document.displayInformation();
        }
    }
}