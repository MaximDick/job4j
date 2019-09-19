package ru.job4j.start;

import ru.job4j.tracker.*;

import java.util.function.Consumer;

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

    private final Consumer<String> output;

    /**
     * Конструктор инициализирующий поля.
     *@param input ввод данных.
     */
    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * Основной цикл программы.
     */

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker, this.output);
        menu.fillActions();
        int[] range = new int[menu.getActionsLength()];

        for (int i = 0; i < menu.getActionsLength(); i++) {
            range[i] = i;
        }
        do {
            menu.show();
            menu.select(input.ask("select:", range));
        } while (!"y".equals(this.input.ask("Exit?(y): ")));
    }

    /**
     * Запускт программы.
     * @param args array objects String.
     */
    public static void main(String[] args) {
        new StartUI(
                new ValidateInput(
                            new ConsoleInput()
                        ),
                        new Tracker(), System.out::println
        ).init();
    }
}