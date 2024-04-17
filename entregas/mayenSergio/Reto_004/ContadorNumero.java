import java.util.Scanner;

public class Reto {

    public static void main(String[] args) {

        DevolverNumero(PedirNumero());
    }

    private static int PedirNumero(){
        Scanner pedirNumero = new Scanner(System.in);

        System.out.println("Ingresa hasta que número quieres imprimir");
        int numero = pedirNumero.nextInt();

        return numero;
    }

    private static void DevolverNumero(int numero){

        if(numero > 1) {
            DevolverNumero(numero - 1);
        }

        System.out.println("Llamada al metodo de forma recursiva voy por el número " + numero + " para ir sumando el número hata al final" );
        System.out.println("El número va aumentando");
        System.out.println("El conteo va: " + numero);

    }
}