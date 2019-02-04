package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class MergingTwoArrayTest {

    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        MergingTwoArrays sort = new MergingTwoArrays();
        int[] inputOne =  new int[] {1, 2, 5, 8};
        int[] inputTwo =  new int[] {3, 4, 6};
        int[] result = sort.mergeArrays(inputOne, inputTwo);
        int[] expects = new int[] {1, 2, 3, 4, 5, 6, 8};
        assertThat(result, is(expects));
    }
}