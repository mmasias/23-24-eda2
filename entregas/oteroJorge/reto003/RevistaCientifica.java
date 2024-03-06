package entregas.oteroJorge.reto003;

import java.util.ArrayList;

public class RevistaCientifica extends Documento{

    private String ambito;

    public RevistaCientifica(String titulo,  ArrayList<Autor> autores, String ambito, String añoPublicacion, String tipo) {
        super(titulo,autores, añoPublicacion, tipo);
        this.ambito = ambito;
    }


}
