package src;

public class Ejecutable {
    public static void main(String[] args) {
        ManagerBiblioteca biblioteca = new ManagerBiblioteca();
        biblioteca.cargarDatos();
        biblioteca.menu();
    }


}


