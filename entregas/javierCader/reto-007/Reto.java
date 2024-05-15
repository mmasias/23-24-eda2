import java.util.Scanner;

public class Reto {
    private Baraja baraja;
    private Scanner scanner;

    private final String ANSI_RESET = "\u001B[0m";
    private final String ANSI_RED = "\u001B[31m";
    private final String ANSI_GREEN = "\u001B[32m";
    private final String ANSI_YELLOW = "\u001B[33m";
    private final String ANSI_BLUE = "\u001B[34m";
    private final String ANSI_PURPLE = "\u001B[35m";
    private final String ANSI_CYAN = "\u001B[36m";
    private final String ANSI_WHITE = "\u001B[37m";

    public Reto() {
        baraja = new Baraja();
        scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            printMenu();
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
                    System.out.println(ANSI_PURPLE + "Exiting..." + ANSI_RESET);
                    return;
                default:
                    System.out.println(ANSI_RED + "Invalid choice. Please try again." + ANSI_RESET);
            }
        }
    }

    private void printMenu() {
        System.out.println(ANSI_CYAN + "===============================" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "         Card Sorting          " + ANSI_RESET);
        System.out.println(ANSI_CYAN + "===============================" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "1. Shuffle Deck" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "2. Sort Deck by Number" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "3. Sort Deck by Palo (Suit)" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "4. Show Deck" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "5. Exit" + ANSI_RESET);
        System.out.println(ANSI_CYAN + "===============================" + ANSI_RESET);
        System.out.print(ANSI_WHITE + "Choose an option: " + ANSI_RESET);
    }

    private void sortDeckByNumber() {
        Carta[] cartas = baraja.getCartas();
        flipAllCards(cartas);
        bubbleSortByNumber(cartas);
        baraja.setCartas(cartas);
        System.out.println(ANSI_GREEN + "Deck sorted by number." + ANSI_RESET);
    }

    private void sortDeckByPalo() {
        Carta[] cartas = baraja.getCartas();
        flipAllCards(cartas);
        bubbleSortByPalo(cartas);
        baraja.setCartas(cartas);
        System.out.println(ANSI_GREEN + "Deck sorted by palo." + ANSI_RESET);
    }

    private void showDeck() {
        for (int i = 0; i < baraja.getCartas().length; i++) {
            Carta carta = baraja.getCartas()[i];
            if (carta != null) {
                carta.mostrar();
            } else {
                System.out.print("[null]");
            }
            if ((i + 1) % 13 == 0) {
                System.out.println();
            } else {
                System.out.print(" ");
            }
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

    private void bubbleSortByNumber(Carta[] cartas) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < cartas.length - 1; i++) {
                int currentKey = cartas[i].getNumero() * 4 + cartas[i].getPalo();
                int nextKey = cartas[i + 1].getNumero() * 4 + cartas[i + 1].getPalo();
                if (currentKey > nextKey) {
                    Carta temp = cartas[i];
                    cartas[i] = cartas[i + 1];
                    cartas[i + 1] = temp;
                    swapped = true;
                }
            }
            System.out.println("\n" + ANSI_BLUE + "--- Intermediate sorting state by number ---" + ANSI_RESET);
            showDeck();
        } while (swapped);
    }

    private void bubbleSortByPalo(Carta[] cartas) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < cartas.length - 1; i++) {
                int currentKey = cartas[i].getPalo() * 13 + cartas[i].getNumero();
                int nextKey = cartas[i + 1].getPalo() * 13 + cartas[i + 1].getNumero();
                if (currentKey > nextKey) {
                    Carta temp = cartas[i];
                    cartas[i] = cartas[i + 1];
                    cartas[i + 1] = temp;
                    swapped = true;
                }
            }
            System.out.println("\n" + ANSI_BLUE + "--- Intermediate sorting state by palo ---" + ANSI_RESET);
            showDeck();
        } while (swapped);
    }

    public static void main(String[] args) {
        Reto reto = new Reto();
        reto.start();
    }
}
