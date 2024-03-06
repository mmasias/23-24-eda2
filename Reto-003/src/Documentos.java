import java.util.ArrayList;
import java.util.Scanner;

public  class Documentos {

    private  String titulo;
    private ArrayList<Autor> autores;
    private String añoDePublicación;
    private ArrayList<String> palabrasClave;
    private String tipo;
    Scanner sc;

    public Documentos(String titulo, String añoDePublicación,  String tipo) {
        this.titulo = titulo;
         autores=new ArrayList<>();
        this.añoDePublicación = añoDePublicación;
         palabrasClave=new ArrayList<>();
        this.tipo = tipo;
        sc=new Scanner(System.in);
    }
    private void agregarAutor() {
        System.out.print("Ingrese el nombre del autor: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese los apellidos del autor: ");
        String apellidos = sc.nextLine();

        Autor nuevoAutor = new Autor(nombre, apellidos);
        autores.add(nuevoAutor);

        System.out.println("Autor agregado exitosamente.");
    }
    private void mostrarAutores() {
        if (autores.isEmpty()) {
            System.out.println("No hay autores para mostrar.");
        } else {
            System.out.println("Lista de Autores:");
            for (Autor autor : autores) {
                System.out.println(autor);
            }
        }
    }
    private void actualizarAutor() {
        mostrarAutores();
        System.out.print("Ingrese el índice del autor que desea actualizar: ");
        int indice = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea

        if (indice >= 0 && indice < autores.size()) {
            System.out.print("Ingrese el nuevo nombre del autor: ");
            String nuevoNombre = sc.nextLine();
            System.out.print("Ingrese los nuevos apellidos del autor: ");
            String nuevosApellidos = sc.nextLine();

            Autor autorActualizado = autores.get(indice);
            autorActualizado.setNombre(nuevoNombre);
            autorActualizado.setApellido(nuevosApellidos);

            System.out.println("Autor actualizado exitosamente.");
        } else {
            System.out.println("Índice no válido. No se puede actualizar el autor.");
        }
    }
    private void eliminarAutor() {
        mostrarAutores();
        System.out.print("Ingrese el índice del autor que desea eliminar: ");
        int indice = sc.nextInt();
        sc.nextLine(); // Consumir el salto de línea

        if (indice >= 0 && indice < autores.size()) {
            autores.remove(indice);
            System.out.println("Autor eliminado exitosamente.");
        } else {
            System.out.println("Índice no válido. No se puede eliminar el autor.");
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

    public String getAñoDePublicación() {
        return añoDePublicación;
    }

    public void setAñoDePublicación(String añoDePublicación) {
        this.añoDePublicación = añoDePublicación;
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

    public Documentos añadir(){boolean ok=false;
        System.out.println("Añade el titulo del documento");
        String titulo=(sc.nextLine());
        do {
            String apellidos = null;
            String nombre=null;
            if (apellidos.equals("FIN")||nombre.equals("FIN")){
                System.out.println("Añade el nombre autor/es del documento");
             nombre = sc.nextLine();


            System.out.println("Añade los apellidos del autor/es del documento");
             apellidos = sc.nextLine();
             Autor a =new Autor(nombre,apellidos);
            autores.add(a);
            ok=true;
        }}while (ok!=false);
        System.out.println("Introduce la fecha de piblicación:");
        String año=(sc.nextLine());

       do {

        ok=false;
        System.out.println("Introduce las palabras clave del documento:" );

      if (!palabrasClave.equals("FIN")) {
          palabrasClave.add(sc.nextLine());
          ok=true;
      }}while (ok!=false);
        while (!ok) {
            System.out.println("Ingrese el tipo de libro (LIBRO, REVISTA, ARTICULO, PAPER): ");
            String entrada = sc.nextLine().toUpperCase();


        }
Documentos d=new Documentos(titulo,año,tipo);


        return d;
    }
}
