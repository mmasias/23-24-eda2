public class Recursivity {

    public static void main(String[] args) {

        System.out.println("--------");
        printfrom1tox(4);

        System.out.println("--------");
        System.out.println("La funcion /downprint/ imprime de forma descendente de X a Y, siendo X e Y los valores que se le pasan como parametros");
        downprint(4, 1);
        System.out.println("En este caso se prueba que si X es mayor a Y, la funcion imprime de forma correcta");
        System.out.println();
        downprint(1, 4);
        System.out.println("En este caso se prueba que si Y es mayor a X, la funcion no muestra errores");
        System.out.println("-----------");
        System.out.println(sumall(1, 4));
        System.out.println("La funcion /sumall/ suma todos los valores entre X e Y, siendo estos los valores que se le pasan como parametros");

    }

    // Imprime por recursividad de 1 a X

    static void printfrom1tox(int x) {
        if (x == 0) {
            System.out.println("Como X es 0, no se imprime nada");
            return;
        }
        System.out.println("Se reduce en 1 el numero");
        printfrom1tox(x - 1);
        System.out.println(x);
    }

    // Imprime de forma descendente de X a Y mediante recursividad
    
    static void downprint(int x, int y) {
        if (x == y) {
            System.out.println(x);
            return;
        } else if(x > y){
            System.out.println(x);
            System.out.println("Se reduce en 1 el numero de X");
            downprint(x - 1, y);
        } else if(x < y){
            System.out.println(y);
            System.out.println("Se reduce en 1 el numero de Y");
            downprint(x, y-1);
        }
        
    }
    // Suma todos los valores entre X y Y utilizando recursividad
    static int sumall(int x, int y) {
        if (x == y) {
            return x;
        } else if (x > y) {
            return x + sumall(x - 1, y);
        } else {
            return x + sumall(x + 1, y);
        }
    }
}
