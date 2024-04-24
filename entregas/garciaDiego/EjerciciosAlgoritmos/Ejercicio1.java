import java.util.Scanner;

//Dado un conjunto de números enteros y un entero objetivo, devuelva los índices de dos números que sumados den el objetivo.
//O(n^2) porque hay dos bucles anidados
public class Ejercicio1 {

    public void initEx1() {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of numbers you want to input: ");
        int n = s.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the Number " + (i + 1) + ": ");
            nums[i] = s.nextInt();
        }
        System.out.println("Enter the target number: ");
        int target = s.nextInt();
        int[] result = sumResultEx1(nums, target);
        System.out.println("The index of the numbers that sum up to the target are: " + result[0] + " and " + result[1]);
        s.close();
    }

    public static int[] sumResultEx1(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }
    


    
}
