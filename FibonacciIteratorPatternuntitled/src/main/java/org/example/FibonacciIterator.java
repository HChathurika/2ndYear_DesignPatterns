package org.example;

import java.util.Iterator;

public class FibonacciIterator implements Iterator<Integer> {

    private int previous = 0;
    private int current = 1;

    /*
     * I keep the Fibonacci calculation state inside the iterator.
     * This is better because each iterator can work independently.
     * If the state was stored in FibonacciSequence, many iterators could share
     * the same state and affect each other.
     */

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public Integer next() {
        int nextNumber = current;
        int newCurrent = previous + current;

        previous = current;
        current = newCurrent;

        return nextNumber;
    }
}