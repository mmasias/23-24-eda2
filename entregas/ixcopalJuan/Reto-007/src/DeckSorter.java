public class DeckSorter {

    public static void main(String[] args){
        Baraja baraja = new Baraja();
        sortDeckBySuit(baraja);
        showDeck(baraja, "Baraja ordenada por palo: ");
        sortDeckByNumber(baraja);
        showDeck(baraja, "Baraja ordenada por numero: ");
    }

    public static void sortDeckBySuit(Baraja baraja){
        Carta[] cards = baraja.getCards();
        mergeSortBySuit(cards, 0, cards.length -1);
    }

    public static void sortDeckByNumber(Baraja baraja) {
        Carta[] cartas = baraja.getCards();
        mergeSortByNumber(cartas, 0, cartas.length - 1);
    }

    public static void mergeSortBySuit(Carta[] cards, int left, int right){
        if (left < right){
            int middle = (left + right) / 2;
            mergeSortBySuit(cards, left, middle);
            mergeSortBySuit(cards, middle + 1, right);
            mergeBySuit(cards, left, middle, right);
        }
    }

    public static void mergeSortByNumber(Carta[] cards, int left, int right){
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSortByNumber(cards, left, middle);
            mergeSortByNumber(cards, middle + 1, right);
            mergeByNumber(cards, left, middle, right);
        }
    }

    public static void mergeBySuit(Carta[] cards, int left, int middle,int right){
        Carta[] temp = new Carta[right - left + 1];
        int i = left, j = middle + 1, k = 0;

        while (i <= middle && j <= right) {
            if (cards[i].getSuit() < cards[j].getSuit() ||
                    (cards[i].getSuit() == cards[j].getSuit() && cards[i].getNumber() < cards[j].getNumber())) {
                temp[k++] = cards[i++];
            } else {
                temp[k++] = cards[j++];
            }
        }

        while (i <= middle) {
            temp[k++] = cards[i++];
        }

        while (j <= right) {
            temp[k++] = cards[j++];
        }

        for (i = 0; i < temp.length; i++) {
            cards[left + i] = temp[i];
        }
    }

    public static void mergeByNumber(Carta[] cards, int left, int middle,int right){
        Carta[] temp = new Carta[right - left + 1];
        int i = left, j = middle + 1, k = 0;

        while (i <= middle && j <= right) {
            if (cards[i].getNumber() < cards[j].getNumber() ||
                    (cards[i].getNumber() == cards[j].getNumber() && cards[i].getSuit() < cards[j].getSuit())) {
                temp[k++] = cards[i++];
            } else {
                temp[k++] = cards[j++];
            }
        }

        while (i <= middle) {
            temp[k++] = cards[i++];
        }

        while (j <= right) {
            temp[k++] = cards[j++];
        }

        for (i = 0; i < temp.length; i++) {
            cards[left + i] = temp[i];
        }
    }

    public static void showDeck(Baraja baraja, String text){
        Carta[] cards = baraja.getCards();
        System.out.println(text);
        for (Carta card : cards) {
            card.show();
        }
        System.out.println();
    }
}
