package RetoBigO;
public class HallarSuma {
    public static void main(String[] args) {
        int[] numbers = {3, 2, 9, 8};
        int numeroobjetivo = 10;
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == numeroobjetivo) {
                    System.out.println("los números en los índices " + i + " y " + j + " suman " + numeroobjetivo);
                }
            }
        }
    }
}

// La complejidad de este programa segun bigO es de O(n^2) siendo n la longitud de la matriz numbers.