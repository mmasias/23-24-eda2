package antonioGavilanes.reto003;

import java.util.Scanner;

class Usuario {

    private String name;
    private DocumentoNode first;
    private TipoDocumento tiposDoc;
    private PalabrasClave palabrasClave;

    public Usuario(String name) {
        this.name = name;
        this.first = null;
        this.tiposDoc = new TipoDocumento();
        this.tiposDoc.add();
        this.palabrasClave = new PalabrasClave(); // Eliminamos la llamada a agregarPalabra() desde aquí
    }

    private void addDoc(Documento food) {
        DocumentoNode newDocumentoNode = new DocumentoNode(food);
        if (first == null) {
            first = newDocumentoNode;
        } else {
            DocumentoNode current = first;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newDocumentoNode);
        }
    }

    private void createDoc() {
        boolean creating = true;
        Scanner userInput = new Scanner(System.in);
        while (creating) {
            System.out.println("Nombre del documento por crear (-1 para terminar)");
            String docName = userInput.nextLine();
            if (docName.equals("-1")) {
                creating = !creating;
            } else {
                System.out.println("Autor del documento");
                String docAuthor = userInput.nextLine();
                System.out.println("Año del documento");
                String docYear = userInput.nextLine();
                System.out.println("Tipos de documentos disponibles:");
                tiposDoc.mostrar();
    
                System.out.println("Selecciona el tipo de documento (ingresa el número correspondiente):");
                int opcionTipoDoc = userInput.nextInt();
                userInput.nextLine();
                if (opcionTipoDoc >= 1 && opcionTipoDoc <= tiposDoc.size()) {
                    String docType = tiposDoc.mostrar(opcionTipoDoc - 1);
                    palabrasClave.agregarPalabra();
                    palabrasClave.mostrarPalabrasClave(); // Mostrar las palabras clave después de agregarlas
                    System.out.println("Palabras clave del documento");
                    String docKeywords = userInput.nextLine();
                    Documento newDoc = new Documento(docName, docAuthor, docYear, docType, docKeywords);
                    addDoc(newDoc);
                } else {
                    System.out.println("Opción no válida.");
                }
            }
        }
    }

    private void editDoc() {
        boolean editing = true;
        Scanner userInput = new Scanner(System.in);
        while (editing) {
            System.out.println("Nombre del documento por editar (-1 para terminar)");
            String docName = userInput.nextLine();
            if (docName.equals("-1")) {
                editing = !editing;
            } else {
                editDoc(docName);
            }
        }
    }

    private void editDoc(String docName) {
        DocumentoNode current = first;
        while (current != null) {
            if (current.getDoc().getTitulo().equals(docName)) {
                System.out.println("Nuevo nombre del documento");
                String newDocName = new Scanner(System.in).nextLine();
                current.getDoc().setTitulo(newDocName);
                return;
            }
            current = current.getNext();
        }
        System.out.println("No se encontró el documento " + docName);
    }

    private void deleteDoc() {
        boolean deleting = true;
        Scanner userInput = new Scanner(System.in);
        while (deleting) {
            System.out.println("Nombre del documento por eliminar (-1 para terminar)");
            String docName = userInput.nextLine();
            if (docName.equals("-1")) {
                deleting = !deleting;
            } else {
                removeDoc(docName);
            }
        }
    }

    private void removeDoc(String docName) {
        if (first.getDoc().getTitulo().equals(docName)) {
            first = first.getNext();
        } else {
            DocumentoNode current = first;
            while (current.getNext() != null) {
                if (current.getNext().getDoc().getTitulo().equals(docName)) {
                    current.setNext(current.getNext().getNext());
                    return;
                }
                current = current.getNext();
            }
        }
    }

    private void startManagement() {
        manage();
    }

    public void manage() {
        boolean managing = true;
        Scanner userInput = new Scanner(System.in);
        do {
            System.out.println("1. Crear documento");
            System.out.println("2. Editar documento");
            System.out.println("3. Eliminar documento");
            System.out.println("4. Ver documentos");
            System.out.println("5. Salir");
            int option = userInput.nextInt();
            userInput.nextLine(); // Consume the newline character after reading the integer
            switch (option) {
                case 1:
                    createDoc();
                    break;
                case 2:
                    editDoc();
                    break;
                case 3:
                    deleteDoc();
                    break;
                case 4:
                    System.out.println(this);
                    break;
                case 5:
                    managing = !managing;
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (managing);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        DocumentoNode current = first;
        while (current != null) {
            result.append("====================================\n");
            result.append("Documento: ").append(current.getDoc().getTitulo()).append("\n");
            result.append("====================================\n");
            result.append("Autor: ").append(current.getDoc().getAutor()).append("\n");
            result.append("Año: ").append(current.getDoc().getAño()).append("\n");
            result.append("Tipo: ").append(current.getDoc().getTipo()).append("\n");
            result.append("Palabras clave: ").append(current.getDoc().getPalabrasClave()).append("\n");
            current = current.getNext();
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Usuario user = new Usuario("Antonio");
        user.startManagement();
    }

}
