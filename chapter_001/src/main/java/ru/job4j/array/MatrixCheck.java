package ru.job4j.array;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class MatrixCheck {

    /**
     * Methods mono
     * @param data array.
     * @return result.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int index = 1; index < data.length; index++) {
            if (data[0][0] != data[index][index]) {
                result = false;
                break;
            }

            if (data[0][data.length - 1] != data[index][data.length - 1 - index]) {
                result = false;
                break;
            }
        }
        return result;
    }
}