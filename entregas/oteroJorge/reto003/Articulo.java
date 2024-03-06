package entregas.oteroJorge.reto003;

import java.util.ArrayList;

public class Articulo extends Documento{
    private String periodico;

    public Articulo(String titulo,ArrayList<Autor> autores, String periodico, String añoPublicacion, String tipo) {
        super(titulo,autores, añoPublicacion, tipo);
        this.periodico = periodico;
    }

    @Override
    public String toString(){
        return "> " + this.getTipo() + " -> " + this.getTitulo() + " -> " + this.getAutoresAsString() + "> " + this.getAñoPublicacion() + " -> " + this.periodico;
    }

    public static void main(String[] args) {
        ArrayList<Autor> autores = new ArrayList<>();
        autores.add(new Autor("Melendi Oficial"));
        autores.add(new Autor("Antonio Orozco"));

        Articulo articulo = new Articulo("La vida es bella", autores, "El País", "2021", "Artículo");
        articulo.printDocumento();
    }
    
}