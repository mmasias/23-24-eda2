package Model;
import java.util.ArrayList;

public class Magazine extends Document {

    public Magazine(String title, ArrayList<Author> authors, int publicationYear, String documentType,
            ArrayList<String> keyWords) {
        super(title, authors, publicationYear, documentType, keyWords);
        
    }

    

   
}
