package ru.job4j.sort;


import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class SortUser {
/**
 * Sort by age.
 * @param list
 * @return new TreeSet<>(list)
 * */

public Set<User> sort(List<User> list) {
    return new TreeSet<>(list);
    }
}
