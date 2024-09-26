
import java.util.Arrays;

public class Algoritmo {

    public static void printNumeros(){
        Object[] numbers = new Object[20];
        System.out.println("Declarando el array..." + "[" + numbers.length + "]");

        System.out.println("Llenando el array con objetos...");
        Arrays.fill(numbers, new Object() {
            int count = 0;

            @Override
            public String toString() {

                System.out.println("Incrementando y convirtiendo a cadena de texto...");
                System.out.println("El valor actual es: " + count);
                return Integer.toString(++count);
            }
        });

        System.out.println("El array contiene los siguientes elementos:" + Arrays.toString(numbers));
    }

    public static void main(String[] args) {
        
        printNumeros();
    }
}