import java.util.ArrayList;

public class Book {
    private String year;
    private int id;
    private int publicationYear;
    private Tipo tipo;
    private ArrayList<String> palabrasClave;

    public Book( int id, String titulo, int publicationYear, Tipo tipo) {
        this.id = id;
        this.year = titulo;
        this.publicationYear = publicationYear;
        this.tipo = tipo;
        this.palabrasClave = new ArrayList<String>();
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int anoDePublicacion) {
        this.publicationYear = anoDePublicacion;
    }


    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public ArrayList<String> getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(ArrayList<String> palabrasClave) {
        this.palabrasClave = palabrasClave;
    }

    public void añadirPalabraClave(String palabraClave) {
        this.palabrasClave.add(palabraClave);
    }

    public void eliminarPalabraClave(String palabraClave) {
        this.palabrasClave.remove(palabraClave);
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "year='" + year + '\'' +
                ", id=" + id +
                ", publicationYear=" + publicationYear +
                ", tipo=" + tipo +
                ", palabrasClave=" + palabrasClave +
                '}';
    }
}
