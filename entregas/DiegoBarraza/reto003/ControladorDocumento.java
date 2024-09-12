package entregas.DiegoBarraza.reto003;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ControladorDocumento {
    private GestionDocumentos biblioteca;
    private Scanner scanner;

    public ControladorDocumento(GestionDocumentos biblioteca, Scanner scanner) {
        this.biblioteca = biblioteca;
        this.scanner = scanner;
    }

    
    public void agregarDocumento() {
        System.out.println("Ingrese el título del documento:");
        String titulo = scanner.nextLine();
        
        System.out.println("Ingrese los autores del documento (separados por comas):");
        String autoresInput = scanner.nextLine();
        List<String> autores = Arrays.asList(autoresInput.split(","));
        
        System.out.println("Ingrese el año de publicación del documento:");
        int añoPublicacion = scanner.nextInt();
        scanner.nextLine(); 
        
        System.out.println("Ingrese el tipo de documento:");
        String tipoDocumento = scanner.nextLine();
        
        System.out.println("Ingrese las palabras clave del documento (separadas por comas):");
        String palabrasClaveInput = scanner.nextLine();
        List<String> palabrasClave = Arrays.asList(palabrasClaveInput.split(","));
        
        biblioteca.agregarDocumento(new Documento(titulo, autores, añoPublicacion, tipoDocumento, palabrasClave));
    }
    public void editarDocumento() {
        System.out.println("Ingrese el título del documento que desea editar:");
        String titulo = scanner.nextLine();
        
        List<Documento> documentosEncontrados = biblioteca.buscarPorTitulo(titulo);
        
        if (!documentosEncontrados.isEmpty()) {
            System.out.println("Documentos encontrados:");
            for (int i = 0; i < documentosEncontrados.size(); i++) {
                System.out.println((i + 1) + ". " + documentosEncontrados.get(i).getTitulo());
            }
            
            System.out.print("Seleccione el número del documento que desea editar: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); 
            
            if (opcion >= 1 && opcion <= documentosEncontrados.size()) {
                Documento documentoAEditar = documentosEncontrados.get(opcion - 1);
                
                System.out.println("Ingrese el nuevo título del documento:");
                String nuevoTitulo = scanner.nextLine();
                
                System.out.println("Ingrese los nuevos autores del documento (separados por comas):");
                String autoresInput = scanner.nextLine();
                List<String> nuevosAutores = Arrays.asList(autoresInput.split(","));
                
                System.out.println("Ingrese el nuevo año de publicación del documento:");
                int nuevoAñoPublicacion = scanner.nextInt();
                scanner.nextLine(); 

                System.out.println("Ingrese el nuevo tipo de documento:");
                String nuevoTipoDocumento = scanner.nextLine();
                
                System.out.println("Ingrese las nuevas palabras clave del documento (separadas por comas):");
                String palabrasClaveInput = scanner.nextLine();
                List<String> nuevasPalabrasClave = Arrays.asList(palabrasClaveInput.split(","));
                
                Documento nuevoDocumento = new Documento(nuevoTitulo, nuevosAutores, nuevoAñoPublicacion, nuevoTipoDocumento, nuevasPalabrasClave);
                boolean exitoEdicion = biblioteca.editarDocumento(titulo, nuevoDocumento);
                
                if (exitoEdicion) {
                    System.out.println("Documento editado con éxito.");
                } else {
                    System.out.println("No se encontró el documento a editar.");
                }
            } else {
                System.out.println("Número de documento seleccionado no válido.");
            }
        } else {
            System.out.println("No se encontró ningún documento con el título proporcionado.");
        }
    }

    public void leerDocumento() {
        System.out.println("Ingrese el título del documento que desea leer:");
        String titulo = scanner.nextLine();
        
        List<Documento> resultados = biblioteca.buscarPorTitulo(titulo);
        if (!resultados.isEmpty()) {
            for (Documento documento : resultados) {
                System.out.println("Título: " + documento.getTitulo());
                System.out.println("Autores: " + String.join(", ", documento.getAutores()));
                System.out.println("Año de publicación: " + documento.getAñoPublicacion());
                System.out.println("Tipo de documento: " + documento.getTipoDocumento());
                System.out.println("Palabras clave: " + String.join(", ", documento.getPalabrasClave()));
            }
        } else {
            System.out.println("No se encontró ningún documento con el título proporcionado.");
        }
    }
public void eliminarDocumento() {
    System.out.println("Ingrese el título del documento que desea eliminar:");
    String titulo = scanner.nextLine();
    
    boolean exitoEliminacion = biblioteca.eliminarDocumento(titulo);
    if (exitoEliminacion) {
        System.out.println("Documento eliminado con éxito.");
    } else {
        System.out.println("No se encontró el documento a eliminar.");
    }
}

    

}

