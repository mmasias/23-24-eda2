import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RetoEDA {

    private Baraja baraja;

    public RetoEDA(Baraja baraja) {
        this.baraja = baraja;
    }

    public static void main(String[] args) {

        Baraja baraja = new Baraja();

        RetoEDA reto = new RetoEDA(baraja);

        // Obtener todas las cartas de la baraja y almacenarlas en una lista
        List<Carta> cartas = new ArrayList<>();
        while (!baraja.vacia()) {
            Carta carta = baraja.sacar();
            cartas.add(carta);
        }

        // Ordenar la lista de cartas primero por número y luego por palo
        Collections.sort(cartas, (carta1, carta2) -> {
            if (carta1.numero != carta2.numero) {
                return carta1.numero - carta2.numero;
            } else {
                return carta1.palo - carta2.palo;
            }
        });

        // Mostrar las cartas ordenadas
        for (Carta carta : cartas) {
            carta.voltear();
            carta.mostrar();
        }
    }
}
