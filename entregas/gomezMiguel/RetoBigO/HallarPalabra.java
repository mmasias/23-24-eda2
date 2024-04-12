package RetoBigO;

public class HallarPalabra {
    public static void main(String[] args) {
        char[] letras = {'a', 'o', 'e', 's', 'c', 'd', 'l'};
        String palabraobjetivo = "sol";
        for (int i = 0; i < letras.length; i++) {
            for (int j = 0; j < letras.length; j++) {
                for (int k = 0; k < letras.length; k++) {
                    if (letras[i] == palabraobjetivo.charAt(0) && letras[j] == palabraobjetivo.charAt(1) && letras[k] == palabraobjetivo.charAt(2)) {
                        System.out.println("Las letras en los índices  " + i + " y " + j + " y " + k + " forman la palabra " + palabraobjetivo);
                    }
                }
            }
        }
    }
}

//  La complejidad de este programa segun bigO es de O(n^3) siendo n la longitud de la matriz letras.
