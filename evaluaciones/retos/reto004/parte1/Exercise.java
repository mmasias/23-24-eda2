package evaluaciones.retos.reto004.parte1;

public class Exercise {
    public static void main(String[] args) {
        int x = 20;
        int y = 10;

        printNumbersAscendent(x);
        System.out.println("\n");
        printNumbersDescendent(x, y);
        System.out.println("\n");
        int result = numberSum(x, y);
        System.out.println("Resultado final de la suma: " + result);
    }

    public static void printNumbersAscendent(int num) {
        if (num >= 0) {
            System.out.println("Vuelve al número " + (num - 1));
            printNumbersAscendent(num - 1);
            System.out.println("Imprime el número " + num);
            System.out.println(num);
        }
    }

    public static void printNumbersDescendent(int num1, int num2) {
        if (num1 > num2) {
            System.out.println("El primer número es mayor que el segundo");
            System.out.println("Se imprime el número " + num1);
            System.out.println(num1);
            System.out.println("Vuelve al número " + (num1 - 1));
            printNumbersDescendent(num1 - 1, num2);
        } else if (num1 < num2) {
            System.out.println("El segundo número es mayor que el primero");
            System.out.println("Se imprime el número " + num2);
            System.out.println(num2);
            System.out.println("Vuelve al número " + (num2 - 1));
            printNumbersDescendent(num1, num2-1);
        }
    }

    public static int numberSum(int num1, int num2) {
        if (num1 == num2) {
            System.out.println("Ambos números son iguales, se suma " + num1);
            return num1;
        } else if (num1 > num2) {
            System.out.println("El primer número es mayor que el segundo");
            System.out.println("Se suma el número " + num1 + " más el número anterior " + (num1 - 1));
            return num1 + numberSum(num1 - 1, num2);
        } else {
            System.out.println("El segundo número es mayor que el primero");
            System.out.println("Se suma el número " + num1 + " más el número anterior " + (num1 - 1));
            return num1 + numberSum(num1 + 1, num2);
        }
    }
}
