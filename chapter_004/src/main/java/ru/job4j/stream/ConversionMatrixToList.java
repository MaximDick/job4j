package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */


public class ConversionMatrixToList {
    /**
     * Convert Matrix to List.
     */
    public List<Integer> convertMatrixToList(Integer[][] matrix) {
        return Arrays.stream(matrix)
               .flatMap(Arrays:: stream).collect(Collectors.toList());

    }

}
