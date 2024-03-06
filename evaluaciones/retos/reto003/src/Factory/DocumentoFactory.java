package Factory;
import java.util.Scanner;

import Model.Documento;

public class DocumentoFactory {
    private Documento documentoACrear;
    Scanner userInput = new Scanner(System.in);

    public DocumentoFactory() {

    }

    public void creaDocumento() {
        System.out.println("Introduce el nombre del documento: ");
        String nombre = userInput.nextLine();

        
    }

}
