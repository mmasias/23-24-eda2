import java.util.LinkedList;
public class Document {
    private String documentType;
    private String author;
    private String title;
    private LinkedList<String> keyword;
    private int publishYear;

    public Document (String documentType, String author, String title, LinkedList<String> keyword, int publishYear) {
        this.documentType = documentType;
        this.author = author;
        this.title = title;
        this.keyword = keyword;
        this.publishYear = publishYear;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LinkedList<String> getKeyword() {
        return keyword;
    }

    public void setKeyword(LinkedList<String> keyword) {
        this.keyword = keyword;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public String getDocumentData(){
        return " Tipo: " + documentType +
                "\n    Autor: " + author +
                "\n    Título: " + title +
                "\n    Palabras Clave: " + keyword.toString() +
                "\n    Año de Publicación: " + publishYear;

    }

}
