package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */
 
 public class MaxTest {
	 @Test
	 public void whenFirstLessSecond(){
		 Max maxim = new Max();
		 int result = maxim.max(8,2,6);
		 assertThat(result, is(8));
	 }
 }