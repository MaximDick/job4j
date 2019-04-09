package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class TrackerSingleTwo {

    private static TrackerSingleTwo instance;
    private TrackerSingleTwo() {
    }

    /**
     * Метод getInstance() - при вызове метода,
     * проверяет статическое поле instance, если поле
     * не загружено, оно инициализирует его новосозданном
     * объектом.*/
    public static TrackerSingleTwo getInstance() {
        if (instance == null) {
            instance = new TrackerSingleTwo();
        }
        return instance;
    }

    public Item add(Item item) {
        return item;
    }

    public static void main(String[] args) {
        TrackerSingleTwo tracker = TrackerSingleTwo.getInstance();
    }
}