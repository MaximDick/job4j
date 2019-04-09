package ru.job4j.tracker.singleton;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class TrackerSingleFourTest {
    @Test
    public void whenTwoTrackerEnumsAreEqual() {
        TrackerSingleFour first = TrackerSingleFour.getInstance();
        TrackerSingleFour second = TrackerSingleFour.getInstance();
        assertThat(first, is(second));
    }
}