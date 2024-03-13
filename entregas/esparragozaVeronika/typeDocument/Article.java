package typeDocument;

import searches.Author;
import searches.Keyword;

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

    public Article(Author authors, Keyword keywords) {
        addTitle();
        addAuthor(authors);
        addYearOfPublication();
        setType("Article");
        addKeyword(keywords);
    }
}
