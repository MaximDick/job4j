package ru.job4j.loop;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

class Counter {
	/**
	 * class Counter add numbers 1 - 10.  Summa30.
	 * @param start
	 * @param finish
	 * @return result.
	 * */
	public int add(int start, int finish) {
		int result = 0;
		for (int index = start; index <= finish; index++) {
			if (index % 2 == 0) {
				result += index;
			}
		}
		return result;
	}
}