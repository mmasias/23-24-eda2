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
        this.yearOfPublication = Integer.parseInt(input.nextLine());
        return yearOfPublication;
    }

    protected void addAuthor(Author authors) {
        boolean isExistAuthor = true;
        System.out.println("Estos son los autores ya existentes, si encuentra el suyo ingrese el numero, sino ingrese el nombre del nuevo a guardar: ");
        authors.showAllAuthors();
        ArrayList<Integer> chooseAuthors = new ArrayList<>();

        while (isExistAuthor) {
            String userInput = input.nextLine();
            if (userInput.matches("\\d+")) {
                int idAuthor = Integer.parseInt(userInput);
                chooseAuthors.add(idAuthor);
            } else {
                authors.addAuthor(userInput);
                int idAuthor = authors.showAuthorByName(userInput);
                if (idAuthor != -1){
                chooseAuthors.add(idAuthor);
                }
            }
            System.out.println("Desea agregar otro autor? (s/n)");
            if (input.nextLine().equalsIgnoreCase("n")){
                isExistAuthor = false;
            }
        }
        this.authorsId = chooseAuthors;
    }

    protected void addKeyword(Keyword keywords) {
        boolean isExistKeyword = true;
        System.out.println("Estas son las palabras clave ya existentes, si encuentra la suya ingrese el numero, sino ingrese la nueva palabra clave a guardar: ");
        keywords.showAllKeywords();
        ArrayList<Integer> chooseKeywords = new ArrayList<>();

        while (isExistKeyword) {
            String userInput = input.nextLine();
            if (userInput.matches("\\d+")) {
                int idKeyword = Integer.parseInt(userInput);
                chooseKeywords.add(idKeyword);
            } else {
                keywords.addKeyword(userInput);
                int idKeyword = keywords.showKeywordByName(userInput);
                if (idKeyword != -1) {
                    chooseKeywords.add(idKeyword);
                }
            }
            System.out.println("Desea agregar otra palabra clave? (s/n)");
            if (input.nextLine().equalsIgnoreCase("n")) {
                isExistKeyword = false;
            }
        }
        this.keywordsId = chooseKeywords;
    }

    public String getTitle() {
        return title;
    }
    public void setType(String type) {
        this.type = type;
    }
}
