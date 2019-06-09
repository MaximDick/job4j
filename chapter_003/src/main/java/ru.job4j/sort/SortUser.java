package ru.job4j.sort;


import java.util.*;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class SortUser {
/**
 * Sort by age.
 * @param list
 * @return new TreeSet<>(list)
 * */

public Set<User> sort(List<User> list) {
    return new TreeSet<>(list);
    }

    public List<User> sortNameLength(List<User> users) {
        Collections.sort(users, new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                return o1.getName().length() - o2.getName().length();
                }
            }
        );
        return users;
    }

    public List<User> sortByAllFields(List<User> list) {
        Collections.sort(list,
                new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                int rst1 = o1.getName().compareTo(o2.getName());
                return rst1 != 0 ? rst1 : o1.compareTo(o2);
                }
            }
        );
        return list;
    }
}
