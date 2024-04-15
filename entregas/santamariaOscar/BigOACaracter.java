package entregas.santamariaOscar;

public class BigOACaracter {
   
    public static void main(String[] args) {
        char[] caracteres = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        String palabraClave = "eba";
        int[] resultado = encontrarPalabraClave(caracteres, palabraClave);

        if (resultado.length == 0) {
            System.out.println("La palabra clave no se encontró en el array.");
        } else {
            System.out.println("Los índices de la palabra clave son: " + resultado[0] + ", " + resultado[1] + ", " + resultado[2]);
        }
    }
   
    public static int[] encontrarPalabraClave(char[] caracteres, String palabraClave) {
        int[] indices = new int[3];     //o(1)
        String palabra= new String(caracteres); //o(n)

        for(int i=0; i<palabraClave.length();i++){ //O(1)*O(m)
            indices[i]=palabra.indexOf(palabraClave.charAt(i)); //O(1)*O(m)
        }
        return indices;//O(1)
    }

}

//La complejidad de todo el método es de O(m*n) donde n es la longitud del array y m la longitud de la palabra clave
