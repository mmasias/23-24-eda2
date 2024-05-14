import java.util.Scanner;

class RetoEDA {


    private Baraja baraja;

    public static void main(String[] args) {

        Baraja baraja = new Baraja();
        int x = 0;

        do {
            System.out.println("Si desea ordenar la baraja por numeros presione: 1 \nSi desea ordenar la baraja por palos presione: 2 ");
            Scanner sc = new Scanner(System.in);
            x = sc.nextInt();

            if (x == 1) {
                baraja.ordenarPorNumero();
            } else if (x == 2) {
                baraja.ordenarPorPalo();
            } else {
                System.out.println("Debe introducir 1 o 2");

            }
        } while (x < 1 || x > 2);
        //
        Carta carta;
        do {
            carta = baraja.sacar();


            carta.voltear();
            carta.mostrar();
        } while (!baraja.vacia());
    }


}
