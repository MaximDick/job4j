package ru.job4j.condition;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Triangle {
    private Point a;
    private Point b;
    private Point c;

    public Triangle(Point a, Point b, Point c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    /**
     * Метод вычисления полупериметра по длине сторон.
     *
     * Формула.
     *
     * (ab +ac +bc) / 2
     *
     * @param ab расстояние a b.
     * @param ac расстояние a c.
     * @param bc расстояние b c.
     * @return Периметр.
     */

    public double period(double ab, double ac, double bc){
    return (ab + ac + bc) / 2;
    }

    /**
     * Метод должен вычислять прощадь треугольника.
     *
     * @return Веруть площадь, если треугольник существует или -1,
     * если треугольника нет.
     */

     public  double area(){

         double rsl = -1; //мы устанавливаем значение -1, так как может быть что треугольника нет.
         // Это значение говорит о том. что треугольника нет.

         double ab = this.a.distanceTo(b);
         double ac = this.a.distanceTo(c);
         double bc = this.b.distanceTo(c);
         double p = this.period(ab, ac, bc);
         if(this.exist(ab, ac, bc)){
             rsl = Math.sqrt(p * (p - ab) * (p - ac) * (p - bc));
         }
         return rsl;
     }

    /**
     * Метод проверяет можно ли построить треугольник с такими длинами сторон.
     *
     *
     * @param ab Длина от точки a b.
     * @param ac Длина от точки a c.
     * @param bc Длина от точки b c.
     * @return если сумма двух сторон больше третьей, then true, else -> false.
     */

     private boolean exist(double ab, double ac, double bc){
         if (ab + ac > bc && ab + bc > ac && ac + bc > ab){
             return true;
         }
          else
             return false;
     }
}