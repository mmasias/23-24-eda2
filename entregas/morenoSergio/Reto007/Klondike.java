public class Klondike {

    public static void main(String[] args) {
        Menu menu = new Menu();
        Baraja baraja = new Baraja();
        Descarte descarte = new Descarte();
        Palo[] palos = { new Palo(), new Palo(), new Palo(), new Palo() };
        Columna[] columnas = { new Columna(baraja, 1), new Columna(baraja, 2), new Columna(baraja, 3), new Columna(baraja, 4), new Columna(baraja, 5), new Columna(baraja, 6), new Columna(baraja, 7) };

        boolean salir = false;
        while (!salir) {
            System.out.println("==== JUEGO DE KLONDIKE ====");
            baraja.mostrar();
            descarte.mostrar();
            for (Palo palo : palos) {
                palo.mostrar();
            }
            for (Columna columna : columnas) {
                columna.mostrar();
            }

            menu.mostrar();
            int opcion = menu.getOpcion();
            switch (opcion) {
                case 1:
                    System.out.println("Mover de Descarte a Palo");
                    moverDeDescarteAPalo(descarte, palos);
                    break;
                case 2:
                    System.out.println("Mover de Descarte a Columna");
                    moverDeDescarteAColumna(descarte, columnas);
                    break;
                case 3:
                    System.out.println("Mover de Columna a Palo");
                    moverDeColumnaAPalo(columnas, palos);
                    break;
                case 4:
                    System.out.println("Mover de Columna a Columna");
                    moverDeColumnaAColumna(columnas);
                    break;
                case 5:
                    System.out.println("Mover de Palo a Columna");
                    moverDePaloAColumna(palos, columnas);
                    break;
                case 6:
                    System.out.println("Barajar Descarte en Baraja");
                    barajarDescarteEnBaraja(baraja, descarte);
                    break;
                case 7:
                    System.out.println("Mostrar Cartas");
                    baraja.mostrar();
                    descarte.mostrar();
                    for (Palo palo : palos) {
                        palo.mostrar();
                    }
                    for (Columna columna : columnas) {
                        columna.mostrar();
                    }
                    break;
                case 8:
                    System.out.println("Voltear Descarte en Baraja");
                    voltearDescarteEnBaraja(baraja, descarte);
                    break;
                case 9:
                    System.out.println("Ordenar Baraja");
                    baraja.ordenar();
                    System.out.println("Baraja ordenada");
                    break;
                case 10:
                    salir = true;
                    break;
            }
        }
    }

    private static void moverDeDescarteAPalo(Descarte descarte, Palo[] palos) {
        if (!descarte.vacia()) {
            Carta carta = descarte.sacar();
            for (Palo palo : palos) {
                if (palo.apilable(carta)) {
                    palo.poner(carta);
                    return;
                }
            }
            descarte.poner(carta);  // Si no se puede apilar, devolver la carta al descarte
        }
    }

    private static void moverDeDescarteAColumna(Descarte descarte, Columna[] columnas) {
        if (!descarte.vacia()) {
            Carta carta = descarte.sacar();
            for (Columna columna : columnas) {
                if (columna.apilable(carta)) {
                    columna.poner(carta);
                    return;
                }
            }
            descarte.poner(carta);  // Si no se puede apilar, devolver la carta al descarte
        }
    }

    private static void moverDeColumnaAPalo(Columna[] columnas, Palo[] palos) {
        for (Columna columna : columnas) {
            if (!columna.vacia()) {
                Carta carta = columna.sacar();
                for (Palo palo : palos) {
                    if (palo.apilable(carta)) {
                        palo.poner(carta);
                        return;
                    }
                }
                columna.poner(carta);  // Si no se puede apilar, devolver la carta a la columna
            }
        }
    }

    private static void moverDeColumnaAColumna(Columna[] columnas) {
        for (int i = 0; i < columnas.length; i++) {
            if (!columnas[i].vacia()) {
                Carta carta = columnas[i].sacar();
                for (int j = 0; j < columnas.length; j++) {
                    if (i != j && columnas[j].apilable(carta)) {
                        columnas[j].poner(carta);
                        return;
                    }
                }
                columnas[i].poner(carta);  // Si no se puede apilar, devolver la carta a la columna original
            }
        }
    }

    private static void moverDePaloAColumna(Palo[] palos, Columna[] columnas) {
        for (Palo palo : palos) {
            if (!palo.vacia()) {
                Carta carta = palo.sacar();
                for (Columna columna : columnas) {
                    if (columna.apilable(carta)) {
                        columna.poner(carta);
                        return;
                    }
                }
                palo.poner(carta);  // Si no se puede apilar, devolver la carta al palo
            }
        }
    }

    private static void barajarDescarteEnBaraja(Baraja baraja, Descarte descarte) {
        while (!descarte.vacia()) {
            Carta carta = descarte.sacar();
            baraja.poner(carta);
        }
        baraja.barajar();
    }

    private static void voltearDescarteEnBaraja(Baraja baraja, Descarte descarte) {
        if (!descarte.vacia()) {
            Carta carta = descarte.sacar();
            carta.voltear();
            baraja.poner(carta);
        }
    }
}
