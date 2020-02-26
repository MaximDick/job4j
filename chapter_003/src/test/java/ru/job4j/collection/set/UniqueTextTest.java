package ru.job4j.collection.set;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UniqueTextTest {
    @Test
    public void isEqual() {
        String origin = "My cat eats a mouse";
        String text = "My cat eats a mouse";
        assertThat(UniqueText.isEqual(origin, text), is(true));
    }

    @Test
    public void isNotEqual() {
        String origin = "My cat eats a mouse";
        String text = "A mouse is eaten by a cat";
        assertThat(UniqueText.isEqual(origin, text), is(false));
    }
}
