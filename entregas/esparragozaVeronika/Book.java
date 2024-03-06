import java.util.ArrayList;

public class Book extends Document{
    private String editorial;
    private String edition;
    private String isbn;

    public Book(String title, ArrayList<String> authors, String yearOfPublication, TypeDocument type, ArrayList<String> keywords, String editorial, String edition, String isbn){
        super(title, authors, yearOfPublication, type, keywords);
        this.editorial = editorial;
        this.edition = edition;
        this.isbn = isbn;
    }
}
