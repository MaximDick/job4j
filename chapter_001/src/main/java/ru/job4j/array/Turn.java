package ru.job4j.array;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Turn {
    /**
     * @param array  value
     * method backNotEven and backNotEven2variant считают для нечетного количества
     * method backNotEven использовал середину массива.
     * */

    public int[] back(int[] array) {
        for (int index = 0; index < array.length; index++) {
            int temp = array[index];
            array[index] = array[array.length - 1 - index];
            array[array.length - 1 - index] = temp;
            index++;
        }
        return array;
    }

    public int[] backNotEven(int[] array) {
        //(array.length + 1) / 2  середина массива
        for (int i = 0; i < (array.length + 1) / 2; i++) {
            int j = array.length - 1;
            int temp = array[i];
            array[i] = array[j - i];
            array[j - i] = temp;
        }
        return array;
    }

    public int[] backNotEven2variant(int[] array) {
        int j = array.length - 1;
        for (int index = 0; index < j; index++, j--) {
            int temp = array[index];
            array[index] = array[j];
            array[j] = temp;
        }
        return array;
    }
}