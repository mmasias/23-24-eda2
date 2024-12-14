public class Ej1 {

    public static void main(String[] args) {
        int[] datos = {3, 2, 9, 8};
        int objetivos = 10;
        int[] resultado = algoritmo(datos, objetivos);
        if (resultado[0] == -1 && resultado[1] == -1)
            System.out.println("No se encontraron dos números que sumen " + objetivos);
        else
            System.out.println("[" + resultado[0] + ", " + resultado[1] + "]");
    }

    public static int[] algoritmo(int[] datos, int objetivos) {
        int[] resultado = {-1, -1};
        for (int i = 0; i < datos.length; i++) {

            for (int j = i + 1; j < datos.length; j++) {
                if (datos[i] + datos[j] == objetivos) {
                    resultado[0] = i;
                    resultado[1] = j;
                    return resultado;
                }
            }
        }
        return resultado;
    }
}
/* El bigO es de tipo n^2, ya que se recorre el arreglo dos veces, una para el primer ciclo y otra para el segundo ciclo.*/