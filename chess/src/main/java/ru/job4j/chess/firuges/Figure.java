package ru.job4j.chess.firuges;

import ru.job4j.chess.exceptions.ImpossibleMoveException;
/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public interface Figure {
    /**
     * возвращает текущую клетку, которую занимает.
     */
    Cell position();

    /**
     * метод, проверяющий движение по шахматной доске.
     * Если фигура не может пойти в назначенную ячейку(dest),
     * то метод должен выбросить Exception.
     *
     * @param source - начальная ячейка.
     * @param dest - назначенная ячейка.
     * @return - массив ячеек, которые прошла фигура.
     * @throws ImpossibleMoveException - выбрасывается в случае, когда фигура не может
     * ходить по правилам игры.
     */
    Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException;

    /**
     * используем загрузку изображений
     */
    default String icon() {
        return String.format(
                "%s.png", this.getClass().getSimpleName()
        );

    }
    /**
     * метод выполняет перезапись положение фигуры на шахматной доске
     * при выполнении всех условий программы.*/
    Figure copy(Cell dest);

}
