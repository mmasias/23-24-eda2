package typeDocument;

import searches.Author;
import searches.Keyword;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Document {
    Scanner input = new Scanner(System.in);
    private String title;
    private ArrayList<Integer> authorsId = new ArrayList<>();
    private int yearOfPublication;
    private String type;
    private ArrayList<Integer> keywordsId = new ArrayList<>();


    public Document(String title, ArrayList<Integer> authors, int yearOfPublication, String type, ArrayList<Integer> keywords){
        this.title = title;
        this.authorsId = authors;
        this.yearOfPublication = yearOfPublication;
        this.type = type;
        this.keywordsId = keywords;
    }

    public Document() {}

    public void printDocument(Author author, Keyword keywords) {
        System.out.println("--> " + "Titulo: " + title + " - Autores: " +   author.printAuthors(authorsId) + " - Año de publicación: " + yearOfPublication + " - Tipo: " + type + " - Palabras clave: " + keywords.printKeywords(keywordsId));
    }

    protected String addTitle(){
        System.out.println("Ingrese el título del documento: ");
        this.title = input.nextLine();
        return title;
    }
    protected int addYearOfPublication(){
        System.out.println("Ingrese el año de publicación: ");
        this.yearOfPublication = Integer.parseInt(input.next());
        return yearOfPublication;
    }
    protected ArrayList<String> addAuthors(){
        ArrayList<String> authors = new ArrayList<>();
        boolean createAuthors = true;
        while(createAuthors){
            System.out.println("Ingrese un autor del documento: ");
            String author = input.nextLine();
            authors.add(author);

            System.out.println("Desea agregar otro autor? (s/n)");
            if (input.next().equals("n")){
                createAuthors = false;
            }
        }
        return authors;
    }
    protected ArrayList<String> addKeywords(){
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
    public void setType(String type) {
        this.type = type;
    }
}
