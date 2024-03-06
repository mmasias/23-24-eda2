package entregas.diestroPaula.Reto003;

import java.util.ArrayList;
import java.util.Scanner;

public class Documento {

    private String titulo;
    private ArrayList<Autor> autores;
    private String añoPublicacion;
    private ArrayList<String> palabrasClave;
    private String tipo;
    Scanner sc;

    public Documento(String titulo, ArrayList<Autor> autores, String añoPublicacion, ArrayList<String> palabrasClave,
            String tipo) {
        this.titulo = titulo;
        this.autores = new ArrayList<>();
        this.añoPublicacion = añoPublicacion;
        this.palabrasClave = new ArrayList<>();
        this.tipo = tipo;
        sc = new Scanner(System.in);
    }

    private void agregarAutor() {
        System.out.print("Ingrese el nombre del autor: ");
        String nombre = sc.nextLine();
        Autor nuevoAutor = new Autor(nombre);
        autores.add(nuevoAutor);

        System.out.println("Autor agregado correctamente.");
    }

    private void listarAutores() {
        if (autores.isEmpty()) {
            System.out.println("No hay autores para listar.");
        } else {
            System.out.println("Lista de Autores:");
            for (Autor autor : autores) {
                System.out.println(autor);
            }
        }
    }

    private void actualizarAutor() {
        listarAutores();
        System.out.print("Ingrese el nombre del autor que desea actualizar: ");
        int indice = sc.nextInt();
        sc.nextLine();

        if (indice >= 0 && indice < autores.size()) {
            System.out.print("Ingrese el nuevo nombre del autor: ");
            String nuevoNombre = sc.nextLine();

            Autor autorActualizado = autores.get(indice);
            autorActualizado.setNombre(nuevoNombre);

            System.out.println("Autor actualizado exitosamente.");
        } else {
            System.out.println("Nombre no encontrado. No se puede actualizar el autor.");
        }
    }

    private void eliminarAutor() {
        listarAutores();
        System.out.print("Ingrese el nombre del autor que desea eliminar: ");
        int indice = sc.nextInt();
        sc.nextLine();

        if (indice >= 0 && indice < autores.size()) {
            autores.remove(indice);
            System.out.println("Autor eliminado exitosamente.");
        } else {
            System.out.println("Nombre no válido. No se puede eliminar el autor.");
        }
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }

    public String getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(String añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    public ArrayList<String> getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(ArrayList<String> palabrasClave) {
        this.palabrasClave = palabrasClave;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Documento añadir() {
        System.out.println("Añada el título del documento: ");
        String titulo = sc.nextLine();

        ArrayList<String> autores = new ArrayList<>();
        boolean añadiendoAutores = true;
        while (añadiendoAutores) {
            System.out.println("Añada el nombre del autor/es ('FIN' para terminar): ");
            String nombreAutor = sc.nextLine();
            if (nombreAutor.equalsIgnoreCase("FIN")) {
                añadiendoAutores = false;
            } else {
                autores.add(nombreAutor);
            }
        }

        System.out.println("Introduzca la fecha de publicación: ");
        String año = sc.nextLine();

        ArrayList<String> palabrasClave = new ArrayList<>();
        System.out.println("Introduzca las palabras clave del documento (escriba 'FIN' para terminar):");
        while (true) {
            String palabraClave = sc.nextLine();
            if (palabraClave.equalsIgnoreCase("FIN")) {
                break;
            } else {
                palabrasClave.add(palabraClave);
            }
        }
        Documento d = new Documento(titulo, null, año, null, tipo);
        return d;
    }
}