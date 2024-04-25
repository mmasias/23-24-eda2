import java.util.ArrayList;

public class Documento {
    private String titulo;
    private int añoDePublicacion;
    private ArrayList<Autor> autores;
    private TipoDoc tipo;
    private ArrayList<String> palabrasClave;

    public Documento(String titulo, int añoDePublicacion, ArrayList<Autor> autores, TipoDoc tipo ) {
        this.titulo = titulo;
        this.añoDePublicacion = añoDePublicacion;
        this.autores = autores;
        this.tipo = tipo;
        this.palabrasClave = new ArrayList<String>();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAñoDePublicacion() {
        return añoDePublicacion;
    }

    public void setAñoDePublicacion(int añoDePublicacion) {
        this.añoDePublicacion = añoDePublicacion;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }

    public TipoDoc getTipo() {
        return tipo;
    }

    public void setTipo(TipoDoc tipo) {
        this.tipo = tipo;
    }

    public ArrayList<String> getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(ArrayList<String> palabrasClave) {
        this.palabrasClave = palabrasClave;
    }

    public void añadirAutor(Autor autor){
        this.autores.add(autor);
    }

    public  void añadirPalabraClave(String palabraClave){
        this.palabrasClave.add(palabraClave);
    }

    public void eliminarAutor(Autor autor){
        this.autores.remove(autor);
    }

    public void eliminarPalabraClave(String palabraClave){
        this.palabrasClave.remove(palabraClave);
    }

}