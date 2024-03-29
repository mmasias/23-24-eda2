import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Biblioteca biblioteca = new Biblioteca();


        biblioteca.anadirDocumento(new Documento("Horus, Señor de la guerra", new ArrayList<>(Arrays.asList("Dan Abnett")), Year.parse("2006"), "novela", new ArrayList<>(Arrays.asList("Fantasia oscura", "Ciencia ficcion"))));
        biblioteca.anadirDocumento(new Documento("MEDICIÓN DE PROTEÍNAS CON EL REACTIVO FOLIN PHENOL", new ArrayList<>(Arrays.asList("OLIVER H. LOWRY", "NIRA J. ROSEBROUGH", "A. LEWIS FARR",
                "ROSE J. RANDALL ")), Year.parse("1951"), "texto cientifico", new ArrayList<>(Arrays.asList("Ciencia", "ADN", "medicion"))));
        biblioteca.accederGestionador();
    }
}