package entregas.celayaIker.Reto004;

public class Trazabilidad {

    public static void main(String[] args) {
        System.out.println("#############################################");
        System.out.println("Suma de numeros Ascendente");
        System.out.println("_____________________________________________");
        printNumbersAscendent(10, 1);
        System.out.println("#############################################");
        System.out.println("Resta de numeros Descendente");
        System.out.println("_____________________________________________");
        System.out.println("Numero Inicial-> " + 10);
        printNumbersDescendent(1, 10);
        System.out.println("_____________________________________________");

    }

    static public void printNumbersAscendent(int max, int actualStatus) {

        if (actualStatus != max) {
            if (actualStatus == 1) System.out.println("Numero Inicial -> " + actualStatus);
            System.out.println("Recursividad en printNumbersAscendent() - Numero maximo-> (" + max + ") - Estado de la suma (" + actualStatus + " + 1) -> (" + (actualStatus + 1) + ")");
            printNumbersAscendent(max, actualStatus + 1);
        }
    }

    static public void printNumbersDescendent(int max, int actualStatus) {

        if (actualStatus != max - 1) {
            System.out.println("Recursividad en printNumbersDescendent() - Numero maximo-> (" + max + ") - Estado de la resta (" + actualStatus + " - 1) -> (" + (actualStatus - 1) + ")");
            printNumbersDescendent(max, actualStatus - 1);
        }
    }
}