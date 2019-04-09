package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public enum TrackerSingleOne {
    /**
     * Данный класс имеет вид enum, т.е. экземпляр класса будет создаваться напрямую обращаясь к
     * переменной enum.
     */

    INSTANCE; // здесь мы указываем перечисления.
    private Tracker tracker = new Tracker();

    /**
     * Добавление записи в тракер.
     * В методе мы через готовый класс тракер создаем запись.
     *
     * @param item - получаем запись.
     * @return - готовую запись.
     */
    public Item add(Item item) {
       return this.tracker.add(item);
    }

    public static void main(String[] args) {
        TrackerSingleOne tracker = TrackerSingleOne.INSTANCE;
    }
}