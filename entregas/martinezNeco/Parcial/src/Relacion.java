package src;

public class Relacion {
    private int documentoId;
    private int escritorId;

    public Relacion(int documentoId, int escritorId) {
        this.documentoId = documentoId;
        this.escritorId = escritorId;
    }

    public int getDocumentoId() { return documentoId; }
    public int getEscritorId() { return escritorId; }
}

