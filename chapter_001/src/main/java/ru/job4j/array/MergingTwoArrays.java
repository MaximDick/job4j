package ru.job4j.array;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class MergingTwoArrays {

    /**
     *Method merge
     *@param arrayOne array element
     *@param arrayTwo array element
     *@return sumOfTwoArrays
     *count - counter sumOfTwoArrays
     */

    public int[] mergeArrays(int[] arrayOne, int[] arrayTwo) {



        int[] sumOfTwoArrays = new int[arrayOne.length + arrayTwo.length];
        int indexArrayOne = 0, indexArrayTwo = 0, count = 0;

        while (indexArrayOne < arrayOne.length && indexArrayTwo < arrayTwo.length) {
            sumOfTwoArrays[count++] = arrayOne[indexArrayOne] < arrayTwo[indexArrayTwo] ? arrayOne[indexArrayOne++] : arrayTwo[indexArrayTwo++];
        }

        while (indexArrayOne < arrayOne.length) {
            sumOfTwoArrays[count++] = arrayOne[indexArrayOne++];
        }


        while (indexArrayOne < arrayTwo.length) {
            sumOfTwoArrays[count++] = arrayTwo[indexArrayTwo++];
        }

        return sumOfTwoArrays;
    }
}