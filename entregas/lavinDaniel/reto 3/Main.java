public class Main {
    public static void main(String[] args) {
        BibliotecaDigital biblioteca = new BibliotecaDigital();

        Documento libro1 = new Documento("Introducción a Java", List.of("Autor1", "Autor2"), 2020, "Libro", List.of("Java", "Programación"));
        Documento articulo1 = new Documento("Principios de la inteligencia artificial", List.of("Autor3"), 2022, "Artículo", List.of("IA", "Machine Learning"));
        biblioteca.agregarDocumento(libro1);
        biblioteca.agregarDocumento(articulo1);

        List<Documento> resultadosTitulo = biblioteca.buscarDocumentos("titulo", "Java");
        System.out.println("Resultados de la búsqueda por título: " + resultadosTitulo);

        List<Documento> resultadosAutor = biblioteca.buscarDocumentos("autor", "Autor1");
        System.out.println("Resultados de la búsqueda por autor: " + resultadosAutor);

    }
}