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

    public List<Document> findByTitle(String title) {
        List<Document> results = new ArrayList<>();
        for (Document doc : documents) {
            if (doc.getTitulo().equalsIgnoreCase(title)) {
                results.add(doc);
            }
        }
        return results;
    }

    public List<Document> findByAuthor(String autorName) {
        List<Document> results = new ArrayList<>();
        for (Document doc : documents) {
            for (Author a : doc.getAuthors()) {
                results.add(doc);
            }
        }
        return results;
    }

    public List<Document> findByYear(int año) {
        List<Document> results = new ArrayList<>();
        for (Document doc : documents) {
            if (doc.getPublicationYear() == año) {
                results.add(doc);
            }
        }
        return results;
    }

    public List<Document> findByType(String documentType) {
        List<Document> results = new ArrayList<>();
        for (Document doc : documents) {
            if (doc.getdocumentType().equalsIgnoreCase(documentType)) {
                results.add(doc);
            }
        }
        return results;
    }

    public List<Document> findByKeyWord(String keyWord) {
        List<Document> results = new ArrayList<>();
        for (Document doc : documents) {
            if (doc.getKeyWords().contains(keyWord)) {
                results.add(doc);
            }
        }
        return results;
    }

    public void deleteDocument(Document document) {
        documents.remove(document);
    }

}

