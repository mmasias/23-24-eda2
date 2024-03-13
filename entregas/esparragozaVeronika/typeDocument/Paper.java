package typeDocument;

import java.util.ArrayList;

public class Paper extends Document{
    public Paper(String title, ArrayList<Integer> authors, int yearOfPublication, String type, ArrayList<Integer> keywords) {
        super(title, authors, yearOfPublication, type, keywords);
        setType("Paper");
    }

    public Paper() {
        addTitle();
        addAuthors();
        addYearOfPublication();
        setType("Paper");
        addKeywords();
    }
}
