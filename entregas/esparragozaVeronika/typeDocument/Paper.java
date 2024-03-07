package typeDocument;

import java.util.ArrayList;

public class Paper extends Document{
    private String type;

    public Paper(String title, ArrayList<String> authors, int yearOfPublication, String type, ArrayList<String> keywords) {
        super(title, authors, yearOfPublication, type, keywords);
        this.type = "Paper";
    }

    public Paper() {
        super();
        this.type = "Paper";
    }
}
