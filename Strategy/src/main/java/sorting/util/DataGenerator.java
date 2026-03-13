package sorting.util;

import java.util.Random;

public class DataGenerator {

    public static int[] generateRandomArray(int size) {

        Random random = new Random();

        int[] array = new int[size];

        for (int i = 0; i < size; i++) {

            array[i] = random.nextInt(100000);
        }

        return array;
    }
}