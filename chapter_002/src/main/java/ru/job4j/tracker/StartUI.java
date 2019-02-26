package ru.job4j.tracker;

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
            } else if (EXIT.equals(answer)){

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

    private void findAllItem() {
        System.out.println("Список всех заявок ");
        this.tracker.findAll();
        for (Item item : this.tracker.findAll()) {
            System.out.println(item.getName());
        }
    }

    private void replaceItem() {
        System.out.println("------------ Редактирование заявки");
        String id = this.input.ask("Введите id : ");
        Item item = new Item();
        this.tracker.replace(id, item);
        String name = this.input.ask("Введите name : ");
        item.setName(name);
        System.out.println("------------ Заявка после редактирования : " + item.getId() + " --------- " + item.getName());
    }

    private void deleteItem() {
        System.out.println("------------ Удаление заявки");
        String id = this.input.ask("Введите id : ");
        this.tracker.delete(id);

    }

    private void findByNameItem() {
        System.out.println("------------ Поиск заявки по имени: ");
        String name = this.input.ask("Введите название заявки : ");
        for (Item item : this.tracker.findByName(name)) {
            if (item != null) {
                System.out.println("------------ Найденная заявка : " + item.getName() + " ---------");
            }
        }
    }


    private void findByIdItem() {
        System.out.println("------------ Поиск заявки по Id: ");
        String id = this.input.ask("Введите Id : ");
        System.out.println("------------ Найденная заявка : " + this.tracker.findById(id).getName() + "---------");
        System.out.println("------------ ID : " + this.tracker.findById(id).getId() + "---------");
        System.out.println("------------ Описание : " + this.tracker.findById(id).getDescription() + "---------");
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