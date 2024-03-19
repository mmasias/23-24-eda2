import searches.AuthorManager;
import searches.KeywordManager;
import searches.DocumentManager;
import typeDocument.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagementSystem {
    Scanner input = new Scanner(System.in);
    private ArrayList<Document> documents;
    private DocumentManager documentManager;
    private final AuthorManager authors = new AuthorManager();
    private final KeywordManager keywords = new KeywordManager();
    private boolean isRunning;

    public void run(){
        documents = new ArrayList<>();
        documentManager = new DocumentManager(documents, authors, keywords);
        isRunning = true;

        falseData();
        while(isRunning){
            initialMenu();
        }
    }
    public void initialMenu() {
        System.out.println("===================================");
        System.out.println("Ingrese lo que desea hacer (solo números): ");
        System.out.println("1. Añadir un nuevo un documento");
        System.out.println("2. Buscar");
        System.out.println("3. Ver todos los documentos");
        System.out.println("4. Salir");
        System.out.print("-> ");

        switch (input.nextInt()){
            case 1:
                addDocument(authors);
                break;
            case 2:
                showFilteringOption();
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
    private void addDocument(AuthorManager authors){
        System.out.println("Ingrese el tipo de documento que desea agregar (solo números): ");
        System.out.println("1. Artículo");
        System.out.println("2. Revista");
        System.out.println("3. Libro");
        System.out.println("4. Paper científico");
        System.out.print("-> ");

        switch (input.nextInt()){
            case 1:
                documents.add(new Article(authors, keywords));
                break;
            case 2:
                documents.add(new Magazine(authors, keywords));
                break;
            case 3:
                documents.add(new Book(authors, keywords));
                break;
            case 4:
                documents.add(new Paper(authors, keywords));
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }
    private void showFilteringOption() {
        documentManager.search(documents, authors, keywords);
    }
    private void printAllDocuments(){
        for (Document document : documents){
            document.printDocument(document, authors, keywords);
        }
        initialMenu();
    }
    public void falseData(){
        System.out.println("Agregando datos falsos...");
        authors.addAuthor(1, "Jane Austen");
        authors.addAuthor(2, "Fyodor Dostoevsky");
        authors.addAuthor(3, "Haruki Murakami");

        keywords.addKeyword(1, "naturaleza");
        keywords.addKeyword(2, "medicina");
        keywords.addKeyword(3, "salud");
        keywords.addKeyword(4, "vida");

        ArrayList<Integer> autorDataExample1 = new ArrayList<>();
        autorDataExample1.add(3);
        ArrayList<Integer> autorDataExample2 = new ArrayList<>();
        autorDataExample2.add(1);
        autorDataExample2.add(2);
        autorDataExample2.add(3);

        ArrayList<Integer> keywordDataExample1 = new ArrayList<>();
        keywordDataExample1.add(1);
        ArrayList<Integer> keywordDataExample2 = new ArrayList<>();
        keywordDataExample2.add(2);
        keywordDataExample2.add(3);
        keywordDataExample2.add(4);


        documents.add(new Article("La naturaleza es bella", autorDataExample1, 2021, "type", keywordDataExample2));
        documents.add(new Magazine("El principito", autorDataExample2, 2019, "type", keywordDataExample1));
        documents.add(new Paper("Nuevas bacterias del siglo 21", autorDataExample2, 2019, "type", keywordDataExample1));
    }
}
