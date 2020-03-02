package ru.job4j.collection.comparator;

public class StringCompare {
    public int compare(String left, String right) {
        int rsl = 0;
        int minLength = Math.min(left.length(), right.length());

        for (int i = 0; i < minLength; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                rsl = Character.compare(left.charAt(i), right.charAt(i));
                break;
            } else if (rsl == 0) {
                rsl = Integer.compare(left.length(), right.length());
            }
        }
        return rsl;
    }
}
