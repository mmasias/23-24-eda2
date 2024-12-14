import java.util.Arrays;
import java.util.Scanner;

public class reto004 {
    public static void main(String[] args) {

        Scanner solicitoNumero = new Scanner(System.in);
        int numero;

        System.out.println("Teclea el número de iteraciones deseadas:");
        numero = solicitoNumero.nextInt();
        System.out.println("Número de iteraciones solicitado: " + numero);

        Object[] numbers = new Object[numero];
        System.out.println("Array inicializado con tamaño de: " + numbers.length);

        Arrays.fill(numbers, new Object() {
            private int count = 0;

            @Override
            public String toString() {
                int currentCount = ++count;
                System.out.println("Incrementando count a: " + currentCount);
                return Integer.toString(currentCount);
            }
        });

        System.out.println("Array final:");
        System.out.println(Arrays.toString(numbers));
    }
}
