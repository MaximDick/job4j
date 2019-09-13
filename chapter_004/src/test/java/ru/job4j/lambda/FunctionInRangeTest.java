package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class FunctionInRangeTest {

    @Test
    public void whenLinerFromOneToFive() {
        FunctionInRange function = new FunctionInRange();
        List<Double> result = function.diapason(5, 8,
                x -> 2 * x + 1
        );
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        FunctionInRange func = new FunctionInRange();
        List<Double> result = func.diapason(4, 7,
                x -> Math.pow(x, 2) + 2 * x + 1
        );
        List<Double> expected = Arrays.asList(25D, 36D, 49D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenLogFromOneToThree() {
        FunctionInRange func = new FunctionInRange();
        List<Double> result = func.diapason(1, 3,
                Math::log
        );
        List<Double> expected = Arrays.asList(0D, 0.6931471805599453D);
        assertThat(result, is(expected));
    }
}
