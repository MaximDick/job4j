package ru.job4j.department;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class DepartmentSortedTest {

    @Test
    public void whenGetUnsorttedListThenSortByDeptAsc() {
    DeptSort deptSort = new DeptSort();
    List<Org> depts = new ArrayList<>();
    depts.add(new Org("K1\\S2"));
    depts.add(new Org("K1\\S1\\D13"));
    depts.add(new Org("K2\\S2"));
    List<Org> result = deptSort.sortAsc(depts);
    List<Org> expected = new ArrayList<>();
    expected.add(new Org("K1"));
    expected.add(new Org("K1\\S1"));
    expected.add(new Org("K1\\S1\\D13"));
    expected.add(new Org("K1\\S2"));
    expected.add(new Org("K2"));
    expected.add(new Org("K2\\S2"));
    assertThat(result, is(expected));
    }

    @Test
    public void whenGetUnsorttedListThenSortByDeptDesc() {
        DeptSort deptSort = new DeptSort();
        List<Org> depts = new ArrayList<>();
        depts.add(new Org("K1\\S2"));
        depts.add(new Org("K1\\S1\\D13"));
        depts.add(new Org("K2\\S2"));
        List<Org> result = deptSort.sortDesc(depts);
        List<Org> expected = new ArrayList<>();
        expected.add(new Org("K2"));
        expected.add(new Org("K2\\S2"));
        expected.add(new Org("K1"));
        expected.add(new Org("K1\\S2"));
        expected.add(new Org("K1\\S1"));
        expected.add(new Org("K1\\S1\\D13"));
        assertThat(result, is(expected));
    }

    @Test
    public void whenGetFourNodesStringWhenSetFourNodes() {
        DeptSort deptSort = new DeptSort();
        List<Org> depts = new ArrayList<>();
        depts.add(new Org("K2\\S2\\D11\\M23"));
        List<Org> result = deptSort.appendAllNodes(depts);
        assertThat(result.size(), is(4));

    }
}
