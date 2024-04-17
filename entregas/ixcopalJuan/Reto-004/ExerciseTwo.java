public class ExerciseTwo {
    public static void main(String[] args) {
        printDescending(10, 5);
    }
    
    public static void printDescending(int x, int y) {
        System.out.println("Entrando a la función printDescending con x = " + x + " y = " + y);
        if (x < y) {
            System.out.println("Condición de salida: x < y");
            return;
        } else {
            System.out.print("Imprimiendo: ");
            System.out.println(x);
            System.out.println("Restando 1 a x para obtener el numero anterior = " + (x - 1));
            System.out.println("Llamando a printDescending con x = " + (x - 1) + " y = " + y);
            System.out.println("--------------------------------------------");
            printDescending(x - 1, y);
        }
    }
}
