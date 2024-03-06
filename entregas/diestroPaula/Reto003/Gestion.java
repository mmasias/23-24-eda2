package entregas.diestroPaula.Reto003;

import java.util.ArrayList;
import java.util.Scanner;

public class Gestion {
    private ArrayList<Documento> documentos;

    public Gestion() {
        documentos = new ArrayList<>();
    }

    public void agregar() {
        Documento d = new Documento(null, null, null, null, null);
        documentos.addLast(d.añadir());
    }

    public void editar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introducezca el titulo del documento que quiera actualizar los datos: ");
        String titulo = sc.nextLine();
        for (int i = 0; i < documentos.size(); i++) {

            boolean editando = false;
            do {
                int n = documentos.indexOf(titulo);
                System.out.println("Introduzca de nuevo la fecha de publicación: ");
                String año = sc.nextLine();
                System.out.println("Introduzca de nuevo el tipo de documento: ");
                String tipo = sc.nextLine();
                Documento d = new Documento(titulo, null, año, null, tipo);

                documentos.set(n, d);
                editando = true;
            } while (!editando);

        }
    }

    public void eliminar() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el titulo del documento que desea eliminar: ");
        String titulo = sc.nextLine();
        for (int i = 0; i < documentos.size(); i++) {
            int n = documentos.indexOf(titulo);
            documentos.remove(n);
        }

        Documento d = null;
        d.getTitulo().equals(titulo);

    }

    @Override
    public String toString() {
        return "Gestion{" +
                "documentos=" + documentos +
                '}';
    }

    public static void main(String[] args) {
        Gestion g = new Gestion();
        g.agregar();
        g.toString();
        g.editar();
        g.toString();
        g.eliminar();
        g.toString();

    }
}