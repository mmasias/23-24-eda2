package entregas.diestroPaula.Reto004;

public class Recursividad {
    public static void main(String[] args) {
        printNum(5);
        printNumRecursive(5);
    }

    public static void printNum(int num) {
        if (num > 0) {
            printNum(num - 1);
            System.out.println(num);
        }
    }

    public static void printNumRecursive(int num) {
        if (num > 0) {
            System.out.println(num);
            printNumRecursive(num - 1);
        }
    }
}