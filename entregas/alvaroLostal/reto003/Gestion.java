package classes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Gestion {
    private ArrayList<Documento> documentos;
    private HashMap<String, ArrayList<Documento>> indiceAutores;
    private HashMap<String, ArrayList<Documento>> indicePalabrasClave;

    public Gestion() {
        this.documentos = new ArrayList<>();
        this.indiceAutores = new HashMap<>();
        this.indicePalabrasClave = new HashMap<>();
    }

    public void agregar(Documento documento) {
        try {
            documentos.add(documento);

            ArrayList<Autor> autores = documento.getAutores();
            for (Autor autor : autores) {
                String nombreCompleto = autor.getNombre() + " " + autor.getApellido();
                if (indiceAutores.containsKey(nombreCompleto)) {
                    indiceAutores.get(nombreCompleto).add(documento);
                } else {
                    ArrayList<Documento> documentosAutor = new ArrayList<>();
                    documentosAutor.add(documento);
                    indiceAutores.put(nombreCompleto, documentosAutor);
                }
            }

            //hola

            ArrayList<String> palabrasClave = documento.getPalabrasClave();
            for (String palabra : palabrasClave) {
                if (indicePalabrasClave.containsKey(palabra)) {
                    indicePalabrasClave.get(palabra).add(documento);
                } else {
                    ArrayList<Documento> documentosPalabraClave = new ArrayList<>();
                    documentosPalabraClave.add(documento);
                    indicePalabrasClave.put(palabra, documentosPalabraClave);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al agregar documento: " + e.getMessage());
        }
    }

    public void modificar(Documento documento, String titulo, int año, ArrayList<Autor> autores,
            ArrayList<String> palabrasClave, Tipo tipo) {
        documento.setTitulo(titulo);
        documento.setAño(año);
        documento.setAutores(autores);
        documento.setPalabrasClave(palabrasClave);
        documento.setTipo(tipo);
    }

    public ArrayList<Documento> buscar(String criterio, String valor) {
        ArrayList<Documento> resultado = new ArrayList<>();
        try {
            for (Documento doc : documentos) {
                switch (criterio.toLowerCase()) {
                    case "titulo":
                        if (doc.getTitulo().toLowerCase().contains(valor.toLowerCase())) {
                            resultado.add(doc);
                        }
                        break;
                    case "autor":
                        for (Autor autor : doc.getAutores()) {
                            if (autor.getNombre().toLowerCase().contains(valor.toLowerCase()) ||
                                    autor.getApellido().toLowerCase().contains(valor.toLowerCase())) {
                                resultado.add(doc);
                                break;
                            }
                        }
                        break;
                    case "anio":
                        if(doc.getAño()==Integer.parseInt(valor)){
                            resultado.add(doc);
                        }
                        break;
                    case "tipo":
                        if (doc.getTipo().toString().toLowerCase().equals(valor.toLowerCase())) {
                            resultado.add(doc);
                        }
                        break;
                    case "palabras clave":
                        for (String palabraClave : doc.getPalabrasClave()) {
                            if (palabraClave.toLowerCase().contains(valor.toLowerCase())) {
                                resultado.add(doc);
                                break;
                            }
                        }
                        break;
                    default:
                        System.out.println("Criterio de búsqueda no válido.");
                        break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error al buscar documentos: " + e.getMessage());
        }
        return resultado;
    }

    public void eliminar(Documento documento) {
        try {
            documentos.remove(documento);
        } catch (Exception e) {
            System.out.println("Error al eliminar documento: " + e.getMessage());
        }
    }

    public HashMap<String, ArrayList<Documento>> getIndiceAutores() {
        return indiceAutores;
    }

    public HashMap<String, ArrayList<Documento>> getIndicePalabrasClave() {
        return indicePalabrasClave;
    }

    public static void main(String[] args) {
        Gestion biblioteca = new Gestion();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            try {
                System.out.println("\u001B[31m" + "\nBiblioteca de Documentos" + "\u001B[0m");
                System.out.println("1. Agregar documento");
                System.out.println("2. Buscar documento");
                System.out.println("3. Modificar documento");
                System.out.println("4. Eliminar documento");
                System.out.println("5. Documentos de autor");
                System.out.println("6. Documentos por palabra clave");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");
                opcion = scanner.nextInt();
                scanner.nextLine();

                switch (opcion) {
                    case 1:
                        agregarDocumento(biblioteca, scanner);
                        break;
                    case 2:
                        buscarDocumento(biblioteca, scanner);
                        break;
                    case 3:
                        modificarDocumento(biblioteca, scanner);
                        break;
                    case 4:
                        eliminarDocumento(biblioteca, scanner);
                        break;
                    case 5:
                        mostrarDocumentoPorAutor(biblioteca, scanner);
                        break;
                    case 6:
                        mostrarDocumentoPorPalabrasClave(biblioteca, scanner);
                        break;
                    case 0:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Número no válido. Intente de nuevo.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Formato de entrada no válido. Intente de nuevo.");
                scanner.nextLine();
                opcion = -1;
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void agregarDocumento(Gestion biblioteca, Scanner scanner) {
        System.out.println("Ingrese los detalles del documento:");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Año: ");
        int año = scanner.nextInt();
        scanner.nextLine();

        ArrayList<Autor> autores = new ArrayList<>();
        System.out.println("Ingrese los autores del documento (escriba 'fin' para terminar):");
        String nombreAutor;
        do {
            System.out.print("Nombre del autor: ");
            nombreAutor = scanner.nextLine();
            if (!nombreAutor.equalsIgnoreCase("fin")) {
                System.out.print("Apellido del autor: ");
                String apellidoAutor = scanner.nextLine();
                autores.add(new Autor(nombreAutor, apellidoAutor));
            }
        } while (!nombreAutor.equalsIgnoreCase("fin"));

        ArrayList<String> palabrasClave = new ArrayList<>();
        System.out.println("Ingrese las palabras clave del documento (escriba 'fin' para terminar):");
        String palabraClave;
        do {
            System.out.print("Palabra clave: ");
            palabraClave = scanner.nextLine();
            if (!palabraClave.equalsIgnoreCase("fin")) {
                palabrasClave.add(palabraClave);
            }
        } while (!palabraClave.equalsIgnoreCase("fin"));

        System.out.println("Ingrese el tipo del documento (LIBRO, REVISTA, ARTICULO, PAPER): ");
        Tipo tipo = Tipo.valueOf(scanner.nextLine().toUpperCase());

        Documento nuevoDocumento = new Documento(titulo, año, autores, palabrasClave, tipo);
        biblioteca.agregar(nuevoDocumento);
        System.out.println("Documento agregado correctamente.");
    }

    private static void buscarDocumento(Gestion biblioteca, Scanner scanner) {
        System.out.print("Ingrese el criterio de búsqueda (titulo, autor, anio, tipo, palabras clave): ");
        String criterio = scanner.nextLine();
        System.out.print("Ingrese el valor a buscar: ");
        String valor = scanner.nextLine();

        ArrayList<Documento> resultado = biblioteca.buscar(criterio, valor);

        if (resultado.isEmpty()) {
            System.out.println("No se encontraron documentos que coincidan con la búsqueda.");
        } else {
            System.out.println("Documentos encontrados:");
            for (Documento doc : resultado) {
                System.out.println("-------------------------");
                System.out.println("Título: " + doc.getTitulo());
                System.out.println("Tipo: " + doc.getTipo());
                System.out.println("Año: " + doc.getAño());
                System.out.print("Autores: ");
                for (int i = 0; i < doc.getAutores().size(); i++) {
                    Autor autor = doc.getAutores().get(i);
                    System.out.print(autor.getNombre() + " " + autor.getApellido());
                    if (i < doc.getAutores().size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
                System.out.println("Palabras Clave: " + doc.getPalabrasClave().toString());

            }
            System.out.println("-------------------------");
        }
    }

    private static void modificarDocumento(Gestion biblioteca, Scanner scanner) {
        System.out.print("Ingrese el título del documento a modificar: ");
        String titulo = scanner.nextLine();

        ArrayList<Documento> resultado = biblioteca.buscar("titulo", titulo);
        if (resultado.isEmpty()) {
            System.out.println("No se encontró ningún documento con ese título.");
        } else {
            System.out.println("Documentos encontrados:");
            for (int i = 0; i < resultado.size(); i++) {
                Documento doc = resultado.get(i);
                System.out.println((i + 1) + ". " + doc.getTitulo() + " - " + doc.getTipo() + " - " + doc.getAño());
            }
            System.out.print("Seleccione el número del documento que desea modificar: ");
            int numDocumento = scanner.nextInt();
            scanner.nextLine();

            if (numDocumento < 1 || numDocumento > resultado.size()) {
                System.out.println("Número de documento no válido.");
            } else {
                Documento documentoAModificar = resultado.get(numDocumento - 1);

                System.out.println("Ingrese los nuevos detalles del documento:");
                System.out.print("Nuevo título: ");
                String nuevoTitulo = scanner.nextLine();
                System.out.print("Nuevo año: ");
                int nuevoAño = scanner.nextInt();
                scanner.nextLine();

                ArrayList<Autor> autores = new ArrayList<>();
                System.out.println("Ingrese los nuevos autores del documento (escriba 'fin' para terminar):");
                String nombreAutor;
                do {
                    System.out.print("Nombre del autor: ");
                    nombreAutor = scanner.nextLine();
                    if (!nombreAutor.equalsIgnoreCase("fin")) {
                        System.out.print("Apellido del autor: ");
                        String apellidoAutor = scanner.nextLine();
                        autores.add(new Autor(nombreAutor, apellidoAutor));
                    }
                } while (!nombreAutor.equalsIgnoreCase("fin"));

                ArrayList<String> palabrasClave = new ArrayList<>();
                System.out.println("Ingrese las nuevas palabras clave del documento (escriba 'fin' para terminar):");
                String palabraClave;
                do {
                    System.out.print("Palabra clave: ");
                    palabraClave = scanner.nextLine();
                    if (!palabraClave.equalsIgnoreCase("fin")) {
                        palabrasClave.add(palabraClave);
                    }
                } while (!palabraClave.equalsIgnoreCase("fin"));

                System.out.println("Ingrese el nuevo tipo del documento (LIBRO, REVISTA, ARTICULO, PAPER): ");
                Tipo nuevoTipo = Tipo.valueOf(scanner.nextLine().toUpperCase());

                biblioteca.modificar(documentoAModificar, nuevoTitulo, nuevoAño, autores, palabrasClave, nuevoTipo);
                System.out.println("Documento modificado correctamente.");
            }
        }
    }

    private static void eliminarDocumento(Gestion biblioteca, Scanner scanner) {
        System.out.print("Ingrese el título del documento a eliminar: ");
        String titulo = scanner.nextLine();

        ArrayList<Documento> resultado = biblioteca.buscar("titulo", titulo);
        if (resultado.isEmpty()) {
            System.out.println("No se encontró ningún documento con ese título.");
        } else {
            System.out.println("Documentos encontrados:");
            for (int i = 0; i < resultado.size(); i++) {
                Documento doc = resultado.get(i);
                System.out.println((i + 1) + ". " + doc.getTitulo() + " - " + doc.getTipo() + " - " + doc.getAño());
            }
            System.out.print("Seleccione el número del documento que desea eliminar: ");
            int numDocumento = scanner.nextInt();
            scanner.nextLine();

            if (numDocumento < 1 || numDocumento > resultado.size()) {
                System.out.println("Número de documento no válido.");
            } else {
                Documento documentoAEliminar = resultado.get(numDocumento - 1);
                biblioteca.eliminar(documentoAEliminar);
                System.out.println("Documento eliminado correctamente.");
            }
        }
    }

    public static void mostrarDocumentoPorAutor(Gestion biblioteca, Scanner scanner) {
        System.out.println("Ingrese el nombre del autor: ");
        String nombreAutor = scanner.nextLine();
        System.out.println("Ingrese el apellido del autor: ");
        String apellidoAutor = scanner.nextLine();
        String nombreCompleto = nombreAutor + " " + apellidoAutor;

        ArrayList<Documento> docs = biblioteca.getIndiceAutores().get(nombreCompleto);
        for (Documento documento : docs) {
            System.out.println(documento.toString());
        }
        System.out.println("-------------------------\n");
    }

    public static void mostrarDocumentoPorPalabrasClave(Gestion biblioteca, Scanner scanner) {
        System.out.println("Ingrese la palabra clave: ");
        String palabra = scanner.nextLine();

        ArrayList<Documento> docs = biblioteca.getIndicePalabrasClave().get(palabra);
        for (Documento documento : docs) {
            System.out.println(documento.toString());
        }
        System.out.println("-------------------------\n");
    }
}