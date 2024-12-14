package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class ManagerBiblioteca {
    private List<Documento> documentos;
    private List<Escritor> escritores;
    private List<Relacion> relaciones;
    private Scanner scanner;

    public ManagerBiblioteca() {
        documentos = new ArrayList<>();
        escritores = new ArrayList<>();
        relaciones = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void cargarDatos() {

        escritores.add(new Escritor(1, "Pepe", "Banderas Cos"));
        documentos.add(new Documento(1, "El silencio que grita", 2000));
        relaciones.add(new Relacion(1, 1));
    }

    public void menu() {
        int opcion;
        do {
            System.out.println("\n*** Biblioteca Manager ***");
            System.out.println("1. Agregar Documento");
            System.out.println("2. Agregar Escritor");
            System.out.println("3. Listar Documentos");
            System.out.println("4. Listar Escritores");
            System.out.println("5. Buscar Documentos por Escritor");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarDocumento();
                    break;
                case 2:
                    agregarEscritor();
                    break;
                case 3:
                    listarDocumentos();
                    break;
                case 4:
                    listarEscritores();
                    break;
                case 5:
                    buscarDocumentosPorEscritor();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (opcion != 6);
    }

    private void agregarDocumento() {
        System.out.print("Ingrese el título del documento: ");
        String titulo = scanner.nextLine();
        System.out.print("Ingrese el año de publicación: ");
        int anio = scanner.nextInt();
        scanner.nextLine();
        Documento documento = new Documento(documentos.size() + 1, titulo, anio);
        documentos.add(documento);
        System.out.println("Documento agregado exitosamente.");
    }

    private void agregarEscritor() {
        System.out.print("Ingrese el nombre del escritor: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese el apellido del escritor: ");
        String apellido = scanner.nextLine();
        Escritor escritor = new Escritor(escritores.size() + 1, nombre, apellido);
        escritores.add(escritor);
        System.out.println("Escritor agregado exitosamente.");
    }

    private void listarDocumentos() {
        documentos.forEach(System.out::println);
    }

    private void listarEscritores() {
        escritores.forEach(System.out::println);
    }

    private void buscarDocumentosPorEscritor() {
        System.out.print("Ingrese el ID del escritor: ");
        int idEscritor = scanner.nextInt();
        List<Documento> documentosEscritor = new ArrayList<>();
        for (Relacion relacion : relaciones) {
            if (relacion.getEscritorId() == idEscritor) {
                documentos.stream()
                        .filter(documento -> documento.getId() == relacion.getDocumentoId())
                        .findFirst()
                        .ifPresent(documentosEscritor::add);
            }
        }
        documentosEscritor.forEach(System.out::println);
    }

}
