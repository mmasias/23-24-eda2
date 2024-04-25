package antonioGavilanes.reto003;

import java.util.ArrayList;

public class TipoDocumento {
    ArrayList<String> tipoDoc = new ArrayList<String>();

    public void add() {
        tipoDoc.add("libro");
        tipoDoc.add("revista");
        tipoDoc.add("articulo");
        tipoDoc.add("papel cientifico");
    }

    public void mostrar() {
        for (String i : tipoDoc) {
            System.out.print(" - " + i);
        }
        System.out.println();
    }

    public String mostrar(int i) {
        return tipoDoc.get(i);
    }

    public int size() {
        return tipoDoc.size();
    }


}
