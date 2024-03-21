import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Document> documents;
    private List<Author> authors;

    public Library() {
        this.documents = new ArrayList<>();
        this.authors = new ArrayList<>();
    }

    public void addDocument(Document document, List<String> authorNames) {
        documents.add(document);

        for (String authorName : authorNames) {
            Author author = findAuthorByName(authorName);
            if (author == null) {
                author = new Author(authorName);
                authors.add(author);
            }
            author.addDocument(document);
        }
    }

    private Author findAuthorByName(String name) {
        for (Author author : authors) {
            if (author.getName().equalsIgnoreCase(name)) {
                return author;
            }
        }
        return null;
    }

    public Document searchDocumentByTitle(String title) {
        for (Document doc : documents) {
            if (doc.getTitle().equalsIgnoreCase(title)) {
                return doc;
            }
        }
        return null;
    }

    public List<Document> searchByAuthor(String authorName) {
        List<Document> results = new ArrayList<>();
        Author author = findAuthorByName(authorName);
        if (author != null) {
            results.addAll(author.getDocuments());
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
