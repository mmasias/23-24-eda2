package typeDocument;

import searches.AuthorManager;
import searches.KeywordManager;

import java.util.ArrayList;

public class Magazine extends Document{
    ArrayList<Integer> authors = new ArrayList<>();
    ArrayList<Integer> keywords = new ArrayList<>();
    public Magazine(String title, ArrayList<Integer> authors, int yearOfPublication, String type, ArrayList<Integer> keywords) {
        super(title, authors, yearOfPublication, type, keywords);
        setType("Magazine");
        this.authors = authors;
        this.keywords = keywords;
    }
    public Magazine(AuthorManager authors, KeywordManager keywords) {
        addTitle();
        addAuthor(authors);
        addYearOfPublication();
        setType("Magazine");
        addKeyword(keywords);
    }
}
