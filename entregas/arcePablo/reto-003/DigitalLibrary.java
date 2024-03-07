import java.util.Scanner;

public class DigitalLibrary {

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        Library library = new Library();
        DocumentGenerator documentGenerator = new DocumentGenerator();
        Menu menu = new Menu();
        fillLibrary(library, documentGenerator, 30);
        menu.welcome();

        while (running){
            menu.displayOptions();
            String option = scanner.nextLine();
            switch (option){
                case "a":
                    library.addDocument(documentGenerator.generateRandomDocument());
                    break;
                /*case "f":

                    break;*/
                case "l":
                    library.listDocuments();
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
