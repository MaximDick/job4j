package ru.job4j.tracker.singleton;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class TrackerSingleThreeTest {
    @Test
    public void whenTwoTrackerEnumsAreEqual() {
        TrackerSingleThree first = TrackerSingleThree.getInstance();
        TrackerSingleThree second = TrackerSingleThree.getInstance();
        assertThat(first, is(second));
    }
}