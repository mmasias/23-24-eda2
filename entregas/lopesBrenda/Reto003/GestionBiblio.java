package entregas.lopesBrenda.Reto003;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class GestionBiblio {
    private ArrayList<Documento> documentos;
    private Scanner scanner;

    public GestionBiblio() {
        this.documentos = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }
    public void menu() {
        Scanner scanner = new Scanner(System.in);
        String opcion;
        do {
            System.out.println("===============================");
            System.out.println("1. Agregar documentos");
            System.out.println("2. Listar documentos");
            System.out.println("3. Eliminar documentos");
            System.out.println("4. Editar documentos");
            System.out.println("5. Salir");
            System.out.println("Elige una opción: ");
            System.out.println("===============================");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    addDocumento();
                    break;
                case "2":
                    printDocumentos();
                    break;
                case "3":
                    printDocumentos();
                    eliminaDocumento();
                    break;
                case "4":
                    printDocumentos();
                    editaDocumento();
                    break;
            }
        } while (!opcion.equals("5"));
    }

    private void addDocumento() {
        System.out.println("Introduce el título del libro:");
        String titulo = scanner.nextLine();
        System.out.println("Introduce el tipo del documento:");
        String categoria = scanner.nextLine();
        System.out.println("Introduce el autor del documento:");
        String autor = scanner.nextLine();
        System.out.println("Introduce el año de libro:");
        int año = scanner.nextInt();
        scanner.nextLine();

        Documento nuevoDocumento = new Documento(titulo, categoria, autor, año);
        documentos.add(nuevoDocumento);
    }

    public void printDocumentos() {
            System.out.println("Documentos en la biblioteca:");
                for (Documento documento : documentos) {
                    System.out.println(documento);
            }
    }

    private void eliminaDocumento() {
        System.out.print("Introduce el titulo del documento que deseas eliminar: ");
        String titulo = scanner.nextLine();
        documentos.removeIf(documentos -> documentos.getName().equals(titulo));
    }

    public void editaDocumento() {
        System.out.println("===============================");
        System.out.print("Introduce el titulo del documento que deseas actualizar: ");
        String titulo = scanner.nextLine();
        for (Documento documento : documentos) {
            if (documento.getName().equals(titulo)) {
                Scanner scanner = new Scanner(System.in);
                String opcion;
                System.out.println("===============================");
                System.out.println("Que deseas cambiar: ");
                System.out.println("1. Titulo");
                System.out.println("2. Categoria");
                System.out.println("3. Autor");
                System.out.println("4. Año");
                System.out.println("5. Volver al menu");
                System.out.println("===============================");
                opcion = scanner.nextLine();
    
                switch (opcion) {
                    case "1":
                        System.out.print("Introduce el nuevo titulo: ");
                        String nuevoTitulo = scanner.nextLine();
                        documento.setName(nuevoTitulo);
                        break;
                    case "2":
                        System.out.print("Introduce la nueva categoria: ");
                        String nuevaCategoria = scanner.nextLine();
                        documento.setCategoria(nuevaCategoria);
                        break;
                    case "3":
                        System.out.print("Introduce el nombre del nuevo autor: ");
                        String nuevoAutor = scanner.nextLine();
                        documento.setAutor(nuevoAutor);
                        break;
                    case "4":
                        System.out.print("Introduce el nuevo año: ");
                        int nuevoAño = scanner.nextInt();
                        scanner.nextLine();
                        documento.setAño(nuevoAño);
                        break;
                }
                break;
            }
        }
    }
    
    public static void main(String[] args) {
        new GestionBiblio().menu();
    }
}
