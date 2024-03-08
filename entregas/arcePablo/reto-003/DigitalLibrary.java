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
                    menu.displayInputs(searchbar);
                    menu.displaySearchbarOptions();
                    modifySearchbar(searchbar);
                    break;
                case "l":
                    ArrayList<Document> filteredDocuments = searchbar.filterDocuments(library.getDocuments());
                    menu.displayInputs(searchbar);
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

    static void modifySearchbar(Searchbar searchbar){
        boolean isEditing = true;
        Scanner scanner = new Scanner(System.in);

        while (isEditing) {
            System.out.println("Ingrese una opción:");
            String option = scanner.nextLine();

            switch (option.toLowerCase()) {
                case "a":
                    System.out.println("Ingrese la palabra clave:");
                    String keywordInput = scanner.nextLine().toUpperCase();
                    try {
                        KeyWordTypes keywordType = KeyWordTypes.valueOf(keywordInput);
                        searchbar.addKeyword(keywordType);
                        System.out.println("Palabra clave añadida exitosamente.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("La palabra clave ingresada no es válida.");
                    }
                    break;

                case "b":
                    System.out.println("Ingrese la palabra clave a borrar:");
                    String keywordToRemoveInput = scanner.nextLine().toUpperCase(); 
                    try {
                        KeyWordTypes keywordToRemoveType = KeyWordTypes.valueOf(keywordToRemoveInput);
                        searchbar.removeKeyword(keywordToRemoveType);
                        System.out.println("Palabra clave borrada exitosamente.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("La palabra clave ingresada no es válida.");
                    }
                    break;

                case "t":
                    System.out.println("Ingrese el nuevo título:");
                    String newTitle = scanner.nextLine();
                    searchbar.setTitleInput(newTitle);
                    break;
                case "d":
                    System.out.println("Ingrese la nueva fecha (en formato yyyy-MM-dd):");
                    String newDateStr = scanner.nextLine();
                    // TO DO
                    break;
                case "u":
                    System.out.println("Ingrese el nuevo autor:");
                    String newAuthor = scanner.nextLine();
                    searchbar.setAuthorInput(newAuthor);
                    break;
                case "y":
                    System.out.println("Ingrese el nuevo tipo de documento:");
                    String newDocType = scanner.nextLine();
                    // TO DO
                    break;
                case "r":
                    System.out.println("Volviendo al menú principal...");
                    isEditing = false;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, ingrese una opción válida.");
            }
        }
    }
}
