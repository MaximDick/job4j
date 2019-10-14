package ru.job4j.stream;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Student {

    /**
     *field for storing points.
     * */
    int score;

    String surName;


    public Student(String surName, int score) {
        this.surName = surName;
        this.score = score;
    }

//    public Student(String surName) {
//        this.surName = surName;
//    }

    public int getScore() {
        return score;
    }

    public String getSurName() {
        return surName;
    }
}
