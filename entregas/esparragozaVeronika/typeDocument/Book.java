package typeDocument;

import java.util.ArrayList;

public class Book extends Document {
    private String isbn;
    private String type;

    public Book(String title, ArrayList<String> authors, int yearOfPublication, String type, ArrayList<String> keywords, String isbn){
        super(title, authors, yearOfPublication, type, keywords);
        this.type = "Book";
        this.isbn = isbn;
    }

    public Book(){
        super();
        this.type = "Book";
    }

    protected String addIsbn(){
        System.out.println("Ingrese el ISBN del libro: ");
        String isbn = input.next();
        return isbn;
    }
}
