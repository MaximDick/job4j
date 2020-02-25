package ru.job4j.collection.set;

import java.util.HashSet;
import java.util.List;

public class FullSearch {
    public static HashSet<String> extractNumber(List<TaskSet> list) {
        HashSet<String> numbers = new HashSet<>();
        for (TaskSet ls : list) {
            numbers.add(ls.getNumber());
        }
        return numbers;
    }
}
