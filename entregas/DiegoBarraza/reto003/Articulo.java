package entregas.DiegoBarraza.reto003;

import java.util.List;

public class Articulo extends Documento{
private String revista;

public Articulo(String titulo,List<String> autores, int añoPublicacion,String tipoDocumento, List<String> palabrasClave,String revista){
super(titulo, autores, añoPublicacion, tipoDocumento, palabrasClave);
this.revista = revista;
        
}
public String getRevista() {
return revista;
}

}