import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        // Caso de números
        int[] datosNumeros = {3, 2, 9, 8};
        int objetivoNumeros = 10;
        int[] resultadoNumeros = algoritmoNumeros(datosNumeros, objetivoNumeros);
        if(resultadoNumeros[0] == -1 && resultadoNumeros[1] == -1)
            System.out.println("No se encontraron dos números que sumen " + objetivoNumeros);
        else
            System.out.println("[" + resultadoNumeros[0] + ", " + resultadoNumeros[1] + "]");

        // Caso de letras
        char[] datosLetras = {'a', 'c', 'd', 'i', 'm', 'r', 't', 'u'};
        String objetivoLetras = "dia";
        int[] resultadoLetras = algoritmoLetras(datosLetras, objetivoLetras);
        if(resultadoLetras[0] == -1 && resultadoLetras[1] == -1 && resultadoLetras[2] == -1) {
            System.out.println("No se encontraron tres letras que formen la palabra " + objetivoLetras);
        } else {
            System.out.println("[" + resultadoLetras[0] + ", " + resultadoLetras[1] + ", " + resultadoLetras[2] + "]");
        }
    }

    public static int[] algoritmoNumeros(int[] datos, int objetivo) {
        int[] resultado = {-1,-1};
        for (int i = 0; i < datos.length-1; i++) {   //O(n)
            for (int j = i + 1; j < datos.length; j++) { //O(n^2)
                if (datos[i] + datos[j] == objetivo) {
                    resultado[0] = i;
                    resultado[1] = j;
                    return resultado;
                }
            }
        }
        return resultado;
    }

    public static int[] algoritmoLetras(char[] datos, String objetivo) {
        int[] resultado = {-1, -1, -1};
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < datos.length; i++) {
            map.put(datos[i], i);
        }
        for (int i = 0; i < objetivo.length() - 2; i++) {
            for (int j = i + 1; j < objetivo.length() - 1; j++) {
                char tercerLetra = objetivo.charAt(i);
                char segundaLetra = objetivo.charAt(j);
                char primeraLetra = objetivo.charAt(i + 2);

                if (map.containsKey(tercerLetra) && map.containsKey(segundaLetra) && map.containsKey(primeraLetra)) {
                    resultado[0] = map.get(tercerLetra);
                    resultado[1] = map.get(segundaLetra);
                    resultado[2] = map.get(primeraLetra);
                    return resultado;
                }
            }
        }
        return resultado;
    }
}
