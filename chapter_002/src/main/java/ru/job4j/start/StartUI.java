package ru.job4j.start;

import ru.job4j.tracker.ConsoleInput;
import ru.job4j.tracker.Input;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class StartUI {
    /**
     * Константа меню для добавления новой заявки.
     */
     private static final String ADD = "0";

     /**
      * Констатнта для получения всех заявок.
      */
     private static final String FINDALL = "1";

    /**
     * Констатнта для редактирования заявки.
     */
     private static final String EDITITEM = "2";

    /**
     * Констатнта для удаления заявки.
     */
     private static final String DELETE = "3";

    /**
     * Констатнта для поиска заявок по Id.
     */
     private static final String FINDBYID = "4";

    /**
     * Констатнта для поиска заявок по Name.
     */
     private static final String FINDBYNAME = "5";

    /**
     * Констатнта для выхода из программы.
     */
     private static final String EXIT = "6";

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
     * @param input ввод данных.
     * @param tracker хранилище заявок.
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Основной цикл программы.
     */
    public void init() {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.ask("Введите пункт меню : ");
            if (ADD.equals(answer)) {
                //добавление вынесено в отдельный метод
                this.createItem();
            } else if (FINDALL.equals(answer)) {
                this.findAllItem();
            } else if (EDITITEM.equals(answer)) {
                this.replaceItem();
            } else if (DELETE.equals(answer)) {
                this.deleteItem();
            } else if (FINDBYID.equals(answer)) {
                this.findByIdItem();
            } else if (FINDBYNAME.equals(answer)) {
                this.findByNameItem();
            } else if (EXIT.equals(answer)) {

                System.out.println("Работа программы завершена");
                System.out.println("Good bay");
                break;
            }
        }
    }


    /**
     * Метод реализует добавление новой заявки в хранилище.
     */

    private void createItem() {
        System.out.println("------------ Добавление новой заявки");
        String name = this.input.ask("Введите имя заявки : ");
        String desc = this.input.ask("Введите описание заявки : ");

        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("------------ Новая заявка c getId : " + item.getId() + "---------");
    }

    /**
     * Метод печатает список всех заявок
     */
    private void findAllItem() {
        System.out.println("Список всех заявок :");
        this.tracker.findAll();
        for (Item item : this.tracker.findAll()) {
            System.out.println("Имя заявки : " + item.getName());
        }
    }

    /**
     * метод редактирует заявки
     */
    private void replaceItem() {
        System.out.println("------------ Редактирование заявки");
        String id = this.input.ask("Введите id : ");
        String name = this.input.ask("Введите name : ");
        String desc = this.input.ask("Введите описание : ");
        Item item = new Item(id, name, desc);
        if (this.tracker.replace(id, item)) {
            System.out.println("------------ Заявка после редактирования : " + item);
        } else {
            System.out.println("Item not found");
        }
    }

    /**
     * Удаление заявки по ID.
     */
    private void deleteItem() {
        System.out.println("------------ Удаление заявки");
        String id = this.input.ask("Введите id : ");
        String name = this.input.ask("Введите name : ");
        String desc = this.input.ask("Введите описание : ");
        Item item = new Item(id,name, desc);
        System.out.println("------------ Удаляемая заявка : " + item);
        this.tracker.delete(id);
    }

    /**
     * Поиск заявки по имени
     */
    private void findByNameItem() {
        System.out.println("------------ Поиск заявки по имени: ");
        String name = this.input.ask("Введите название заявки : ");
        for (Item item : this.tracker.findByName(name)) {
            if (item != null) {
                System.out.println(item);
            }
        }
    }

    /**
     * Поиск заявки по ID
     */
    private void findByIdItem() {
        System.out.println("------------ Поиск заявки по Id: ");
        String id = this.input.ask("Введите Id : ");
        Item item = tracker.findById(id);
        if (item != null){
            System.out.println(item);
            } else {
            System.out.println("Item not found");
        }
    }


    private void showMenu() {
        System.out.println("Меню. ");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.println("Select: ");

    }

    /**
     * Запускт программы.
     * @param args
     */
    public static void main(String[] args) {
        new StartUI(new ConsoleInput(), new Tracker()).init();
    }


}