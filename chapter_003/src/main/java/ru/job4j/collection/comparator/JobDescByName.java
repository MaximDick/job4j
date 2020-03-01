package ru.job4j.collection.comparator;

import java.util.Comparator;

public class JobDescByName implements Comparator<Job> {
    /**
     * По убыванию имени.
     */
    @Override
    public int compare(Job o1, Job o2) {
        return o2.getName().compareTo(o1.getName());
    }
}
