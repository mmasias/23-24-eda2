import searches.SearchEngine;
import typeDocument.*;

import java.util.ArrayList;
import java.util.Scanner;

public class DocumentManagement {
    Scanner input = new Scanner(System.in);
    ArrayList<Document> documents;
    SearchEngine searchEngine;
    boolean isRunning;
    public void run(){
        documents = new ArrayList<>();
        searchEngine = new SearchEngine();
        isRunning = true;

        dataFalsa();
        while(isRunning){
            initialMenu();
        }

    }

    public void initialMenu() {
        System.out.println("Ingrese lo que desea hacer: ");
        System.out.println("1. Añadir un nuevo un documento");
        System.out.println("2. Buscar un documento");
        System.out.println("3. Ver todos los documentos");
        System.out.println("4. Salir");

        switch (input.nextInt()){
            case 1:
                addDocument();
                break;
            case 2:
                searchDocument();
                System.out.println("Buscando...");
                break;
            case 3:
                printAllDocuments();
                break;
            case 4:
                System.out.println("Saliendo...");
                isRunning = false;
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    private void addDocument(){
        System.out.println("Ingrese el tipo de documento que desea agregar: ");
        System.out.println("1. Artículo");
        System.out.println("2. Revista");
        System.out.println("3. Libro");
        System.out.println("4. Paper científico");


        switch (input.nextInt()){
            case 1:
                documents.add(new Article());
                System.out.println("Artículo agregado:: " + documents.getLast().getTitle());
                break;
            case 2:
                documents.add(new Magazine());
                break;
            case 3:
                documents.add(new Book());
                break;
            case 4:
                documents.add(new Paper());
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }
    private void searchDocument() {
        searchEngine.searchDocument();
    }
    private void printAllDocuments(){
        for (Document document : documents){
            document.printDocument();
        }
        initialMenu();
    }


    public void dataFalsa(){
        ArrayList<String> authors = new ArrayList<>();
        authors.add("Veronika");
        authors.add("Pablo");
        ArrayList<String> keywords = new ArrayList<>();
        keywords.add("keyword1");
        keywords.add("keyword2");
        documents.add(new Article("La naturaleza es bella", authors, 2021, "tipo", keywords));
        documents.add(new Magazine("que mas pues", authors, 2019, "type", keywords));
        documents.add(new Book("el pais", authors, 2067, "tipo random", keywords, "isbn"));
        documents.add(new Paper("diario montañes", authors, 2024, "hi", keywords));
    }
}
