package entregas.mayenSergio.Reto_003;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class GeneradorDocumentos {

    private static Scanner scanner = new Scanner(System.in);

    public static List<Documento> crearNuevoDocumento() {
        List<Documento> nuevosDocumentos = new ArrayList<>();

        do {
            System.out.print("Título del documento: ");
            String titulo = scanner.nextLine();

            System.out.print("Autor del documento: ");
            String autor = scanner.nextLine();

            System.out.print("Tipo de documento (LIBRO, REVISTA, ARTICULO, PAPER): ");
            String tipoStr = scanner.nextLine().toUpperCase();
            Documento.TipoDocumento tipo = Documento.TipoDocumento.valueOf(tipoStr);

            Documento documento = new Documento(titulo, autor, tipo);
            nuevosDocumentos.add(documento);

            System.out.println("Documento agregado correctamente.\n");

            System.out.println("¿Desea crear más documentos? (si/no): ");

        } while (scanner.nextLine().equalsIgnoreCase("si"));

        return nuevosDocumentos;
    }

    public static void editarDocumento(List<Documento> documentos) {
        System.out.print("Ingrese el título del documento que desea editar: ");
        String tituloBuscado = scanner.nextLine();

        Iterator<Documento> iterator = documentos.iterator();
        while (iterator.hasNext()) {
            Documento documento = iterator.next();
            if (documento.getTitulo().equalsIgnoreCase(tituloBuscado)) {
                System.out.print("Nuevo título del documento: ");
                String nuevoTitulo = scanner.nextLine();
                documento.setTitulo(nuevoTitulo);

                System.out.print("Nuevo autor del documento: ");
                String nuevoAutor = scanner.nextLine();
                documento.setAutor(nuevoAutor);

                System.out.print("Nuevo tipo de documento (LIBRO, REVISTA, ARTICULO, PAPER): ");
                String nuevoTipoStr = scanner.nextLine().toUpperCase();
                documento.setTipo(Documento.TipoDocumento.valueOf(nuevoTipoStr));

                System.out.println("Documento editado correctamente.\n");
                return;
            }
        }
        System.out.println("Documento no encontrado.\n");
    }

    public static void eliminarDocumento(List<Documento> documentos) {
        System.out.print("Ingrese el título del documento que desea eliminar: ");
        String tituloBuscado = scanner.nextLine();

        Iterator<Documento> iterator = documentos.iterator();
        while (iterator.hasNext()) {
            Documento documento = iterator.next();
            if (documento.getTitulo().equalsIgnoreCase(tituloBuscado)) {
                iterator.remove();
                System.out.println("Documento eliminado correctamente.\n");
                return;
            }
        }
        System.out.println("Documento no encontrado.\n");
    }

    public static void buscarDocumento(List<Documento> documentos) {
        System.out.print("Ingrese el título del documento que desea buscar: ");
        String tituloBuscado = scanner.nextLine();

        for (Documento documento : documentos) {
            if (documento.getTitulo().equalsIgnoreCase(tituloBuscado)) {
                System.out.println("Documento encontrado:\n" + documento + "\n");
                return;
            }
        }
        System.out.println("Documento no encontrado.\n");
    }
}
