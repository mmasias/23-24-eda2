import java.util.ArrayList;
public class Library {
    private ArrayList<Document> documents;

    public Library() {
        documents = new ArrayList<>();
    }

    public ArrayList<Document> getDocuments() {
        return documents;
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
}
