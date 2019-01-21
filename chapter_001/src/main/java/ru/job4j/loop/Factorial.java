package ru.job4j.loop;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Factorial {
    /**
     * class considers Factorial 120 and Zero.
     * @param start число
     * @return factorial
     */
    public int whenCalculateFactorialForFiveThenOneHundreedTwenty(int start) {
        int factorial = 1;
        for (int i = 1; i <= start; i++) {
            factorial *= i;
        }
        return factorial;
    }

    public int whenCalculateFactorialForZeroThenOne(int start){
        int factorialZero = 1;
        for (int i = 0; i <= start; i++) {
            factorialZero *= i;
        }
        return 1;
    }
}