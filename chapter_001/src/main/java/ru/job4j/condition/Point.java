package ru.job4j.condition;

/**
 * В этой задаче мы создадим класс Point, который описывает точку в системе координат.
 * Также мы научим наш новый тип данных взаимодействовать с самим собой.
 * Мы научим его считать расстояние до другой точки в системе координат.
 *
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public double distanceTo(Point that) {
        // Точка А - это текущая точка. К ней мы обращаемся через оператор this.
        Point a = this;
        // Точка В - это входящая точка. К ней мы можем обратиться напрямую через имя переменной that.
        // или для удобства мы создали новую переменную b и к ней присвоили переменную that.
        Point b = that;

        int x1 = a.x;
        int y1 = a.y;
        int x2 = b.x;
        int y2 = b.y;

        double result = Math.sqrt(
                Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
        );
        return result;
    }

    public static void main(String[] args) {
        Point a = new Point(7, 9);
        Point b = new Point(4, 5);
        // сделаем вызов метода
        System.out.println("Координаты точки A:");
        System.out.println("x1 = " + a.x + "\ty1 = " + b.x);
        System.out.println("Координаты точки B:");
        System.out.println("x2 = " + a.y + "\ty2 = " + b.y);
        //System.out.println();
        double result = a.distanceTo(b);
        System.out.println("Расстояние между точками А и В : " + result);
    }

}
