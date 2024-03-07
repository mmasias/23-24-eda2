package src;

import java.util.ArrayList;
import java.util.Scanner;

public class Gestion {
    private ArrayList<Documento> documentos;
    private Scanner sc;

    public Gestion() {
        this.documentos = new ArrayList<>();
        this.sc = new Scanner(System.in);
    }

    public void añadirDocumento() {
        System.out.println("Ingrese el titulo del documento");
        String titulo = sc.nextLine();
        System.out.println("Ingrese el año de publicacion");
        int año = sc.nextInt();
        sc.nextLine();
        System.out.println("Ingrese el tipo de documento (1. LIBRO 2. REVISTA 3. ARTICULO 4. PAPEL)");
        int opcion = sc.nextInt();
        sc.nextLine();
        Tipo tipo = Tipo.values()[opcion - 1];
        ArrayList<Autor> autores = ingresarAutores();
        Documento documento = new Documento(titulo, año, autores, tipo);
        ingresarPalabrasClave(documento);
        documentos.add(documento);
    }

    private ArrayList<Autor> ingresarAutores() {
        ArrayList<Autor> autores = new ArrayList<>();
        String nombre;
        do {
            System.out.println("Nombre del autor: ");
            nombre = sc.nextLine();
            if (!nombre.equalsIgnoreCase("fin")) {
                System.out.println("Apellido del autor: ");
                String apellido = sc.nextLine();
                autores.add(new Autor(nombre, apellido));
            }
        } while (!nombre.equalsIgnoreCase("fin"));
        return autores;
    }

    private void ingresarPalabrasClave(Documento documento) {
        String palabra;
        do {
            palabra = sc.nextLine();
            if (!palabra.equalsIgnoreCase("fin")) {
                documento.añadirPalabraClave(palabra);
            }
        } while (!palabra.equalsIgnoreCase("fin"));
    }

    public void menu() {
        int opcion;
        do {
            System.out.println("1. Agregar documento");
            System.out.println("2. Modificar documento");
            System.out.println("3. Buscar por titulo");
            System.out.println("4. Buscar por autor");
            System.out.println("5. Buscar por palabra clave");
            System.out.println("6. Eliminar documento");
            System.out.println("7. Salir");
            opcion = sc.nextInt();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    añadirDocumento();
                    break;
            }
        } while (opcion != 7);
    }

    public static void main(String[] args) {
        Gestion gestion = new Gestion();
        gestion.menu();
    }
}
