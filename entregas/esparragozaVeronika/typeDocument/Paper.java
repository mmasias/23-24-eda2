package typeDocument;

import searches.Author;
import searches.Keyword;

import java.util.ArrayList;

public class Paper extends Document{
    ArrayList<Integer> authors = new ArrayList<>();
    ArrayList<Integer> keywords = new ArrayList<>();
    public Paper(String title, ArrayList<Integer> authors, int yearOfPublication, String type, ArrayList<Integer> keywords) {
        super(title, authors, yearOfPublication, type, keywords);
        setType("Paper");
        this.authors = authors;
        this.keywords = keywords;
    }
    public Paper(Author authors, Keyword keywords) {
        addTitle();
        addAuthor(authors);
        addYearOfPublication();
        setType("Paper");
        addKeyword(keywords);
    }
}
