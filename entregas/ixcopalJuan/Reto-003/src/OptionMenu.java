public class OptionMenu {
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RESET = "\u001B[0m";
    public void menu1() {
        System.out.println("1 - Ver categorias");
        System.out.println("2 - Agregar documento");
        System.out.println("3 - Buscar documento por el titulo");
        System.out.println("4 - Ver autores");
        System.out.println("5 - Eliminar un documento");
        System.out.println("6 - Listar documentos existentes");
        System.out.println("7 - Salir del programa");
        System.out.print("Ingrese su opción: ");
    }

    public void division(){
        System.out.println(ANSI_GREEN + "+-----------------------------------------------------------+" + ANSI_RESET);
    }
}
