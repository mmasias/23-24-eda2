package entregas.oteroJorge.reto003;

import java.util.ArrayList;
import java.util.Scanner;

public class Manager {

    private ArrayList<Documento> documentos;

    public Manager() {
        this.documentos = new ArrayList<>();

    }

    public void setDocumentos(ArrayList<Documento> documentos) {
        this.documentos = documentos;
    }

    private void addDocumento(Documento documento) {
        this.documentos.add(documento);
    }

    private void editDocumento(String titulo) {
        Documento documento = null;
        for (Documento doc : documentos) {
            if (doc.getTitulo().equals(titulo)) {
                documento = doc;
                break;
            }
        }
        if (documento != null) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Introduce el nuevo titulo del documento");
            String nuevoTitulo = sc.nextLine();
            System.out.println("Introduce el nuevo año de publicación del documento");
            String nuevoAño = sc.nextLine();
            System.out.println("Introduce el nuevo tipo de documento");
            String nuevoTipo = sc.nextLine();
            System.out.println("Introduce el nuevo nombre del autor");
            String nuevoAutor = sc.nextLine();
            Autor autor1 = new Autor(nuevoAutor);
            ArrayList<Autor> autores = new ArrayList<>();
            autores.add(autor1);
            documento.setTitulo(nuevoTitulo);
            documento.setAñoPublicacion(nuevoAño);
            documento.setTipo(nuevoTipo);
            documento.setAutores(autores);
        } else {
            System.out.println("El documento no existe");
        }

    }

    private void removeDocumento(Documento documento) {
        this.documentos.remove(documento);
    }

    private void removeDocumentoPorTitulo(String titulo) {
        Documento documento = null;
        for (Documento doc : documentos) {
            if (doc.getTitulo().equals(titulo)) {
                documento = doc;
                break;
            }
        }
        if (documento != null) {
            removeDocumento(documento);
        } else {
            System.out.println("El documento no existe");
        }
    }

    private void buscarDocumentoPorTitulo(String titulo) {
        Documento documento = null;
        for (Documento doc : documentos) {
            if (doc.getTitulo().equals(titulo)) {
                documento = doc;
                break;
            }
        }
        if (documento != null) {
            documento.printDocumento();
        } else {
            System.out.println("El documento no existe");
        }
    }

    private void buscarDocumentoPorAutor(String autor) {
        for (Documento doc : documentos) {
            for (Autor aut : doc.getAutores()) {
                if (aut.getNombreCompleto().equals(autor)) {
                    doc.printDocumento();
                }
            }
        }
    }

    private void printDocumentos() {
        System.out.println(this.toString());
    }

    public void eleminarTodosLosDocumentos() {
        this.documentos.clear();
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Documento documento : documentos) {
            sb.append(documento.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    private void añadirDocumento(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el titulo del documento");
        String titulo = sc.nextLine();
        System.out.println("Introduce el año de publicación del documento");
        String año = sc.nextLine();
        System.out.println("Introduce el tipo de documento");
        String tipo = sc.nextLine();
        System.out.println("Introduce el nombre del autor");
        String autor = sc.nextLine();
        Autor autor1 = new Autor(autor);
        ArrayList<Autor> autores = new ArrayList<>();
        autores.add(autor1);
        Documento documento = new Documento(titulo, autores, año, tipo);
        addDocumento(documento);
    }

    private void opciones(){
        System.out.println("1. Añadir documento");
        System.out.println("2. Editar documento por titulo");
        System.out.println("4. Eliminar documento por titulo");
        System.out.println("5. Buscar documento por titulo");
        System.out.println("6. Buscar documento por autor");
        System.out.println("7. Mostrar todos los documentos");
        System.out.println("8. Eliminar todos los documentos");
        System.out.println("9. Salir");
    }

    public void run(){
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            opciones();
            System.out.println();
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    añadirDocumento();
                    break;
                case 2:
                    System.out.println("Introduce el titulo del documento a editar");
                    String tituloEditar = sc.nextLine();
                    editDocumento(tituloEditar);
                    break;
                case 4:
                    System.out.println("Introduce el titulo del documento a eliminar");
                    String tituloEliminar = sc.nextLine();
                    removeDocumentoPorTitulo(tituloEliminar);
                    break;
                case 5:
                    System.out.println("Introduce el titulo del documento a buscar");
                    String tituloBuscar = sc.nextLine();
                    buscarDocumentoPorTitulo(tituloBuscar);
                    break;
                case 6:
                    System.out.println("Introduce el nombre del autor a buscar");
                    String autorBuscar = sc.nextLine();
                    buscarDocumentoPorAutor(autorBuscar);
                    break;
                case 7:
                    printDocumentos();
                    System.out.println();
                    break;
                case 8:
                    eleminarTodosLosDocumentos();
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;
            }
        } while (opcion != 9);
        System.out.println("Fin del programa");
    }
}
