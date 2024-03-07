package entregas.garciaDiego.Reto003;

import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        Management management = new Management(new ArrayList<Document>());
        management.menu();
    }
}
