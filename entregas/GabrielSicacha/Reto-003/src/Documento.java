import java.time.Year;
import java.util.ArrayList;

public class Documento {
    private String titulo;
    private ArrayList<String> autores;
    private Year publicacion;
    private String tipoDocumento;
    private ArrayList<String> palabrasClave;

    public Documento(String titulo, ArrayList<String> autores, Year publicacion, String tipoDocumento, ArrayList<String> palabrasClave) {
        this.titulo = titulo;
        this.autores = autores;
        this.publicacion = publicacion;
        this.tipoDocumento = tipoDocumento;
        this.palabrasClave = palabrasClave;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public ArrayList<String> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<String> autores) {
        this.autores = autores;
    }

    public Year getPublicacion() {
        return publicacion;
    }

    public void setPublicacion(Year publicacion) {
        this.publicacion = publicacion;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public ArrayList<String> getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(ArrayList<String> palabrasClave) {
        this.palabrasClave = palabrasClave;
    }

    public void imprimirDetalleDocumento(){
        System.out.println("-------------------------------------------------------------");
        System.out.println("Titulo: "+ titulo);
        System.out.println("Autores: " + autores);
        System.out.println("año de Publicacion: " + publicacion);
        System.out.println("Tipo de documento: " + tipoDocumento);
        System.out.println("Palabras claves: " + palabrasClave);
        System.out.println("-------------------------------------------------------------");
    }
}
