import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<Document> documents;
    private List<Author> authors;

    public Library() {
        this.documents = new ArrayList<>();
        this.authors = new ArrayList<>();
    }

    public List<Document> getAllDocuments() {
        return this.documents;
    }

    public List<Author> getAllAuthors() {
        return this.authors;        
    }

    public void addDocument(String title, List<String> authorNames, int publishingYear, String type, List<String> keywords) {
        Document document = new Document(title, publishingYear, type);
        
        for (String authorName : authorNames) {
            Author author = null;
            for (Author existingAuthor : authors) {
                if (existingAuthor.getName().equalsIgnoreCase(authorName)) {
                    author = existingAuthor;
                    break;
                }
            }
            if (author == null) {
                author = new Author(authorName);
                authors.add(author);
            }
            document.addAuthor(author);
        }

        for (String keyword : keywords) {
            document.addKeyword(keyword);
        }
        
        documents.add(document);
    }

    
    public List<String> getDocAuthors(Document document) {
        List<String> authorNames = new ArrayList<>();
        for (Author author : this.authors) {
            if (author.getDocuments().contains(document)) {
                authorNames.add(author.getName());
            }
        }
        return authorNames;
    }
    
    public Document searchDocByTitle(String title) {
        for (Document doc : documents) {
            if (doc.getTitle().equalsIgnoreCase(title)) {
                return doc;
            }
        }
        return null;
    }
    
    public List<Document> searchDocByAuthor(String authorName) {
        List<Document> results = new ArrayList<>();
        Author author = searchAuthorByName(authorName);
        if (author != null) {
            results.addAll(author.getDocuments());
        }
        return results;
    }
    
    public Author searchAuthorByName(String name) {
        for (Author author : authors) {
            if (author.getName().equalsIgnoreCase(name)) {
                return author;
            }
        }
        return null;
    }
    
    public List<Document> searcDocByType(String type) {
        List<Document> results = new ArrayList<>();
        for (Document doc : documents) {
            if (doc.getType().equalsIgnoreCase(type)) {
                results.add(doc);
            }
        }
        return results;
    }

    public List<Document> searchDocByYear(int year) {
        List<Document> results = new ArrayList<>();
        for (Document doc : documents) {
            if (doc.getPublishingYear() == year) {
                results.add(doc);
            }
        }
        return results;
    }
    
    public List<Document> searchDocByKeyword(String keyword) {
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
        Document toDelete = searchDocByTitle(title);
        
        if (toDelete != null) {
            List<Author> docAuthors = toDelete.getAuthors();
            if (docAuthors != null) {
                for (Author author : docAuthors) {
                    author.removeDocument(toDelete);
                }
            }
            documents.remove(toDelete);
        }
    }
    
}
