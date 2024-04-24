import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Ejercicio1 ejercicio1 = new Ejercicio1();
        Ejercicio2 ejercicio2 = new Ejercicio2();

        System.out.println("\u001B[34mMenu\u001B[0m");
        System.out.println("\u001B[32m1. Ejercicio 1\u001B[0m");
        System.out.println("\u001B[32m2. Ejercicio 2\u001B[0m");
        System.out.println("\u001B[33mEnter the number of the exercise you want to run: \u001B[0m");

        int option = s.nextInt();

        switch (option) {
            case 1:
                ejercicio1.initEx1();
                System.out.println("\u001B[35mThe complexity of this algorithm is O(n^2) because there are two nested loops\u001B[0m");
                break;
            case 2:
                ejercicio2.initEx2();
                System.out.println("\u001B[35mThe complexity of this algorithm is O(n^3) because there are three nested loops\u001B[0m");
                break;
            default:
                break;
        }

        s.close();
    }

}
