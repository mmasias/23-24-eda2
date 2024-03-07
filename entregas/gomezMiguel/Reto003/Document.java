import java.lang.reflect.Array;
import java.util.ArrayList;

public class Document {
    String title;
    int PublishedYear;
    int Tipeofdocument;
    ArrayList<Author> authors;
    ArrayList<String> keywords;

    public Document(String title, int PublishedYear, int Tipeofdocument) {
        this.title = title;
        this.PublishedYear = PublishedYear;
        this.Tipeofdocument = Tipeofdocument;
        authors = new ArrayList<Author>();
        keywords = new ArrayList<String>();

    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addKeyword(String keyword) {
        keywords.add(keyword);
    }

    public void editAuthor(Author author, int index) {
        authors.set(index, author);
    }

    public void editKeyword(String keyword, int index) {
        keywords.set(index, keyword);
    }

    public void deleteAuthor(int index) {
        authors.remove(index);
    }   

    public void deleteKeyword(int index) {
        keywords.remove(index);
    }

    public String gettitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublishedYear() {
        return PublishedYear;
    }

    public void setPublishedYear(int PublishedYear) {
        this.PublishedYear = PublishedYear;
    }

    public int getTipeofdocument() {
        return Tipeofdocument;
    }

    public void setTipeofdocument(int Tipeofdocument) {
        this.Tipeofdocument = Tipeofdocument;
    }

    public void identifyTipeofdocument(int Tipeofdocument){
        switch(Tipeofdocument){
            case 0:
                System.out.println("Libro");
                break;
            case 1:
                System.out.println("Revista");
                break;
            case 2:
                System.out.println("Tesis");
                break;
            case 3:
                System.out.println("Artículo");
                break;
            default:
                System.out.println("Tipo de documento no válido");
                break;
        }
    }

    public static void main(String[] args) {
        Document document = new Document("El principito", 1943, 0);
        Author author = new Author("Antoine", "de Saint-Exupéry");
        document.addKeyword("Infantil");
        document.addAuthor(author);
        System.out.println(document.gettitle());
        System.out.println(document.getPublishedYear());
        document.identifyTipeofdocument(document.getTipeofdocument());
        System.out.println(document.authors.get(0).getfirstname() + " " + document.authors.get(0).getlastname());
        System.out.println(document.keywords.get(0));
    }

}

