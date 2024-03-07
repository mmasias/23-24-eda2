package typeDocument;

import java.util.ArrayList;

public class Article extends Document{
    private String type;

    public Article(String title, ArrayList<String> authors, int yearOfPublication, String type, ArrayList<String> keywords) {
        super(title, authors, yearOfPublication, type, keywords);
        this.type = "Article";
    }

    public Article() {
        addTitle();
        addAuthors();
        addYearOfPublication();
        this.type = "Article";
        addKeywords();

        System.out.println("Artículo creado:: el titulo es en ARTICLE::" + getTitle());
        System.out.println("Artículo creado:: el tipo es en ARTICLE::" + getType());
    }
}
