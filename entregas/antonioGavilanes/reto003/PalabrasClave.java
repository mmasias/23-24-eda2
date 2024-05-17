package antonioGavilanes.reto003;

import java.util.ArrayList;
import java.util.Scanner;

public class PalabrasClave {
    private ArrayList<String> palabrasClave;

    public PalabrasClave() {

        this.palabrasClave = new ArrayList<>();
    }

    public String agregarPalabra() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una palabra clave (o escriba '-1' para terminar):");
        String palabra = scanner.nextLine();
        while (!palabra.equals("-1")) {
            palabrasClave.add(palabra);
            System.out.println("Palabra clave agregada correctamente.");
            System.out.println("Ingrese otra palabra clave (o escriba '-1' para terminar):");
            palabra = scanner.nextLine();
        }
        return palabra;
    }

    public void mostrarPalabrasClave() {

        System.out.println("Palabras clave:");
        for (String palabra : palabrasClave) {
            System.out.print(" - " + palabra);
        }
        System.out.println();

    }

    public static void main(String[] args) {

        PalabrasClave palabrasClave = new PalabrasClave();
        palabrasClave.agregarPalabra();
        palabrasClave.mostrarPalabrasClave();
    }
}