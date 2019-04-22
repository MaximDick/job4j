package ru.job4j.chess.exceptions;

public class FigureNonFoundException extends RuntimeException {
    /**
     * Конструктор с сообщением пользователю.
     *
     * @param msg - сообщение.
     */

    public FigureNonFoundException(String msg) {
        super(msg);
    }
}