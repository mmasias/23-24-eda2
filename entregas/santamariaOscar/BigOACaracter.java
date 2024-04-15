package entregas.santamariaOscar;

public class BigOACaracter {
   
    public static void main(String[] args) {
        char[] caracteres = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        String palabraClave = "deg";
        int[] resultado = encontrarPalabraClave(caracteres, palabraClave);

        if (resultado.length == 0) {
            System.out.println("La palabra clave no se encontró en el array.");
        } else {
            System.out.println("Los índices de la palabra clave son: " + resultado[0] + ", " + resultado[1] + ", " + resultado[2]);
        }
    }
   
    public static int[] encontrarPalabraClave(char[] caracteres, String palabraClave) {
        int[] indices = new int[caracteres.length];
        int indice = 0;

        for (int i = 0; i < caracteres.length; i++) {
            if (caracteres[i] == palabraClave.charAt(indice)) {
                indices[indice] = i;
                indice++;
                if (indice == palabraClave.length()) {
                    return indices;
                }
            } else {
                indice = 0;
            }
        }

        return new int[0];
    }

}
