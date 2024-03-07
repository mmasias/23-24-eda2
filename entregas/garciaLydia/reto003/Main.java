package entregas.garciaLydia.reto003;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        BibliotecaDigital biblioteca = new BibliotecaDigital();


        Documento libro1 = new Documento("Introducción a Java", List.of("John Smith", "Emily Brown"), 2020, "Libro", List.of("Java", "Programación"));
        Documento articulo1 = new Documento("Artículo sobre IA", List.of("Alice Johnson"), 2019, "Artículo", List.of("Inteligencia Artificial", "Machine Learning"));
        Documento revista1 = new Documento("Revista de Tecnología", List.of("Robert Davis"), 2021, "Revista", List.of("Tecnología", "Innovación"));


        biblioteca.agregarDocumento(libro1);
        biblioteca.agregarDocumento(articulo1);
        biblioteca.agregarDocumento(revista1);


        List<Documento> resultados = biblioteca.buscarPorTitulo("Java");
        System.out.println("Documentos encontrados por título:");
        for (Documento documento : resultados) {
            System.out.println(documento.getTitulo());
        }


        resultados = biblioteca.buscarPorAutor("Alice Johnson");
        System.out.println("\nDocumentos encontrados por autor:");
        for (Documento documento : resultados) {
            System.out.println(documento.getTitulo());
        }

        
        resultados = biblioteca.buscarPorPalabrasClave("Tecnología");
        System.out.println("\nDocumentos encontrados por palabras clave:");
        for (Documento documento : resultados) {
            System.out.println(documento.getTitulo());
        }
    }
}