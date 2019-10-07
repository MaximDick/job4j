package ru.job4j.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class School {

    /**
     * Method student filtering.
     * @param students - list students.
     * @param predict - filtration condictions.
     * return - list filtered student.*/

    List<Student> collect(List<Student> students, Predicate<Student> predict) {

        return students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }
}
