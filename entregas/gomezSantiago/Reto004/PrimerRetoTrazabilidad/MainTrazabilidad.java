package entregas.gomezSantiago.Reto004.PrimerRetoTrazabilidad;

public class MainTrazabilidad {
    public static void main(String[] args) {
        recursividad(1, 100); 
    }
  
    static void recursividad(int i, int x) {
      System.out.println("+---------------------------------------+");
      System.out.println("| Entrando a la función de recursividad |"); 
      System.out.println("+---------------------------------------+");
  
        if (i <= x) {
          System.out.println("+--------------------------------------------------+");
          System.out.println("| Entrando a la función de recursividad con i = " + i); 
          System.out.println("+--------------------------------------------------+");
            System.out.println("+------------------------+");
            System.out.println("| El valor de i es: " + i); 
            System.out.println("| Sumando i para obtener el siguiente número |"); 
            System.out.println("+--------------------------------------------+");
            i++; 
            System.out.println("+---------------------------+");
            System.out.println("| El siguiente número es: " + i); 
            System.out.println("+---------------------------+");
            recursividad(i, x);
        } 

        if (i > x) {
            System.out.println("+---------------------------------------------------------+");
            System.out.println("| El número es mayor al indicado, se finaliza el programa |");
            System.out.println("+---------------------------------------------------------+");

        }
    }
  }
  