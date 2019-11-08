package ru.job4j.sort;

import org.junit.Test;

import java.util.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class SortUserTest {

    @Test
    public void whenSortedUserByAge() {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
                list.add(new User("Messi", 31));
                list.add(new User("Suarez", 32));
                list.add(new User("Neymar", 27));
                list.add(new User("Xavi", 39));
                list.add(new User("Iniesta", 35));

        Set<User> result = sortUser.sort(list);
        List<User> expected = List.of(
                new User("Neymar", 27),
                new User("Messi", 31),
                new User("Suarez", 32),
                new User("Iniesta", 35),
                new User("Xavi", 39)
        );
        assertThat(result.toString(), is(expected.toString()));
    }

    @Test
    public void whenSortedUserByName() {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
                list.add(new User("Suarez", 32));
                list.add(new User("Ronaldinho", 39));
                list.add(new User("Messi", 31));

        List<User> result = sortUser.sortNameLength(list);
        List<User> expected = List.of(
                new User("Messi", 31),
                new User("Suarez", 32),
                new User("Ronaldinho", 39)
        );
        assertThat(result.toString(), is(expected.toString()));
    }

    @Test
    public void whenSortedUserByFields() {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
        list.add(new User("Messi", 31));
        list.add(new User("Messi", 19));
        list.add(new User("Neymar", 27));
        list.add(new User("Valdes", 39));
        list.add(new User("Henry", 35));
        list.add(new User("Henry", 30));

        List<User> result = sortUser.sortByAllFields(list);

        List<User> expected = List.of(
                new User("Henry", 30),
                new User("Henry", 35),
                new User("Messi", 19),
                new User("Messi", 31),
                new User("Neymar", 27),
                new User("Valdes", 39)
        );
        assertThat(result.toString(), is(expected.toString()));
    }
}
