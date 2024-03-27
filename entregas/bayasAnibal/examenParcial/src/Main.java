import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LibraryManager gestion = new LibraryManager(new ArrayList<Book>());
        gestion.menu();
    }
}