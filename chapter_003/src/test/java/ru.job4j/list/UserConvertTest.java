package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertTrue;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class UserConvertTest {
    @Test
    public void whenUsersOfArrayListThenUsersOfHashMap() {
        UserConvert convert = new UserConvert();
        ArrayList<User> list = new ArrayList<>();
        list.add(new User(9,  "Max",  "N.Novgorod"));
        list.add(new User(22, "Alex", "Moscow"));
        HashMap<Integer, User> result = convert.process(list);
        assertTrue(result.containsKey(9));
    }
}
