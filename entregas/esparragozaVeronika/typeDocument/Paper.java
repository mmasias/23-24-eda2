package typeDocument;

import searches.AuthorManager;
import searches.KeywordManager;

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
    public Paper(AuthorManager authors, KeywordManager keywords) {
        addTitle();
        addAuthor(authors);
        addYearOfPublication();
        setType("Paper");
        addKeyword(keywords);
    }
}
