import java.time.LocalDate;

public class Prestamo {
    private Documento documento;
    private LocalDate fechaDevolucion;

    public Prestamo(Documento documento, LocalDate fechaDevolucion) {
        this.documento = documento;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Documento getDocumento() {
        return documento;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }
}
