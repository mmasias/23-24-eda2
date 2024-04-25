package entregas.lavinDaniel.reto004;

public class Parte1 {

        public static void imprimirNumero(int x) {
            imprimirNumeroHelper(x, "imprimirNumero");
        }

        private static void imprimirNumeroHelper(int x, String methodName) {
            if (x > 0) {
                System.out.println("Método: " + methodName + ", Valor de x: " + x);
                imprimirNumeroHelper(x - 1, methodName);
                System.out.println("Método: " + methodName + ", Imprimiendo número: " + x);
            }
        }

        public static void printNumbers2(int x) {
            printNumbers2Helper(x, "printNumbers2");
        }

        private static void printNumbers2Helper(int x, String methodName) {
            if (x > 0) {
                System.out.println("Método: " + methodName + ", Imprimiendo número: " + x);
                printNumbers2Helper(x - 1, methodName);
            }
        }

        public static int sumarNumeros(int x) {
            return sumarNumerosHelper(x, "sumarNumeros");
        }

        private static int sumarNumerosHelper(int x, String methodName) {
            if (x > 0) {
                System.out.println("Método: " + methodName + ", Valor de x: " + x);
                int sumaParcial = x + sumarNumerosHelper(x - 1, methodName);
                System.out.println("Método: " + methodName + ", Suma parcial: " + sumaParcial);
                return sumaParcial;
            } else {
                System.out.println("Método: " + methodName + ", Fin de la recursión.");
                return 0;
            }
        }

        public static void main(String[] args) {
            imprimirNumero(10);
            System.out.println("---");
            printNumbers2(10);
            System.out.println("---");
            System.out.println("Suma total: " + sumarNumeros(10));
        }


}
