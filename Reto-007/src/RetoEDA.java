import java.util.Scanner;

class RetoEDA {


    private Baraja baraja;

    public static void main(String[] args) {

        Baraja baraja = new Baraja();

        //
        System.out.println("Si desea ordenar la baraja por numeros presione: 1 \nSi desea ordenar la baraja por palos presione: 2 ");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();

        //
        Carta carta;
        do {
            carta = baraja.sacar();


            if (x == 1) {
                baraja.ordenarPorNumero();
            } else if (x == 2) {
                baraja.ordenarPorPalo();
            } else {
                System.out.println("Debe introducir 1 o 2");
                x = sc.nextInt();
            }

            carta.voltear();
            carta.mostrar();
        } while (!baraja.vacia());
    }


}
