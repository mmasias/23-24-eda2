import java.util.ArrayList;
import java.util.Scanner;

public class DocumentManagement {
    Scanner input = new Scanner(System.in);
    public void run(){
        initialMenu();
    }

    public void initialMenu(){
        System.out.println("Ingrese lo que desea hacer: ");
        System.out.println("1. Añadir un nuevo un documento");
        System.out.println("2. Buscar un documento");
        System.out.println("3. Salir");

        switch (input.nextInt()){
            case 1:
                addDocument();
                break;
            case 2:
                //searchDocument();
                System.out.println("Buscando...");
                break;
            case 3:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
    }


    private String addTitle(){
        System.out.println("Ingrese el título del documento: ");
        String title = input.next();
        return title;
    }
    private String addYearOfPublication(){
        System.out.println("Ingrese el año de publicación: ");
        String yearOfPublication = input.next();
        return yearOfPublication;
    }
    private TypeDocument addType(){
        System.out.println("Ingrese el tipo de documento: ");
        TypeDocument type = TypeDocument.valueOf(input.next());
        return type;
    }
    private ArrayList<String> addAuthors(){
        ArrayList<String> authors = new ArrayList<>();
        boolean createAuthors = true;
        while(createAuthors){
            System.out.println("Ingrese un autor del documento: ");
            String author = input.next();
            authors.add(author);

            System.out.println("Desea agregar otro autor? (s/n)");
            if (input.next().equals("n")){
                createAuthors = false;
            }
        }
        return authors;
    }
    private ArrayList<String> addKeywords(){
        ArrayList<String> keywords = new ArrayList<>();
        boolean createKeywords = true;
        while(createKeywords){
            System.out.println("Ingrese una palabra clave/tema del documento: ");
            String author = input.next();
            keywords.add(author);

            System.out.println("Desea agregar otra palabra clave? (s/n)");
            if (input.next().equals("n")){
                createKeywords = false;
            }
        }
        return keywords;
    }

    protected void addDocument(){
        new Document(addTitle(), addAuthors(), addYearOfPublication(), addType(), addKeywords());
    }
}
