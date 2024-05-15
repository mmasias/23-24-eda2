package entregas.garciaDiego.Reto003;

import java.util.ArrayList;
import java.util.Scanner;

public class Management {
    private ArrayList<Document> documents;

    public Management(ArrayList<Document> documents) {
        this.documents = documents;
    }

    public void add() {
        System.out.println("Enter the title of the document");
        Scanner s = new Scanner(System.in);
        String title = s.nextLine();
        System.out.println("Enter the year of publication");
        int year = s.nextInt();
        System.out.println("Enter the type of document");
        System.out.println("1. BOOK 2. MAGAZINE 3. ARTICLE 4. PAPER");
        int option = s.nextInt();
        Type type = null;
        switch (option) {
            case 1:
                type = Type.BOOK;
                break;
            case 2:
                type = Type.MAGAZINE;
                break;
            case 3:
                type = Type.ARTICLE;
                break;
            case 4:
                type = Type.PAPER;
                break;
            default:
                break;
        }
        boolean add = true;
        ArrayList<Author> authors = new ArrayList<Author>();
        do {
            System.out.println("Enter the name of the author");
            Scanner s2 = new Scanner(System.in);
            String name = s2.nextLine();
            System.out.println("Enter the last name of the author");
            String lastName = s2.nextLine();
            Author author = new Author(name, lastName);
            authors.add(author);
            System.out.println("Do you want to add another author? (yes-no)");
            String answer = s2.nextLine();
            if (answer.equals("no")) {
                add = false;
            } else {
                add = true;
            }
        } while (add);
        Document document = new Document(title, year, authors, type);
        String word = "";
        do {
            System.out.println("Enter keywords (end-to finish)");
            word = s.nextLine();
            if (!word.equals("end")) {
                document.addKeyword(word);
            }
        } while (!word.equals("end"));
        documents.add(document);
    }

    public void modify() {
        System.out.println("Enter the title of the document to modify");
        Scanner sc = new Scanner(System.in);
        String title = sc.nextLine();
        for (Document document : documents) {
            if (document.getTitle().equals(title)) {
                System.out.println("Enter the new title of the document");
                String newTitle = sc.nextLine();
                document.setTitle(newTitle);
                System.out.println("Enter the new year of publication");
                int newYear = sc.nextInt();
                document.setYearOfPublication(newYear);
                System.out.println("Enter the new type of document");
                System.out.println("1. BOOK 2. MAGAZINE 3. ARTICLE 4. PAPER");
                int option = sc.nextInt();
                Type type = null;
                switch (option) {
                    case 1:
                        type = Type.BOOK;
                        break;
                    case 2:
                        type = Type.MAGAZINE;
                        break;
                    case 3:
                        type = Type.ARTICLE;
                        break;
                    case 4:
                        type = Type.PAPER;
                        break;
                    default:
                        break;
                }
                document.setType(type);
                boolean add = true;
                do{
                    System.out.println("Enter the name of the author");
                    Scanner s3 = new Scanner(System.in);
                    String name = s3.nextLine();
                    System.out.println("Enter the last name of the author");
                    String lastName = s3.nextLine();
                    Author author = new Author(name, lastName);
                    ArrayList<Author> authors = new ArrayList<Author>();
                    authors.add(author);
                    document.setAuthors(authors);
                    System.out.println("Do you want to add another author? (yes-no)");
                    String answer = s3.nextLine();
                    if (answer.equals("no")) {
                        add = false;
                    } else {
                        add = true;
                    }
                }while(add);
                String word = "";
                do {
                    System.out.println("Enter keywords (end-to finish)");
                    word = sc.nextLine();
                    if (!word.equals("end")) {
                        document.addKeyword(word);
                    }
                } while (!word.equals("end"));
            }
        }
    }

    public void search() {
        System.out.println("Enter the title of the document to search");
        Scanner s = new Scanner(System.in);
        String title = s.nextLine();
        for (Document document : documents) {
            if (document.getTitle().equals(title)) {
                System.out.println("Title: " + document.getTitle());
                System.out.println("Year of publication: " + document.getYearOfPublication());
                System.out.println("Type: " + document.getType());
                System.out.println("Authors: ");
                for (Author author : document.getAuthors()) {
                    System.out.println(author.getFirstName() + " " + author.getLastName());
                }
                System.out.println("Keywords: ");
                for (String word : document.getKeywords()) {
                    System.out.println(word);
                }
            }
        }
    }

    public void searchByAuthor() {
        System.out.println("Enter the name of the author to search");
        Scanner s = new Scanner(System.in);
        String name = s.nextLine();
        for (Document document : documents) {
            for (Author author : document.getAuthors()) {
                if (author.getFirstName().equals(name)) {
                    System.out.println("Title: " + document.getTitle());
                    System.out.println("Year of publication: " + document.getYearOfPublication());
                    System.out.println("Type: " + document.getType());
                    System.out.println("Authors: ");
                    for (Author author2 : document.getAuthors()) {
                        System.out.println(author2.getFirstName() + " " + author2.getLastName());
                    }
                    System.out.println("Keywords: ");
                    for (String word : document.getKeywords()) {
                        System.out.println(word);
                    }
                }
            }
        }
    }

    public void searchByKeywords() {
        System.out.println("Enter the keyword to search");
        Scanner s = new Scanner(System.in);
        String word = s.nextLine();
        for (Document document : documents) {
            for (String keyword : document.getKeywords()) {
                if (keyword.equals(word)) {
                    System.out.println("Title: " + document.getTitle());
                    System.out.println("Year of publication: " + document.getYearOfPublication());
                    System.out.println("Type: " + document.getType());
                    System.out.println("Authors: ");
                    for (Author author : document.getAuthors()) {
                        System.out.println(author.getFirstName() + " " + author.getLastName());
                    }
                    System.out.println("Keywords: ");
                    for (String word2 : document.getKeywords()) {
                        System.out.println(word2);
                    }
                }
            }
        }
    }

    public void delete() {
        System.out.println("Enter the title of the document to delete");
        Scanner s = new Scanner(System.in);
        String title = s.nextLine();
        for (Document document : documents) {
            if (document.getTitle().equals(title)) {
                documents.remove(document);
                break;
            }
        }
    }

    public void menu() {
        boolean exit = false;
        do {
            System.out.println("1. Add document");
            System.out.println("2. Modify document");
            System.out.println("3. Search document");
            System.out.println("4. Search by author");
            System.out.println("5. Search by keywords");
            System.out.println("6. Delete document");
            System.out.println("7. Exit");
            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    add();
                    break;
                case 2:
                    modify();
                    break;
                case 3:
                    search();
                    break;
                case 4:
                    searchByAuthor();
                    break;
                case 5:
                    searchByKeywords();
                    break;
                case 6:
                    delete();
                    break;
                case 7:
                    exit = true;
                    break;
                default:
                    break;
            }
        } while (!exit);
    }
}
