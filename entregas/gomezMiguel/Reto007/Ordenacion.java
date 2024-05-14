public class Ordenacion{
    public void ordenarPorPalo1(Baraja baraja){
        for(int i = 0; i < baraja.cartas.length; i++){
            for(int j = 0; j < baraja.cartas.length - 1; j++){
                if(baraja.cartas[j].getpalo() > baraja.cartas[j + 1].getpalo()){
                    Carta carta = baraja.cartas[j];
                    baraja.cartas[j] = baraja.cartas[j + 1];
                    baraja.cartas[j + 1] = carta;
                }
            }
        }
    }

    public void ordenarPorPalo2(Baraja baraja){
        for(int i = 0; i < baraja.cartas.length; i++){
            for(int j = 0; j < baraja.cartas.length - 1; j++){
                if(baraja.cartas[j].getpalo() < baraja.cartas[j + 1].getpalo()){
                    Carta carta = baraja.cartas[j];
                    baraja.cartas[j] = baraja.cartas[j + 1];
                    baraja.cartas[j + 1] = carta;
                }
            }
        }
    }
}