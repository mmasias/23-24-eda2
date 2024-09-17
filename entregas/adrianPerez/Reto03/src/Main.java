import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(new ArrayList<Documento>());
        biblioteca.menu();
    }
}