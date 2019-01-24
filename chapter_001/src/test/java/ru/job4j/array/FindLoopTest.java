package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static  org.junit.Assert.assertThat;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class FindLoopTest {
    @Test
    public void whenArrayHasLenght5Then0() {
        FindLoop find = new FindLoop();
        int[] input =  new int[] {5, 10, 3};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = 0;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHasLenght22Then4() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {1, 19, 54, 9, 22, 89, 8};
        int value = 22;
        int result = find.indexOf(input, 22);
        int expect = 4;
        assertThat(result, is(expect));
    }

    @Test
    public void whenArrayHasLengthMinusOne() {
        FindLoop find = new FindLoop();
        int[] input = new int[] {2, 4, 66, 8};
        int value = 5;
        int result = find.indexOf(input, value);
        int expect = -1;
        assertThat(result, is(expect));
    }

}