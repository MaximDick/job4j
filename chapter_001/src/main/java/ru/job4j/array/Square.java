package ru.job4j.array;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Square {
    /**
     * method calculate squares numbers.
     * @param bound numbers.
     * @return rst.
     */

    public int[] calculate(int bound) {
        int[] rst = new int[bound];

        for (int index = 0; index != bound; index++) {
            rst[index] = (index + 1) * (index + 1);
        }
        return rst;
    }
}