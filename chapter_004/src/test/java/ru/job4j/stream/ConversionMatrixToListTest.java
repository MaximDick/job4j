package ru.job4j.stream;


import org.junit.Test;

import java.util.Arrays;
import java.util.List;


import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class ConversionMatrixToListTest {

    @Test
    public void whenMatrix2X2ThenList() {
        Integer[][] matrix = {{1, 4, 6}, {8, 9, 22}};
        List<Integer> expected = Arrays.asList(1, 4, 6, 8, 9, 22);
        List<Integer> result = new ConversionMatrixToList().convertMatrixToList(matrix);
        assertThat(result, is(expected));
    }
}
