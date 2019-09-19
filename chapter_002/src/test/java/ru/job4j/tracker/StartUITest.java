package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.start.StartUI;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class StartUITest {

    private final PrintStream out = System.out;
    private final ByteArrayOutputStream bas = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(bas);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };


    @Before
    public void loadOutput() {
        System.out.println("execute before method");
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.out);
        System.out.println("execute after method");
    }

    /**
     * Добавление заявки*/
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        Input input = new StubInput(new String[]{"0", "test name", "desc", "y"}); // создаем StubInput с последовательностью действий
        new StartUI(input, tracker, output).init();   // создаем StartUI и вызываем метод init()
        assertThat(tracker.findAll().get(0).getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введенное при эмуляции.
    }

    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("test name", "desc"));
        //создаём StubInput с последовательностью действий(производим замену заявки)
        Input input = new StubInput(new String[]{"2", item.getId(), "test replace", "заменили заявку", "y"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker, output).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test replace"));
    }

    @Test
    public void whenDeleteThen() {
        Tracker tracker = new Tracker();
        //создаем первую заявку
        Item item = tracker.add(new Item("test nameOne", "descOne"));
        Input input = new StubInput(new String[]{"3", item.getId(), "test nameOne", "descOne", "No", "0", "test name", "desc", "y"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findAll().get(0).getName(), is("test name"));
    }

    /**
     * Find All Items*/
    @Test
    public void whenAddThreeItemTrackerHasNewItemsThenFindAllItems() {
        loadOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Leo Messi", "Barcelona", 10));
        Item item2 = tracker.add(new Item("Luis Suarez", "Barcelona", 9));
        Item item3 = tracker.add(new Item("Ivan Rakitic", "Barcelona", 4));
        new StartUI(new StubInput(new String[]{"1", "y"}), tracker, output).init();
        /*assertThat(
                this.output.toString(),
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                            .add("execute before method")
                            .add(forStartUITest())
                            .add("Find All item :")
                            .add(" Заявка № 1")
                            .add("Name : " + item1.getName())
                            .add("Description : " + item1.getDescription())
                            .add("Create : " + item1.getCreate())
                            .add("Id : " + item1.getId())
                            .add("________________________________________")
                            .add(" Заявка № 2")
                            .add("Name : " + item2.getName())
                            .add("Description : " + item2.getDescription())
                            .add("Create : " + item2.getCreate())
                            .add("Id : " + item2.getId())
                            .add("________________________________________")
                            .add(" Заявка № 3")
                            .add("Name : " + item3.getName())
                            .add("Description : " + item3.getDescription())
                            .add("Create : " + item3.getCreate())
                            .add("Id : " + item3.getId())
                            .add("________________________________________")
                            .toString()
                )
        );
        assertThat(this.output.toString(), is(expect));*/
        assertThat(tracker.findAll().get(0).getName(), is("Leo Messi"));
        assertThat(tracker.findAll().get(1).getName(), is("Luis Suarez"));
        assertThat(tracker.findAll().get(2).getName(), is("Ivan Rakitic"));
        backOutput();
    }

    /**
     * FindById
     */
    @Test
    public void whenAddThreeItemTrackerHasNewItemsThenFindById() {
        loadOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Leo Messi", "Barcelona"));
        Item item2 = tracker.add(new Item("Luis Suarez", "Barcelona"));
        Input input = new StubInput(new String[]{"4", item1.getId(), "y"});
        new StartUI(input, tracker, output).init();
        /*assertThat(
                this.output.toString(),
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                            .add("execute before method")
                            .add(forStartUITest())
                            .add("------------ Find item by id : ")
                            .add("Name : " + item1.getName())
                            .add("Description : " + item1.getDescription())
                            .add("Id : " + item1.getId())
                            .toString()
                )
        );*/
        assertThat(tracker.findById(item2.getId()).getName(), is("Luis Suarez"));
        backOutput();
    }

    /**
     * FindByName
     */
    @Test
    public void whenAddTwoItemTrackerHasNewItemsThenFindByName() {
        loadOutput();
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Leo Messi", "Barcelona"));
        Item item2 = tracker.add(new Item("Luis Suarez", "Barcelona"));
        Input input = new StubInput(new String[]{"5", item2.getName(), "y"});
        new StartUI(input, tracker, output).init();
        /*assertThat(
                this.out.toString(),
                is(
                        new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                                .add("execute before method")
                                .add(forStartUITest())
                                .add("------------ Find item by name : ")
                                .add("Name : " + item2.getName())
                                .add("Description : " + item2.getDescription())
                                .add("Id : " + item2.getId())
                                .toString()
                )
        );*/
        assertThat(tracker.findByName("Leo Messi").get(0).getDescription(), is("Barcelona"));
        backOutput();
    }
}