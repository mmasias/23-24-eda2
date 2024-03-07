package Model;
import java.util.ArrayList;

public class Book extends Document {

    private int numberOfPages;

    public Book(String title, ArrayList<Author> authors, int publicationYear, String documentType,
            ArrayList<String> keyWords, int numberOfPages) {
        super(title, authors, publicationYear, documentType, keyWords);
        this.numberOfPages = numberOfPages;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int number) {
        numberOfPages = number;
    }

    

    

    
}
