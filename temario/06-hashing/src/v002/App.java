package v002;

import java.security.NoSuchAlgorithmException;

public class App {
    public static void main(String[] args) {
        Persona persona = new Persona("Juan", "Pérez", 85);

        try {
            String hashOriginal = persona.getHash();
            System.out.println("Hash original: " + hashOriginal);

            // Simular cambio de calificación
            persona.setCalificacion(90);

            String hashModificado = persona.getHash();
            System.out.println("Hash modificado: " + hashModificado);

            if (hashOriginal.equals(hashModificado)) {
                System.out.println("Los datos no han sido modificados.");
            } else {
                System.out.println("Los datos han sido modificados.");
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
