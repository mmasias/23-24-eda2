import searches.AuthorManager;
import searches.KeywordManager;
import searches.DocumentManager;
import typeDocument.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ManagementSystem {
    Scanner input = new Scanner(System.in);
    private DocumentManager documentManager;
    private final AuthorManager authors = new AuthorManager();
    private final KeywordManager keywords = new KeywordManager();
    private boolean isRunning;

    public void run(){
        documentManager = new DocumentManager(new ArrayList<>(), authors, keywords);
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
                search(authors, keywords);
                break;
            case 3:
                printAllDocumentsInfo();
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
                documentManager.add(new Article(authors, keywords));
                break;
            case 2:
                documentManager.add(new Magazine(authors, keywords));
                break;
            case 3:
                documentManager.add(new Book(authors, keywords));
                break;
            case 4:
                documentManager.add(new Paper(authors, keywords));
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }
    public void search(AuthorManager authors, KeywordManager keywords){
        System.out.println("Ingrese la característica por la que desea buscar (solo números): ");
        System.out.println("1. Título");
        System.out.println("2. Autor");
        System.out.println("3. Año de publicación");
        System.out.println("4. Tipo de documento");
        System.out.println("5. Palabra clave");
        System.out.print("-> ");

        switch (input.nextInt()){
            case 1:
                System.out.println("Ingrese el título del documento: ");
                System.out.print("-> ");
                input.nextLine();
                newSearch("title", input.nextLine());
                break;
            case 2:
                System.out.println("Ingrese el nombre del autor: ");
                System.out.print("-> ");
                input.nextLine();
                newSearch("author", input.nextLine());
                break;
            case 3:
                System.out.println("Ingrese el año de publicación: ");
                System.out.print("-> ");
                newSearch("year", input.next());
                break;
            case 4:
                System.out.println("Los tipos de documentos son los siguientes (solo números):");
                System.out.println("1. Artículo");
                System.out.println("2. Revista");
                System.out.println("3. Libro");
                System.out.println("4. Paper científico");
                System.out.print("-> ");
                newSearch("type", input.next());
                break;
            case 5:
                System.out.println("Ingrese la palabra clave a buscar: ");
                System.out.print("-> ");
                input.nextLine();
                newSearch("keyword", input.nextLine());
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    private void printAllDocumentsInfo(){
        for (Document document : documentManager.getAllDocuments()){
            System.out.println("# Titulo " + document.getTitle() + " -" +
                    " Autores: " + authors.printAuthors(document.getAuthorsId()) +
                    " - Año de publicacion: " + document.getYearOfPublication() + " - " +
                    "Tipo: " + document.getType() + " - " +
                    "Keywords: " + keywords.printKeywords(document.getKeywordsId()));
        }
    }
    public void newSearch(String typeOfSearch, String dataToSearch){
        switch (typeOfSearch) {
            case "title":
                printResult(documentManager.searchByTitle(dataToSearch));
                break;
            case "author":
                printResult(documentManager.searchByAuthor(dataToSearch));
                break;
            case "year":
                printResult(documentManager.searchByYearOfPublication(Integer.parseInt(dataToSearch)));
                break;
            case "type":
                switch (dataToSearch) {
                    case "1" -> dataToSearch = "Article";
                    case "2" -> dataToSearch = "Magazine";
                    case "3" -> dataToSearch = "Book";
                    case "4" -> dataToSearch = "Paper";
                }
                printResult(documentManager.searchByType(dataToSearch));
                break;
            case "keyword":
                printResult(documentManager.searchByKeyword(dataToSearch));
                break;
            default:
                break;
        }
    }
    public void printResult(ArrayList<Document> arrayList) {
        if (arrayList.isEmpty()) {
            System.out.println("No se encontraron resultados");
        } else {
            System.out.println("Resultados de la busqueda: ");
            for (Document document : arrayList) {
                System.out.println("-> Titulo " + document.getTitle() + " -" +
                        " Autores: " + authors.printAuthors(document.getAuthorsId()) +
                        " - Año de publicacion: " + document.getYearOfPublication() + " - " +
                        "Tipo: " + document.getType() + " - " +
                        "Keywords: " + keywords.printKeywords(document.getKeywordsId()));
            }
        }
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


        documentManager.add(new Article("La naturaleza es bella", autorDataExample1, 2021, "type", keywordDataExample2));
        documentManager.add(new Magazine("El principito", autorDataExample2, 2019, "type", keywordDataExample1));
        documentManager.add(new Paper("Nuevas bacterias del siglo 21", autorDataExample2, 2019, "type", keywordDataExample1));
    }
}
