package ru.job4j.department;

import java.util.*;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

class DeptSort {

    private final Comparator<Org> deptAscComparator = (org1, org2) -> {
        int min = Math.min(org1.length(), org2.length());
        int result = 0;
        for (int i = 0; i < min; i++) {
            if (!org1.get(i).equals(org2.get(i))) {
                result = org1.get(i).compareTo(org2.get(i));
                break;
            }
        }
        if (result == 0) {
            result = (org1.length() - org2.length());
        }
        return result;
    };


    private final Comparator<Org> deptDescComparator = (org1, org2) -> {

        int min = Math.min(org1.length(), org2.length());
        int result = 0;
        for (int i = 0; i < min; i++) {
            if (!org2.get(i).equals(org1.get(i))) {
                result = org2.get(i).compareTo(org1.get(i));
                break;
            }
        }
        if (result == 0) {
            result = (org1.length() - org2.length());
        }
        return result;
    };


    public List<Org> sort(List<Org> orgs, Comparator<Org> comparator) {
        orgs = appendAllNodes(orgs);
        orgs.sort(comparator);
        return orgs;
    }

    public List<Org> sortAsc(List<Org> orgs) {

        return sort(orgs, deptAscComparator);
    }

    public List<Org> sortDesc(List<Org> orgs) {

        return sort(orgs, deptDescComparator);
    }

    protected List<Org> appendAllNodes(List<Org> orgs) {
        Set<Org> result = new HashSet<>();
        for (Org org : orgs) {
            StringBuilder path = new StringBuilder();
            for (String s : org.getDepts()) {
                if (path.length() != 0) {
                    path.append("\\");
                }
                path.append(s);
                result.add(new Org(path.toString()));
            }
        }
        List<Org> list = new ArrayList<>();
        list.addAll(result);
        return list;
    }
}
