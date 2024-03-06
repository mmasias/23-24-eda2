package entregas.oteroJorge.reto003;

import java.util.ArrayList;

public class Articulo extends Documento{
    private String periodico;

    public Articulo(String titulo,ArrayList<Autor> autores, String periodico, String añoPublicacion, String tipo) {
        super(titulo,autores, añoPublicacion, tipo);
        this.periodico = periodico;
    }


    
}