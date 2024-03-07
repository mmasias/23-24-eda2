package Model;
import java.util.ArrayList;

public abstract class Document {
    private String title;
    private ArrayList<Author> authors =  new ArrayList<>();
    private int publishingYear;
    private String documentType;
    private ArrayList<String> keyWords = new ArrayList<>();

    public Document(String title, ArrayList<Author> authors, int publishingYear,String documentType, ArrayList<String> keyWords) {
        this.title = title;
        this.authors = authors;
        this.publishingYear = publishingYear;
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

    public Author getAuthor(String name, String surname) {
        for (Author a : authors) {
            if (a.getName().equals(name) && a.getSurnames().equals(surname)) {
                return a;
            }
        }
        return null;
    }

    public int searchAuthorIndex(Author author) {
        int index = authors.indexOf(author);
        return index;
    }

    public int getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(int newpublishingYear) {
        publishingYear = newpublishingYear;
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

   
    public String toStringDocument() {
        return "-> Documento: " + title;
    }

}
