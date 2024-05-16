package entregas.gomezSantiago.Reto004.PrimerRetoTrazabilidad;

//Indicar un número e imprimir del 1 a X

public class Main {
    public static void main(String[] args) {
      recursividad(1, 10);
    }
    
    static void recursividad(int i, int x) {
      if (i <= x) {
        System.out.println(i); 
        i++; 
        recursividad(i, x);
      } 
    }
}