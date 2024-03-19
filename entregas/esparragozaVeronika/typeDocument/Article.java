package typeDocument;

import searches.AuthorManager;
import searches.KeywordManager;

import java.util.ArrayList;

public class Article extends Document{
    ArrayList<Integer> authors = new ArrayList<>();
    ArrayList<Integer> keywords = new ArrayList<>();

    public Article(String title, ArrayList<Integer> authors, int yearOfPublication, String type, ArrayList<Integer> keywords) {
        super(title, authors, yearOfPublication, type, keywords);
        setType("Article");
        this.authors = authors;
        this.keywords = keywords;
    }

    public Article(AuthorManager authors, KeywordManager keywords) {
        addTitle();
        addAuthor(authors);
        addYearOfPublication();
        setType("Article");
        addKeyword(keywords);
    }
}
