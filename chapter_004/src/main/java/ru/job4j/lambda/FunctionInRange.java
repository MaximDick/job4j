package ru.job4j.lambda;


import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class FunctionInRange {
    public List<Double> diapason(int start, int finish, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (int index = start; index != finish; index++) {
            result.add(
                    func.apply((double) index)
            );
        }
        return result;
    }
}
