package reto003;

import java.util.ArrayList;
import java.util.Scanner;

public class Biblioteca {
    private ArrayList<Documento> documentos;

    public Biblioteca() {
        this.documentos = new ArrayList<>();
    }


    public ArrayList<Documento> getDocumentos() {
        return documentos;
    }
    public void setDocumentos(ArrayList<Documento> d) {
        this.documentos = d;
    }

    public void addDocumento (Documento d) {
        documentos.add(d);
    }
    public void addDocumento() {
        Documento d = null;
        Autor a = null;
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce titulo");
        String titulo = sc.nextLine();

        System.out.println("Introduce nombre del autor");
        String nAutor = sc.nextLine();
        a = new Autor(nAutor);
        ArrayList<Autor> aut = new ArrayList<>();
        aut.add(a);

        System.out.println("Introduce año de publicacion");
        String anio = sc.nextLine();
        int an = Integer.parseInt(anio);
        
        String tipo = null;
        System.out.println("Introduce 1 si es libro, 2 revista, 3 articulo y 4 paper");
        String aux = sc.nextLine();
        int aux2 = Integer.parseInt(aux);
        switch (aux2) {
            case 1:
                tipo = "Libro";
                break;
            case 2: 
                tipo = "Revista";
                break;
            case 3:
                tipo = "Articulo";
                break;
            case 4:
                tipo = "Paper";
                break;
            default:
                break;
        }
        d = new Documento(titulo, aut, an, tipo);
        documentos.add(d);
    }

    public void editDocumento (String titulo) {
        Documento doc = null;
        ArrayList<Autor> newAutores = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        doc = buscaDocPorNombre(titulo);
        if (doc != null) {
            System.out.println("Introduce el nuevo titulo");
            String nTitulo = sc.nextLine();
            doc.setTitulo(nTitulo);
            System.out.println("Introduce el autor\n");
            String nAutor = sc.nextLine();
            Autor a = new Autor(nAutor);
            newAutores.add(a);
            doc.setAutores(newAutores);
            System.out.println("Introduce el año de publicación\n");
            String nAnio = sc.nextLine();
            int nAno = Integer.parseInt(nAnio);
            doc.setAnio(nAno);

            String tipo = null;
            System.out.println("Introduce 1 si es libro, 2 revista, 3 articulo y 4 paper");
            String aux = sc.nextLine();
            int aux2 = Integer.parseInt(aux);
            switch (aux2) {
                case 1:
                    tipo = "Libro";
                    break;
                case 2: 
                    tipo = "Revista";
                    break;
                case 3:
                    tipo = "Articulo";
                    break;
                case 4:
                    tipo = "Paper";
                    break;
                default:
                    break;
            }
            doc.setTipo(tipo);

        } else {
            System.out.println("Documento no encontrado");
        }
    }

    public void printDocumentos() {
        System.out.println(this.toString());
    }

    public void removeDocumento (Documento d) {
        documentos.remove(d);
    }
    public void removeDocumento (String titulo){
        Documento d = buscaDocPorNombre(titulo);
        removeDocumento(d);
    }
    public void removeAll () {
        this.documentos.clear();
    }

    public Documento buscaDocPorNombre(String n) {
        Documento doc = null;
        for (Documento d : documentos) {
            if (d.getTitulo().equals(n)) {
                doc = d;
            }
        }
        if (doc != null) {
            return doc;
        } else {
            return null;
        }
    }
    public Documento buscaDocPorAutor(Autor aut) {
        Documento doc = null;
        for (Documento d : documentos) {
            for (Autor a : d.getAutores()) {
                if (a.equals(aut)) {
                    doc = d;
                }
            }
        }
        if (doc != null) {
            return doc;
        } else {
            return null;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Documento d : documentos) {
            sb.append(d.toString());
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Biblioteca central = new Biblioteca();
        Autor a = new Autor("Julio Iglesias");
        ArrayList<Autor> autores = new ArrayList<>();
        autores.add(a);
        Documento d1 = new Documento("Los changuis", autores, 2011, "Revista");
        Autor a2 = new Autor("Arturo Pérez Reverte");
        ArrayList<Autor> autores2 = new ArrayList<>();
        autores2.add(a2);
        Documento d2 = new Documento("Una Historia de España", autores2, 2019, "Libro");
        Documento d3 = new Documento("El problema final", autores2, 2023, "Libro");
        central.addDocumento(d1);
        central.printDocumentos();
        System.out.println("Los changuis añadido\n");
        central.addDocumento(d2);
        central.printDocumentos();
        System.out.println("Una historia de España añadido\n");
        central.addDocumento(d3);
        central.printDocumentos();
        System.out.println("El problema final añadido\n");
        central.addDocumento();
        central.printDocumentos();
        System.out.println("Documento añadido por consola\n");
        central.removeDocumento("Los changuis");
        central.printDocumentos();
        System.out.println("Los changuis eliminado\n");
        central.editDocumento("Una historia de España");
        central.printDocumentos();
        System.out.println("Una historia de España editado");
        central.removeDocumento(d3);
        central.printDocumentos();
        System.out.println("El problema final eliminado\n");
        central.removeAll();
        central.printDocumentos();
        System.out.println("Todos los libros eliminados\n");

    }


}
