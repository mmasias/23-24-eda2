package entregas.DiegoBarraza.reto003;

import java.util.List;

class Paper extends Documento {
    private String conferencia;

    public Paper(String titulo, List<String> autores, int añoPublicacion, String tipoDocumento, List<String> palabrasClave, String conferencia) {
        super(titulo, autores, añoPublicacion, tipoDocumento, palabrasClave);
        this.conferencia = conferencia;
    }

    public String getConferencia() {
        return conferencia;
    }
}