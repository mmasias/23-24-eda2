package entregas.DiegoBarraza.reto003;

import java.util.ArrayList;
import java.util.List;
class GestionDocumentos {
    private List<Documento> documentos;

    public GestionDocumentos() {
        this.documentos = new ArrayList<>();
    }

    
    public void agregarDocumento(Documento documento) {
        documentos.add(documento);
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
            for (String autorDocumento : documento.getAutores()) {
                if (autorDocumento.toLowerCase().contains(autor.toLowerCase())) {
                    resultados.add(documento);
                    break;
                }
            }
        }
        return resultados;
    }
    public List<Documento> buscarPorAño(int año) {
        List<Documento> resultados = new ArrayList<>();
        for (Documento documento : documentos) {
            if (documento.getAñoPublicacion() == año) {
                resultados.add(documento);
            }
        }
        return resultados;
    }
    public List<Documento> buscarPorTipo(String tipo) {
        List<Documento> resultados = new ArrayList<>();
        for (Documento documento : documentos) {
            if (documento.getTipoDocumento().toLowerCase().contains(tipo.toLowerCase())) {
                resultados.add(documento);
            }
        }
        return resultados;
    }
    public List<Documento> buscarPorPalabraClave(String palabraClave) {
        List<Documento> resultados = new ArrayList<>();
        for (Documento documento : documentos) {
            for (String palabraClaveDocumento : documento.getPalabrasClave()) {
                if (palabraClaveDocumento.toLowerCase().contains(palabraClave.toLowerCase())) {
                    resultados.add(documento);
                    break;
                }
            }
        }
        return resultados;
    }
    public boolean eliminarDocumento(String titulo) {
        for (Documento documento : documentos) {
            if (documento.getTitulo().equalsIgnoreCase(titulo)) {
                documentos.remove(documento);
                return true; 
            }
        }
        return false; 
    }
    public boolean editarDocumento(String titulo, Documento nuevoDocumento) {
        for (int i = 0; i < documentos.size(); i++) {
            Documento documento = documentos.get(i);
            if (documento.getTitulo().equalsIgnoreCase(titulo)) {
                documentos.set(i, nuevoDocumento);
                return true; 
            }
        }
        return false; 
    }
    public void mostrarDocumentos() {
        for (Documento documento : documentos) {
            System.out.println(documento);
        }
    }
}