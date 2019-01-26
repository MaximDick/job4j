package ru.job4j.array;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Matrix {
    /**
     * class Matrix multiplication table.
     * @param size SIZE Table.
     * @return multiplication table
     */

    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int indexOne = 0; indexOne < table.length; indexOne++) {
            for (int indexTwo = 0; indexTwo < table.length; indexTwo++) {
                table[indexOne][indexTwo] = (indexOne + 1) * (indexTwo + 1);
            }
        }
        return table;
    }
}