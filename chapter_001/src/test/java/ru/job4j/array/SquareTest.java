package ru.job4j.array;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class SquareTest {
    @Test
    public void whenBound3Then149() {
        int bound = 3;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[]{1, 4, 9};
        assertThat(rst, is(expect));
    }

    @Test
    public void whenBound6Then149162536() {
        int bound = 6;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[]{1, 4, 9, 16, 25, 36};
        assertThat(rst, is(expect));
    }

    @Test
    public void whenBound8Then1491625364964() {
        int bound = 8;
        Square square = new Square();
        int[] rst = square.calculate(bound);
        int[] expect = new int[]{1, 4, 9, 16, 25, 36, 49, 64};
        assertThat(rst, is(expect));
    }


}
