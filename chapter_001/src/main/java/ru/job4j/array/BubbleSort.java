package ru.job4j.array;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class BubbleSort {

    /**
     * class BubbleSort.
     * @param array numbers.
     * @return  array sort numbers.
     **/

    public int[] bubbleSortNumbers(int[] array) {
        for (int out = array.length - 1; out > 1; out--) {
        for (int in = 0; in < array.length - 1; in++) {
            if (array[in] > array[in + 1]) {
                int temp;
                temp = array[in];
                array[in] = array[in + 1];
                array[in + 1] = temp;
            }
        }
    }
        return array;
    }
}