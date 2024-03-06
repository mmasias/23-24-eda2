
import java.util.ArrayList;
import java.util.Scanner;

public class Gestion {
    private ArrayList<Documento> documentos;

    public Gestion(ArrayList<Documento> documentos) {
        this.documentos = documentos;
    }

    public void agregar() {

        System.out.println("Ingrese el titulo del documento");
        Scanner sc = new Scanner(System.in);
        String titulo = sc.nextLine();

        System.out.println("Ingrese el año de publicacion");
        int año = sc.nextInt();

        System.out.println("Ingrese el tipo de documento");
        System.out.println("1. LIBRO 2. REVISTA 3. ARTICULO 4. PAPER");
        int opcion = sc.nextInt();

        Tipo tipo = null;
        switch (opcion) {
            case 1:
                tipo = Tipo.LIBRO;
                break;
            case 2:
                tipo = Tipo.REVISTA;
                break;
            case 3:
                tipo = Tipo.ARTICULO;
                break;
            case 4:
                tipo = Tipo.PAPER;
                break;
            default:
                break;
        }

        System.out.println("Ingrese el nombre del autor");
        String nombre = sc.nextLine();

        System.out.println("Ingrese el apellido del autor");
        String apellido = sc.nextLine();

        Autor autor = new Autor(nombre, apellido);
        ArrayList<Autor> autores = new ArrayList<Autor>();
        autores.add(autor);

        Documento documento = new Documento(titulo, año, autores, tipo);
        String palabra = "";

        do {
            System.out.println("Introduzca palabras clave (acabe -para terminar)");
            palabra = sc.nextLine();
            if (!palabra.equals("aca")) {
                documento.añadirPalabraClave(palabra);
            }

        } while (!palabra.equals("fin"));
        documentos.add(documento);
    }

    public void modificar() {
        Scanner userInput = new Scanner(System.in);
        boolean modificar = true;

        while (modificar) {
            System.out.println("Ingrese el titulo del documento que desea modificar");
            String titulo = userInput.nextLine();

            for (Documento documento : documentos) {
                if (documento.getTitulo().equals(titulo)) {
                    System.out.println("Ingrese el nuevo titulo");
                    String nuevoTitulo = userInput.nextLine();
                    documento.setTitulo(nuevoTitulo);

                    System.out.println("Ingrese el nuevo año de publicacion");
                    int nuevoAño = userInput.nextInt();
                    documento.setAnoDePublicacion(nuevoAño);

                    System.out.println("Ingrese el nuevo tipo de documento");
                    System.out.println("1. LIBRO 2. REVISTA 3. ARTICULO 4. PAPER");

                    int opcion = userInput.nextInt();
                    Tipo tipo = null;

                    switch (opcion) {
                        case 1:
                            tipo = Tipo.LIBRO;
                            break;
                        case 2:
                            tipo = Tipo.REVISTA;
                            break;
                        case 3:
                            tipo = Tipo.ARTICULO;
                            break;
                        case 4:
                            tipo = Tipo.PAPER;
                            break;
                        default:
                            break;
                    }

                    documento.setTipo(tipo);
                    System.out.println("Ingrese el nombre del autor");
                    String nombre = userInput.nextLine();

                    System.out.println("Ingrese el apellido del autor");
                    String apellido = userInput.nextLine();
                    Autor autor = new Autor(nombre, apellido);

                    ArrayList<Autor> autores = new ArrayList<Autor>();
                    autores.add(autor);
                    documento.setAutores(autores);
                    String palabra = "";

                    do {
                        System.out.println("Introduzca palabras clave (fin -para terminar)");
                        palabra = userInput.nextLine();
                        if (!palabra.equals("fin")) {
                            documento.añadirPalabraClave(palabra);
                        }
                    } while (!palabra.equals("fin"));
                    modificar = false;
                    break;
                }
            }
        }
    }

    public void buscar() {
        Scanner userInput = new Scanner(System.in);
        boolean buscar = true;

        while (buscar) {
            System.out.println("Ingrese el titulo del documento que desea buscar");
            String titulo = userInput.nextLine();

            for (Documento documento : documentos) {
                if (documento.getTitulo().equals(titulo)) {
                    System.out.println("Titulo: " + documento.getTitulo());
                    System.out.println("Año de publicacion: " + documento.getAnoDePublicacion());
                    System.out.println("Autores: ");
                    for (Autor autor : documento.getAutores()) {
                        System.out.println(autor.getNombre() + " " + autor.getApellido());
                    }
                    System.out.println("Tipo: " + documento.getTipo());
                    System.out.println("Palabras clave: ");
                    for (String palabra : documento.getPalabrasClave()) {
                        System.out.println(palabra);
                    }
                    buscar = false;
                    break;
                }
            }
        }
    }

    public void eliminar() {
        Scanner userInput = new Scanner(System.in);
        boolean deleting = true;

        while (deleting) {
            System.out.println("Ingrese el titulo del documento que desea eliminar");
            String titulo = userInput.nextLine();
            for (Documento documento : documentos) {
                if (documento.getTitulo().equals(titulo)) {
                    documentos.remove(documento);
                    System.out.println("Documento eliminado");
                    deleting = false;
                    break;
                }
            }
        }
    }

    public void imprimirInfo() {
        System.out.println("");
        System.out.println("Información de todos los libros:");
        System.out.println("");
        for (Documento documento : documentos) {
            if (documento.getTipo() == Tipo.LIBRO) {
                System.out.println("Titulo: " + documento.getTitulo());
                System.out.println("Año de publicacion: " + documento.getAnoDePublicacion());
                System.out.println("Autores: ");
                for (Autor autor : documento.getAutores()) {
                    System.out.println(autor.getNombre() + " " + autor.getApellido());
                }
                System.out.println("Palabras clave: ");
                for (String palabra : documento.getPalabrasClave()){
                    System.out.println(palabra);
                }
                System.out.println();
            
            }
        }
    }


    public void menu() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("1. Agregar documento");
            System.out.println("2. Modificar documento");
            System.out.println("3. Buscar documento");
            System.out.println("4. Eliminar documento");
            System.out.println("5. Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    agregar();
                    break;
                case 2:
                    modificar();
                    break;
                case 3:
                    buscar();
                    break;
                case 4:
                    eliminar();
                    break;
                default:
                    break;
            }
        } while (opcion != 5);

        imprimirInfo();

    }

}