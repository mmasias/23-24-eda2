package entregas.saraPatino.retos;

public class reto1 {
    public static void main(String[] args) {
        recursividad(1, 10);
        }
    
        static void recursividad(int i, int x) {
            if (i <= x) {
                System.out.println("Verificamos que el primer número sea menor que x");
                System.out.println(i);
                System.out.println("Imprimimos i en caso de que sea menor que x"); 
                i++; 
                System.out.println("Le sumamos 1 al primer número");
                recursividad(i, x);
            } 
        }
    }
    

    
