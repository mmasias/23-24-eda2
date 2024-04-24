import java.util.Scanner;

public class RecursividadEjercicios {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Dame un número: ");
        int x = scanner.nextInt();
        printToX(x);
        
        System.out.println("Dame otro número: ");
        int y = scanner.nextInt();
        printFromXtoY(x, y);
        
        scanner.close(); 
    }

    public static void printToX(int x) {
        System.out.print("La x ahora vale: " + x + ". ");
        if (x > 0){
            System.out.print("Restando uno ...\n");
            printToX(x - 1);     
        } else if(x == 0) {
            System.out.print("Saliendo ...\n");
        }
    }

    public static void printFromXtoY(int x, int y) {
        System.out.print("La x vale: " + x +".");
        System.out.print(" La y vale: " + (y)+ ". ");
        if (x < y){
            System.out.print("Restando uno...\n");
            printFromXtoY(x, y-1);     
        } else if(x == y) {
            System.out.print("La x y la y valen lo mismo, saliendo...\n");
        } else {
            System.out.print("La x es mayor que la y\n");
        }
    }
}
