public class Recursion {

    public static void main(String[] args) {
        imprimirNumero(1,20);
        System.out.println("----------");
        ordenDescendente(1,20);
        System.out.println("----------");
        System.out.println(sumarNumeros(20));
    }
     
    static void imprimirNumero(int inicio, int numero) {
        int x = inicio;
        System.out.println(x);
        x++;
        if (x <= numero) {
            imprimirNumero(x, numero);
        }
    }

    static void ordenDescendente(int inicio, int numero) {
        int x = inicio;
        System.out.println(numero - x + 1);
        x++;
        if (x <= numero) {
            ordenDescendente(x, numero);
        }
    }


    static int sumarNumeros(int x) {
        if (x > 0) {
            return x + sumarNumeros(x - 1);
        } else {
            return 0;
        }
    }
}
