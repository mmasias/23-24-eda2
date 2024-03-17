package searches;

import typeDocument.Document;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchEngine {
    Scanner input = new Scanner(System.in);

    public void searchDocument(ArrayList<Document> documents, Author authors, Keyword keywords){
        System.out.println("Ingrese la característica por la que desea buscar (solo números): ");
        System.out.println("1. Título");
        System.out.println("2. Autor");
        System.out.println("3. Año de publicación");
        System.out.println("4. Tipo de documento");
        System.out.println("5. Palabra clave");
        System.out.print("-> ");
        SearchDocument document = new SearchDocument(documents, authors, keywords);

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
}
