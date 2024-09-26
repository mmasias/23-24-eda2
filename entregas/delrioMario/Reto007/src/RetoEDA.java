import java.util.Comparator;
import java.util.Scanner;

class RetoEDA {

    private Baraja baraja;

    public static void main(String[] args) {

        Baraja baraja = new Baraja();

        //
        Scanner scanner = new Scanner(System.in);

        System.out.println("1- Ordenar por palo");
        System.out.println("2- Ordenar por número");
        System.out.println("3- Salir");
        System.out.print("Opción: ");
        
        int respuesta= scanner.nextInt();

        Carta[] array = baraja.cartas;
        if(respuesta==1){
            Comparator<Carta> comparadorPalo = new Comparator<Carta>() {
                public int compare(Carta carta1, Carta carta2) {
                    if (carta1.numero < carta2.numero) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            };
          
           
            array = baraja.cartas;
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - i - 1; j++) {
                    if (comparadorPalo.compare(array[j], array[j + 1]) > 0) {
                        Carta temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }else if(respuesta==2){
            Comparator<Carta> comparadorCarta = new Comparator<Carta>() {
                public int compare(Carta carta1, Carta carta2) {
                    if (carta1.igualPalo(carta2)) {
                        if (carta1.numero < carta2.numero) {
                            return 1;
                        } else {
                            return -1;
                        }
                    } else {
                        if (carta1.palo < carta2.palo) {
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                }
            };
    
            
            for (int i = 0; i < array.length - 1; i++) {
                for (int j = 0; j < array.length - i - 1; j++) {
                    if (comparadorCarta.compare(array[j], array[j + 1]) > 0) {
                        Carta temp = array[j];
                        array[j] = array[j + 1];
                        array[j + 1] = temp;
                    }
                }
            }
        }
        

        
        //
        Carta carta;
        do {
            carta = baraja.sacar();
            carta.voltear();
            carta.mostrar();
        } while (!baraja.vacia());
    }
}
