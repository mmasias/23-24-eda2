package src;

import java.util.Scanner;


import java.util.Scanner;
public class Ejercicio {

        public static void main(String[] args) {
            Scanner s = new Scanner(System.in);
            System.out.println("Ingrese un número:");
            int x = s.nextInt();
            s.close();

            System.out.println("Numeros del 1 al " + x + ":");
            imprimirNum(x);

            System.out.println("Numeros del " + x + " al 1 al reves:");
            imprimirNum2(x);

            System.out.println("Suma de los numeros del 1 al " + x + ":");
            int suma = sumarNum(x);
            System.out.println(suma);
        }

        public static void imprimirNum(int x) {
            if (x > 0) {
                System.out.println("Imprimiendo " + x);
                imprimirNum(x - 1);
            }
        }

        public static void imprimirNum2(int x) {
            if (x > 0) {
                imprimirNum2(x - 1);
                System.out.println("Imprimiendo " + x);
            }
        }

        public static int sumarNum(int x) {
            if (x > 0) {
                int sumParcial = x + sumarNum(x - 1);
                System.out.println("Sumando " + x + ", Suma parcial: " + sumParcial);
                return sumParcial;
            } else {
                return 0;
            }
        }
    }
