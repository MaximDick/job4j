package ru.job4j.chess;

import ru.job4j.chess.exceptions.FigureNonFoundException;
import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.exceptions.OccupiedWayException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Logic {
    private final Figure[] figures = new Figure[32];
    private int index = 0;

    public void add(Figure figure) {
        this.figures[this.index++] = figure;
    }

    /**
     * Пробегаемся в цикле по массиву ячеек и по массифу фигур.
     * Если значения ячейки куда будет сделан ход совпадает с одним
     * из значений массива фигур, то выбрасывается исключение о занятости ячейки,
     * иначе делается ход.
     *
     * @param source - откуда делается ход.
     * @param dest   - куда делается ход.
     * @return - возвращаем булево значение разрешается ли сделать ход или нет.
     * @throws ImpossibleMoveException - ошибка, если невозможно пойти.
     * @throws OccupiedWayException    - ошибака, если клетка занята.
     * @throws FigureNonFoundException - ошибка, если фигура не найдена.
     */

    public boolean move(Cell source, Cell dest) throws ImpossibleMoveException, OccupiedWayException, FigureNonFoundException {
        boolean rst = false;
        int index = this.findBy(source);
        if (index != -1) {
            if (!occupiedWay(source, dest)) {
                rst = true;
                this.figures[index] = this.figures[index].copy(dest);
            } else {
                throw new OccupiedWayException("Way is occupied");
            }
        }
        return rst;
    }


    public void clean() {
        for (int position = 0; position != this.figures.length; position++) {
            this.figures[position] = null;
        }
        this.index = 0;
    }

    private int findBy(Cell cell) {
        int rst = -1;
        for (int index = 0; index != this.figures.length; index++) {
            if (this.figures[index] != null && this.figures[index].position().equals(cell)) {
                rst = index;
                break;
            }
        }
        return rst;
    }

    private boolean occupiedWay(Cell source, Cell dest) {
        boolean rst = false;
        int index = this.findBy(source);
        if (index != -1) {
            Cell[] steps = this.figures[index].way(source, dest);
            if (steps.length > 0 && steps[steps.length - 1].equals(dest)) {
                rst = true;
                for (int i = 1; i < steps.length; i++) {
                    if (findBy(steps[i]) != -1) {
                        rst = false;
                        break;
                    }
                }
            }
        }
        return !rst;
    }
}