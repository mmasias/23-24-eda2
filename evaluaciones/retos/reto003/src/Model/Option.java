package Model;

import java.util.ArrayList;
import java.util.Scanner;

public class Option {
    private ArrayList<Document> documents = new ArrayList<>();
    Library digitalLibrary;
    Scanner userInput = new Scanner(System.in);

    public Option() {
        this.digitalLibrary = new Library(documents);
    }

    public void createDocument(String documentType) {
        int authorCount = 0;
        int wordsCount = 0;
        ArrayList<Author> authors = new ArrayList<>();
        ArrayList<String> keyWords = new ArrayList<>();
        Document documentCreated = null;

        System.out.println("Introduce el nombre del documento: ");
        String documentName = userInput.nextLine();

        System.out.println("Introduce la cantidad de autores del documento: ");
        int authorNumber = Integer.parseInt(userInput.nextLine());

        while (authorCount != authorNumber) {
            System.out.println("Introduce el nombre del autor: ");
            String authorName = userInput.nextLine();

            
            System.out.println("Introduce los apellidos del autor: ");
            String authorSurnames = userInput.nextLine();

            Author author = new Author(authorName, authorSurnames);
            authors.add(author);
            authorCount++;
        }

        System.out.println("Introduce el año de publicación del documento: ");
        int publishingYear = userInput.nextInt();

        System.out.println("Introduce el número de temas/palabras clave del documento: ");
        int keyWordNumber = userInput.nextInt();
        userInput.nextLine();

        while (wordsCount != keyWordNumber) {
            System.out.println("Introduce el tema/palabra clave: ");
            String keyWord = userInput.nextLine();
            keyWords.add(keyWord);
            
            wordsCount++;
        }
        
        switch(documentType) {
            case "Artículo":
                documentCreated = new Article(documentName, authors, publishingYear, documentType, keyWords);
                break;
            case "Libro":
                System.out.println("Introduce el número de páginas: ");
                int numPages = userInput.nextInt();
                documentCreated = new Book(documentName, authors, publishingYear, documentType, keyWords, numPages);
                break;
            case "Paper Científico":
                documentCreated = new ScientificPaper(documentName, authors, publishingYear, documentType, keyWords);
                break;
            case "Revista":
                documentCreated = new Magazine(documentName, authors, publishingYear, documentType, keyWords);
                break;
        }
        digitalLibrary.addDocument(documentCreated);
        
    }

    public void editDocument(String documentTitle) {
        Document documentSearched = digitalLibrary.searchDocumentByName(documentTitle);

        if (documentSearched != null) {
            System.out.println("¿Qué quiere editar del documento " + documentTitle + "?");
            System.out.println("T - Título | A - Autor | P - Año de Publicación | K - Palabra Clave | Y - Tipo | S - Salir");
            String chosenOption = userInput.nextLine();
                    
            switch(chosenOption) {
                case "T": 
                    System.out.println("Introduce el nuevo título: ");
                    String newTitle = userInput.nextLine();
                    digitalLibrary.editDocumentName(documentSearched.getTitle(), newTitle);
                    break;
                case "A":
                    System.out.println("Introduce el nombre del autor a editar: ");
                    String oldName = userInput.nextLine();
                    System.out.println("Introduce los apellidos del autor a editar: ");
                    String oldSurname = userInput.nextLine();

                    System.out.println("Introduce el nuevo nombre del autor: ");
                    String newName = userInput.nextLine();
                    System.out.println("Introduce los nuevos apellidos del autor: ");
                    String newSurname = userInput.nextLine();

                    Author oldAuthor = documentSearched.getAuthor(oldName, oldSurname);
                    Author newAuthor = new Author(newName, newSurname);
                    digitalLibrary.editDocumentAuthor(documentTitle, oldAuthor ,newAuthor);
                    break;
                        
                case "P": 
                    System.out.println("Introduce el nuevo año de publicación: ");
                    int newYear = userInput.nextInt();

                    digitalLibrary.editDocumentPublishingYear(documentSearched.getTitle(), documentSearched.getPublishingYear(), newYear);
                    break;
                case "K":
                    System.out.println("Introduce la palabra clave a editar: ");
                    String oldKeyWord = userInput.nextLine();

                    System.out.println("Introduce la nueva palabra clave: ");
                    String newKeyWord = userInput.nextLine();

                    digitalLibrary.editDocumentKeyWord(documentSearched.getTitle(), oldKeyWord, newKeyWord);
                    break;
                case "Y": 
                    System.out.println("Introduce el nuevo tipo de documento (Revista, Artículo, Paper Científico o Libro): ");
                    String newType = userInput.nextLine();
                    digitalLibrary.editDocumentType(documentSearched.getTitle(), documentSearched.getDocumentType(), newType);
                    break;
                case "S":
                    break;
            }
        }
        
    }
    public void deleteDocument(String documentTitle) {
        this.digitalLibrary.deleteDocument(documentTitle);
    }
    public void showDocuments() {
        this.digitalLibrary.printDocumentListing();
    }
}

