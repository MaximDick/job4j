package ru.job4j.collection.comparator;

import java.util.Comparator;

public class JobAscendingByPriority implements Comparator<Job> {
   /**
    * По возрастанию преиоритета.
    */
    public int compare(Job o1, Job o2) {
        return Integer.compare(o1.getPriority(), o2.getPriority());
    }
}
