package entregas.diestroPaula.Reto003;

import java.util.ArrayList;
import java.util.Scanner;

public class Documento {
    private String titulo;
    private ArrayList<Autor> autores;
    private String añoPublicacion;
    private ArrayList<String> palabrasClave;
    private String tipo;
    private Scanner sc;

    public Documento(String titulo, ArrayList<Autor> autores, String añoPublicacion, ArrayList<String> palabrasClave,
            String tipo) {
        this.titulo = titulo;
        this.autores = autores;
        this.añoPublicacion = añoPublicacion;
        this.palabrasClave = palabrasClave;
        this.tipo = tipo;
        sc = new Scanner(System.in);
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
        int nombre = sc.nextInt();
        sc.nextLine();

        if (nombre >= 0 && nombre < autores.size()) {
            System.out.print("Ingrese el nuevo nombre del autor: ");
            String nuevoNombre = sc.nextLine();

            Autor autorActualizado = autores.get(nombre);
            autorActualizado.setNombre(nuevoNombre);

            System.out.println("Autor actualizado exitosamente.");
        } else {
            System.out.println("Nombre no encontrado.");
        }
    }

    private void eliminarAutor() {
        listarAutores();
        System.out.print("Ingrese el nombre del autor que desea eliminar: ");
        int nombre = sc.nextInt();
        sc.nextLine();

        if (nombre >= 0 && nombre < autores.size()) {
            autores.remove(nombre);
            System.out.println("Autor eliminado exitosamente.");
        } else {
            System.out.println("Nombre no válido.");
        }
    }

    public Documento añadir() {
        System.out.println("Añada el título del documento: ");
        String titulo = sc.nextLine();

        ArrayList<String> autores = new ArrayList<>();
        boolean añadiendoAutores = true;
        while (añadiendoAutores) {
            System.out.println("Añada el nombre del autor/es ('-1' para terminar): ");
            String nombreAutor = sc.nextLine();
            if (nombreAutor.equalsIgnoreCase("-1")) {
                añadiendoAutores = false;
            } else {
                autores.add(nombreAutor);
            }
        }

        System.out.println("Introduzca la fecha de publicación: ");
        String año = sc.nextLine();
        return null;
    }

    public Documento clasificarPalabrasClave() {
        ArrayList<String> palabrasClave = new ArrayList<>();
        boolean añadiendoPalabras = true;
        while (añadiendoPalabras) {
            System.out.println("Añada una palabra clave ('-1' para terminar): ");
            String palabra = sc.nextLine();
            if (palabra.equalsIgnoreCase("-1")) {
                añadiendoPalabras = false;
            } else {
                palabrasClave.add(palabra);
            }
        }
        return null;
    }

    public Documento clasificarTipo() {
        System.out.println("Introduzca el tipo de documento: ([L]ibro, [R]evista, [A]rtículo, [P]aper) ");
        String tipo = sc.nextLine();
        if (tipo.equalsIgnoreCase("L")) {
            tipo = "Libro";
        } else if (tipo.equalsIgnoreCase("R")) {
            tipo = "Revista";
        } else if (tipo.equalsIgnoreCase("A")) {
            tipo = "Artículo";
        } else if (tipo.equalsIgnoreCase("P")) {
            tipo = "Paper";
        } else {
            System.out.println("Tipo de documento no válido.");
        }

        Documento d = new Documento(titulo, autores, añoPublicacion, palabrasClave, tipo);
        return d;
    }

    public void mostrarDetalles() {
        System.out.println("Título: " + titulo);
        System.out.println("Autores: ");
        for (Autor autor : autores) {
            System.out.println(autor.getNombre());
        }
        System.out.println("Año de publicación: " + añoPublicacion);
        System.out.println("Palabras clave: ");
        for (String palabraClave : palabrasClave) {
            System.out.println(palabraClave);
        }
        System.out.println("Tipo de documento: " + tipo);
    }
}