package ru.job4j.array;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Check {
    /**
     * class Check
     * @param data array true/false.
     * @return result.
     **/

    public boolean mono(boolean[] data) {
        boolean result = false;
        for (int index = 0; index < data.length - 1; index++) {
            if (!data[index]) {
                result = false;
            } else {
                result = true;
            }
        }
        return result;
    }
}