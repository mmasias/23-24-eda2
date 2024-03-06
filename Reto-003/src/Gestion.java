import java.util.ArrayList;
import java.util.Scanner;

public class Gestion {
    private ArrayList<Documentos> documentos;

    public Gestion() {
        documentos = new ArrayList<>();
    }

    public void agregar() {
        Documentos d = null;
        documentos.addLast(d.añadir());
    }

    public void editar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el titulo del documento que quieres actualizar los datos:");
        String titulo = sc.nextLine();
        for (int i = 0; i < documentos.size(); i++) {

            boolean ok = false;
            do {
                int n = documentos.indexOf(titulo);
                System.out.println("Introduce de nuevo la fecha de publicación:");
                String año = sc.nextLine();
                System.out.println("Introduce de nuevo el tipo de documento:");
                String tipo = sc.nextLine();
                Documentos d = new Documentos(titulo, año, tipo);

                documentos.set(n, d);
                ok = true;
            } while (!ok);

        }
    }

    public void eliminar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresa el titulo del documento que desea eliminar:");
        String titulo = sc.nextLine();
        for (int i = 0; i < documentos.size(); i++) {
            int n = documentos.indexOf(titulo);
            documentos.remove(n);
        }


        Documentos d = null;
        d.getTitulo().equals(titulo);

    }

    @Override
    public String toString() {
        return "Gestion{" +
                "documentos=" + documentos +
                '}';
    }

    public static void main(String[] args) {
        Gestion g = null;
        g.agregar();
        g.toString();
        g.editar();
        g.toString();
        g.eliminar();
        g.toString();

    }
}



