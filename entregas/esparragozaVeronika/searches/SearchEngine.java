package searches;

import java.util.Scanner;

public class SearchEngine {
    Scanner input = new Scanner(System.in);

    public void searchDocument(){
        System.out.println("Ingrese la caracteristica por la que desea buscar: ");
        System.out.println("1. Título");
        System.out.println("2. Autor");
        System.out.println("3. Año de publicación");
        System.out.println("4. Tipo de documento");
        System.out.println("5. Palabra clave");

        switch (input.nextInt()){
        case 1:
            System.out.println("Ingrese el título del documento: ");
            new SearchDocument("title", input.next());
            break;
        case 2:
            new SearchDocument("author", input.next());
            break;
        case 3:
            new SearchDocument("year", input.next());
            break;
        case 4:
            new SearchDocument("type", input.next());
            break;
        case 5:
            new SearchDocument("keyword", input.next());
            break;
        default:
            System.out.println("Opción no válida");
            break;
        }
    }
}
