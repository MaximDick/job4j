package ru.job4j.collection.set;

import java.util.HashSet;
import java.util.List;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class FullSearch {
    public static HashSet<String> extractNumber(List<TaskSet> list) {
        HashSet<String> numbers = new HashSet<>();
        for (TaskSet ls : list) {
            numbers.add(ls.getNumber());
        }
        return numbers;
    }
}
