package ru.job4j.array;

import java.util.Arrays;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class ArrayDuplicate {
    /**
     * method removeDuplicates.
     * @param array input elements.
     * @return array without duplicates
     */
    public String[] removeDuplicates(String[] array) {
        int unique = array.length;
        for (int out = 0; out < unique; out++) {
            for (int in = out + 1; in < unique; in++) {
                if (array[out].equals(array[in])) {
                    array[in] = array[unique - 1];
                    unique--;
                    in--;
                }
            }
        }
        return Arrays.copyOf(array, unique);
    }
}