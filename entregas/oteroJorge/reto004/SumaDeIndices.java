package entregas.oteroJorge.reto004;

import java.util.Scanner;

public class SumaDeIndices{
    public static void main(String[] args) {
        mostrarResultado(sumaDeIndices(crearArray(), valorASumar()));
    }

    static int preguntaNumeros(){
        System.out.println("Introduce un número: ");
        Scanner scanner = new Scanner(System.in);
        int numero = scanner.nextInt();
        return numero;
    }

    static int[] crearArray(){
        int[] numeros = new int[6];
        numeros[0] = preguntaNumeros();
        numeros[1] = preguntaNumeros();
        numeros[2] = preguntaNumeros();
        numeros[3] = preguntaNumeros();
        numeros[4] = preguntaNumeros();
        numeros[5] = preguntaNumeros();
        return numeros;
    }

    static int valorASumar(){
        System.out.println("¿Cuánto tiene que sumar? ");
        Scanner scanner = new Scanner(System.in);
        int numero = scanner.nextInt();
        return numero;
    }

    static int sumaDeIndices(int[] numeros, int valorASumar){
        int sumaDeIndices = 0;
        for (int i = 0; i < numeros.length; i++) {
            for (int j = 0; j < numeros.length; j++) {
                if (numeros[i] + numeros[j] == valorASumar) {
                    System.out.println("Los números " + numeros[i] + " y " + numeros[j] + " suman " + valorASumar);
                    sumaDeIndices = i + j;
                    return sumaDeIndices;
                }
            }
        }
        return sumaDeIndices;
    }

    static void mostrarResultado(int sumaDeIndices){
        if(sumaDeIndices == 0){
            System.out.println("No se ha encontrado ningún par de números que sumen el valor introducido");
        } else {
            System.out.println("La suma de los índices de los números que suman el valor introducido es: " + sumaDeIndices);
        }
    }
}