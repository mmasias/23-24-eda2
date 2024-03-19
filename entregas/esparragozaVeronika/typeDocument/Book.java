package typeDocument;

import searches.AuthorManager;
import searches.KeywordManager;

import java.util.ArrayList;

public class Book extends Document {
    ArrayList<Integer> authors = new ArrayList<>();
    ArrayList<Integer> keywords = new ArrayList<>();

    public Book(String title, ArrayList<Integer> authors, int yearOfPublication, String type, ArrayList<Integer> keywords){
        super(title, authors, yearOfPublication, type, keywords);
        setType("Book");
        this.authors = authors;
        this.keywords = keywords;
    }
    public Book(AuthorManager authors, KeywordManager keywords) {
        addTitle();
        addAuthor(authors);
        addYearOfPublication();
        setType("Book");
        addKeyword(keywords);
    }
}
