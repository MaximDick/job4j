package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
    private List<Student> students = Arrays.asList(new Student(45),
            new Student(58),
            new Student(85),
            new Student(74),
            new Student(90),
            new Student(65));

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
}