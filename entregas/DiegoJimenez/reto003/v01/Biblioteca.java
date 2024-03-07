package reto003.v01;

import java.util.ArrayList;
import java.util.Scanner;

import reto003.v01.Documento.Articulo;
import reto003.v01.Documento.Autor;
import reto003.v01.Documento.Libro;
import reto003.v01.Documento.Paper;
import reto003.v01.Documento.Revista;

public class Biblioteca {
    private ArrayList<Documento> documentos;
    private Scanner scanner;

    public Biblioteca() {
        this.documentos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    public void ejecutar() {
        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Agregar documento");
            System.out.println("2. Mostrar documentos");
            System.out.println("3. Buscar documentos");
            System.out.println("4. Editar título de documento");
            System.out.println("5. Eliminar documento");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (opcion) {
                case 1:
                    agregarDocumento();
                    break;
                case 2:
                    mostrarDocumentos();
                    break;
                case 3:
                    buscarDocumentos();
                    break;
                case 4:
                    editarTituloDocumento();
                    break;
                case 5:
                    eliminarDocumento();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
            }
        } while (opcion != 6);
    }

    private void agregarDocumento() {
        System.out.print("Ingrese el título del documento: ");
        String titulo = scanner.nextLine();

        System.out.print("Ingrese el autor del documento (separado por comas si son varios): ");
        String autoresInput = scanner.nextLine();
        String[] autoresArray = autoresInput.split(",");
        Documento documento = null; 
        for (String nombreAutor : autoresArray) {
            if (documento == null) { 
                System.out.print("Ingrese el año de publicación: ");
                int año = scanner.nextInt();
                scanner.nextLine(); 
                
                System.out.print("Ingrese el tipo de documento (Libro, Revista, Artículo, Paper): ");
                String tipoDocumento = scanner.nextLine();
                
                switch (tipoDocumento.toLowerCase()) {
                    case "libro":
                        documento = new Libro(titulo, año);
                        break;
                    case "revista":
                        documento = new Revista(titulo, año);
                        break;
                    case "artículo":
                        documento = new Articulo(titulo, año);
                        break;
                    case "paper":
                        documento = new Paper(titulo, año);
                        break;
                    default:
                        System.out.println("Tipo de documento inválido. Se creará un documento genérico.");
                        documento = new Documento(titulo, año, "Documento genérico");
                }
            }
            
            documento.addAutor(new Autor(nombreAutor.trim()));
        }
        
        System.out.print("Ingrese las palabras clave (separadas por comas): ");
        String palabrasClaveInput = scanner.nextLine();
        String[] palabrasClaveArray = palabrasClaveInput.split(",");
        for (String palabraClave : palabrasClaveArray) {
            documento.addPalabraClave(palabraClave.trim());
        }
        
        documentos.add(documento);
        System.out.println("Documento agregado correctamente.");
    }

    private void mostrarDocumentos() {
        if (documentos.isEmpty()) {
            System.out.println("No hay documentos en la biblioteca.");
        } else {
            System.out.println("Documentos en la biblioteca:");
            for (Documento doc : documentos) {
                System.out.println(doc);
            }
        }
    }
    
    

    private void buscarDocumentos() {
        if (documentos.isEmpty()) {
            System.out.println("No hay documentos en la biblioteca.");
            return;
        }
        System.out.println("Opciones de búsqueda:");
        System.out.println("1. Por título");
        System.out.println("2. Por autor");
        System.out.println("3. Por palabra clave");
        System.out.println("4. Por tipo de documento");
        System.out.print("Seleccione una opción de búsqueda: ");
        int opcion = scanner.nextInt();
        scanner.nextLine(); 
        
        switch (opcion) {
            case 1:
                buscarPorTitulo();
                break;
            case 2:
                buscarPorAutor();
                break;
            case 3:
                buscarPorPalabraClave();
                break;
            case 4:
                buscarPorTipoDocumento();
                break;
            default:
                System.out.println("Opción inválida.");
        }
    }

    private void buscarPorTitulo() {
        System.out.print("Ingrese el título a buscar: ");
        String titulo = scanner.nextLine();
        boolean encontrado = false;
        for (Documento doc : documentos) {
            if (doc.getTitulo().equalsIgnoreCase(titulo)) {
                System.out.println(doc);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron documentos con ese título.");
        }
    }

    private void buscarPorAutor() {
        System.out.print("Ingrese el autor a buscar: ");
        String autorBusqueda = scanner.nextLine();
        boolean encontrado = false;
        for (Documento doc : documentos) {
            boolean autorEncontrado = false;
            for (Autor a : doc.getAutores()) {
                if (a.getNombre().equalsIgnoreCase(autorBusqueda)) {
                    autorEncontrado = true;
                    break;
                }
            }
            if (autorEncontrado) {
                System.out.println(doc);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron documentos con ese autor.");
        }
    }

    private void buscarPorPalabraClave() {
        System.out.print("Ingrese la palabra clave a buscar: ");
        String palabraClave = scanner.nextLine();
        boolean encontrado = false;
        for (Documento doc : documentos) {
            if (doc.getPalabrasClave().contains(palabraClave.toLowerCase())) {
                System.out.println(doc);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron documentos con esa palabra clave.");
        }
    }

    private void buscarPorTipoDocumento() {
        System.out.print("Ingrese el tipo de documento a buscar: ");
        String tipoDocumento = scanner.nextLine();
        boolean encontrado = false;
        for (Documento doc : documentos) {
            if (doc.getClass().getSimpleName().equalsIgnoreCase(tipoDocumento)) {
                System.out.println(doc);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron documentos de ese tipo.");
        }
    }

    private void editarTituloDocumento() {
        if (documentos.isEmpty()) {
            System.out.println("No hay documentos para editar.");
            return;
        }
        System.out.print("Ingrese el título del documento a editar: ");
        String tituloViejo = scanner.nextLine();
        System.out.print("Ingrese el nuevo título: ");
        String tituloNuevo = scanner.nextLine();

        boolean encontrado = false;
        for (Documento doc : documentos) {
            if (doc.getTitulo().equals(tituloViejo)) {
                doc.setTitulo(tituloNuevo);
                encontrado = true;
                System.out.println("Título del documento editado correctamente.");
                break;
            }
        }
        if (!encontrado) {
            System.out.println("Documento no encontrado.");
        }
    }

    private void eliminarDocumento() {
        if (documentos.isEmpty()) {
            System.out.println("No hay documentos para eliminar.");
            return;
        }
        System.out.print("Ingrese el título del documento a eliminar: ");
        String titulo = scanner.nextLine();

        boolean eliminado = documentos.removeIf(doc -> doc.getTitulo().equals(titulo));
        if (eliminado) {
            System.out.println("Documento eliminado correctamente.");
        } else {
            System.out.println("Documento no encontrado.");
        }
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.ejecutar();
    }
}
