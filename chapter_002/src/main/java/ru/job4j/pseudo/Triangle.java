package ru.job4j.pseudo;

public class Triangle implements Shape {

    /**
     * @author Maxim Dick (maxim1994barca@gmail.com)
     * @version $Id$
     * @since 0.1
     */

    /**
     * Method draw рисует треугольник.
     * @return pic.toString().
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
            pic.append("  +");
            pic.append(System.lineSeparator());
            pic.append(" +++");
            pic.append(System.lineSeparator());
            pic.append("+++++");
            pic.append(System.lineSeparator());
        return pic.toString();
    }

}