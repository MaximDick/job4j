package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserTest {
    @Test
    public void whenTwoEqualsTrue() {
        User first = new User("Dima", "0987654");
        User second = new User("Dima", "0987654");
        assertThat(first.equals(second), is(true));
    }
}
