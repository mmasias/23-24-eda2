package Model;
import java.util.ArrayList;

public class CientificPaper extends Document {

    public CientificPaper(String title, ArrayList<Author> authors, int publicationYear, String documentType,
            ArrayList<String> keyWords) {
        super(title, authors, publicationYear, documentType, keyWords);
        
    }

    
    
}
