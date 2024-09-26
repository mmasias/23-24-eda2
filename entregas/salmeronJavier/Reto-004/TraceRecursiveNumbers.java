public class TraceRecursiveNumbers {
    public static void main(String[] args) {
        int target = 10;
        recursiveNumbers(1, target);

        System.out.println("Hello from main!");
    }
    
    private static void recursiveNumbers(int current, int target) {
        System.out.println("\nCalled recursiveNumbers from " + current + " to " + target);
        if (current > target) {
            System.out.println("Target reached, returning to main.\n");
            return;
        }
        System.out.println("Status: " + current);
        recursiveNumbers(current + 1, target);
    }
}