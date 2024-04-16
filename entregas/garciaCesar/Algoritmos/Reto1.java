package entregas.garciaCesar.Algoritmos;

import java.time.Duration;
import java.time.LocalDateTime;

public class Reto1 {
    public static void main(String[] args) {
        int[] array = { 8, 1, 3, 4, 5,78,45,9,9,5,45,65 };
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

    public static int[] algoritmoSuma(int[] a, int objetivo) {
        int[] resultado = { -1, -1 };
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = i + 1; j < a.length; j++) {
                // System.out.println(i+" "+j);
                if (a[i] + a[j] == objetivo) {
                    resultado[0] = i;
                    resultado[1] = j;
                    return resultado;
                }
            }
        }
        return resultado;
    }

    public static int[] algoritmoSuma2(int[] a, int objetivo) {
        int[] resultado = { -1, -1 };
        for (int i = 0; i < a.length - 1; i++) {
            if (a[i]<objetivo) {
                for (int j = i + 1; j < a.length; j++) {
                    if (a[i] + a[j] == objetivo) {
                        resultado[0] = i;
                        resultado[1] = j;
                        return resultado;
                    }
                }
            }
        }
        return resultado;
    }
}
