public class Recursive {
  public static void printNumbersAscendent(int n) {
    if (n > 0) {
      printNumbersAscendent(n - 1);
      System.out.println("Calling printNumbersAscendent(" + (n - 1) + ")");
      System.out.println("Printing " + n);
    }
  }

  public static void printNumbersDescendent(int n) {
    if (n > 0) {
      System.out.println("Printing " + n);
      System.out.println("Calling printNumbersDescendent(" + (n - 1) + ")");
      printNumbersDescendent(n - 1);
    }
  }

  public static int sumNumbers(int n) {
    if (n > 0) {
      int sum = n + sumNumbers(n - 1);
      System.out.println("Calling sumNumbers(" + (n - 1) + ")");
      System.out.println("Returning " + sum + " adding " + n );
      return sum;
    }
    System.out.println("Returning " + n);
    return n;
  }

  public static void main(String[] args) {
    printNumbersAscendent(5);
    System.out.println("---------------");
    printNumbersDescendent(5);
    System.out.println("---------------");
    System.out.println(sumNumbers(5));
    System.out.println("---------------");
  }
}