package clases;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Gestion gestion = new Gestion(new ArrayList<Documento>());
        gestion.menu();
    }
}