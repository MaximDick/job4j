package ru.job4j.condition;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class PointTest {
    @Test
    public void calculatedDistanceBetween2Points() {
        Point point1 = new Point(7,9);
        Point point2 = new Point(4,5);
        double result = point1.distanceTo(point2);
        assertThat(result, closeTo(5.0, 0.1));
    }
}
