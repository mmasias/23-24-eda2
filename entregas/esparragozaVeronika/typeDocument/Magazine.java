package typeDocument;

import java.util.ArrayList;

public class Magazine extends Document{
    public Magazine(String title, ArrayList<Integer> authors, int yearOfPublication, String type, ArrayList<String> keywords) {
        super(title, authors, yearOfPublication, type, keywords);
        setType("Magazine");
    }

    public Magazine() {
        addTitle();
        addAuthors();
        addYearOfPublication();
        setType("Magazine");
        addKeywords();
    }
}
