package classes;

import java.util.ArrayList;

public class Documento {
    private String titulo;
    private int año;
    private ArrayList<Autor> autores;
    private ArrayList<String> palabrasClave;
    private Tipo tipo;

    public Documento(String titulo, int año, ArrayList<Autor> autores, ArrayList<String> palabrasClave, Tipo tipo) {
        this.titulo = titulo;
        this.año = año;
        this.autores = autores;
        this.palabrasClave = palabrasClave;
        this.tipo = tipo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public ArrayList<Autor> getAutores() {
        return autores;
    }

    public void setAutores(ArrayList<Autor> autores) {
        this.autores = autores;
    }

    public ArrayList<String> getPalabrasClave() {
        return palabrasClave;
    }

    public void setPalabrasClave(ArrayList<String> palabrasClave) {
        this.palabrasClave = palabrasClave;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public void agregarAutor(Autor autor) {
        this.autores.add(autor);
    }

    public void agregarPalabrasClave(String palabra) {
        this.palabrasClave.add(palabra);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("-------------------------\n");
        sb.append("Título: ").append(titulo).append("\n");
        sb.append("Año: ").append(año).append("\n");
        sb.append("Autores: ");
        for (int i = 0; i < autores.size(); i++) {
            Autor autor = autores.get(i);
            sb.append(autor.getNombre()).append(" ").append(autor.getApellido());
            if (i < autores.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append("\nPalabras Clave: ").append(palabrasClave.toString()).append("\n");
        sb.append("Tipo: ").append(tipo);
        return sb.toString();
    }

}
