import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Colection{
    ArrayList<Document> documents;
    

    public Colection() {
        documents = new ArrayList<Document>();
    }

    public void createDocument() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el título del documento");
        String title = scanner.nextLine();
        System.out.println("Ingrese el año de publicación");
        int PublishedYear = scanner.nextInt();
        boolean typeestablished = false;
        int Tipeofdocument = 0;
        while(!typeestablished){
            System.out.println("Ingrese el tipo de documento");
            System.out.println("1. Libro");
            System.out.println("2. Revista");
            System.out.println("3. Artículo");
            System.out.println("4. Paper Científico");
            Tipeofdocument = (scanner.nextInt() - 1);
            if(Tipeofdocument < 0 || Tipeofdocument > 3){
                System.out.println("Tipo de documento no válido");
            } else{
                typeestablished = true;
                break;
            }
        }

        Document document = new Document(title, PublishedYear, Tipeofdocument);
        documents.add(document);
        createAuthors(document);
        createKeywords(document);
    }

    public void createAuthors(Document document){
        Scanner scanner = new Scanner(System.in);
        String authorfirstname = "";
        String authorlastname = "";
        while(authorfirstname != "-1" || authorlastname != "-1"){
            System.out.println("Ingrese el nombre del autor [-1 para salir]");
            authorfirstname = scanner.nextLine();
            System.out.println("Ingrese el apellido del autor [-1 para salir]");
            authorlastname = scanner.nextLine();
            if(authorfirstname.equals("-1") || authorlastname.equals("-1")){
                break;
            } else {
            Author author = new Author(authorfirstname,authorlastname);
            document.addAuthor(author);
            }
        }
    }

    public void createKeywords(Document document){
        Scanner scanner = new Scanner(System.in);
        String keyword = "";
        while(keyword != "-1"){
            System.out.println("¿Desea agregar una palabra clave? (s/n)");
            if(scanner.nextLine().equals("n")){
                break;
            }
            System.out.println("Ingrese la palabra clave [-1 para salir]");
            keyword = scanner.nextLine();
            if(keyword.equals("-1")){
                System.out.println("Palabra clave no válida");
                continue;
            } else {
            document.addKeyword(keyword);
            }
        }
    }

    public void addDocument(Document document) {
        documents.add(document);
    }

    public void editDocument(Document document, int index) {
        documents.get(index).editDocument();
    }

    public void deleteDocument(int index) {
        documents.remove(index);
    }

    public void showDocument(int index) {
        documents.get(index).printDocument();
    }

    public void showAllDocuments() {
        for (Document document : documents) {
            System.out.println(document);
        }
    }

    public int searchDocuments() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el término de búsqueda:");
        String searchTerm = scanner.nextLine();
        List<Integer> matchingIndexes = new ArrayList<>();
        boolean found = false;

        for (int i = 0; i < documents.size(); i++) {
            Document document = documents.get(i);
            if (document.getTitle().toLowerCase().contains(searchTerm.toLowerCase())) {
                matchingIndexes.add(i);
                found = true;
            }
        }

        for (int i = 0; i < documents.size(); i++) {
            Document document = documents.get(i);
            for (Author author : document.getAuthors()) {
                if (author.getfirstname().toLowerCase().contains(searchTerm.toLowerCase())
                        || author.getlastname().toLowerCase().contains(searchTerm.toLowerCase())) {
                    matchingIndexes.add(i);
                    found = true;
                    break;
                }
            }
        }

        for (int i = 0; i < documents.size(); i++) {
            Document document = documents.get(i);
            for (String keyword : document.getKeywords()) {
                if (keyword.toLowerCase().contains(searchTerm.toLowerCase())) {
                    matchingIndexes.add(i);
                    found = true;
                    break;
                }
            }
        }

        if (found) {
            System.out.println("Se encontraron múltiples documentos que coinciden con el término de búsqueda:");
            for (int i = 0; i < matchingIndexes.size(); i++) {
                int index = matchingIndexes.get(i);
                System.out.println((i + 1) + ". " + documents.get(index).getTitle());
            }
            System.out.println("Seleccione el documento deseado (ingrese el número):");
            int selectedIndex = scanner.nextInt();
            return matchingIndexes.get(selectedIndex - 1);
        } else {
            System.out.println("No se encontraron documentos que coincidan con el término de búsqueda.");
            return -1;
        }
    }

    public static void main(String[] args) {
        Colection colection = new Colection();
        Scanner scanner = new Scanner(System.in);
        boolean SystemOn = true;
        while(SystemOn){
        System.out.println("¿Qué quieres hacer?");
        System.out.println("1. Crear un documento");
        System.out.println("2. Modificar un documento");
        System.out.println("3. Eliminar un documento");
        System.out.println("4. Ver un documento");
        System.out.println("5. Ver todos los documentos");
        System.out.println("6. Eliminar la colección de documentos");
        System.out.println("7. Salir");
        String option = scanner.nextLine();
        
        switch(option){
            case "1":
                System.out.println("Creando un documento");
                colection.createDocument();
                break;
            case "2":
                System.out.println("Modificando un documento");
                int index = colection.searchDocuments();
                if(index != -1){
                    colection.editDocument(colection.documents.get(index), index);
                }
                break;
            case "3":
                System.out.println("Eliminando un documento");
                int index2 = colection.searchDocuments();
                if(index2 != -1){
                    colection.deleteDocument(index2);
                }
                break;
            case "4":
                System.out.println("Viendo un documento");
                int index3 = colection.searchDocuments();
                if(index3 != -1){
                    colection.showDocument(index3);
                }
                break;
            case "5":
                System.out.println("Viendo todos los documentos");
                colection.showAllDocuments();
                break;
            case "6":
                System.out.println("Eliminando datos");
                Scanner scanner2 = new Scanner(System.in);
                System.out.println("¿Estás seguro de que quieres eliminar la colección de documentos?(s/n)");
                if (scanner2.nextLine().equals("s")) {
                    colection.documents.clear();
                }
                break;
            case "7":
                System.out.println("Saliendo del sistema");
                SystemOn = false;
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }
        
        }
        
    }
}
