public class ImprimeNumero {
    public static void main(String[] args) {
        recursividad(1, 10);
        }
    
        static void recursividad(int i, int x) {
            if (i <= x) {
                System.out.println("Verificamos que el primer número ["+ i + "] sea menor o igual que x:" + x);

                System.out.println("Imprimimos i [" + i + "] en caso de que sea menor que x"); 

                System.out.println(i);
                

                System.out.println("Le sumamos 1 al primer número y se vuelve a llamar la función, por ejemplo: " + i + " +  1");

                i++; 
                
                recursividad(i, x);
            } 
        }
    }
    

    
