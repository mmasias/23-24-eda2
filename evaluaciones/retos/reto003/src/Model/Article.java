package Model;
import java.util.ArrayList;

public class Article extends Document {

    public Article(String title, ArrayList<Author> authors, int publicationYear, String documentType,
            ArrayList<String> keyWords) {
        super(title, authors, publicationYear, documentType, keyWords);
        
    }

    

   
}
