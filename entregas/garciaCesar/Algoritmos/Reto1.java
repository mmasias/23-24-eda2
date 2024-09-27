package entregas.garciaCesar.Algoritmos;

public class Reto1 {
    public static void main(String[] args) {
        int[] array = { 8, 1, 3, 4, 5, 78, 45, 9, 65 };
        int[] resul = algoritmoSuma(array, 11);
        if (resul[0] == -1) {
            System.out.println("No se ha encontrado la secuencia");
        } else {
            System.out.println("La secuencia es: " + resul[0] + " " + resul[1]); 
        }
        
        resul = algoritmoSuma2(array, 11); 

        if (resul[0] == -1) {
            System.out.println("No se ha encontrado la secuencia");
        } else {
            System.out.println("La secuencia es: " + resul[0] + " " + resul[1]);
        }
    }

    public static int[] algoritmoSuma(int[] a, int objetivo) {// Suma de complejidades: O(1) + O(n) + O(n^2) + O(n^2) + O(n^2) + O(1) = O(3n^2 + n + 2) ≈ O(n^2)
        int[] resultado = { -1, -1 };//O(1)
        for (int i = 0; i < a.length - 1; i++) {//O(n)
            for (int j = i + 1; j < a.length; j++) {//O(n^2)
                // System.out.println(i+" "+j);
                if (a[i] + a[j] == objetivo) {//O(n^2)
                    resultado[0] = i;//O(n^2)
                    resultado[1] = j;//O(n^2)
                    return resultado;//O(n^2)
                }
            }
        }
        return resultado;//O(1)
    }

    public static int[] algoritmoSuma2(int[] a, int objetivo) {// Suma de complejidades: O(1) + O(n) + O(n) + O(n^2) + O(n^2) + O(n^2) + O(1) = O(3n^2 + 2n + 2) ≈ O(n^2)
        int[] resultado = { -1, -1 };//O(1)
        for (int i = 0; i < a.length - 1; i++) {//O(n)
            if (a[i]<objetivo) {//O(n)
                for (int j = i + 1; j < a.length; j++) {//O(n^2)
                    if (a[i] + a[j] == objetivo) {//O(n^2)
                        resultado[0] = i;//O(n^2)
                        resultado[1] = j;//O(n^2)
                        return resultado;//O(n^2)
                    }
                }
            }
        }
        return resultado;//O(1)
    }

}
