import java.util.Scanner;

public class NumerosRecursividad {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Introdusca un entero positivo");
        int n = s.nextInt();
        System.out.println("---------------");
        System.out.println("Imprimiendo recorrido de 1 a "+n);
        recorrido(n);
        System.out.println("---------------");
        System.out.println("Imprimiendo recorrido inverso de "+n+" a 1");
        recorridoInverso(n);
        System.out.println("---------------");
        System.out.println("Imprimendo la suma de los numeros del 1 al "+n);
        System.out.println(sumar(n));
    }

    public static void recorrido(int x){
        if(x>0){
            recorrido(x-1);
            System.out.println(x);
        }
    }

    public static void recorridoInverso(int x){
        if(x>0){
            System.out.println(x);
            recorridoInverso(x-1);
        }
    }

    public static int sumar(int x){
        if (x>0){
          return x+sumar(x-1);
        }
        return 0;
    }
}