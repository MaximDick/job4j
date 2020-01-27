package ru.job4j.ex;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class FactTest {
    @Test(expected = IllegalArgumentException.class)
    public void thenFactZero() {
        Fact.calc(0);
    }

    @Test
    public void whenFactorial5IsEqualTo11() {
       int rsl =  Fact.calc(5);
       assertThat(rsl, is(120));
    }

}
