package tests;

import java.util.Random;

public class SleepSort {

    public static void sleepSort(int[] numbers) {
        Thread[] threads = new Thread[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            final int number = numbers[i]; 
            threads[i] = new Thread(() -> {
                try {
                    Thread.sleep(number * 2);
                    System.out.println(number);
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
    }

    public static void main(String[] args) {
        Random rand = new Random();
        int[] numbers = new int[1000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rand.nextInt(100) + 1; 
        }


        long startTime = System.currentTimeMillis();
        sleepSort(numbers);
        long endTime = System.currentTimeMillis();

        System.out.println("Sorting took " + (endTime - startTime) + " ms");
    }
}
