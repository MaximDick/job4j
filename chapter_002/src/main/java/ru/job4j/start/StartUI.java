package ru.job4j.start;

import ru.job4j.tracker.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class StartUI {

    /**
     * Получение данных от пользователя.
     */
    private final Input input;

    /**
     * Хранилище заявок.
     */
    private final Tracker tracker;

    /**
     * Конструктор инициализирующий поля.
     *@param input ввод данных.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основной цикл программы.
     */

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        menu.fillActions();
        int [] range = new int [menu.getActionsLength()];

        for (int i = 0; i < menu.getActionsLength(); i++) {
            System.out.println(range[i]);
        }
        do {
            menu.show();
            menu.select(input.ask("select:", range));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        Input input = new ValidateInput();
        new StartUI(input, new Tracker()).init();
    }
}