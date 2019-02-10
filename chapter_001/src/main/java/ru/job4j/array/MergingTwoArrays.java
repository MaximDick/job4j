package ru.job4j.array;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class MergingTwoArrays {
    /**
     *Method merge
     *@param arrayOne array element.
     *@param arrayTwo array element.
     *@return result array elements.
     *count - counter sumOfTwoArrays.
     */

    public int[] mergeArrays(int[] arrayOne, int[] arrayTwo) {

        int[] result = new int[arrayOne.length + arrayTwo.length];
        int indexArray1 = 0, indexArrayTwo = 0, count = 0;

        while (indexArray1 < arrayOne.length && indexArrayTwo < arrayTwo.length) {
            result[count++] = arrayOne[indexArray1] < arrayTwo[indexArrayTwo] ? arrayOne[indexArray1++] : arrayTwo[indexArrayTwo++];
        }

        while (indexArray1 < arrayOne.length) {
            result[count++] = arrayOne[indexArray1++];
        }

        while (indexArrayTwo < arrayTwo.length) {
            result[count++] = arrayTwo[indexArrayTwo++];
        }
        return result;
    }
}