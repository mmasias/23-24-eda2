package entregas.canteroPablo.Reto003;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private ArrayList<Document> documentList;

    public Library() {
        documentList = new ArrayList<>();
    }

    public ArrayList<Document> getDocumentList() {
        return documentList;
    }

    public void setDocumentList(ArrayList<Document> documentList) {
        this.documentList = documentList;
    }

    public void addDocument() {
        System.out.println("Nombre del documento: ");
        Scanner userInput = new Scanner(System.in);
        String tittle = userInput.nextLine();
        ArrayList<Author> authorList = new ArrayList<Author>();
        System.out.println("¿Cuántos autores tiene el documento? ");
        int numberAuthors = userInput.nextInt();
        userInput.nextLine();

        for (int i = 0; i < numberAuthors; i++) {
            System.out.println("Nombre del autor: ");
            String name = userInput.nextLine();
            System.out.println("Apellido del autor: ");
            String surname = userInput.nextLine();
            Author author = new Author(name, surname);
            authorList.add(author);
        }
        System.out.println("Año de publicacion: ");
        int age = userInput.nextInt();
        boolean validTypeOfDocument = true;
        String typeDocument = "";
        do {
            System.out.println("Tipo de documento: (1-Libro, 2-Revista, 3-Artículo, 4-Paper) ");
            int numberDocument = userInput.nextInt();

            if (numberDocument == 1) {
                typeDocument = "Libro";

            } else if (numberDocument == 2) {
                typeDocument = "Revista";

            } else if (numberDocument == 3) {
                typeDocument = "Artículo";
            } else if (numberDocument == 4) {
                typeDocument = "Paper";
            } else {
                System.out.println("Tipo de documento no valido, ingrese otro");
                validTypeOfDocument = false;

            }

        } while (validTypeOfDocument = false);
        ArrayList<String> keyWords = new ArrayList<String>();
        System.out.println("¿Cuántos palabras clave tiene el documento? ");
        int numberKeyWords = userInput.nextInt();
        userInput.nextLine();

        for (int i = 0; i < numberKeyWords; i++) {
            System.out.println("Palabras Clave: ");
            String keyword = userInput.nextLine();
            keyWords.add(keyword);

        }
        Document document = new Document(tittle, authorList, age, typeDocument, keyWords);
        documentList.add(document);
        System.out.println("Documento añadido correctamente");

    }

    public void printDocumentListing() {
        if (documentList.isEmpty()) {
            System.out.println("No hay documentos en la lista.");
        } else {
            System.out.println("Lista de documentos:");
            for (Document document : documentList) {
                System.out.println("Título: " + document.getTittle());
                System.out.println("Autores:");
                for (Author author : document.getAuthor()) {
                    System.out.println("- " + author.getName() + " " + author.getSurname());
                }
                System.out.println("Año de publicación: " + document.getAge());
                System.out.println("Tipo de documento: " + document.getTypeDocument());
                System.out.println("Palabras clave:");
                for (String keyword : document.getKeyWords()) {
                    System.out.println("- " + keyword);
                }
                System.out.println();
            }
        }
    }

    public void editDocument() {

        System.out.println("¿Que documento quieres editar?");
        Scanner userInput = new Scanner(System.in);
        String tittle = userInput.nextLine();
        boolean validOption = true;
        if (documentList.get(0).getTittle().equals(tittle)) {

            do {
                System.out.println("Que quieres editar");
                System.out.println(
                        "1- Titulo,2- Autores, 3- Año de publicacion, 4- Tipo de documento, 5- Palabras clave, 6-Salir");
                int option = userInput.nextInt();
                if (option == 1) {
                    System.out.println("Nuevo titulo: ");
                    String newTittle = userInput.nextLine();
                    documentList.get(0).setTittle(newTittle);
                } else if (option == 2) {
                    ArrayList<Author> authorList = new ArrayList<Author>();
                    System.out.println("¿Cuántos autores tiene el documento? ");
                    int numberAuthors = userInput.nextInt();
                    userInput.nextLine();

                    for (int i = 0; i < numberAuthors; i++) {
                        System.out.println("Nombre del autor: ");
                        String name = userInput.nextLine();
                        System.out.println("Apellido del autor: ");
                        String surname = userInput.nextLine();
                        Author author = new Author(name, surname);
                        authorList.add(author);
                    }
                    documentList.get(0).setAuthor(authorList);
                } else if (option == 3) {
                    System.out.println("Año de publicacion: ");
                    int age = userInput.nextInt();
                    documentList.get(0).setAge(age);
                } else if (option == 4) {
                    boolean validTypeOfDocument = true;
                    String typeDocument = "";
                    do {
                        System.out.println("Tipo de documento: (1-Libro, 2-Revista, 3-Artículo, 4-Paper) ");
                        int numberDocument = userInput.nextInt();

                        if (numberDocument == 1) {
                            typeDocument = "Libro";

                        } else if (numberDocument == 2) {
                            typeDocument = "Revista";

                        } else if (numberDocument == 3) {
                            typeDocument = "Artículo";
                        } else if (numberDocument == 4) {
                            typeDocument = "Paper";
                        } else {
                            System.out.println("Tipo de documento no valido, ingrese otro");
                            validTypeOfDocument = false;

                        }

                    } while (validTypeOfDocument = false);
                    documentList.get(0).setTypeDocument(typeDocument);
                } else if (option == 5) {
                    ArrayList<String> keyWords = new ArrayList<String>();
                    System.out.println("¿Cuántos palabras clave tiene el documento? ");
                    int numberKeyWords = userInput.nextInt();
                    userInput.nextLine();

                    for (int i = 0; i < numberKeyWords; i++) {
                        System.out.println("Palabras Clave: ");
                        String keyword = userInput.nextLine();
                        keyWords.add(keyword);

                    }
                    documentList.get(0).setKeyWords(keyWords);
                } else if (option == 6) {

                } else {
                    System.out.println("Opcion no valida");
                    validOption = false;
                }

            } while (validOption = false);
        } else {
            System.out.println("El documento no existe");

        }

    }

    public void deleteDocument() {
        System.out.println("¿Que documento quieres eliminar?");
        Scanner userInput = new Scanner(System.in);
        String tittle = userInput.nextLine();
        if (documentList.contains(tittle)) {
            documentList.remove(tittle);
        } else {
            System.out.println("El documento no existe");
        }
    }

    public void searchDocument() {
        System.out.println("¿Que documento quieres buscar?");
        Scanner userInput = new Scanner(System.in);
        String tittle = userInput.nextLine();
        if (documentList.contains(tittle)) {
            printDocumentListing();
        } else {
            System.out.println("El documento no existe");
        }
    }

    public void searchDocumentByAuthor() {
        System.out.println("¿Que autor quieres buscar?");
        Scanner userInput = new Scanner(System.in);
        String name = userInput.nextLine();
        String surname = userInput.nextLine();
        boolean validAuthor = false;
        for (Document document : documentList) {
            for (Author author : document.getAuthor()) {
                if (author.getName().equals(name) && author.getSurname().equals(surname)) {
                    printDocumentListing();
                    System.out.println();
                    validAuthor = true;
                }
            }
        }
        if (validAuthor == false) {
            System.out.println("El autor no existe");
        }
    }

    public void searchDocumentByAge() {
        System.out.println("¿Que año quieres buscar?");
        Scanner userInput = new Scanner(System.in);
        int age = userInput.nextInt();
        boolean validAge = false;
        for (Document document : documentList) {
            if (document.getAge() == age) {
                printDocumentListing();
                validAge = true;
            }
        }
        if (validAge == false) {
            System.out.println("El año no existe");
        }
    }

    public void searchDocumentByTypeOfDocument() {
        System.out.println("¿Que tipo de documento quieres buscar?");
        Scanner userInput = new Scanner(System.in);
        boolean validTypeOfDocument = true;
        String typeDocument = "";
        do {
            System.out.println("Tipo de documento: (1-Libro, 2-Revista, 3-Artículo, 4-Paper) ");
            int numberDocument = userInput.nextInt();

            if (numberDocument == 1) {
                typeDocument = "Libro";

            } else if (numberDocument == 2) {
                typeDocument = "Revista";

            } else if (numberDocument == 3) {
                typeDocument = "Artículo";
            } else if (numberDocument == 4) {
                typeDocument = "Paper";
            } else {
                System.out.println("Tipo de documento no valido, ingrese otro");
                validTypeOfDocument = false;

            }

        } while (validTypeOfDocument = false);
        boolean validType = false;
        for (Document document : documentList) {
            if (document.getTypeDocument().equals(typeDocument)) {
                printDocumentListing();
                System.out.println();
                validType = true;
            }
        }
        if (validType == false) {
            System.out.println("El tipo de documento no existe");
        }
    }

    public void searchDocumentByKeyWords() {
        System.out.println("¿Que palabra clave quieres buscar?");
        Scanner userInput = new Scanner(System.in);
        String keyword = userInput.nextLine();
        boolean validKeyword = false;
        for (Document document : documentList) {
            if (document.getKeyWords().contains(keyword)) {
                printDocumentListing();
                validKeyword = true;
            }
        }
        if (validKeyword == false) {
            System.out.println("La palabra clave no existe");
        }
    }

    public void menu() {
        boolean continuar = true;
        do {
            System.out.println("1- Añadir documento");
            System.out.println("2- Editar documento");
            System.out.println("3- Eliminar documento");
            System.out.println("4- Buscar documento");
            System.out.println("5- Buscar documento por autor");
            System.out.println("6- Buscar documento por año de publicacion");
            System.out.println("7- Buscar documento por tipo de documento");
            System.out.println("8- Buscar documento por palabras clave");
            System.out.println("9- Listar documentos");
            System.out.println("10- Salir");
            Scanner userInput = new Scanner(System.in);
            int option = userInput.nextInt();
            if (option == 1) {
                addDocument();
            } else if (option == 2) {
                editDocument();
            } else if (option == 3) {
                deleteDocument();
            } else if (option == 4) {
                searchDocument();
            } else if (option == 5) {
                searchDocumentByAuthor();
            } else if (option == 6) {
                searchDocumentByAge();
            } else if (option == 7) {
                searchDocumentByTypeOfDocument();
            } else if (option == 8) {
                searchDocumentByKeyWords();
            } else if (option == 9) {
                printDocumentListing();
            } else if (option == 10) {
                continuar = false;

            } else {
                System.out.println("Opcion no valida");
            }
        } while (continuar == true);
        System.out.println("Adios");

    }
}
