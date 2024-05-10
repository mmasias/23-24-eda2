public class ExerciseOne {
    public static void SearchSumIndex(int target){
        int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] response = twoSum(nums, target);
        System.out.println("Los índices de los números que suman " + target +  " son: " + response[0] + " y " + response[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }

        throw new IllegalArgumentException("No hay dos números que sumen el objetivo");
    }
}
