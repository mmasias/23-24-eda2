package entregas.garciaCesar.Algoritmos;

import java.util.HashMap;
import java.util.Map;

public class Reto2 {
    public static void main(String[] args) {
        char[] chars = {'a', 'c', 'd', 'i', 'm', 'r', 't', 'u'}; 
        String keyword = "dia";
        int[] result = algoritmoEncontrar(chars, keyword);
        System.out.println("Resultado: " + result[0] + " " + result[1] + " " + result[2]);
        result = algoritmoEncontrar2(chars, keyword);
        System.out.println("Resultado: " + result[0] + " " + result[1] + " " + result[2]);
        result = algoritmoEncontrar3(chars, keyword);
        System.out.println("Resultado: " + result[0] + " " + result[1] + " " + result[2]);
    }

    public static int[] algoritmoEncontrar(char[] chars, String keyword) {// Suma de complejidades: O(1) + O(n) + O(n) + O(n) + O(n) + O(1) = O(4n + 2) ≈ O(n)
        Map<Character, Integer> charIndices = new HashMap<>();//O(1)

        for (int i = 0; i < chars.length; i++) {//O(n)
            charIndices.put(chars[i], i);//O(n)
        }

        int[] keywordIndices = new int[keyword.length()];//O(1)
        for (int i = 0; i < keyword.length(); i++) {//O(n)
            char c = keyword.charAt(i);//O(n)
            if (charIndices.containsKey(c)) {//O(n)
                keywordIndices[i] = charIndices.get(c);//O(n)
            } else {//O(n)
                // Si algún carácter de la palabra clave no está presente, retornamos null
                return null;//O(n)
            }
        }

        return keywordIndices;//O(1)
    }

    public static int[] algoritmoEncontrar2(char[] letras, String palabra){// Suma de complejidades: O(1) + O(n) + O(n) + O(n^2) + O(1) = O(n^2+ 2n + 2) ≈ O(n)
        int[] indices = {-1, -1, -1};//O(1)
        String letraString = new String(letras);//O(n)
        for (int i = 0; i < palabra.length(); i++) {//O(n)
            indices[i] = letraString.indexOf(palabra.charAt(i));//O(n^2)
        }

        return indices;//O(1)
    }

    public static int[] algoritmoEncontrar3(char[] letras, String palabra){// Suma de complejidades: O(1) + O(1) + O(n) + O(1) = O(n + 3) ≈ O(n)
        int[] indices = {-1, -1, -1};//O(1)
        for (int i = 0; i < 3; i++) {//O(1)
            indices[i] = miIndexOf(letras, palabra.charAt(i));//O(n)
        }

        return indices;//O(1)
    }


    public static int miIndexOf(char[] letras, char letra){// Suma de complejidades: O(n) + O(n) + O(n) + O(1) = O(3n + 1) ≈ O(n)
        for (int i = 0; i < letras.length; i++) {//O(n)
            if (letras[i] == letra) {//O(n)
                return i;//O(n)
            }
        }
        return -1;//O(1)
    }
}

