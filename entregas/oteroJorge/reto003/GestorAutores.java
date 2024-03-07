package entregas.oteroJorge.reto003;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorAutores {

    private ArrayList<Autor> autores;

    public GestorAutores() {
        this.autores = new ArrayList<>();
    }

    public ArrayList<Autor> getAutores(){
        return this.autores;
    }

    public void agregarAutor(int id, String nombreCompleto){
        Autor autor = new Autor(id, nombreCompleto);
        this.autores.add(autor);
    }

    public void editarAutor(String nombreViejo){
        Autor autor = null;
        for (Autor aut : autores) {
            if (aut.getNombreCompleto().equals(nombreViejo)) {
                autor = aut;
                break;
            }
        }
        if (autor != null) {
            System.out.println("Introduce el nuevo nombre del autor");
            String nuevoNombre = System.console().readLine();
            autor.setNombreCompleto(nuevoNombre);
        } else {
            System.out.println("El autor no existe");
        }
    }
    
    public void eliminarAutor(String nombre){
        Autor autor = null;
        for (Autor aut : autores) {
            if (aut.getNombreCompleto().equals(nombre)) {
                autor = aut;
                break;
            }
        }
        if (autor != null) {
            autores.remove(autor);
        } else {
            System.out.println("El autor no existe");
        }
    }

    public void agregarAutor(Autor autor){
        this.autores.add(autor);
    }
    
    public void listarAutores(){
        System.out.println("Autores:");
        for (Autor autor : autores) {
            System.out.println(autor.getId() + " - " + autor.getNombreCompleto());
        }
    }

    public String listarEsteAutor(ArrayList<Integer> idAutores){
        String autores = "";
        for (int id : idAutores) {
            for (Autor autor : this.autores) {
                if (autor.getId() == id) {
                    autores += autor.getNombreCompleto() + ", ";
                }
            }
        }
        return autores;
    }

    public boolean existeAutor(int id){
        for (Autor autor : autores) {
            if (autor.getId() == id) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        GestorAutores gestorAutores = new GestorAutores();
        Autor autor1 = new Autor(1, "J.R.R. Tolkien");
        Autor autor2 = new Autor(2, "Isaac Asimov");
        Autor autor3 = new Autor(3, "Jorge");

        gestorAutores.agregarAutor(autor1);
        gestorAutores.agregarAutor(autor2);
        gestorAutores.agregarAutor(autor3);

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre del autor a editar");
        String nombre = sc.nextLine();
        gestorAutores.editarAutor(nombre);
        gestorAutores.listarAutores();
    }
}
