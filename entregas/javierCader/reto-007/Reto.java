import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import tests.SleepSort;

public class Reto {
    private Baraja baraja;
    private Scanner scanner;

    public Reto() {
        baraja = new Baraja();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Shuffle Deck");
            System.out.println("2. Sort Deck by Number");
            System.out.println("3. Sort Deck by Palo (Suit)");
            System.out.println("4. Show Deck");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    baraja = new Baraja();
                    break;
                case 2:
                    sortDeckByNumber();
                    break;
                case 3:
                    sortDeckByPalo();
                    break;
                case 4:
                    showDeck();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void sortDeckByNumber() {
        Carta[] cartas = baraja.getCartas();
        flipAllCards(cartas);
        sleepSortByNumber(cartas);
        baraja.setCartas(cartas);
        System.out.println("Deck sorted by number.");
    }

    private void sortDeckByPalo() {
        Carta[] cartas = baraja.getCartas();
        flipAllCards(cartas);
        sleepSortByPalo(cartas);
        baraja.setCartas(cartas);
        System.out.println("Deck sorted by palo.");
    }

    private void showDeck() {
        for (Carta carta : baraja.getCartas()) {
            carta.mostrar();
        }
        System.out.println();
    }

    private void flipAllCards(Carta[] cartas) {
        for (Carta carta : cartas) {
            if (!carta.bocaArriba()) {
                carta.voltear();
            }
        }
    }

    private void sleepSortByNumber(Carta[] cartas) {
        int[] numeros = new int[cartas.length];
        for (int i = 0; i < cartas.length; i++) {
            numeros[i] = cartas[i].getNumero() * 4 + cartas[i].getPalo();
        }
        SleepSort.sleepSort(numeros, sortedNumbers -> {
            reorderCartas(cartas, sortedNumbers, true);
            System.out.println("Intermediate sorting state by number:");
            showDeck();
        });
    }

    private void sleepSortByPalo(Carta[] cartas) {
        int[] numeros = new int[cartas.length];
        for (int i = 0; i < cartas.length; i++) {
            numeros[i] = cartas[i].getPalo() * 13 + cartas[i].getNumero();
        }
        SleepSort.sleepSort(numeros, sortedNumbers -> {
            reorderCartas(cartas, sortedNumbers, false);
            System.out.println("Intermediate sorting state by palo:");
            showDeck();
        });
    }

    private void reorderCartas(Carta[] cartas, int[] sortedNumbers, boolean sortByNumber) {
        Map<Integer, Carta> originalCardMap = new HashMap<>();
        for (Carta carta : cartas) {
            int key = sortByNumber ? carta.getNumero() * 4 + carta.getPalo() : carta.getPalo() * 13 + carta.getNumero();
            originalCardMap.put(key, carta);
        }

        for (int i = 0; i < sortedNumbers.length; i++) {
            int sortedKey = sortedNumbers[i];
            if (originalCardMap.containsKey(sortedKey)) {
                cartas[i] = originalCardMap.get(sortedKey);
            } else {
                cartas[i] = null;
            }
        }
    }

    public static void main(String[] args) {
        Reto reto = new Reto();
        reto.start();
    }
}
