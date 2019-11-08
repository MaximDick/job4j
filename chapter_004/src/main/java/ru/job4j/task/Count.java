package ru.job4j.task;

import java.util.Arrays;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Count {
   public int count(int[] arr) {
       return Arrays
               .stream(arr)
               .filter(x -> x % 2 == 0)
               .map(x -> x * x)
               .reduce(0, (a1, a2) -> a1 + a2);
    }
}
