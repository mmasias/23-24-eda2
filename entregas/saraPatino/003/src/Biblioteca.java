package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Biblioteca {
    List<Documento> documentos;

    public Biblioteca() {
        this.documentos = new ArrayList<>();
    }

    public void agregarDocumento(Documento documento) {
        this.documentos.add(documento);
    }

    public List<Documento> buscarDocumento(String criterio, String valor) {
        List<Documento> resultados = new ArrayList<>();
        for (Documento documento : documentos) {
            switch (criterio) {
                case "titulo":
                    if (documento.getTitulo().getName().equalsIgnoreCase(valor)) {
                        resultados.add(documento);
                    }
                    break;
                case "autor":
                    for (Autor autor : documento.getAutores()) {
                        if (autor.getName().equalsIgnoreCase(valor)) {
                            resultados.add(documento);
                            break;
                        }
                    }
                    break;
                case "año":
                    if (documento.getAñoPublicacion().equalsIgnoreCase(valor)) {
                        resultados.add(documento);
                    }
                    break;
                case "tipo":
                    if (documento.getTipo().equalsIgnoreCase(valor)) {
                        resultados.add(documento);
                    }
                    break;
                case "keyword":
                    for (String keyword : documento.getKeywords()) {
                        if (keyword.equalsIgnoreCase(valor)) {
                            resultados.add(documento);
                            break;
                        }
                    }
                    break;
            }
        }
        return resultados;
    }

    public void mostrarDocumentos(List<Documento> documentos) {
        for (Documento documento : documentos) {
            System.out.println("ID: " + documento.getId());
            System.out.println("Título: " + documento.getTitulo().getName());
            System.out.println("Tipo: " + documento.getTipo());
            System.out.println("Autores:");
            for (Autor autor : documento.getAutores()) {
                System.out.println("- " + autor.getName());
            }
            System.out.println("Año de Publicación: " + documento.getAñoPublicacion());
            System.out.println("Keywords:");
            for (String keyword : documento.getKeywords()) {
                System.out.println("- " + keyword);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Agregar Documento");
            System.out.println("2. Buscar Documento");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    Documento nuevoDocumento = new Documento();
                    System.out.print("Ingrese el título del documento: ");
                    nuevoDocumento.setTitulo(new Titulo(scanner.nextLine()));

                    System.out.print("Ingrese el tipo del documento: ");
                    nuevoDocumento.setTipo(scanner.nextLine());

                    System.out.print("Ingrese el año de publicación del documento: ");
                    nuevoDocumento.setAñoPublicacion(scanner.nextLine());

                    System.out.print("Ingrese la cantidad de autores del documento: ");
                    int numAutores = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    Autor[] autores = new Autor[numAutores];
                    for (int i = 0; i < numAutores; i++) {
                        System.out.print("Ingrese el nombre del autor " + (i + 1) + ": ");
                        autores[i] = new Autor(scanner.nextLine());
                    }
                    nuevoDocumento.setAutores(autores);

                    System.out.print("Ingrese la cantidad de keywords del documento: ");
                    int numKeywords = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer
                    String[] keywords = new String[numKeywords];
                    for (int i = 0; i < numKeywords; i++) {
                        System.out.print("Ingrese la keyword " + (i + 1) + ": ");
                        keywords[i] = scanner.nextLine();
                    }
                    nuevoDocumento.setKeywords(keywords);

                    biblioteca.agregarDocumento(nuevoDocumento);
                    System.out.println("Documento agregado correctamente.\n");
                    break;
                case 2:
                    System.out.println("Seleccione el criterio de búsqueda:");
                    System.out.println("1. Título");
                    System.out.println("2. Autor");
                    System.out.println("3. Año de publicación");
                    System.out.println("4. Tipo");
                    System.out.println("5. Keyword");
                    System.out.print("Opción: ");
                    int criterio = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el buffer

                    System.out.print("Ingrese el valor de búsqueda: ");
                    String valor = scanner.nextLine();

                    List<Documento> resultados = null;
                    switch (criterio) {
                        case 1:
                            resultados = biblioteca.buscarDocumento("titulo", valor);
                            break;
                        case 2:
                            resultados = biblioteca.buscarDocumento("autor", valor);
                            break;
                        case 3:
                            resultados = biblioteca.buscarDocumento("año", valor);
                            break;
                        case 4:
                            resultados = biblioteca.buscarDocumento("tipo", valor);
                            break;
                        case 5:
                            resultados = biblioteca.buscarDocumento("keyword", valor);
                            break;
                        default:
                            System.out.println("Opción inválida.");
                    }

                    if (resultados != null && !resultados.isEmpty()) {
                        System.out.println("Resultados de la búsqueda:");
                        biblioteca.mostrarDocumentos(resultados);
                    } else {
                        System.out.println("No se encontraron documentos que coincidan con la búsqueda.\n");
                    }
                    break;
                case 3:
                    System.out.println("Saliendo del programa.");
                    System.exit(0);
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }
}