package ru.job4j.department;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static java.io.File.separator;

public class Org {

    private static final String SEPARATOR = "\\\\";
    private final List<String> depts;

    public Org(String initString) {
        this.depts = Arrays.asList(initString.split(SEPARATOR));
    }

    public List<String> getDepts() {
        return this.depts;
    }

    public int length() {
        return this.depts.size();
    }

    public String get(int index) {
        return this.depts.get(index);
    }

    @Override
    public String toString() {
        return depts.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Org org = (Org) o;
        return Objects.equals(depts, org.depts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(depts);
    }
}
