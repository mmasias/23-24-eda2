import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Document {
    String title;
    int PublishedYear;
    int Tipeofdocument;
    ArrayList<Author> authors;
    ArrayList<String> keywords;

    public Document(String title, int PublishedYear, int Tipeofdocument) {
        this.title = title;
        this.PublishedYear = PublishedYear;
        this.Tipeofdocument = Tipeofdocument;
        authors = new ArrayList<Author>();
        keywords = new ArrayList<String>();

    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addKeyword(String keyword) {
        keywords.add(keyword);
    }

    public void editAuthor(Author author, int index) {
        authors.set(index, author);
    }

    public void editKeyword(String keyword, int index) {
        keywords.set(index, keyword);
    }

    public void deleteAuthor(int index) {
        authors.remove(index);
    }   

    public void deleteKeyword(int index) {
        keywords.remove(index);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPublishedYear() {
        return PublishedYear;
    }

    public void setPublishedYear(int PublishedYear) {
        this.PublishedYear = PublishedYear;
    }

    public int getTipeofdocument() {
        return Tipeofdocument;
    }

    public void setTipeofdocument(int Tipeofdocument) {
        this.Tipeofdocument = Tipeofdocument;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public ArrayList<String> getKeywords() {
        return keywords;
    }

    public void identifyTipeofdocument(int Tipeofdocument){
        switch(Tipeofdocument){
            case 0:
                System.out.println("Libro");
                break;
            case 1:
                System.out.println("Revista");
                break;
            case 2:
                System.out.println("Tesis");
                break;
            case 3:
                System.out.println("Artículo");
                break;
            default:
                System.out.println("Tipo de documento no válido");
                break;
        }
    }

    public void printDocument(){
        System.out.println("Título: " + title);
        System.out.println("Año de publicación: " + PublishedYear);
        identifyTipeofdocument(Tipeofdocument);
        System.out.println("Autores: ");
        for (int i = 0; i < authors.size(); i++) {
            System.out.println(authors.get(i).getfirstname() + " " + authors.get(i).getlastname());
        }
        System.out.println("Palabras clave: ");
        for (int i = 0; i < keywords.size(); i++) {
            System.out.println(keywords.get(i));
        }
    }

    public void editDocument() {
        Scanner scanner = new Scanner(System.in);
        boolean editing = true;
        while (editing) {
            System.out.println("¿Qué desea editar?");
            System.out.println("1. Título");
            System.out.println("2. Año de publicación");
            System.out.println("3. Tipo de documento");
            System.out.println("4. Autores");
            System.out.println("5. Palabras clave");
            System.out.println("6. Salir");
            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    System.out.println("Ingrese el nuevo título");
                    String newTitle = scanner.nextLine();
                    setTitle(newTitle);
                    break;
                case "2":
                    System.out.println("Ingrese el nuevo año de publicación");
                    int newPublishedYear = scanner.nextInt();
                    setPublishedYear(newPublishedYear);
                    break;
                case "3":
                    boolean typeEstablished = false;
                    int newTypeOfDocument = 0;
                    while (!typeEstablished) {
                        System.out.println("Ingrese el nuevo tipo de documento");
                        System.out.println("1. Libro");
                        System.out.println("2. Revista");
                        System.out.println("3. Artículo");
                        System.out.println("4. Paper Científico");
                        newTypeOfDocument = (scanner.nextInt() - 1);
                        if (newTypeOfDocument < 0 || newTypeOfDocument > 3) {
                            System.out.println("Tipo de documento no válido");
                        } else {
                            typeEstablished = true;
                            break;
                        }
                    }
                    setTipeofdocument(newTypeOfDocument);
                    break;
                case "4":
                    System.out.println("Ingrese el nombre o apellido del autor que desea editar:");
                    String authorName = scanner.nextLine();
                    int authorIndex = findAuthorIndex(authorName);
                    if (authorIndex != -1) {
                        System.out.println("Autor encontrado. Ingrese el nuevo nombre del autor:");
                        String newFirstName = scanner.nextLine();
                        System.out.println("Ingrese el nuevo apellido del autor:");
                        String newLastName = scanner.nextLine();
                        Author newAuthor = new Author(newFirstName, newLastName);
                        editAuthor(newAuthor, authorIndex);
                        System.out.println("Autor editado con éxito.");
                    } else {
                        System.out.println("El autor no fue encontrado.");
                    }
                    break;
                case "5":
                    System.out.println("Ingrese la palabra clave que desea editar:");
                    String keyword = scanner.nextLine();
                    int keywordIndex = findKeywordIndex(keyword);
                    if (keywordIndex != -1) {
                        System.out.println("Palabra clave encontrada. Ingrese la nueva palabra clave:");
                        String newKeyword = scanner.nextLine();
                        editKeyword(newKeyword, keywordIndex);
                        System.out.println("Palabra clave editada con éxito.");
                    } else {
                        System.out.println("La palabra clave no fue encontrada.");
                    }
                    break;
                case "6":
                    editing = false;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }
    }

    public int findAuthorIndex(String name) {
        for (int i = 0; i < authors.size(); i++) {
            Author author = authors.get(i);
            if (author.getfirstname().equalsIgnoreCase(name) || author.getlastname().equalsIgnoreCase(name)) {
                return i;
            }
        }
        return -1;
    }

    public int findKeywordIndex(String keyword) {
        return keywords.indexOf(keyword);
    }

    public static void main(String[] args) {
        Document document = new Document("El principito", 1943, 0);
        Author author = new Author("Antoine", "de Saint-Exupéry");
        document.addKeyword("Infantil");
        document.addAuthor(author);
        System.out.println(document.getTitle());
        System.out.println(document.getPublishedYear());
        document.identifyTipeofdocument(document.getTipeofdocument());
        System.out.println(document.authors.get(0).getfirstname() + " " + document.authors.get(0).getlastname());
        System.out.println(document.keywords.get(0));
    }

}

