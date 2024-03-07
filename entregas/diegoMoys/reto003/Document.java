import java.util.List;

public class Document {
    private String title;
    private List<Author> authors;
    private int publicationYear;
    private DocumentType documentType;
    private List<Keywords> keywords;

    public Document(String title, List<Author> authors, int publicationYear, DocumentType documentType, List<Keywords> keywords) {
        this.title = title;
        this.authors = authors;
        this.publicationYear = publicationYear;
        this.documentType = documentType;
        this.keywords = keywords;
    }

    public String getTitle() {
        return title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public List<Keywords> getKeywords() {
        return keywords;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public void setKeywords(List<Keywords> keywords) {
        this.keywords = keywords;
    }

    public void displayInformation() {
        System.out.println("-------------------------\n");
        System.out.println("Título: " + title);
        System.out.println("Autor/es: " + authors);
        System.out.println("Año de publicación: " + publicationYear);
        System.out.println("Tipo de documento: " + documentType);
        System.out.println("Palabras clave: " + keywords);
        System.out.println("-------------------------\n");
    }
}

