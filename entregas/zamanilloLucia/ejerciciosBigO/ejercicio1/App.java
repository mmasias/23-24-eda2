package entregas.zamanilloLucia.ejerciciosBigO.ejercicio1;

import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        int[] array = {3, 2, 9, 8};
        int number = 10;
        Operation operation = new Operation();

        int[] result = operation.indexCalculator(array, number);
        System.out.println(Arrays.toString(result));
        
    }
}
