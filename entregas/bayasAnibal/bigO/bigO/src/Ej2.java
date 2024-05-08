public class Ej2 {

    public static void main(String[] args) {
        char[] datos = {'a', 'b', 'c', 'd', 'e'};
        String objetivos = "abe";
        int[] resultado = algoritmo(datos, objetivos);
        if (resultado[0] == -1 && resultado[1] == -1 && resultado[2] == -1)
            System.out.println("No se encontraron dos números que sumen " + objetivos);
        else
            System.out.println("[" + resultado[0] + ", " + resultado[1] + ", " + resultado[2] + "]");
    }

    public static int[] algoritmo(char[] datos, String objetivos) {
        String palabraDatos= new String(datos); //1
        int[] resultado = {-1, -1, -1};//1
        for(int i = 0; i < objetivos.length(); i++){//1 o n dependiendio el tamaño de objetivos
            resultado[i]=palabraDatos.indexOf(objetivos.charAt(i));  //n
        }
        return resultado;
    }
}

/* Si siempre consideramos que la entrada es de 3 letras sería bigO de n,
pero si consideramos que la entrada es de n letras sería bigO de n^2*/