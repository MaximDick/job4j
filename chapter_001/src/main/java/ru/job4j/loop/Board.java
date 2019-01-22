package ru.job4j.loop;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Board {
    /**
     * class Board 3x3 and 4x5.
     * @param width ширина доски.
     * @param height высота доски.
     * @return screen.toString()
     * */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        int i; int j;
        for (i = 0; i < width; i++) {
            for (j = 0; j < height; j++) {

                // условие проверки, что писать пробел или X
                // Выше в задании мы определили закономерность,
                // когда нужно проставлять X.
                //i = width;
                //j = height;
                int sum = i + j;
                if ((sum) % 2 == 0) {
                        screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            // добавляем перевод на новую строку.
            screen.append(ln);
        }
        return screen.toString();
    }
}