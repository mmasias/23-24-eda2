import java.util.LinkedList;
public class Document {
    private String documentType;
    private String author;
    private String title;
    private LinkedList<KeyWord> keyword;
    private int publishYear;

    public Document (String documentType, String author, String title, LinkedList<KeyWord> keyword, int publishYear) {
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

    public LinkedList<KeyWord> getKeyword() {
        return keyword;
    }

    public void setKeyword(LinkedList<KeyWord> keyword) {
        this.keyword = keyword;
    }

    public int getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(int publishYear) {
        this.publishYear = publishYear;
    }

    public String getDocumentData(){
        StringBuilder keywordsString = new StringBuilder();
        for (KeyWord keyWord : keyword) {
            keywordsString.append(keyWord.getKeyWord()).append(", ");
        }
        if (keywordsString.length() > 0) {
            keywordsString.setLength(keywordsString.length() - 2);
        }

        return " Tipo: " + documentType +
                "\n    Autor: " + author +
                "\n    Título: " + title +
                "\n    Palabras Clave: " + keywordsString.toString() +
                "\n    Año de Publicación: " + publishYear;

    }
}