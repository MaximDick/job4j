package ru.job4j.calculator;
/**
 * Class для вычисления арифметических операций +,-,/,*.
 * @author Maxim Dick (maxim1994barca@gmail.com).
 * @version $Id$.
 * @since 0.1.
 */

public class Calculator {
	private double result;
	/**
	 * метод Add - сложение двух чисел.
	 * @param first первое слагаемое.
	 * @param second - второе слагаемое.
     */
	public void add(double first, double second) {
		this.result = first + second;
    }
	/**
	 * Возвращает результат
     */
    public double getResult() {
		return this.result;
	}
	/**
	 * Вычисляет разность двух чисел
     */
	public void subtract(double first, double second) {
		this.result = first - second;
	}
	/**
	 * Вычисляет частное
     */
	public  void div(double first, double second) {
		this.result = first / second;
	}
	/**
	 * вычисляет произведение двух чисел
     */
	public void multiple(double first, double second) {
		this.result = first * second;
	}
}