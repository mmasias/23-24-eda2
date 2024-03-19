package typeDocument;

import searches.AuthorManager;
import searches.KeywordManager;

import java.util.ArrayList;
import java.util.Scanner;

public abstract class Document {
    Scanner input = new Scanner(System.in);
    private String title;
    private int yearOfPublication;
    private String type;
    private ArrayList<Integer> authorsId = new ArrayList<>();
    private ArrayList<Integer> keywordsId = new ArrayList<>();

    public Document(String title, ArrayList<Integer> authors, int yearOfPublication, String type, ArrayList<Integer> keywords){
        this.title = title;
        this.authorsId = authors;
        this.yearOfPublication = yearOfPublication;
        this.type = type;
        this.keywordsId = keywords;
    }
    public Document() {}
    public void printDocument(Document document, AuthorManager authors, KeywordManager keywords) {
        System.out.println(document.toString(authors, keywords));
    }
    protected void addTitle(){
        System.out.println("Ingrese el título del documento: ");
        System.out.print("-> ");
        this.title = input.nextLine();

    }
    protected void addYearOfPublication(){
        System.out.println("Ingrese el año de publicación: ");
        System.out.print("-> ");
        this.yearOfPublication = Integer.parseInt(input.nextLine());
    }
    protected void addAuthor(AuthorManager authors) {
        boolean isExistAuthor = true;
        System.out.println("Estos son los autores ya existentes, si encuentra el suyo ingrese el numero, sino ingrese el nombre del nuevo a guardar: ");
        authors.showAllAuthors();
        ArrayList<Integer> chooseAuthors = new ArrayList<>();

        while (isExistAuthor) {
            System.out.print("-> ");
            String userInput = input.nextLine();
            if (userInput.matches("\\d+")) {
                int idAuthor = Integer.parseInt(userInput);
                chooseAuthors.add(idAuthor);
            } else {
                authors.addAuthor(userInput);
                int idAuthor = authors.showAuthorByName(userInput);
                if (idAuthor != -1) {
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
    protected void addKeyword(KeywordManager keywords) {
        boolean isExistKeyword = true;
        System.out.println("Estas son las palabras clave ya existentes, si encuentra la suya ingrese el numero, sino ingrese la nueva palabra clave a guardar: ");
        keywords.showAllKeywords();
        ArrayList<Integer> chooseKeywords = new ArrayList<>();

        while (isExistKeyword) {
            System.out.print("-> ");
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
        return this.title;
    }
    public int getYearOfPublication() {
        return this.yearOfPublication;
    }
    public String getType() {
        return this.type;
    }
    public ArrayList<Integer> getKeywordsId() {
        return this.keywordsId;
    }
    public ArrayList<Integer> getAuthorsId() {
        return this.authorsId;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String toString(AuthorManager author, KeywordManager keywords) {
        return "# Titulo: " + title + " - Autores: " + author.printAuthors(authorsId) + " - Año de publicación: " + yearOfPublication + " - Tipo: " + type + " - Palabras clave: " + keywords.printKeywords(keywordsId);
    }
}
