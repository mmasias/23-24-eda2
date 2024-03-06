package Factory;
import java.util.ArrayList;
import java.util.Scanner;


import Model.*;

public class DocumentoController {
    private Document documentoACrear;
    Scanner userInput = new Scanner(System.in);

    public DocumentoController() {

    }

    public Document creaDocumento(String tipoDocumento) {
        int countAutores = 0;
        int countPalabras = 0;
        ArrayList<Author> autores = new ArrayList<>();
        ArrayList<String> palabrasClave = new ArrayList<>();

        System.out.println("Introduce el nombre del documento: ");
        String nombreDoc = userInput.nextLine();

        System.out.println("Introduce la cantidad de autores del documento: ");
        int numAutores = userInput.nextInt();

        while (countAutores != numAutores) {
            System.out.println("Introduce el nombre del autor: ");
            String nombreAutor = userInput.nextLine();

            System.out.println("Introduce los apellidos del autor: ");
            String apellidosAutor = userInput.nextLine();

            Author autor = new Author(nombreAutor, apellidosAutor);
            autores.add(autor);
            countAutores++;
        }

        System.out.println("Introduce el año de publicación del documento: ");
        int anhoPublicacion = userInput.nextInt();

        System.out.println("Introduce el número de temas/palabras clave del documento: ");
        int numPalabras = userInput.nextInt();

        while (countPalabras != numPalabras) {
            System.out.println("Introduce el el tema/palabra clave");
            String palabraClave = userInput.nextLine();
            palabrasClave.add(palabraClave);

            countPalabras++;

        }

        switch(tipoDocumento) {
            case "Artículo":
                documentoACrear = new Article(nombreDoc, autores, anhoPublicacion, tipoDocumento, palabrasClave);
                break;
            case "Libro":
                documentoACrear = new Book(nombreDoc, autores, anhoPublicacion, tipoDocumento, palabrasClave);
                break;
            case "Paper Científico":
                documentoACrear = new CientificPaper(nombreDoc, autores, anhoPublicacion, tipoDocumento, palabrasClave);
                break;
            case "Revista":
                documentoACrear = new Magazine(nombreDoc, autores, anhoPublicacion, tipoDocumento, palabrasClave);
        }
        return documentoACrear;

    }

   

}
