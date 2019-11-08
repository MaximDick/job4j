package ru.job4j.task;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CountTest {
    @Test
    public void whenInputArrayThenReturnResultCalculation() {
        int[] arr = {1, 2, 3, 5, 6};
        int result = new Count().count(arr);
        int expected = 40;
        assertThat(result, is(expected));
    }

    @Test
    public void whenInputArrayThenReturnCalculationZero() {
        int[] arr = {1, 3, 5, 7};
        int result = new Count().count(arr);
        int expected = 0;
        assertThat(result, is(expected));
    }
}
