public class Hanoi {

    public static void resolverTorresDeHanoi(int n, char torreOrigen, char torreDestino, char torreAuxiliar) {
        if (n == 1) {
            System.out.println("Mover disco 1 de torre " + torreOrigen + " a torre " + torreDestino);
            return;
        }
        System.out.println("Llamada recursiva para mover " + (n-1) + " discos de torre " + torreOrigen + " a torre " + torreAuxiliar + " usando torre " + torreDestino + " como auxiliar");
        resolverTorresDeHanoi(n - 1, torreOrigen, torreAuxiliar, torreDestino);
        System.out.println("Mover disco " + n + " de torre " + torreOrigen + " a torre " + torreDestino);
        System.out.println("Llamada recursiva para mover " + (n-1) + " discos de torre " + torreAuxiliar + " a torre " + torreDestino + " usando torre " + torreOrigen + " como auxiliar");
        resolverTorresDeHanoi(n - 1, torreAuxiliar, torreDestino, torreOrigen);
    }

    static void cleanScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
      }

    public static void main(String[] args) {
        int numeroDeDiscos = 5;
        cleanScreen();
        System.out.println("Iniciando Torres de Hanói con " + numeroDeDiscos + " discos.");
        resolverTorresDeHanoi(numeroDeDiscos, 'A', 'C', 'B');
        System.out.println("Torres de Hanói completadas.");
    }
}
