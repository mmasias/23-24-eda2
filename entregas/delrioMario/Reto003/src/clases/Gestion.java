package clases;

import java.util.ArrayList;
import java.util.Scanner;

public class Gestion {
    private ArrayList<Documento> documentos;

    public Gestion() {
        this.documentos = new ArrayList<Documento>();
    }

    public void agregar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el titulo del documento");
        String titulo = sc.nextLine();
        System.out.println("Ingrese el año de publicacion");
        int año = sc.nextInt();
        System.out.println("Ingrese el tipo de documento (1. LIBRO 2. REVISTA 3. ARTICULO 4. PAPEL)");
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
                tipo = Tipo.PAPEL;
                break;
            default:
                break;
        }

        ArrayList<Autor> autores = new ArrayList<>();
        System.out.println("Ingrese los autores del documento (escriba 'fin' para terminar):");
        String nombre;
        do {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nombre del autor: ");
            nombre = scanner.nextLine();
            if (!nombre.equalsIgnoreCase("fin")) {
                System.out.println("Apellido del autor: ");
                String apellido = scanner.nextLine();
                autores.add(new Autor(nombre, apellido));
            }
        } while (!nombre.equalsIgnoreCase("fin"));
        
        Documento documento = new Documento(titulo, año, autores, tipo);
        String palabra = "";
        do {
            System.out.println("Introduzca palabras clave (fin-para terminar)");
            palabra = sc.nextLine();
            if (!palabra.equals("fin")) {
                documento.añadirPalabraClave(palabra);
            }

        } while (!palabra.equals("fin"));
        documentos.add(documento);
    }

    public void modificar() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el titulo del libro a editar");
        String tituloLibro = scanner.nextLine();

        for (Documento documento : documentos) {
            if (documento.getTipo().equals(tituloLibro)) {
                System.out.println("Dime el nombre del nuevo titulo a añadir");
                String nuevoTitulo = scanner.nextLine();
                documento.setTitulo(nuevoTitulo);
                System.out.println("Dime el año de publicacion del libro");
                int anoPublicacion = scanner.nextInt();
                documento.setAnoDePublicacion(anoPublicacion);
                System.out.println("Dime que quieres añadir (1.LIBRO 2.REVISTA 3.ARTICULO 4.PAPEL)");
                int eleccion = scanner.nextInt();
                Tipo tipo = null;

                switch (eleccion) {
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
                        tipo = Tipo.PAPEL;
                        break;

                    default:
                        break;
                }
                documento.setTipo(tipo);
                boolean agregar = true;
                while (agregar) {
                    System.out.println("Dime el nombre del autor");
                    String nombre = scanner.nextLine();
                    System.out.println("Dime el apellido del autor");
                    String apellido = scanner.nextLine();
                    Autor autor = new Autor(nombre, apellido);
                    ArrayList<Autor> autores = new ArrayList<Autor>();
                    documento.añadirAutor(autor);
                    System.out.println("Quieres añadir otro autor? (s/n)");
                    String respuesta = scanner.nextLine();
                    if (respuesta.equals("n")) {
                        agregar = false;
                    }
                }

                String palabra = "";

                do {
                    System.out.println("Introduzca palabras clave (fin-para terminar)");
                    palabra = scanner.nextLine();
                    if (!palabra.equals("fin")) {
                        documento.añadirPalabraClave(palabra);
                    }

                } while (!palabra.equals("fin"));

            }
        }
    }

    public void buscarPorTitulo() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el titulo que desea buscar");
        String titulo = sc.nextLine();
        for (Documento documento : documentos) {
            if (documento.getTitulo().equals(titulo)) {
                System.out.println("Titulo: "+documento);
                System.out.println("Año de publicacion: " + documento.getAnoDePublicacion());
                System.out.println("Tipo: " + documento.getTipo());
            }
            for (Autor autor : documento.getAutores()) {
                System.out.print("Nombre: " + autor.getNombre());
                System.out.println("Apellido: " + autor.getApellido());
            }
            for (String palabraClave : documento.getPalabrasClave()) {
                System.out.println("Palabra clave: " + palabraClave);
            }
        }
    }

    public void buscarPorAutor() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre del autor que desea buscar");
        String nombre = sc.nextLine();
        for (Documento documento : documentos) {
            for (Autor autor : documento.getAutores()) {
                if (autor.getNombre().equals(nombre)) {
                    System.out.println("Titulo: "+documento);
                    System.out.println("Año de publicacion: " + documento.getAnoDePublicacion());
                    System.out.println("Tipo: " + documento.getTipo());
                }
                for (Autor nuevoAutor : documento.getAutores()) {
                    System.out.print("Nombre: " + nuevoAutor.getNombre());
                    System.out.println(" Apellido: " + nuevoAutor.getApellido());
                }
                for (String palabraClave : documento.getPalabrasClave()) {
                    System.out.println("Palabra clave: " + palabraClave);
                }
            }
        }
    }

    public void buscarPorPalabraClave() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la palabra clave que desea buscar");
        String palabra = sc.nextLine();
        for (Documento documento : documentos) {
            for (String palabraClave : documento.getPalabrasClave()) {
                if (palabraClave.equals(palabra)) {
                    System.out.println("Titulo: "+documento);
                    System.out.println("Año de publicacion: " + documento.getAnoDePublicacion());
                    System.out.println("Tipo: " + documento.getTipo());
                }
                for (Autor autor : documento.getAutores()) {
                    System.out.print("Nombre: " + autor.getNombre());
                    System.out.println("Apellido: " + autor.getApellido());
                }
                for (String nuevaPalabraClave : documento.getPalabrasClave()) {
                    System.out.println("Palabra clave: " + nuevaPalabraClave);
                }
            }
        }
    }

    public void eliminar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el titulo del documento que quieres eliminar");
        String titulo = sc.nextLine();
        for (Documento documento : documentos) {
            if (documento.getTitulo().equals(titulo)) {
                documentos.remove(documento);
            }
        }
    }

    public void menu() {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        do {
            System.out.println("1. Agregar documento");
            System.out.println("2. Modificar documento");
            System.out.println("3. Buscar por titulo");
            System.out.println("4. Buscar por autor");
            System.out.println("5. Buscar por palabra clave");
            System.out.println("6. Eliminar documento");
            System.out.println("7. Salir");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    agregar();
                    break;
                case 2:
                    modificar();
                    break;
                case 3:
                    buscarPorTitulo();
                    break;
                case 4:
                    buscarPorAutor();
                    break;
                case 5:
                    buscarPorPalabraClave();
                    break;
                case 6:
                    eliminar();
                    break;
                default:
                    break;
            }
        } while (opcion != 7);
    }

    public static void main(String[] args) {
        Gestion gestion = new Gestion();
        gestion.menu();
    }

    public static void maittn(String[] args) {
        Gestion gestion = new Gestion();
        gestion.menu();
    }
}
