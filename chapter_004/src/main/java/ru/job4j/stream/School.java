package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    /**
     * Convert List to Map.
     */

    Map<String, Student> convertListToMap(List<Student> students) {
        return students.stream().collect(Collectors.toMap(
                Student::getSurName,
                student -> student
        ));
    }

//    List<Student> levelOf(List<Student> students, int bound) {
//        return students
//                .stream()
//                .flatMap(Stream::ofNullable)
//                .takeWhile(x -> x.getScore() > bound)
//                .collect(Collectors.toList());

    public List<Student> levelOf(List<Student> students, int bound) {
        return students.stream().sorted(Comparator.nullsLast(Student::compareTo))
                .flatMap(Stream::ofNullable).takeWhile(s -> s.score > bound)
                .collect(Collectors.toList());
    }
}
