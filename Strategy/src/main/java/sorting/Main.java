package sorting;

import sorting.context.Sorter;
import sorting.strategy.*;
import sorting.util.DataGenerator;

public class Main {

    public static void main(String[] args) {

        int smallSize = 30;
        int largeSize = 100000;

        int[] smallArray = DataGenerator.generateRandomArray(smallSize);
        int[] largeArray = DataGenerator.generateRandomArray(largeSize);

        SortStrategy[] strategies = {
                new QuickSortStrategy(),
                new MergeSortStrategy(),
                new HeapSortStrategy()
        };

        Sorter sorter = new Sorter();

        System.out.println("=== SMALL DATASET (" + smallSize + ") ===");
        testStrategies(sorter, strategies, smallArray);

        System.out.println("\n=== LARGE DATASET (" + largeSize + ") ===");
        testStrategies(sorter, strategies, largeArray);
    }

    private static void testStrategies(Sorter sorter, SortStrategy[] strategies, int[] original) {

        for (SortStrategy strategy : strategies) {

            int[] copy = original.clone();
            sorter.setStrategy(strategy);

            long start = System.nanoTime();
            sorter.sort(copy);
            long end = System.nanoTime();

            long time = end - start;

            System.out.println(strategy.getClass().getSimpleName()
                    + " -> " + time + " ns");
        }
    }
}