package ru.job4j.tracker;

import java.util.function.Consumer;
/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public interface UserAction {

    /**
     * Метод возвращает ключ опции.
     * @return key ключ
     */
    int key();

    /**
     * Основной метод.
     * @param input объект типа Input
     * @param tracker объект типа Tracker
     */
    void execute(Input input, Tracker tracker, Consumer<String> output);

    /**
     *Метод возвращает информацию о данном пункте меню.
     * @return Строка меню
     */
    String info();
}