package ru.job4j.collection.comparator;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class JobTest {
    @Test
    public void whenComaparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobDescByName().thenComparing(new JobDescByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenComparatorByNameAndPriority() {
        Comparator<Job> cmpNamePriority = new JobAscendingByName().thenComparing(new JobAscendingByPriority());
        int rsl = cmpNamePriority.compare(
                new Job("Impl task", 0),
                new Job("Fix bug", 1)
        );
        assertThat(rsl, greaterThan(0));
    }
    @Test
    public void whenSortAbcAndPriority() {
        List<Job> jobs = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Fix bug", 4),
                new Job("Fix bug", 2),
                new Job("X task", 0)
        );
        List<Job> result = Arrays.asList(
                new Job("Fix bug", 1),
                new Job("Fix bug", 2),
                new Job("Fix bug", 4),
                new Job("X task", 0)
        );
        Collections.sort(jobs, new JobAscendingByName().thenComparing(new JobAscendingByPriority()));
        assertThat(jobs.toString(), is(result.toString()));
    }

    @Test
    public void whenDescByName() {
        Comparator<Job> cmpName = new JobDescByName();
        int rsl = cmpName.compare(
                new Job("Impl task", 0),
                new Job("Bug", 7)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenIncByName() {
        Comparator<Job> cmpName = new JobAscendingByName();
        int rsl = cmpName.compare(
                new Job("Bug", 7),
                new Job("Impl task", 0)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenDescByPriority() {
        Comparator<Job> cmpPriority = new JobDescByPriority();
        int rsl = cmpPriority.compare(
                new Job("Bug", 5),
                new Job("Bug", 2)
        );
        assertThat(rsl, lessThan(0));
    }

    @Test
    public void whenIncByPriority() {
        Comparator<Job> cmpPriority = new JobAscendingByPriority();
        int rsl = cmpPriority.compare(
                new Job("Bug", 2),
                new Job("Bug", 5)
        );
        assertThat(rsl, lessThan(0));
    }

}
