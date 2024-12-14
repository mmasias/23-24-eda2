import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nombre;
    private List<Prestamo> prestamos;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.prestamos = new ArrayList<>();
    }

    public void agregarPrestamo(Documento documento, LocalDate fechaDevolucion) {
        prestamos.add(new Prestamo(documento, fechaDevolucion));
    }

    public boolean devolverDocumento(Documento documento) {
        return prestamos.removeIf(prestamo -> prestamo.getDocumento().equals(documento));
    }

    public List<Prestamo> getPrestamos() {
        return prestamos;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}