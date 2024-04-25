import java.util.Scanner;

public class Sumar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Ingrese el número inicial (x): ");
        int x = scanner.nextInt();
        
        System.out.print("Ingrese el número final (y): ");
        int y = scanner.nextInt();
        
        int suma = sumarNumerosDescendente(x, y);
        System.out.println("La suma de los números del " + x + " al " + y + " es: " + suma);
    }

    public static int sumarNumerosDescendente(int actual, int y) {
        if (actual > y) {
            return 0;
        } else {
            return actual + sumarNumerosDescendente(actual + 1, y);
        }
    }
}
