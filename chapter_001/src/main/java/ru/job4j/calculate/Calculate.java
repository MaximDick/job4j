package ru.job4j.calculate;

/**
 * Class Calculate display a message : "Hello World" 
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @since 0.1
*/

public class Calculate {
	/**
	 * Main.
	 * @param args - args.
	 */
	public static void main(String[]args) {
		System.out.println("Hello World!!!");
	}
	/**
     * Method echo.
     * @param name Your name.
     * @return Echo plus your name.
     */
    public String echo(String name) {
        return "Echo, echo, echo : " + name;
    }
}