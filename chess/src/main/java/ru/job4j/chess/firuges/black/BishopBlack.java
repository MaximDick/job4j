package ru.job4j.chess.firuges.black;

import ru.job4j.chess.exceptions.ImpossibleMoveException;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    private boolean isDiagonal(Cell source, Cell dest) {
        return (Math.abs(source.y - dest.y) == Math.abs(source.x - dest.x));
    }
    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        int dX = (source.x - dest.x) < 0 ? -1 : 1;
        int dY = (source.y - dest.y) < 0 ? -1 : 1;
        int length = Math.abs(source.x - dest.x) + 1;
        Cell[] steps;
        if (isDiagonal(source, dest)) {
            steps = new Cell[length];
            for (int i = 0; i < length; i++) {
                steps[i] = Cell.values()[(source.x - i * dX) * 8 + (source.y - i * dY)];
            }
        } else {
            throw new ImpossibleMoveException("Wrong way");
        }
        return steps;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
