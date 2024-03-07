package entregas.oteroJorge.reto003;

import java.util.ArrayList;
import java.util.Scanner;

public class Gestor {

    private ArrayList<Documento> documentos;
    GestorAutores gestorAutores;

    public Gestor() {
        this.documentos = new ArrayList<>();
        this.gestorAutores = new GestorAutores();
    }

    public GestorAutores getGestorAutores(){
        return this.gestorAutores;
    }

    public void setDocumentos(ArrayList<Documento> documentos) {
        this.documentos = documentos;
    }

    public void addDocumento(Documento documento) {
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
            documento.setTitulo(nuevoTitulo);
            documento.setAñoPublicacion(nuevoAño);
            documento.setTipo(nuevoTipo);
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
            if (doc.getTitulo().equalsIgnoreCase(titulo)) {
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
        for (Documento doc : this.documentos) {
            if (doc.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                documento = doc;
                break;
            }
        }
        if (documento != null) {
            documento.printDocumento(this.gestorAutores);
        } else {
            System.out.println("El documento no existe");
        }
    }
    

    private void buscarDocumentoPorAutor(String autor) {
        ArrayList<Documento> documentosAutor = new ArrayList<>();
        for (Documento doc : documentos) {
            for (int id : doc.getIdAutores()) {
                for (Autor aut : gestorAutores.getAutores()) {
                    if (aut.getId() == id && aut.getNombreCompleto().equals(autor)) {
                        documentosAutor.add(doc);
                    }
                }
            }
        }
        if (documentosAutor.size() > 0) {
            for (Documento doc : documentosAutor) {
                doc.printDocumento(this.gestorAutores);
            }
        } else {
            System.out.println("No hay documentos con ese autor");
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
            sb.append(documento.toString(this.gestorAutores));
            sb.append("\n");
        }
        return sb.toString();
    }

    private void añadirDocumento(GestorAutores gestorAutores){
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el titulo del documento");
        String titulo = sc.nextLine();
        System.out.println("Introduce el año de publicación del documento");
        String año = sc.nextLine();
        System.out.println("Introduce el tipo de documento");
        String tipo = sc.nextLine();
        boolean añadiendoAutores = true;
        ArrayList<Integer> idAutores = new ArrayList<>();
        while (añadiendoAutores) {
            gestorAutores.listarAutores();
            System.out.println("Introduce el id del autor");
            int idAutor = sc.nextInt();
            sc.nextLine();
            idAutores.add(idAutor);
            if(gestorAutores.existeAutor(idAutor)){
                
            }
            else{
                System.out.println("Introduce el nombre del autor");
                String nombreAutor = sc.nextLine();
                gestorAutores.agregarAutor(idAutor, nombreAutor);
            }
            System.out.println("¿Quieres añadir otro autor? (s/n)");
                String respuesta = sc.nextLine();
                if (respuesta.equals("n")) {
                    añadiendoAutores = false;
                } 
        }
        Documento documento = new Documento(titulo, idAutores, año, tipo);
        addDocumento(documento);
    }

    private void opciones(){
        System.out.println("1. Añadir documento");
        System.out.println("2. Editar documento por titulo");
        System.out.println("3. Editar autor");
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
                    añadirDocumento(gestorAutores);
                    break;
                case 2:
                    System.out.println("Introduce el titulo del documento a editar");
                    String tituloEditar = sc.nextLine();
                    editDocumento(tituloEditar);
                    break;
                case 3:
                    System.out.println("Introduce el nombre del autor a editar");
                    String nombreAutor = sc.nextLine();
                    gestorAutores.editarAutor(nombreAutor);
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
