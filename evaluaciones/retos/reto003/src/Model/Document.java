package Model;
import java.util.ArrayList;

public abstract class Document {
    private String title;
    private ArrayList<Author> authors =  new ArrayList<>();
    private int publicationYear;
    private String documentType;
    private ArrayList<String> keyWords = new ArrayList<>();

    public Document(String title, ArrayList<Author> authors, int publicationYear,String documentType, ArrayList<String> keyWords) {
        this.title = title;
        this.authors = authors;
        this.publicationYear = publicationYear;
        this.keyWords = keyWords;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String titleDoc) {
        title = titleDoc;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public int searchAuthorIndex(Author author) {
        int index = authors.indexOf(author);
        return index;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicatioYear(int newPublicationYear) {
        publicationYear = newPublicationYear;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String type) {
        documentType = type;
    }

    public ArrayList<String> getKeyWords() {
        return keyWords;
    }

    public int searchKeyWordIndex(String word) {
        int index = keyWords.indexOf(word);
        return index;
    }

    @Override
    public String toString() {
        return "-> Documento: " + title;
    }

}
