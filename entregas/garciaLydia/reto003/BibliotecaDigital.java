package entregas.garciaLydia.reto003;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaDigital {
    private List<Documento> documentos;


    public BibliotecaDigital() {
        documentos = new ArrayList<>();
    }


    public void agregarDocumento(Documento documento) {
        documentos.add(documento);
    }


    public void eliminarDocumento(Documento documento) {
        documentos.remove(documento);
    }


    public List<Documento> buscarPorTitulo(String titulo) {
        List<Documento> resultados = new ArrayList<>();
        for (Documento documento : documentos) {
            if (documento.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                resultados.add(documento);
            }
        }
        return resultados;
    }


    public List<Documento> buscarPorAutor(String autor) {
        List<Documento> resultados = new ArrayList<>();
        for (Documento documento : documentos) {
            for (String nombreAutor : documento.getAutores()) {
                if (nombreAutor.toLowerCase().contains(autor.toLowerCase())) {
                    resultados.add(documento);
                    break;
                }
            }
        }
        return resultados;
    }


    public List<Documento> buscarPorAnoPublicacion(int ano) {
        List<Documento> resultados = new ArrayList<>();
        for (Documento documento : documentos) {
            if (documento.getAnoPublicacion() == ano) {
                resultados.add(documento);
            }
        }
        return resultados;
    }

    public List<Documento> buscarPorTipoDocumento(String tipoDocumento) {
        List<Documento> resultados = new ArrayList<>();
        for (Documento documento : documentos) {
            if (documento.getTipoDocumento().equalsIgnoreCase(tipoDocumento)) {
                resultados.add(documento);
            }
        }
        return resultados;
    }


    public List<Documento> buscarPorPalabrasClave(String palabraClave) {
        List<Documento> resultados = new ArrayList<>();
        for (Documento documento : documentos) {
            for (String palabra : documento.getPalabrasClave()) {
                if (palabra.toLowerCase().contains(palabraClave.toLowerCase())) {
                    resultados.add(documento);
                    break;
                }
            }
        }
        return resultados;
    }
}

