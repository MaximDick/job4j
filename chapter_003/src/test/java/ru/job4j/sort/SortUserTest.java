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
        assertThat(result.iterator().next().getAge(), is(27));
    }

    @Test
    public void whenSortedUserByName() {
        SortUser sortUser = new SortUser();
        List<User> list = new ArrayList<>();
        list.add(new User("Messi", 31));
        list.add(new User("Suarez", 32));
        list.add(new User("Neymar", 27));
        list.add(new User("Xavi", 39));
        list.add(new User("Iniesta", 35));
        List<User> result = sortUser.sortNameLength(list);
        assertThat(result.toString(), is("[Xavi 39, Messi 31, Suarez 32, Neymar 27, Iniesta 35]"));
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
        List<User> result = sortUser.sortByAllFields(list);
        assertThat(result.toString(), is("[Henry 35, Messi 19, Messi 31, Neymar 27, Valdes 39]"));
    }
}
