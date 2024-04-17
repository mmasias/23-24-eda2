public class TraceRecursiveNumbers {
    public static void main(String[] args) {
        int target = 10;
        recursiveNumbers(1, target);
    }
    
    private static void recursiveNumbers(int current, int target) {
        System.out.println("Called recursiveNumbers from " + current + " to " + target);
        if (current > target) {
            System.out.println("Target reached, returning to main.");
            return;
        }
        System.out.println("Status: " + current);
        recursiveNumbers(current + 1, target);
    }
}