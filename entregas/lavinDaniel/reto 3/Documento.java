import java.util.List;

class Documento{
    String titulo;
    List<String> autores;
    int añoPublicacion;
    String tipoDocumento;
    List<String> palabrasClave;

public Documento(String titulo, List<String> autores, int añoPublicacion, String tipoDocumento, List<String> palabrasClave){
        this.titulo = titulo;
        this.autores = autores;
        this.añoPublicacion = añoPublicacion;
        this.tipoDocumento = tipoDocumento;
        this.palabrasClave = palabrasClave;
    }

}