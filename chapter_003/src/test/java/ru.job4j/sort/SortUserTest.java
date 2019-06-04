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
    public void whenSortedUserByAge(){
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
}
