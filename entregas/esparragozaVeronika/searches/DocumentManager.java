package searches;

import typeDocument.Document;

import java.util.ArrayList;
import java.util.Scanner;

public class DocumentManager {
    Scanner input = new Scanner(System.in);
    private final ArrayList<Document> documents;
    private final AuthorManager authors;
    private final KeywordManager keywords;

    public DocumentManager(ArrayList<Document> documents, AuthorManager authors, KeywordManager keywords){
        this.documents = documents;
        this.authors = authors;
        this.keywords = keywords;
    }

    public void search(ArrayList<Document> documents, AuthorManager authors, KeywordManager keywords){
        System.out.println("Ingrese la característica por la que desea buscar (solo números): ");
        System.out.println("1. Título");
        System.out.println("2. Autor");
        System.out.println("3. Año de publicación");
        System.out.println("4. Tipo de documento");
        System.out.println("5. Palabra clave");
        System.out.print("-> ");
        DocumentManager document = new DocumentManager(documents, authors, keywords);

        switch (input.nextInt()){
            case 1:
                System.out.println("Ingrese el título del documento: ");
                System.out.print("-> ");
                input.nextLine();
                document.newSearch("title", input.nextLine());
                break;
            case 2:
                System.out.println("Ingrese el nombre del autor: ");
                System.out.print("-> ");
                input.nextLine();
                document.newSearch("author", input.nextLine());
                break;
            case 3:
                System.out.println("Ingrese el año de publicación: ");
                System.out.print("-> ");
                document.newSearch("year", input.next());
                break;
            case 4:
                System.out.println("Los tipos de documentos son los siguientes (solo números):");
                System.out.println("1. Artículo");
                System.out.println("2. Revista");
                System.out.println("3. Libro");
                System.out.println("4. Paper científico");
                System.out.print("-> ");
                document.newSearch("type", input.next());
                break;
            case 5:
                System.out.println("Ingrese la palabra clave a buscar: ");
                System.out.print("-> ");
                input.nextLine();
                document.newSearch("keyword", input.nextLine());
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }

    public void newSearch(String typeOfSearch, String dataToSearch){
        switch (typeOfSearch) {
            case "title":
                printResult(searchByTitle(dataToSearch));
                break;
            case "author":
                printResult(searchByAuthor(dataToSearch));
                break;
            case "year":
                printResult(searchByYearOfPublication(Integer.parseInt(dataToSearch)));
                break;
            case "type":
                switch (dataToSearch) {
                    case "1" -> dataToSearch = "Article";
                    case "2" -> dataToSearch = "Magazine";
                    case "3" -> dataToSearch = "Book";
                    case "4" -> dataToSearch = "Paper";
                }
                printResult(searchByType(dataToSearch));
                break;
            case "keyword":
                printResult(searchByKeyword(dataToSearch));
                break;
            default:
                break;
        }
    }
    private ArrayList<Document> searchByTitle(String title){
        ArrayList<Document> result = new ArrayList<>();
        for (Document document : documents) {
            if (document.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(document);
            }
        }
        return result;
    }
    public ArrayList<Document> searchByAuthor(String authorName) {
        ArrayList<Document> result = new ArrayList<>();
        if (authors != null) {
            ArrayList<String> similarAuthors = authors.findSimilarAuthors(authorName);
            for (String similarAuthor : similarAuthors) {
                int authorId = authors.showAuthorByName(similarAuthor);
                if (authorId != -1) {
                    for (Document document : documents) {
                        if (document.getAuthorsId().contains(authorId)) {
                            result.add(document);
                        }
                    }
                }
            }
        }
        return result;
    }
    private ArrayList<Document> searchByYearOfPublication(int year){
        ArrayList<Document> result = new ArrayList<>();
        for (Document document : documents) {
            if (document.getYearOfPublication() == (year)) {
                result.add(document);
            }
        }
        return result;
    }
    private ArrayList<Document> searchByType(String type){
        ArrayList<Document> result = new ArrayList<>();
        for (Document document : documents) {
            if (document.getType().equals(type)) {
                result.add(document);
            }
        }
        return result;
    }
    public ArrayList<Document> searchByKeyword(String keywordName) {
        ArrayList<Document> result = new ArrayList<>();
        if (keywords != null) {
            int keywordId = keywords.showKeywordByName(keywordName);
            if (keywordId != -1) {
                for (Document document : documents) {
                    if (document.getKeywordsId().contains(keywordId)) {
                        result.add(document);
                    }
                }
            }
        }
        return result;
    }
    public void printResult(ArrayList<Document> arrayList) {
        if (arrayList.isEmpty()) {
            System.out.println("No se encontraron resultados");
        } else {
            System.out.println("Resultados de la busqueda: ");
            for (Document object : arrayList) {
                System.out.println("-> " + object.toString(this.authors, this.keywords));
            }
        }
    }
}
