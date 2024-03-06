package entregas.oteroJorge.reto003;

import java.util.ArrayList;

public class Libro extends Documento{

    private String tema;

    public Libro(String titulo, ArrayList<Autor> autores, String añoPublicacion, String tipo, String tema) {
        super(titulo, autores, añoPublicacion, tipo);
        this.tema = tema;

    }

    @Override
    public String toString(){
        return "> " + this.getTipo() + " -> " + this.getTitulo() + " -> " + this.getAutoresAsString() + "> " + this.getAñoPublicacion() + " -> " + this.tema;
    }

    public static void main(String[] args) {
        ArrayList<Autor> autores = new ArrayList<>();
        autores.add(new Autor("Melendi Oficial"));
        autores.add(new Autor("Antonio Orozco"));

        Libro libro = new Libro("La vida es bella", autores, "2021", "Libro", "Autoayuda");
        libro.printDocumento();
    }
}
