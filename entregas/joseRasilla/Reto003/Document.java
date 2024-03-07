import java.util.List;

public class Document {
    protected String title;
    protected List<Author> authors;
    protected int publicationYear;
    protected String documentType;
    protected List<String> keyWords;

    public Document(String title, List<Author> authors, int publicationYear, String documentType, List<String> keyWords) {
        this.title = title;
        this.authors = authors;
        this.publicationYear = publicationYear;
        this.documentType = documentType;
        this.keyWords = keyWords;
    }
    // Getters y setters
    public String getTitulo() {
        return title;
    }

    public void setTitulo(String title) {
        this.title = title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getdocumentType() {
        return documentType;
    }

    public void setdocumentType(String documentType) {
        this.documentType = documentType;
    }

    public List<String> getKeyWords() {
        return keyWords;
    }

    public void setKeyWords(List<String> keyWords) {
        this.keyWords = keyWords;
    }
}
