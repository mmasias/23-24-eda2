public class ExerciseOne {
    public static void main(String[] args) {
        recursividad(1, 10);
    }

    static void recursividad(int i, int x) {
        System.out.println("Entrando a la funcion de recursividad con i = " + i);
        if (i <= x) {
            System.out.println("El valor de i es: " + i);
            System.out.println(i);
            i++;
            System.out.println("Sumando 1 a i para obtener el siguiente numero = " + i);

            System.out.println("Llamando a la recursividad con i = " + i + " y x = " + x);
            System.out.println("------------------------------");
            recursividad(i, x);

        } else {
            System.out.println("Llamada recursiva con i = " + i + " - Condición de salida alcanzada.");
        }
    }
}
