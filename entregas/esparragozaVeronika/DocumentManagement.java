import searches.Author;
import searches.SearchEngine;
import typeDocument.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DocumentManagement {
    Scanner input = new Scanner(System.in);
    ArrayList<Document> documents;
    SearchEngine searchEngine;
    Author authors = new Author();
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
        System.out.println("2. Buscar");
        System.out.println("3. Ver todos los documentos");
        System.out.println("4. Salir");

        switch (input.nextInt()){
            case 1:
                addDocument();
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
    private void showFilteringOption() {
        System.out.println("Puede buscar por los siguientes filtros:");
        System.out.println("1. Autor");
        System.out.println("2. Año de publicación");
        System.out.println("3. Tipo de documento");
        System.out.println("4. Titulo del documento");
        System.out.println("5. Palabra clave");

        switch (input.nextInt()){
            case 1:
                searchEngine.searchByAuthor(authors);
                break;
            case 2:
                //searchEngine.searchByYear(documents);
                break;
            case 3:
                //searchEngine.searchByType(documents);
                break;
            case 4:
                //searchEngine.searchByTitle(documents);
                break;
            case 5:
                //searchEngine.searchByKeyword(documents);
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }
    private void printAllDocuments(){
        for (Document document : documents){
            document.printDocument();
        }
        initialMenu();
    }

    public void dataFalsa(){
        authors.addNewAuthor(1, "Gabriel García Márquez");
        authors.addNewAuthor(2, "Jane Austen");
        authors.addNewAuthor(3, "Fyodor Dostoevsky");
        authors.addNewAuthor(4, "Haruki Murakami");


        ArrayList<Integer> autorDataExample1 = new ArrayList<>();
        autorDataExample1.add(4);
        ArrayList<Integer> autorDataExample2 = new ArrayList<>();
        autorDataExample2.add(2);
        autorDataExample2.add(3);
        autorDataExample2.add(4);

        ArrayList<String> keywordDataExample1 = new ArrayList<>();
        keywordDataExample1.add("naturaleza");
        ArrayList<String> keywordDataExample2 = new ArrayList<>();
        keywordDataExample2.add("medicina");
        keywordDataExample2.add("salud");
        keywordDataExample2.add("vida");


        documents.add(new Article("La naturaleza es bella", autorDataExample1, 2021, "tipo", keywordDataExample2));
        documents.add(new Magazine("que mas pues", autorDataExample2, 2019, "type", keywordDataExample1));
    }
}
