package sorting.context;

import sorting.strategy.SortStrategy;

public class Sorter {

    private SortStrategy strategy;

    public void setStrategy(SortStrategy strategy) {
        this.strategy = strategy;
    }

    public void sort(int[] array) {

        if (strategy == null) {
            throw new IllegalStateException("Sorting strategy not set");
        }

        strategy.sort(array);
    }
}