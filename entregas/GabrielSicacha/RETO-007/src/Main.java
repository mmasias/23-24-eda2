public class Main {
    public static void main(String[] args) {
        boolean usando = true;
        do {
            Menu menu = new Menu();
            menu.mostrarInicio();
            int opcion = menu.getOpcion();
            switch (opcion) {
                case 1:
                    new Klondike().jugar();
                    break;
                case 2:
                    new Baraja().ordenar();
                    break;
                case 3:
                    usando = !usando;
                    break;
            }
        } while(usando);
    }
}
