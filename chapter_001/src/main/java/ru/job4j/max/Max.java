package ru.job4j.max;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */
 
 public class Max {
     int result;
     /**
      * method max - Максиммум из 2 чисел.
      * @param first первое число.
      * @param second второе число.
      * @return result
      * */
	 public int max(int first, int second){
	      this.result = first > second ? first : second;
	 return this.result;
	 }
 }