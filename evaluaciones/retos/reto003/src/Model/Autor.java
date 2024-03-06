package Model;
public class Autor {
    private String nombre;
    private String apellidos;

    public Autor(String nombre, String apellidos){
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setNombre(String nombreAutor) {
        nombre = nombreAutor;
    }

    public void setApellidos(String apellidosAutor) {
        apellidos = apellidosAutor;
    }

}
