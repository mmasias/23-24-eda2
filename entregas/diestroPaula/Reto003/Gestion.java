package entregas.diestroPaula.Reto003;

import java.util.ArrayList;
import java.util.Scanner;

public class Gestion {
    private ArrayList<Documento> documentos;
    private Scanner scanner;

    public Gestion() {
        documentos = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void agregarDocumento() {
        System.out.println("\nIngrese el título del documento:");
        String titulo = scanner.nextLine();

        ArrayList<Autor> autores = new ArrayList<>();
        boolean añadiendoAutores = true;
        while (añadiendoAutores) {
            System.out.println("Ingrese el nombre del autor (-1 para terminar):");
            String nombreAutor = scanner.nextLine();
            if (nombreAutor.equalsIgnoreCase("-1")) {
                añadiendoAutores = false;
            } else {
                autores.add(new Autor(nombreAutor));
            }
        }

        System.out.println("Introduzca la fecha de publicación:");
        String año = scanner.nextLine();

        ArrayList<String> palabrasClave = new ArrayList<>();
        System.out.println("Introduzca las palabras clave del documento (-1 para terminar):");
        while (true) {
            String palabraClave = scanner.nextLine();
            if (palabraClave.equalsIgnoreCase("-1")) {
                break;
            } else {
                palabrasClave.add(palabraClave);
            }
        }

        System.out.println("Introduzca el tipo de documento: ([L]ibro, [R]evista, [A]rtículo, [P]aper)");
        String tipo = scanner.nextLine();

        Documento documento = new Documento(titulo, autores, año, palabrasClave, tipo);
        documentos.add(documento);
        System.out.println("Documento agregado exitosamente.");
    }

    public void editarDocumento() {
        System.out.println("\nIngrese el título del documento a editar:");
        String tituloBusqueda = scanner.nextLine();
        boolean encontrado = false;

        for (Documento documento : documentos) {
            if (documento.getTitulo().equalsIgnoreCase(tituloBusqueda)) {
                System.out.println("Documento encontrado:");
                documento.mostrarDetalles();
                encontrado = true;

                System.out.println("¿Qué dato desea editar?");
                System.out.println("1. Título");
                System.out.println("2. Autores");
                System.out.println("3. Año de publicación");
                System.out.println("4. Palabras clave");
                System.out.println("5. Tipo de documento");
                System.out.print("Ingrese su opción: ");
                int opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese el nuevo título:");
                        String nuevoTitulo = scanner.nextLine();
                        documento.setTitulo(nuevoTitulo);
                        break;
                    case 2:
                        ArrayList<Autor> autores = new ArrayList<>();
                        boolean añadiendoAutores = true;
                        while (añadiendoAutores) {
                            System.out.println("Ingrese el nombre del autor (-1 para terminar):");
                            String nombreAutor = scanner.nextLine();
                            if (nombreAutor.equalsIgnoreCase("-1")) {
                                añadiendoAutores = false;
                            } else {
                                autores.add(new Autor(nombreAutor));
                            }
                        }
                        break;
                    case 3:
                        System.out.println("Ingrese el nuevo año de publicación:");
                        String nuevoAño = scanner.nextLine();
                        documento.setAñoPublicacion(nuevoAño);
                        break;
                    case 4:
                        ArrayList<String> palabrasClave = new ArrayList<>();
                        System.out.println("Introduzca las palabras clave del documento (-1 para terminar):");
                        while (true) {
                            String palabraClave = scanner.nextLine();
                            if (palabraClave.equalsIgnoreCase("-1")) {
                                break;
                            } else {
                                palabrasClave.add(palabraClave);
                            }
                        }
                        break;
                    case 5:
                        System.out.println("Ingrese el nuevo tipo de documento:");
                        String nuevoTipo = scanner.nextLine();
                        documento.setTipo(nuevoTipo);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
                break;
            }
        }

        if (!encontrado) {
            System.out.println("El documento no fue encontrado.");
        }
    }

    public void eliminarDocumento() {
        System.out.println("\nIngrese el título del documento a eliminar:");
        String tituloBusqueda = scanner.nextLine();
        boolean encontrado = false;

        for (Documento documento : documentos) {
            if (documento.getTitulo().equalsIgnoreCase(tituloBusqueda)) {
                documentos.remove(documento);
                System.out.println("Documento eliminado exitosamente.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("El documento no fue encontrado.");
        }
    }

    public void buscarDocumento() {
        System.out.println("\nIngrese el título del documento a buscar:");
        String tituloBusqueda = scanner.nextLine();
        boolean encontrado = false;

        for (Documento documento : documentos) {
            if (documento.getTitulo().equalsIgnoreCase(tituloBusqueda)) {
                System.out.println("Documento encontrado:");
                documento.mostrarDetalles();
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("El documento no fue encontrado.");
        }
    }

    public void mostrarDocumentos() {
        System.out.println("\nLista de Documentos:");
        for (Documento documento : documentos) {
            documento.mostrarDetalles();
        }
    }

    public void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Agregar nuevo documento");
            System.out.println("2. Buscar documento");
            System.out.println("3. Mostrar todos los documentos");
            System.out.println("4. Editar documento");
            System.out.println("5. Eliminar documento");
            System.out.println("6. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    agregarDocumento();
                    break;
                case 2:
                    buscarDocumento();
                    break;
                case 3:
                    mostrarDocumentos();
                    break;
                case 4:
                    editarDocumento();
                    break;
                case 5:
                    eliminarDocumento();
                    break;
                case 6:
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 6);
    }

    public static void main(String[] args) {
        Gestion gestion = new Gestion();
        gestion.mostrarMenu();
    }
}