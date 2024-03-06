import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BibliotecaDigital {
    private List<Documento> documentos;

    public BibliotecaDigital() {
        this.documentos = new ArrayList<>();
    }

    public void agregarDocumento(Documento documento) {
        documentos.add(documento);
    }

    public boolean eliminarDocumento(String titulo) {
        return documentos.removeIf(doc -> doc.getTitulo().equalsIgnoreCase(titulo));
    }

    public List<Documento> getDocumentos() {
        return this.documentos;
    }

    public void editarDocumento(String titulo, Documento nuevoDocumento) {
        for (int i = 0; i < documentos.size(); i++) {
            if (documentos.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                documentos.set(i, nuevoDocumento);
                break;
            }
        }
    }

    public List<Documento> buscarPorCriterio(String criterio, String valor) {

        if ("titulo".equalsIgnoreCase(criterio)) {
            return documentos.stream()
                    .filter(doc -> doc.getTitulo().equalsIgnoreCase(valor))
                    .collect(Collectors.toList());
        }

        return new ArrayList<>();
    }

    public List<Documento> clasificarPorTipo(String tipo) {
        return documentos.stream()
                .filter(doc -> doc.getTipo().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }

}
