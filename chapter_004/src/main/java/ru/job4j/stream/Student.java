package ru.job4j.stream;

import java.util.Comparator;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Student implements Comparable<Student> {

    /**
     *field for storing points.
     * */
    int score;
    String name;
    String surName;


    public Student(String surName, int score) {
        this.surName = surName;
        this.score = score;
    }

    public Student(String name, String surName, int score) {
        this.name = name;
        this.surName = surName;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }


    @Override
    public int compareTo(Student o1) {
        int result = 0;
        result = this.score < o1.score ? 1 : -1;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        Student other = (Student) obj;
        if (this == obj || (this.score == other.score
                && this.name.equals(other.name))) {
            result = true;
        }
        return result;
    }

    @Override
    public int hashCode() {
        return 17 * this.score + this.name.hashCode();
    }
}

