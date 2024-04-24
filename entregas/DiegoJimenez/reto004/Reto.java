import java.util.Scanner;

public class Reto {
    public static void main(String[] args) {
        Scanner finalnumber = new Scanner(System.in);
        System.out.println("Ingrese un numero: ");
        int n = finalnumber.nextInt();
        System.out.println("Contando el numero en orden ascendente:");
        CountToNumberAsc(n, 1); 
        System.out.println("Contando el numero en orden descendente:");
        CountToNumberDesc(n); 
    }

    public static void CountToNumberAsc(int target, int current) {
        if (current <= target) {
            System.out.println("Sumando 1 al número " + (current - 1) + ", nuevo número es: " + current);
            CountToNumberAsc(target, current + 1); 
        }
    }

    public static void CountToNumberDesc(int num) {
        if (num >= 1) {
            System.out.println("Restando 1 al número " + num + ", nuevo número es: " + (num - 1));
            CountToNumberDesc(num - 1); 
        }
    }
}
