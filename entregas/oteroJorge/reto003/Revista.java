package entregas.oteroJorge.reto003;

import java.util.ArrayList;

public class Revista extends Documento{

    private String ambito;

    public Revista(String titulo, ArrayList<Autor> autores, String ambito, String añoPublicacion, String tipo) {
        super(titulo, autores, añoPublicacion, tipo);
        this.ambito = ambito;
    }

    @Override
    public String toString(){
        return "> " + this.getTipo() + " -> " + this.getTitulo() + " -> " + this.getAutoresAsString() + "> " + this.getAñoPublicacion() + " -> " + this.ambito;
    }

    public static void main(String[] args) {
        ArrayList<Autor> autores = new ArrayList<>();
        autores.add(new Autor("Melendi Oficial"));
        autores.add(new Autor("Antonio Orozco"));

        Revista revista = new Revista("La vida es bella", autores, "Autoayuda", "2021", "Revista");
        revista.printDocumento();
    }


}
