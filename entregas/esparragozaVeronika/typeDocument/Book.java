package typeDocument;

import java.util.ArrayList;

public class Book extends Document {

    public Book(String title, ArrayList<Integer> authors, int yearOfPublication, String type, ArrayList<Integer> keywords, String isbn){
        super(title, authors, yearOfPublication, type, keywords);
        setType("Book");
    }

    public Book(){
        addTitle();
        addAuthors();
        addYearOfPublication();
        setType("Book");
        addKeywords();
    }
}
