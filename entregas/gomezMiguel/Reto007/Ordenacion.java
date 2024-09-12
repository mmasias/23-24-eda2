public class Ordenacion{
    public void ordenarPorPalo1(Baraja baraja){
        Carta[] cartas = baraja.getCartas();
        for(int i = 0; i < cartas.length; i++){
            for(int j = 0; j < cartas.length - 1; j++){
                if(cartas[j].getpalo() > cartas[j + 1].getpalo()){
                    Carta carta = cartas[j];
                    cartas[j] = cartas[j + 1];
                    cartas[j + 1] = carta;
                }
            }
        }
        baraja.setCartas(cartas);
    }

    public void ordenarPorPalo2(Baraja baraja){
        Carta[] cartas = baraja.getCartas();
        for(int i = 0; i < cartas.length; i++){
            for(int j = 0; j < cartas.length - 1; j++){
                if(cartas[j].getpalo() < cartas[j + 1].getpalo()){
                    Carta carta = cartas[j];
                    cartas[j] = cartas[j + 1];
                    cartas[j + 1] = carta;
                }
            }
        }
        baraja.setCartas(cartas);
    }

    public void ordenarPorPalo1yNumeroAsc(Baraja baraja){
        Carta[] cartas = baraja.getCartas();
        for (int i = 0; i < cartas.length; i++) {
            for (int j = 0; j < cartas.length - 1; j++) {
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
        baraja.setCartas(cartas);
    }

    public void ordenarPorPalo1yNumeroDesc(Baraja baraja){
        Carta[] cartas = baraja.getCartas();
        for (int i = 0; i < cartas.length; i++) {
            for (int j = 0; j < cartas.length - 1; j++) {
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
            }
        }
        baraja.setCartas(cartas);
    }

    public void ordenarPorPalo2yNumeroAsc(Baraja baraja){
        Carta[] cartas = baraja.getCartas();
        for (int i = 0; i < cartas.length; i++) {
            for (int j = 0; j < cartas.length - 1; j++) {
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
        }
        baraja.setCartas(cartas);
    }

    public void ordenarPorPalo2yNumeroDesc(Baraja baraja){
        Carta[] cartas = baraja.getCartas();
        for (int i = 0; i < cartas.length; i++) {
            for (int j = 0; j < cartas.length - 1; j++) {
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
        baraja.setCartas(cartas);
    }

    public void ordenarPorNumeroAsc(Baraja baraja){
        Carta[] cartas = baraja.getCartas();
        for(int i = 0; i < cartas.length; i++){
            for(int j = 0; j < cartas.length - 1; j++){
                if(cartas[j].getnumero() < cartas[j + 1].getnumero()){
                    Carta carta = cartas[j];
                    cartas[j] = cartas[j + 1];
                    cartas[j + 1] = carta;
                }
            }
        }
        baraja.setCartas(cartas);
    }

    public void ordenarPorNumeroDesc(Baraja baraja){
        Carta[] cartas = baraja.getCartas();
        for(int i = 0; i < cartas.length; i++){
            for(int j = 0; j < cartas.length - 1; j++){
                if(cartas[j].getnumero() > cartas[j + 1].getnumero()){
                    Carta carta = cartas[j];
                    cartas[j] = cartas[j + 1];
                    cartas[j + 1] = carta;
                }
            }
        }
        baraja.setCartas(cartas);
    }
}