import java.util.Scanner;

public class Ejercicio {
public static void main(String[] args) {
Scanner s = new Scanner(System.in);
System.out.println("pon un numero");
int x = s.nextInt();
System.out.println("numeros del 1 al " + x);
imprimirNum(x);
System.out.println("numeros del 1 al " + x + " al reves");
imprimirNum2(x);
System.out.println("suma de números del 1 al " + x);
System.out.println(sumarNum(x));
s.close();
}

public static void imprimirNum(int x) {
    if (x > 0) {
        imprimirNum(x - 1);
        System.out.println(x);
    }
}

public static void imprimirNum2(int x) {
    if (x > 0) {
        System.out.println(x);
        imprimirNum2(x - 1);
    }
}

public static int sumarNum(int x) {
    if (x > 0) {
        return x + sumarNum(x - 1);
    } else {
        return 0;
    }
}
}