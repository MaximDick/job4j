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
        for (int index = 0; index < array.length - 1; index++) {
            if (array[index] > array[index + 1]) {
                int temp;
                temp = array[index];
                array[index] = array[index + 1];
                array[index + 1] = temp;
            }
        }
    }
        return array;
    }
}