package ru.job4j.max;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */
 
 public class Max {
     /**
      * method max - Максиммум из 3 чисел.
      * @param first первое число.
      * @param second второе число.
      * @param third третье число.
      * @return max(first or second or third).
      * */

	 public int max(int first, int second, int third){
	     return Math.max(Math.max(first, second),third);

	 }
}