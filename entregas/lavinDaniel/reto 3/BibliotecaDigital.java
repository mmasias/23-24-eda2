import java.util.ArrayList;
import java.util.List;

public class BibliotecaDigital {
    List<Documento> documentos;
    public BibliotecaDigital(){
        this.documentos=new ArrayList<>();
    }
    public void agregarDocumento(Documento documento){
        documentos.add(documento);
    }
    public List<Documento> buscarDocumentos(String criterio, String valor){
        List<Documento> resultados = new ArrayList<>();
        for (Documento documento : documentos ){
            switch (criterio.toLowerCase()){
                case "titulo":
                    if (documento.titulo.toLowerCase().contains(valor.toLowerCase())){
                        resultados.add(documento);
                    }
                    break;
                case "autor":
                    if (documento.autores.stream().anyMatch(autor -> autor.toLowerCase().contains(valor.toLowerCase()))){
                        resultados.add(documento);
                    }
                    break;
                case "año":
                    if (String.valueOf(documento.añoPublicacion).contains(valor)){
                        resultados.add(documento);
                    }
                    break;
                case "tipo":
                    if (documento.tipoDocumento.toLowerCase().contains(valor.toLowerCase())){
                        resultados.add(documento);
                    }
                    break;
                case "palabra clave":
                    if (documento.palabrasClave.stream().anyMatch(palabra -> palabra.toLowerCase().contains(valor.toLowerCase()))){
                        resultados.add(documento);
                    }
                    break;
                default:
                    System.out.println("Criterio no válido");
                    break;

            }
        }
        return resultados;
    }
    public void listarDocumentos(){
        for (Documento documento : documentos) {
            System.out.println("-------------------------------");
            System.out.println("Título: " + documento.titulo);
            System.out.println("Autores: " + String.join(", ", documento.autores));
            System.out.println("Año de Publicación: " + documento.añoPublicacion);
            System.out.println("Tipo de Documento: " + documento.tipoDocumento);
            System.out.println("Palabras Clave: " + String.join(", ", documento.palabrasClave));
            System.out.println("-------------------------------");
        }
    }
}