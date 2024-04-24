package clases;
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
        boolean agregar = true;
        ArrayList<Autor> autores = new ArrayList<Autor>();
        do {
            System.out.println("Ingrese el nombre del autor");
            Scanner sc2 = new Scanner(System.in);
            String nombre = sc2.nextLine();
            System.out.println("Ingrese el apellido del autor");
            String apellido = sc2.nextLine();
            Autor autor = new Autor(nombre, apellido);
            autores.add(autor);
            System.out.println("Desea agregar otro autor? (si-no)");
            String respuesta = sc2.nextLine();
            if (respuesta.equals("no")) {
                agregar = false;
            } else {
                agregar = true;
            }
        } while (agregar);
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
        System.out.println("Ingrese el titulo del documento a modificar");
        Scanner sc = new Scanner(System.in);
        String titulo = sc.nextLine();
        for (Documento documento : documentos) {
            if (documento.getTitulo().equals(titulo)) {
                System.out.println("Ingrese el nuevo titulo del documento");
                String nuevoTitulo = sc.nextLine();
                documento.setTitulo(nuevoTitulo);
                System.out.println("Ingrese el nuevo año de publicacion");
                int nuevoAño = sc.nextInt();
                documento.setAnoDePublicacion(nuevoAño);
                System.out.println("Ingrese el nuevo tipo de documento");
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
                documento.setTipo(tipo);
                boolean agregar = true;
                do{
                    System.out.println("Ingrese el nombre del autor");
                    Scanner sc2 = new Scanner(System.in);
                    String nombre = sc2.nextLine();
                    System.out.println("Ingrese el apellido del autor");
                    String apellido = sc2.nextLine();
                    Autor autor = new Autor(nombre, apellido);
                    ArrayList<Autor> autores = new ArrayList<Autor>();
                    autores.add(autor);
                    documento.setAutores(autores);
                    System.out.println("Desea agregar otro autor? (si-no)");
                    String respuesta = sc2.nextLine();
                    if (respuesta.equals("no")) {
                        agregar = false;
                    } else {
                        agregar = true;
                    }
                }while(agregar);
                }

                String palabra = "";
                do {
                    System.out.println("Introduzca palabras clave (fin-para terminar)");
                    palabra = sc.nextLine();
                    if (!palabra.equals("fin")) {
                        documento.añadirPalabraClave(palabra);
                    } 
                } while (!palabra.equals("fin"));
            }
        }

    public void buscar() {
        System.out.println("Ingrese el titulo del documento a buscar");
        Scanner sc = new Scanner(System.in);
        String titulo = sc.nextLine();
        for (Documento documento : documentos) {
            if (documento.getTitulo().equals(titulo)) {
                System.out.println("Titulo: " + documento.getTitulo());
                System.out.println("Año de publicacion: " + documento.getAnoDePublicacion());
                System.out.println("Tipo: " + documento.getTipo());
                System.out.println("Autores: ");
                for (Autor autor : documento.getAutores()) {
                    System.out.println(autor.getNombre() + " " + autor.getApellido());
                }
                System.out.println("Palabras clave: ");
                for (String palabra : documento.getPalabrasClave()) {
                    System.out.println(palabra);
                }
            }
        }
    }
    public void buscarPorAutor() {
        System.out.println("Ingrese el nombre del autor a buscar");
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();
        for (Documento documento : documentos) {
            for (Autor autor : documento.getAutores()) {
                if (autor.getNombre().equals(nombre)) {
                    System.out.println("Titulo: " + documento.getTitulo());
                    System.out.println("Año de publicacion: " + documento.getAnoDePublicacion());
                    System.out.println("Tipo: " + documento.getTipo());
                    System.out.println("Autores: ");
                    for (Autor autor2 : documento.getAutores()) {
                        System.out.println(autor2.getNombre() + " " + autor2.getApellido());
                    }
                    System.out.println("Palabras clave: ");
                    for (String palabra : documento.getPalabrasClave()) {
                        System.out.println(palabra);
                    }
                }
            }
        }
    }
    public void buscarPorPalabrasClave() {
        System.out.println("Ingrese la palabra clave a buscar");
        Scanner sc = new Scanner(System.in);
        String palabra = sc.nextLine();
        for (Documento documento : documentos) {
            for (String palabraClave : documento.getPalabrasClave()) {
                if (palabraClave.equals(palabra)) {
                    System.out.println("Titulo: " + documento.getTitulo());
                    System.out.println("Año de publicacion: " + documento.getAnoDePublicacion());
                    System.out.println("Tipo: " + documento.getTipo());
                    System.out.println("Autores: ");
                    for (Autor autor : documento.getAutores()) {
                        System.out.println(autor.getNombre() + " " + autor.getApellido());
                    }
                    System.out.println("Palabras clave: ");
                    for (String palabra2 : documento.getPalabrasClave()) {
                        System.out.println(palabra2);
                    }
                }
            }
        }
    }

    public void eliminar() {
        System.out.println("Ingrese el titulo del documento a eliminar");
        Scanner sc = new Scanner(System.in);
        String titulo = sc.nextLine();
        for (Documento documento : documentos) {
            if (documento.getTitulo().equals(titulo)) {
                documentos.remove(documento);
                break;
            }
        }
    }
    public void menu() {
        boolean salir = false;
        do {
            System.out.println("1. Agregar documento");
            System.out.println("2. Modificar documento");
            System.out.println("3. Buscar documento");
            System.out.println("4. Buscar por autor");
            System.out.println("5. Buscar por palabras clave");
            System.out.println("6. Eliminar documento");
            System.out.println("7. Salir");
            Scanner sc = new Scanner(System.in);
            int opcion = sc.nextInt();
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
                    buscarPorAutor();
                    break;
                case 5:
                    buscarPorPalabrasClave();
                    break;
                case 6:
                    eliminar();
                    break;
                case 7:
                    salir = true;
                    break;
                default:
                    break;
            }
        } while (!salir);
    }
}