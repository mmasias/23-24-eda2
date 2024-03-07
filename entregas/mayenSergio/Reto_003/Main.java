package entregas.mayenSergio.Reto_003;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Documento> documentos = GeneradorDocumentos.generarDocumentos();
        Menu.mostrarMenu(documentos);
    }
}
