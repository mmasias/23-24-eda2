package tests;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class SleepSort {
    public static void sleepSort(int[] numbers) {
        AtomicInteger index = new AtomicInteger(0);
        Thread[] threads = new Thread[numbers.length];
        int[] sortedNumbers = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            final int number = numbers[i]; 
            threads[i] = new Thread(() -> {
                try {
                    Thread.sleep(number * 8);
                    sortedNumbers[index.getAndIncrement()] = number;
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    System.out.println("Thread interrupted: " + e.getMessage());
                }
            });
            threads[i].start();
        }

        for (Thread t : threads) {
            try {
                t.join(); 
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Failed to join thread: " + e.getMessage());
            }
        }

        System.arraycopy(sortedNumbers, 0, numbers, 0, numbers.length);
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[100];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100) + 1; 
        }

        long startTime = System.currentTimeMillis();
        sleepSort(numbers);
        long endTime = System.currentTimeMillis();

        System.out.println("Sorting took " + (endTime - startTime) + " ms");

        double sortQualityPercentage = tests.SortQuality.sortedPercentage(numbers);
        System.out.println("The array is " + String.format("%.2f", sortQualityPercentage) + "% sorted.");
    }
}
