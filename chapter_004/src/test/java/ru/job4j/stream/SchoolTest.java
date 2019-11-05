package ru.job4j.stream;

import org.junit.Test;

import java.util.*;
import java.util.function.Predicate;


import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class SchoolTest {

    /**
     * Object school.*/
     private School school = new School();

    /**
     * Students list.
     */
    private List<Student> students = List.of(
            new Student("Ivanov", 45),
            new Student("Cheryshev", 58),
            new Student("Arshavin", 85),
            new Student("Fedorov", 74),
            new Student("Fetisov", 90),
            new Student("Stalin", 65));

    /**
     * Getting a filtered list of class A.*/
    @Test
    public void whenFilterClassAThenListClassA() {
        List<Student> expected = new ArrayList<>();
        Predicate<Student> predicate1 = student -> student.getScore() > 70;
        Predicate<Student> predicate2 = student -> student.getScore() < 100;
        List<Student> result = school.collect(students, predicate1.and(predicate2));
        for (Student student: students) {
            if (student.getScore() > 70 && student.getScore() < 100) {
                expected.add(student);
            }
        }
        assertThat(result, is(expected));
    }

    /**
     * Getting a filtered list of class B.
     */

    @Test
    public void whenFilterClassBThenListClassB() {
        List<Student> expected = new ArrayList<>();
        Predicate<Student> predicate1 = student -> student.getScore() > 50;
        Predicate<Student> predicate2 = student -> student.getScore() < 70;
        List<Student> result = school.collect(students, predicate1.and(predicate2));
        for (Student student: students) {
            if (student.getScore() > 50 && student.getScore() < 70) {
                expected.add(student);
            }
        }
        assertThat(result, is(expected));
    }

    /**
     * Getting a filtered list of class B.
     */
    @Test
    public void whenFilterClassCThenListClassC() {
        List<Student> expected = new ArrayList<>();
        Predicate<Student> predicate1 = student -> student.getScore() < 50;
        Predicate<Student> predicate2 = student -> student.getScore() > 0;
        List<Student> result = school.collect(students, predicate1.and(predicate2));
        for (Student student: students) {
            if (student.getScore() > 0 && student.getScore() < 50) {
                expected.add(student);
            }
        }
        assertThat(result, is(expected));
    }


    @Test
    public void whenListToMap() {
        School school = new School();
        List<Student> list = new ArrayList<>();
        list.add(new Student("Messi", 94));
        list.add(new Student("Ronaldo", 93));
        list.add(new Student("Pelle", 91));
        list.add(new Student("Cheryshev", 88));
        list.add(new Student("Xavi", 98));
        Map<String, Student> result = school.convertListToMap(list);
        assertThat(result.get("Messi").getScore(), is(94));
    }

    @Test
    public void whenScoreMoreBoundThan() {
          List<Student> result = school.levelOf(students, 85);
        assertThat(result.size(), is(1));
    }


}