import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private ArrayList<Documento> documentos;
    public Biblioteca(ArrayList<Documento> documentos) {
        this.documentos = documentos;
    }

    public void añadirDoc(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre del documento: ");
        String titulo = sc.nextLine();
        System.out.println("Año de publicación: ");
        int año = sc.nextInt();
        System.out.println("Tipo de documento: 1. Libro, 2. Revista, 3. Articulo, 4. Papel");
        int tipo = sc.nextInt();
        sc.nextLine();
        TipoDoc tipoDoc = null;
        switch (tipo) {
            case 1:
                tipoDoc = TipoDoc.Libro;
            case 2:
                tipoDoc = TipoDoc.Revista;
            case 3:
                tipoDoc = TipoDoc.Articulo;
            case 4:
                tipoDoc = TipoDoc.Papel;
        }
        boolean salir = false;
        ArrayList<Autor> autores = new ArrayList<Autor>();
        do{
            System.out.println("Nombre del autor: ");
            String nombre = sc.nextLine();
            System.out.println("Apellido del autor: ");
            String apellido = sc.nextLine();
            Autor autor = new Autor(nombre, apellido);
            autores.add(autor);
            System.out.println("Desea añadir otro autor? 1. Si, 2. No");
            int respuesta = sc.nextInt();
            sc.nextLine();
            if(respuesta == 2){
                salir = true;
            }
        }while(!salir);
        salir = false;
        Documento doc = new Documento(titulo, año, autores, tipoDoc);
        String palabraClave;
        do{
            System.out.println("Palabra clave: ");
            palabraClave = sc.nextLine();
            doc.añadirPalabraClave(palabraClave);
            System.out.println("Desea añadir otra palabra clave? 1. Si, 2. No");
            int respuesta = sc.nextInt();
            sc.nextLine();
            if(respuesta == 2){
                salir = true;
            }
        }while(!salir);
        documentos.add(doc);
    }

    public void editarDoc(){
        System.out.println("Nombre del documento a editar: ");
        Scanner sc = new Scanner(System.in);
        String titulo = sc.nextLine();
        for(Documento doc : documentos){
            if(doc.getTitulo().equals(titulo)){
                System.out.println("Nuevo nombre del documento: ");
                String nuevoTitulo = sc.nextLine();
                doc.setTitulo(nuevoTitulo);
                System.out.println("Nuevo año de publicación: ");
                int nuevoAño = sc.nextInt();
                doc.setAñoDePublicacion(nuevoAño);
                System.out.println("Nuevo tipo de documento: 1. Libro, 2. Revista, 3. Articulo, 4. Papel");
                int tipo = sc.nextInt();
                sc.nextLine();
                TipoDoc tipoDoc = null;
                switch (tipo) {
                    case 1:
                        tipoDoc = TipoDoc.Libro;
                    case 2:
                        tipoDoc = TipoDoc.Revista;
                    case 3:
                        tipoDoc = TipoDoc.Articulo;
                    case 4:
                        tipoDoc = TipoDoc.Papel;
                }
                doc.setTipo(tipoDoc);
                boolean salir = false;
                ArrayList<Autor> autores = new ArrayList<Autor>();
                do{
                    System.out.println("Nombre del autor: ");
                    String nombre = sc.nextLine();
                    System.out.println("Apellido del autor: ");
                    String apellido = sc.nextLine();
                    Autor autor = new Autor(nombre, apellido);
                    autores.add(autor);
                    System.out.println("Desea añadir otro autor? 1. Si, 2. No");
                    int respuesta = sc.nextInt();
                    sc.nextLine();
                    if(respuesta == 2){
                        salir = true;
                    }
                }while(!salir);
                doc.setAutores(autores);
                String palabraClave;
                do{
                    System.out.println("Palabra clave: ");
                    palabraClave = sc.nextLine();
                    doc.añadirPalabraClave(palabraClave);
                    System.out.println("Desea añadir otra palabra clave? 1. Si, 2. No");
                    int respuesta = sc.nextInt();
                    sc.nextLine();
                    if(respuesta == 2){
                        salir = true;
                    }
                }while(!salir);
            }
        }
    }

    public void buscarDoc(){
        System.out.println("Nombre del documento a buscar: ");
        Scanner sc = new Scanner(System.in);
        String titulo = sc.nextLine();
        for(Documento doc : documentos){
            if(doc.getTitulo().equals(titulo)){
                System.out.println("Titulo: " + doc.getTitulo());
                System.out.println("Año de publicación: " + doc.getAñoDePublicacion());
                System.out.println("Tipo de documento: " + doc.getTipo());
                System.out.println("Autores: ");
                for(Autor autor : doc.getAutores()){
                    System.out.println(autor.getNombre() + " " + autor.getApellido());
                }
                System.out.println("Palabras clave: ");
                for(String palabraClave : doc.getPalabrasClave()){
                    System.out.println(palabraClave);
                }
            }
        }
    }

    public void buscarDocAutor(){
        System.out.println("Nombre del autor a buscar: ");
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        System.out.println("Apellido del autor a buscar: ");
        String apellido = sc.nextLine();
        System.out.println("Titulos de este autor:");
        for(Documento doc : documentos){
            for(Autor autor : doc.getAutores()){
                if(autor.getNombre().equals(nombre) && autor.getApellido().equals(apellido)){
                    System.out.println(doc.getTitulo());
                }
            }       
        }
    }   

    public void buscarDocAño(){
        System.out.println("Año de publicación a buscar: ");
        Scanner sc = new Scanner(System.in);
        int año = sc.nextInt();
        System.out.println("Titulos de este año:");
        for(Documento doc : documentos){
            if(doc.getAñoDePublicacion() == año){
                System.out.println(doc.getTitulo());
            }
        }
    }

    public void buscarDocTipo(){
        System.out.println("Tipo de documento a buscar: 1. Libro, 2. Revista, 3. Articulo, 4. Papel");
        Scanner sc = new Scanner(System.in);
        int tipo = sc.nextInt();
        TipoDoc tipoDoc = null;
        switch (tipo) {
            case 1:
                tipoDoc = TipoDoc.Libro;
            case 2:
                tipoDoc = TipoDoc.Revista;
            case 3:
                tipoDoc = TipoDoc.Articulo;
            case 4:
                tipoDoc = TipoDoc.Papel;
        }
        System.out.println("Titulos de este tipo:");
        for(Documento doc : documentos){
            if(doc.getTipo().equals(tipoDoc)){
                System.out.println(doc.getTitulo());
            }
        }
    }

    public void buscarDocPalabraClave(){
        System.out.println("Palabra clave a buscar: ");
        Scanner sc = new Scanner(System.in);
        String palabraClave = sc.nextLine();
        System.out.println("Titulos con esta palabra clave:");
        for(Documento doc : documentos){
            for(String palabra : doc.getPalabrasClave()){
                if(palabra.equals(palabraClave)){
                    System.out.println(doc.getTitulo());
                }
            }
        }
    }

    public void eliminarDoc(){
        System.out.println("Nombre del documento a eliminar: ");
        Scanner sc = new Scanner(System.in);
        String titulo = sc.nextLine();
        for(Documento doc : documentos){
            if(doc.getTitulo().equals(titulo)){
                documentos.remove(doc);
            }
        }
    }

    public void menu(){
        Scanner sc = new Scanner(System.in);
        int opcion;
        do{
            System.out.println("1. Añadir documento");
            System.out.println("2. Editar documento");
            System.out.println("3. Buscar documento");
            System.out.println("4. Buscar documento por autor");
            System.out.println("5. Buscar documento por año");
            System.out.println("6. Buscar documento por tipo");
            System.out.println("7. Buscar documento por palabra clave");
            System.out.println("8. Eliminar documento");
            System.out.println("9. Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    añadirDoc();
                    break;
                case 2:
                    editarDoc();
                    break;
                case 3:
                    buscarDoc();
                    break;
                case 4:
                    buscarDocAutor();
                    break;
                case 5:
                    buscarDocAño();
                    break;
                case 6:
                    buscarDocTipo();
                    break;
                case 7:
                    buscarDocPalabraClave();
                    break;
                case 8:
                    eliminarDoc();
                    break;
                case 9:
                    System.out.println("Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        }while(opcion != 9);
    }
}