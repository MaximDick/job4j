package ru.job4j.comparator;


import java.util.Comparator;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class ListCompare implements Comparator<String> {
   @Override
    public int compare(String left, String right) {
        int rst = 0;
        int compareLength = Integer.compare(left.length(), right.length());
        for (int index = 0; index < (compareLength > 0 ? right.length() : left.length()); index++) {
            rst = Character.compare(left.charAt(index), right.charAt(index));
            if (rst != 0) {
                break;
            }
       }
        // Если длина части слова разная, но короткое слово совпадает с частью длинного
       if (rst == 0 && compareLength != 0) {
           rst = compareLength;
       }
       return rst;
   }
}
