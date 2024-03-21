import java.util.ArrayList;
import java.util.List;

public class Author {
    private String name;
    private List<Document> documents;

    public Author(String name) {
        this.name = name;
        this.documents = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void addDocument(Document document) {
        if (!documents.contains(document)) {
            documents.add(document);
            if (!document.getAuthors().contains(this)) {
                document.addAuthor(this);
            }
        }
    }

    public void removeDocument(Document document) {
        if (documents.remove(document)) {
            if (document.getAuthors().contains(this)) {
                document.removeAuthor(this);
            }
        }
    }
}
