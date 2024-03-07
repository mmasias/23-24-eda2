import java.util.ArrayList;
import java.util.Scanner;

import Types.KeyWordTypes;

public class DigitalLibrary {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        Library library = new Library();
        Searchbar searchbar = new Searchbar();
        DocumentGenerator documentGenerator = new DocumentGenerator();
        Menu menu = new Menu();
        fillLibrary(library, documentGenerator, 200);
        menu.welcome();

        while (running){
            menu.displayMainOptions();
            String option = scanner.nextLine();
            switch (option){
                case "a":
                    library.addDocument(documentGenerator.generateRandomDocument());
                    break;
                case "f":
                    searchbar.addKeyword(KeyWordTypes.JAVA);
                    break;
                case "l":
                    ArrayList<Document> filteredDocuments = searchbar.filterDocuments(library.getDocuments());
                    searchbar.displayInputs();
                    menu.listDocuments(filteredDocuments);
                    break;
                case "s":
                    running = false;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    static void fillLibrary(Library library, DocumentGenerator documentGenerator, int amountOfDocuments){
        for (int i = 0; i < amountOfDocuments; i++){        
            library.addDocument(documentGenerator.generateRandomDocument());
        }
    }
}
