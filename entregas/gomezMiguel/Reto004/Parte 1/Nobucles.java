public class Nobucles {
    public static void main(String[] args) {
        System.out.println("-----------");
        imprime(4);
        System.out.println("-----------");
        imprimedesc(4, 1);
        System.out.println();
        imprimedesc(1, 4);
        System.out.println("-----------");
        System.out.println(sumatoria(1, 4));
    }

    // Imprime sin bucles de 1 a x (numero que des tú)

    static void imprime(int x) {
        if (x == 0) {
            System.out.println("El número ha llegado a ser 0, se imprimen los numeros:");
            return;
        }
        System.out.println("Llama al método imprime(" + (x - 1) + ") va por"+ x);
        imprime(x - 1);
        System.out.println(x);
    }

    // Imprime de x a y en descendiente, sin bucles
    
    static void imprimedesc(int x, int y) {
        if (x == y) {
            System.out.println("Los números han llegado a ser iguales, se imprime el número menor");
            System.out.println(x);
            return;
        } else if(x > y){
            System.out.println("El primer número es mayor al segundo, se procede a reducir en 1 el primer número y se imprime");
            System.out.println(x);
            imprimedesc(x - 1, y);
        } else if(x < y){
            System.out.println("El segundo número es mayor al primero, se procede a reducir en 1 el segundo número y se imprime");
            System.out.println(y);
            imprimedesc(x, y-1);
        }
        
    }
    // Sumar los números de x a y
    static int sumatoria(int x, int y) {
        if (x == y) {
            System.out.println("Los números han llegado a ser iguales, se imprime el sumatorio de los números");
            return x;
        } else if (x > y) {
            System.out.println("El primer número es mayor al segundo, se procede a sumar el primer número a si mismo -1 recursivamente hasta llegar a ser igual al segundo número");
            return x + sumatoria(x - 1, y);
        } else {
            System.out.println("El segundo número es mayor al primero, se procede a sumar el primer número a si mismo +1 recursivamente hasta llegar a ser igual al segundo número");
            return x + sumatoria(x + 1, y);
        }
    }
}
