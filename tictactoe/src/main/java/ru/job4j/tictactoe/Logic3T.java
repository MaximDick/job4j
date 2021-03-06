package ru.job4j.tictactoe;

import java.util.Arrays;
import java.util.function.Predicate;

public class Logic3T {
    private final Figure3T[][] table;

    public Logic3T(Figure3T[][] table) {
        this.table = table;
    }

    public boolean fillBy(Predicate<Figure3T> predicate, int startX, int startY, int deltaX, int deltaY) {
        boolean result = true;
        for (int index = 0; index != this.table.length; index++) {
            Figure3T cell = this.table[startX][startY];
            startX += deltaX;
            startY += deltaY;
            if (!predicate.test(cell)) {
                result = false;
                break;
            }
        }
        return result;
    }
    /**проверяет есть ли в поле выигрышные комбинации для Крестика.*/
    public boolean isWinnerX() {
        return /*this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 0)
                || this.fillBy(Figure3T::hasMarkX, 0, 1, 1, 0)
                || this.fillBy(Figure3T::hasMarkX, 0, 2, 1, 0)
                || this.fillBy(Figure3T::hasMarkX, 0, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkX, 1, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkX, 2, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkX, 0, 0, 1, 1)
                || this.fillBy(Figure3T::hasMarkX, this.table.length - 1, 0, -1, 1);*/
        isWin(Figure3T::hasMarkX);

    }

    /**проверяет есть ли в поле выигрышные комбинации для Нолика.*/
    public boolean isWinnerO() {
        return /*this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 0)
                || this.fillBy(Figure3T::hasMarkO, 0, 1, 1, 0)
                || this.fillBy(Figure3T::hasMarkO, 0, 2, 1, 0)
                || this.fillBy(Figure3T::hasMarkO, 0, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkO, 1, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkO, 2, 0, 0, 1)
                || this.fillBy(Figure3T::hasMarkO, 0, 0, 1, 1)
                || this.fillBy(Figure3T::hasMarkO, this.table.length - 1, 0, -1, 1);*/
        isWin(Figure3T::hasMarkO);
    }

    public boolean isWin(Predicate<Figure3T> pr) {
        return this.fillBy(pr, 0, 0, 1, 0)
                || this.fillBy(pr, 0, 0, 0, 1)
                || this.fillBy(pr, 0, 0, 1, 1)
                || this.fillBy(pr, this.table.length - 1, 0, -1, 1)
                || this.fillBy(pr, 0, 2, 1, 0)
                || this.fillBy(pr, 0, 1, 1, 0)
                || this.fillBy(pr, 1, 0, 0, 1)
                || this.fillBy(pr, 2, 0, 0, 1);
    }
    /**
     * проверяет, если ли пустые клетки для новых ходов.*/
    public boolean hasGap() {
        /*boolean result = false;
        for (int indexOut = 0; indexOut < this.table.length; indexOut++) {
            for (int indexIn = 0; indexIn < this.table.length; indexIn++) {
                Figure3T cell = this.table[indexOut][indexIn];
                if (!cell.hasMarkX() && !cell.hasMarkO()) {
                    result = true;
                }
            }
        }
        return result;*/

        return Arrays.stream(table)
                .flatMap(Arrays::stream)
                .anyMatch(figure -> !figure.hasMarkX() && !figure.hasMarkO());
    }
}
