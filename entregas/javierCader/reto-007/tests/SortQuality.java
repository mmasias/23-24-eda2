package tests;

public class SortQuality {

    public static double sortedPercentage(int[] array) {
        if (array.length < 2) return 100.0;

        int sortedPairs = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] <= array[i + 1]) {
                sortedPairs++;
            }
        }

        double percentageSorted = ((double) sortedPairs / (array.length - 1)) * 100;
        return percentageSorted;
    }
}
