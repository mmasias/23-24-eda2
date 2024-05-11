package entregas.celayaIker.Reto003.src;

import java.util.ArrayList;

public class Document {
    private String title;
    private int yearOfPublication;
    private ArrayList<Author> authors;
    private Type type;
    private ArrayList<String> keywords;

    public Document(String title, int yearOfPublication, ArrayList<Author> authors, Type type) {
        this.title = title;
        this.yearOfPublication = yearOfPublication;
        this.authors = authors;
        this.type = type;
        this.keywords = new ArrayList<String>();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(int yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(ArrayList<Author> authors) {
        this.authors = authors;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(ArrayList<String> keywords) {
        this.keywords = keywords;
    }

    public void addAuthor(Author author) {
        this.authors.add(author);
    }

    public void addKeyword(String keyword) {
        this.keywords.add(keyword);
    }

    public void removeAuthor(Author author) {
        this.authors.remove(author);
    }

    public void removeKeyword(String keyword) {
        this.keywords.remove(keyword);
    }
}