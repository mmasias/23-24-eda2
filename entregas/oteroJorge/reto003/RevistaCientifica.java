package entregas.oteroJorge.reto003;

import java.util.ArrayList;

public class RevistaCientifica extends Documento{

    private String ambito;

    public RevistaCientifica(String titulo,  ArrayList<Autor> autores, String ambito, String añoPublicacion, String tipo) {
        super(titulo,autores, añoPublicacion, tipo);
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

        RevistaCientifica revistaCientifica = new RevistaCientifica("La vida es bella", autores, "Biología", "2021", "Revista Científica");
        revistaCientifica.printDocumento();
    }


}
