package ru.job4j.collection.set;

import java.util.HashSet;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class UniqueText {
    public static boolean isEqual(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();

        for (String org: origin) {
            check.add(org);
        }

        for (String str: text) {
            if (!check.contains(str)) {
                rsl = false;
            }

        }
     return rsl;
    }
}
