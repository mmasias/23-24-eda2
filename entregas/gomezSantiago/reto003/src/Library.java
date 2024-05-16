import java.awt.*;
import java.util.LinkedList;
import java.util.Scanner;
public class Library {
    public static void main(String[] args) {

        final String ANSI_CYAN = "\u001B[36m";
        final String ANSI_RED = "\u001B[31m";
        final String ANSI_PURPLE = "\u001B[35m";
        final String ANSI_RESET = "\u001B[0m";


        Manager manager = new Manager();
        Scanner scanner = new Scanner(System.in);
        OptionMenu options = new OptionMenu();


        DocumentType tipo1 = new DocumentType("Libro");
        DocumentType tipo2 = new DocumentType("Revista");
        DocumentType tipo3 = new DocumentType("Articulo");
        DocumentType tipo4 = new DocumentType("Paper Cientifico");

        manager.addDocumentType(tipo1);
        manager.addDocumentType(tipo2);
        manager.addDocumentType(tipo3);
        manager.addDocumentType(tipo4);


        while (true) {
            options.menu1();
            int userOption = scanner.nextInt();

            switch (userOption) {
                case 1:
                    options.division();
                    manager.listDocumentTypes();
                    options.division();
                    break;
                case 2:
                    options.division();
                    boolean tipoValido = false;
                    String tipoDocumento = "";
                    while (!tipoValido) {
                        System.out.print("Ingrese el tipo de documento: ");
                        tipoDocumento = scanner.next();

                        for (DocumentType documentType : manager.documentTypes) {
                            if (documentType.getType().equalsIgnoreCase(tipoDocumento)) {
                                tipoValido = true;
                                break;
                            }
                        }

                        if (!tipoValido) {
                            options.division();
                            System.out.println(ANSI_RED + "El tipo de documento ingresado no es válido." + ANSI_RESET);
                            System.out.println(ANSI_PURPLE + "Los tipos de documento disponibles son:" + ANSI_RESET);
                            manager.listDocumentTypes();
                            options.division();
                        }
                    }

                    scanner.nextLine();
                    System.out.print("Ingrese el título del documento: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Ingrese el autor del documento: ");
                    String autorNombre = scanner.nextLine();
                    Author autorExistente = null;
                    for (Author autor : manager.authors) {
                        if (autor.getFullName().equalsIgnoreCase(autorNombre)) {
                            autorExistente = autor;
                            break;
                        }
                    }
                    if (autorExistente == null) {
                        autorExistente = new Author(autorNombre);
                        manager.addAuthor(autorExistente);
                    }


                    System.out.print("Ingrese las palabras clave del documento (separadas por comas): ");
                    String palabrasClaveInput = scanner.nextLine();
                    String[] palabrasClaveArray = palabrasClaveInput.split(",");
                    LinkedList<KeyWord> palabrasClave = new LinkedList<>();
                    for (String palabraClave : palabrasClaveArray) {
                        palabrasClave.add(new KeyWord(palabraClave.trim()));
                    }
                    System.out.print("Ingrese el año de publicación del documento: ");
                    int anioPublicacion = scanner.nextInt();

                    Document nuevoDocumento = new Document(tipoDocumento, autorExistente, titulo, palabrasClave, anioPublicacion);
                    manager.addDocument(nuevoDocumento);
                    System.out.println(ANSI_CYAN + "Documento agregado correctamente!!!!" + ANSI_RESET);
                    options.division();
                    break;

                case 3:
                    options.division();
                    scanner.nextLine();
                    System.out.print("Ingrese el título del documento a buscar: ");
                    String titleToSearch = scanner.nextLine();
                    LinkedList<Document> foundDocuments = manager.searchByTitle(titleToSearch);
                    if (!foundDocuments.isEmpty()) {
                        System.out.println("Documentos encontrados con el título '" + titleToSearch + "':");
                        int number = 1;
                        for (Document document : foundDocuments) {
                            System.out.println(number + " -" + document.getDocumentData());
                            number++;
                        }
                    } else {
                        System.out.println(ANSI_RED + "No se encontraron documentos con el título '" + titleToSearch + "'" + ANSI_RESET);
                    }
                    options.division();
                    break;
                case 4:
                    options.division();
                    manager.listAuthors();
                    options.division();
                    break;
                case 5:
                    options.division();
                    scanner.nextLine();
                    System.out.print("Ingrese el título del documento que desea eliminar: ");
                    String titleToDelete = scanner.nextLine();
                    manager.removeDocumentByTitle(titleToDelete);
                    options.division();
                    break;
                case 6:
                    options.division();
                    System.out.println("Lista de libros existentes:");
                    manager.listDocuments();
                    options.division();
                    break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida, por favor ingrese una opción válida. :)");
            }
        }
    }
}