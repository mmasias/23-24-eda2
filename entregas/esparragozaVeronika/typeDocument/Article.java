package typeDocument;

import java.util.ArrayList;

public class Article extends Document{

    public Article(String title, ArrayList<Integer> authors, int yearOfPublication, String type, ArrayList<String> keywords) {
        super(title, authors, yearOfPublication, type, keywords);
        setType("Article");
    }

    public Article() {
        addTitle();
        addAuthors();
        addYearOfPublication();
        setType("Article");
        addKeywords();
    }
}
