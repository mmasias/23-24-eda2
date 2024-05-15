package tests;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class SleepSort {
    public static void sleepSort(int[] numbers, Consumer<int[]> callback) {
        AtomicInteger index = new AtomicInteger(0);
        Thread[] threads = new Thread[numbers.length];
        int[] sortedNumbers = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            final int number = numbers[i];
            final int currentIndex = i;
            threads[i] = new Thread(() -> {
                try {
                    Thread.sleep(number * 8);
                    synchronized (sortedNumbers) {
                        sortedNumbers[index.getAndIncrement()] = numbers[currentIndex];
                        callback.accept(sortedNumbers.clone());
                    }
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
}
