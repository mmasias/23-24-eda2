public class ExerciseThree {
    public static void main(String[] args) {
        int suma = sumNumbers(5, 7);
        System.out.println("La suma es: " + suma);
    }
    
    public static int sumNumbers(int x, int y) {
        System.out.println("Entrando a la función sumNumbers con x = " + x + " y = " + y);
        if (x == y) {
            System.out.println("x es igual a y, devolviendo: " + x);
            return x;
        } else {
            System.out.println("Sumando 1 a x = " + (x+1));
            System.out.println("Llamando a sumNumbers con x = " + (x + 1) + ", y = " + y);
            System.out.println("Sumando " + x + " con el resultado de la recursión");
            System.out.println("--------------------------");
            return x + sumNumbers(x + 1, y);
        }
    }
}
