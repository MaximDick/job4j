package ru.job4j.collection.comparator;

import java.util.Comparator;

public class JobAscendingByName implements Comparator<Job> {
   /**
    * По возратсанию имени.
    */
    @Override
    public int compare(Job o1, Job o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
