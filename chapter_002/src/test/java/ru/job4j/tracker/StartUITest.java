package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.start.StartUI;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class StartUITest {
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String []{"0", "test name", "desc", "6"}); // создаем StubInput с последовательностью действий
        new StartUI(input, tracker).init();   // создаем StartUI и вызываем метод init()
        assertThat(tracker.findAll()[0].getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введенное при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "6"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteThen() {
        Tracker tracker = new Tracker();
        //создаем первую заявку
        Item item = tracker.add(new Item("test nameOne", "descOne"));
        Input input = new StubInput(new String[]{"3", item.getId(), "test nameOne", "descOne", "0", "test name", "desc", "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenFindID() {
        Tracker tracker = new Tracker();
        //создаем первую заявку
        Item item = tracker.add(new Item("test nameOne", "descOne"));
        Input input = new StubInput(new String[]{"0", "test nameTwo", "descTwo", "4", item.getId(), "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[1].getName(), is("test nameTwo"));
    }

    @Test
    public void whenFindName() {
        Tracker tracker = new Tracker();
        //создаем первую заявку
        Item item = tracker.add(new Item("test nameOne", "descOne"));
        Input input = new StubInput(new String[]{"0", "test nameTwo", "descTwo", "5", item.getName(),  "6"});
        new StartUI(input, tracker).init();
        assertThat(tracker.findAll()[0].getName(), is("test nameOne"));
    }
}