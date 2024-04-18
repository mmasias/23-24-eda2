public class Trazabilidad {

    public static void main(String[] args) {
        imprimirNumero(1,20);
        System.out.println("----------".repeat(5));
        ordenDescendente(1,20);
        System.out.println("----------".repeat(5));
        System.out.println("Resultado: [" + sumarNumeros(20) + "]");
    }
     
    static void imprimirNumero(int inicio, int numero) {
        int x = inicio;
        System.out.print("Imprimo el nº: [" + x + "]");
        x++;
        System.out.print(" y sumo uno a ese número: [" + x + "]\n");
        if (x <= numero) {
            imprimirNumero(x, numero);
        }
    }

    static void ordenDescendente(int inicio, int numero) {
        int x = inicio;
        System.out.print("Imprimo el nº: [" + numero + "]");
        numero--;
        System.out.print(" y resto uno a ese número: [" + numero + "]\n");
        if (numero >= x) {
            ordenDescendente(x, numero);
        }
    }

    static int sumarNumeros(int numero) {
        if (numero == 0) {
            System.out.println("Llegué al final de la recursividad");
            return numero;
        } else {
            System.out.print("Sumo el nº: [" + numero + "]");
            System.out.println(" y resto uno al primer nº [" + (numero - 1) + "]");
            return numero + sumarNumeros(numero - 1);
        }
    }
}