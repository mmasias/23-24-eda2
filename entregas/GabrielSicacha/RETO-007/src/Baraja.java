import java.util.Random;

public class Baraja {

    private Carta[] cartas;

    private final int PALOS = 4;
    private final int NUMEROS = 13;
    private final int TOTAL_CARTAS = PALOS * NUMEROS;

    private int ultima;

    public Baraja() {
        ultima = 0;
        cartas = new Carta[TOTAL_CARTAS];
        for (int palo = 0; palo < PALOS; palo++) {
            for (int numero = 0; numero < NUMEROS; numero++) {
                this.poner(new Carta(palo, numero));
            }
        }
        this.barajar();
    }

    private void barajar() {
        Random aleatorio = new Random();
        for (int i = 0; i < 1000; i++) {
            int origen = aleatorio.nextInt(TOTAL_CARTAS);
            int destino = aleatorio.nextInt(TOTAL_CARTAS);
            Carta carta = cartas[origen];
            cartas[origen] = cartas[destino];
            cartas[destino] = carta;
        }
    }

    public void poner(Carta carta) {
        cartas[ultima] = carta;
        ultima++;
    }

    public void mostrar() {
        System.out.print("BARAJA: ");
        if (this.vacia()) {
            System.out.println("No hay cartas en la baraja");
        } else {
            Carta carta = this.cima();
            carta.mostrar();
            System.out.println();
        }
    }

    public void mostrar(Carta[] cartas){
        for(Carta carta : cartas){
            if(!carta.bocaArriba()){
                carta.voltear();
            }
            carta.mostrar();
        }
    }

    private Carta cima() {
        return cartas[ultima - 1];
    }

    public void moverA(Descarte descarte) {
        if (this.vacia()) {
            System.out.println("¡No hay cartas en la baraja!");
        } else {
            int contador = 3;
            while (contador > 0 && !this.vacia()) {
                Carta carta = this.sacar();
                carta.voltear();
                descarte.poner(carta);
                contador--;
            }
        }
    }

    public Carta sacar() {
        ultima--;
        return cartas[ultima];
    }

    public boolean vacia() {
        return ultima == 0;
    }

    public void ordenar() {
        Menu menu = new Menu();
        boolean ordenando = true;
        do{
             menu.mostrarBaraja();
            int opcion = menu.getOpcion();
            switch (opcion) {
                case 1:
                    mostrar(ordenarPorNumeros(cartas));
                    break;
                case 2:
                    mostrar(ordenarPorPalos(cartas));
                    break;
                case 3:
                    ordenando = !ordenando;
                    break;
            }
        } while(ordenando);

    }

    private Carta[] ordenarPorPalos(Carta[] cartas) {
        int p = 0;
        int c = 0;
        int d = 0;
        int t = 0;

        Carta[] corazones= new Carta[13];
        Carta[] picas= new Carta[13];
        Carta[] diamantes= new Carta[13];
        Carta[] trebores= new Carta[13];
        
        for(Carta carta: cartas){
            if(carta.getPalo()==0){
                picas[p]=carta;
                p++;
            } else if (carta.getPalo()==1) {
                trebores[t]=carta;
                t++;
            } else if (carta.getPalo()==2) {
                diamantes[d]=carta;
                d++;
            } else {
                corazones[c]=carta;
                c++;
            }
        }

        picas=ordenarPorNumeros(picas);
        trebores=ordenarPorNumeros(trebores);
        diamantes=ordenarPorNumeros(diamantes);
        corazones=ordenarPorNumeros(corazones);

        for (int i = 0; i < TOTAL_CARTAS;i++){
            if(i>=39){
                cartas[i]=corazones[i-(13*3)];
            } else if (i>=26){
                cartas[i]=diamantes[i-(13*2)];
            } else if (i>=13){
                cartas[i]=trebores[i-(13)];
            } else {
                cartas[i]=picas[i];
            }
        }

        return cartas;
    }

    private Carta[] ordenarPorNumeros(Carta[] cartas) {
        if(cartas.length<=1){
            return cartas;
        }

        //odio que la cantidad de cartas no sea 2^x
        int medio = cartas.length/2;
        Carta[] mitadA = new Carta[medio];
        Carta[] mitadB = new Carta[cartas.length - medio];

        for (int i = 0; i < medio; i++) {
            mitadA[i] = cartas[i];
        }
        for (int i = medio; i < cartas.length; i++) {
            mitadB[i - medio] = cartas[i];
        }

        mitadA = ordenarPorNumeros(mitadA);
        mitadB = ordenarPorNumeros(mitadB);

        return unirMitades(mitadA,mitadB);
    }

    private Carta[] unirMitades(Carta[] mitadA, Carta[] mitadB){
        Carta[] nuevoConjunto = new Carta[mitadA.length+mitadB.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while((mitadA.length>i)&&(mitadB.length>j)){
            if(mitadA[i].getNumero()<=mitadB[j].getNumero()){
                nuevoConjunto[k++] = mitadA[i++];
            } else {
                nuevoConjunto[k++] = mitadB[j++];
            }
        }

        while (i < mitadA.length) {
            nuevoConjunto[k++] = mitadA[i++];
        }

        while (j < mitadB.length) {
            nuevoConjunto[k++] = mitadB[j++];
        }

        return nuevoConjunto;
    }
}
