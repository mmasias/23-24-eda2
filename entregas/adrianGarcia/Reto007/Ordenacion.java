import java.util.Scanner;

public class Ordenacion{
    public void ordenarPorPalo(Baraja baraja, boolean palo2){
        Carta[] cartas = baraja.getCartas();
        for(int i = 0; i < cartas.length; i++){
            for(int j = 0; j < cartas.length - 1; j++){
                if (palo2)
                {
                    if(cartas[j].getpalo() > cartas[j + 1].getpalo()){
                        Carta carta = cartas[j];
                        cartas[j] = cartas[j + 1];
                        cartas[j + 1] = carta;
                    }
                }
                else{
                    if(cartas[j].getpalo() < cartas[j + 1].getpalo()){
                        Carta carta = cartas[j];
                        cartas[j] = cartas[j + 1];
                        cartas[j + 1] = carta;
                    }
                }
            }
        }
        baraja.setCartas(cartas);
    }
    public void ordenarPorPalo1yNumero(Baraja baraja, boolean desc){
        Carta[] cartas = baraja.getCartas();
        for (int i = 0; i < cartas.length; i++) {
            for (int j = 0; j < cartas.length - 1; j++) {
                if(!desc)
                {
                    if (cartas[j].getpalo() > cartas[j + 1].getpalo()) {
                        Carta temp = cartas[j];
                        cartas[j] = cartas[j + 1];
                        cartas[j + 1] = temp;
                    } else if (cartas[j].getpalo() == cartas[j + 1].getpalo()) {
                        if (cartas[j].getnumero() > cartas[j + 1].getnumero()) {
                            Carta temp = cartas[j];
                            cartas[j] = cartas[j + 1];
                            cartas[j + 1] = temp;
                        }
                    }
                }else{
                    if (cartas[j].getpalo() > cartas[j + 1].getpalo()) {
                        Carta temp = cartas[j];
                        cartas[j] = cartas[j + 1];
                        cartas[j + 1] = temp;
                    } else if (cartas[j].getpalo() == cartas[j + 1].getpalo()) {
                        if (cartas[j].getnumero() < cartas[j + 1].getnumero()) {
                            Carta temp = cartas[j];
                            cartas[j] = cartas[j + 1];
                            cartas[j + 1] = temp;
                        }
                    }
                }
            }
        }
        baraja.setCartas(cartas);
    }

    public void ordenarPorPalo2yNumero(Baraja baraja, boolean desc){
        Carta[] cartas = baraja.getCartas();
        for (int i = 0; i < cartas.length; i++) {
            for (int j = 0; j < cartas.length - 1; j++) {
                if (!desc)
                {
                    if (cartas[j].getpalo() < cartas[j + 1].getpalo()) {
                        Carta temp = cartas[j];
                        cartas[j] = cartas[j + 1];
                        cartas[j + 1] = temp;
                    } else if (cartas[j].getpalo() == cartas[j + 1].getpalo()) {
                        if (cartas[j].getnumero() < cartas[j + 1].getnumero()) {
                            Carta temp = cartas[j];
                            cartas[j] = cartas[j + 1];
                            cartas[j + 1] = temp;
                        }
                    }
                }
                else
                {
                    if (cartas[j].getpalo() < cartas[j + 1].getpalo()) {
                        Carta temp = cartas[j];
                        cartas[j] = cartas[j + 1];
                        cartas[j + 1] = temp;
                    } else if (cartas[j].getpalo() == cartas[j + 1].getpalo()) {
                        if (cartas[j].getnumero() > cartas[j + 1].getnumero()) {
                            Carta temp = cartas[j];
                            cartas[j] = cartas[j + 1];
                            cartas[j + 1] = temp;
                        }
                    }
                }
            }
        }
        baraja.setCartas(cartas);
    }
    public void ordenarPorNumero(Baraja baraja, boolean desc){
        Carta[] cartas = baraja.getCartas();
        for (int i = 0; i < cartas.length; i++){
            for (int j = 0; j < cartas.length - 1; j++){
                if (desc)
                {
                    if(cartas[j].getnumero() < cartas[j + 1].getnumero()){
                        Carta carta = cartas[j];
                        cartas[j] = cartas[j + 1];
                        cartas[j + 1] = carta;
                    }
                }else{
                    if(cartas[j].getnumero() > cartas[j + 1].getnumero()){
                        Carta carta = cartas[j];
                        cartas[j] = cartas[j + 1];
                        cartas[j + 1] = carta;
                    }
                }
            }
        }
        baraja.setCartas(cartas);
    }
    public void salir(){
        Baraja baraja = new Baraja();
        System.out.println("Aqui tienes tu baraja sin ordenar"+ "\n"+ "Gracias por jugar, adios.");
        baraja.imprime();
        baraja = null;
    }
    public void menu(){
        System.out.println("¿Cómo quieres ordenar la baraja?");
        System.out.println("1. Por palo (♥️,♦️,♣️,♠️) sin importar Nºs"+"\n"+"2. Por palo (♠️,♣️,♦️,♥️) sin importar Nºs"+"\n"+"3. Por palo (♥️,♦️,♣️,♠️) y Nºs Ascendentes"+"\n"+"4. Por palo (♥️,♦️,♣️,♠️) y Nºs Descendentes");
        System.out.println("5. Por palo (♠️,♣️,♦️,♥️) y Nºs Ascendentes"+"\n"+"6. Por palo (♠️,♣️,♦️,♥️) y Nºs Descendentes"+"\n"+"7. Por Nºs Ascendentes sin importar palo"+"\n"+"8. Por Nºs Descendentes sin importar palo");
        System.out.println("9. Salir"+ "\n"+ "Elige una opción: ");
    }
}