package entregas.garciaLydia.reto004.parte1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ejercicioTrazabilidad {
    static List<String> trace = new ArrayList<>();

    public static void printNumbers(int x, int level) {
        if (x > 0) {
            String traceInfo = "Level " + level + ": Called printNumbers(" + (x - 1) + ")";
            trace.add(traceInfo);
            printNumbers(x - 1, level + 1);

            traceInfo = "Level " + level + ": Printing " + x;
            trace.add(traceInfo);
            System.out.println(x);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese un número: ");
        int x = scanner.nextInt();

        printNumbers(x, 1);

        System.out.println("\nTrazabilidad:");
        for (String info : trace) {
            System.out.println(info);
        }
    }
}