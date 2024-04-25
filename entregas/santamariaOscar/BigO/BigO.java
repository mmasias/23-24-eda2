package BigO;
/**
 * BigO
 */
public class BigO {

    public static void main(String[] args) {
        int[] nums = { 3, 2, 9, 8 };
        int objetivo = 12;
        int[] resultado = encontrarSuma(nums, objetivo);


        System.out.println("Índices de los números que suman " + objetivo + ": " + resultado[0] + " y " + resultado[1]);
    }
   
    public static int[] encontrarSuma(int[] nums, int objetivo) {
        
        for (int i = 0; i < nums.length - 1; i++) {         //O(n)
            for (int j = i + 1; j < nums.length; j++) {     //O(n2)

                if (nums[i] + nums[j] == objetivo) {     //O(n2)
                    return new int[] { i, j };          //o(1)
                }
            }
        }
        return new int[]{-1,-1};    //O(1)
    }

    //La complejidad de este algoritmo es O(n2) ya que el peor caso es que se recorran todos los elementos del arreglo
}
