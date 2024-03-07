package typeDocument;

import java.util.ArrayList;

public class Magazine extends Document{
    private String type;

    public Magazine(String title, ArrayList<String> authors, int yearOfPublication, String type, ArrayList<String> keywords) {
        super(title, authors, yearOfPublication, type, keywords);
        this.type = "Magazine";
    }

    public Magazine() {
        super();
        this.type = "Magazine";
    }
}
