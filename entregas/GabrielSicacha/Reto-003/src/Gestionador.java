import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Gestionador {

    Biblioteca biblioteca;

    public Gestionador(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void gestionar() {
        boolean gestionando = true;
        while (gestionando){
            Scanner scanner = new Scanner(System.in);
            System.out.println("----------------Gestion de Documentos 30k--------------------");
            System.out.println("1. Gestionar Documentos");
            System.out.println("2. Buscar Documentos");
            System.out.println("3. Salir del gestor");
            System.out.println("-------------------------------------------------------------");
            int eleccion = scanner.nextInt();
            switch (eleccion) {
                case 1:
                    cud();
                    break;
                case 2:
                    buscarDocumento();
                    break;
                case 3:
                    gestionando=false;
                    System.exit(0);
                    break;
                default:
                    System.out.println("Introdusca una opcion valida.");
            }
        }
    }

    public void cud(){
        Scanner scanner = new Scanner(System.in);
        boolean crud = true;
        while (crud) {
            System.out.println("---------------------------C.U.D-----------------------------");
            System.out.println("1. Añadir documento");
            System.out.println("2. Editar documento");
            System.out.println("3. Eliminar documento");
            System.out.println("4. Volver");
            System.out.println("-------------------------------------------------------------");
            int eleccion = scanner.nextInt();
            switch (eleccion) {
                case 1:
                    crearDocumento();
                    break;
                case 2:
                    editarDocumento();
                    break;
                case 3:
                    borrarDocumento();
                    break;
                case 4:
                    crud=false;
                    break;
            }
        }
    }

    public void crearDocumento() {
        System.out.println("--------------------Creacion de Documento--------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introdusca titulo del documento");
        String tituloDelDoc = scanner.nextLine();

        System.out.println("Introducir Nombre del autor o autores divididos por comas");
        System.out.println("(dejar el blanco caso sea autor desconocido");
        String nombreAutor = scanner.nextLine();
        ArrayList<String> autoresDelDoc = new ArrayList<>( Arrays.asList(nombreAutor.split("\\s*,\\s*")));

        if(nombreAutor.isEmpty()){
            autoresDelDoc.add("Autor Desconocido");
        } else {
            autoresDelDoc.add(nombreAutor);
        }


        System.out.println("Introdusca el año del documento");
        Year anoDelDoc = Year.of(scanner.nextInt());
        scanner.nextLine();

        System.out.println("Introdusca el tipo de documento");
        String tipoDeDoc = scanner.nextLine();

        System.out.println("Introdusca palabras clave del documento divididas por comas");
        String palabrasClave = scanner.nextLine();
        ArrayList<String> palabrasClaveDelDoc = new ArrayList<>(Arrays.asList(palabrasClave.split("\\s*,\\s*")));
        System.out.println("Documento Creado!");
        biblioteca.anadirDocumento(new Documento(tituloDelDoc, autoresDelDoc, anoDelDoc, tipoDeDoc, palabrasClaveDelDoc));
    }

    public void editarDocumento() {
        System.out.println("---------------------Edicion de Documento--------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduzca el título del documento a editar:");
        String docAEditar = scanner.nextLine();

        Documento documento = biblioteca.buscarPorTitulo(docAEditar);
        if (documento == null) {
            System.out.println("No existe tal documento en la biblioteca");
        } else {
            System.out.println("---------------------Edicion de Documento--------------------");
            System.out.println("Documento seleccionado: ");
            documento.imprimirDetalleDocumento();
            System.out.println("¿Qué deseas modificar? ");
            System.out.println("1. Titulo");
            System.out.println("2. Autores");
            System.out.println("3. Año de publicación");
            System.out.println("4. Tipo de documento");
            System.out.println("5. Palabras clave");
            System.out.println("--------------------------------------------------------------");

            int eleccion = scanner.nextInt();
            scanner.nextLine();

            switch (eleccion) {
                case 1:
                    System.out.println("Introduce el nuevo título:");
                    String nuevoTitulo = scanner.nextLine();
                    documento.setTitulo(nuevoTitulo);
                    break;
                case 2:
                    System.out.println("Introduce los nuevos autores (separadas por comas):");
                    String nuevosAutores = scanner.nextLine();
                    ArrayList<String> autores = new ArrayList<>(Arrays.asList(nuevosAutores.split("\\s*,\\s*")));
                    documento.setAutores(autores);
                    break;
                case 3:
                    System.out.println("Introduce el nuevo año de publicación:");
                    int nuevoAno = scanner.nextInt();
                    documento.setPublicacion(Year.of(nuevoAno));
                    break;
                case 4:
                    System.out.println("Introduce el nuevo tipo de documento:");
                    String nuevoTipo = scanner.nextLine();
                    documento.setTipoDocumento(nuevoTipo);
                    break;
                case 5:
                    System.out.println("Introduce las nuevas palabras clave (separadas por comas):");
                    String nuevasPalabrasClave = scanner.nextLine();
                    ArrayList<String> palabrasClave = new ArrayList<>(Arrays.asList(nuevasPalabrasClave.split("\\s*,\\s*")));
                    documento.setPalabrasClave(palabrasClave);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }


    public void borrarDocumento(){
        System.out.println("------------------Eliminacion de Documento-------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introdusca titulo del documento a eliminar");
        String docABorrar = scanner.nextLine();
        biblioteca.borrarDocumento(docABorrar);
    }

    public void buscarDocumento() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("------------------Busqueda de Documento----------------------");
        System.out.println("1. Buscar por titulo");
        System.out.println("2. Buscar por autor");
        System.out.println("3. Buscar por tipo de documento");
        System.out.println("4. Buscar por año de publicacion");
        System.out.println("5. Buscar por palabras clave");
        System.out.println("6. Mostrar todo");
        System.out.println("-------------------------------------------------------------");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                System.out.println("Introduce el título del documento:");
                String tituloBusqueda = scanner.nextLine();
                ArrayList<Documento> documentosPorTitulo = new ArrayList<>();
                documentosPorTitulo.add(biblioteca.buscarPorTitulo(tituloBusqueda));
                mostrarDocumentosEncontrados(documentosPorTitulo);
                break;
            case 2:
                System.out.println("Introduce el nombre del autor:");
                String autorBusqueda = scanner.nextLine();
                ArrayList<Documento> documentosPorAutor = biblioteca.buscarPorAutor(autorBusqueda);
                mostrarDocumentosEncontrados(documentosPorAutor);
                break;
            case 3:
                System.out.println("Introduce el tipo de documento:");
                String tipoBusqueda = scanner.nextLine();
                Documento documentoPorTipo = biblioteca.buscarPorTipo(tipoBusqueda);
                if (documentoPorTipo != null) {
                    System.out.println("Documento encontrado:");
                    documentoPorTipo.imprimirDetalleDocumento();
                } else {
                    System.out.println("No se encontraron documentos con el tipo especificado.");
                }
                break;
            case 4:
                System.out.println("Introduce el año de publicación:");
                int anoBusqueda = scanner.nextInt();
                ArrayList<Documento> documentosPorAno = biblioteca.buscarPorAno(anoBusqueda);
                mostrarDocumentosEncontrados(documentosPorAno);
                break;
            case 5:
                System.out.println("Introduce la palabra clave:");
                String palabraClaveBusqueda = scanner.nextLine();
                ArrayList<Documento> documentosPorPalabraClave = biblioteca.buscarPorPalabrasClave(palabraClaveBusqueda);
                mostrarDocumentosEncontrados(documentosPorPalabraClave);
                break;
            case 6:
                System.out.println("Mostrando todos los documentos");
                mostrarDocumentosEncontrados(biblioteca.todoDocumentos());
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private void mostrarDocumentosEncontrados(ArrayList<Documento> documentos) {
        if (documentos.isEmpty()) {
            System.out.println("No se ha encontrado ningun documento que cumpla con el criterio de busqueda.");
        } else {
            System.out.println("Documentos encontrados:"+documentos.size());
            for (Documento documento : documentos) {
                documento.imprimirDetalleDocumento();
            }
        }
    }


}
