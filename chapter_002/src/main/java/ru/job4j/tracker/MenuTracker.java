package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    /**
     *@param хранит ссыдку на объект.
     */
    private  Input input;
    /**
     *@param хранит ссылку на объект.
     */
    private Tracker tracker;
    /**
     *@param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     *
     *@param input   объект типа Input

     */
    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    /**
     * Метод для получения массива меню.
     *
     * @return длину массива
     */
    public int getActionsLength() {
        return this.actions.size();
    }

    /**
     * Метод заполняет массив.
     */
    public void fillActions() {
        this.actions.add(new AddItem(0, "Add program"));
        this.actions.add(new ShowItems(1, "Show all items"));
        this.actions.add(new UpdateItem(2, "Edit item"));
        this.actions.add(new DeleteItem(3, "Delete item"));
        this.actions.add(new FindItemById(4, "Find item by Id"));
        this.actions.add(new FindItemByName(5, "Find item by Name"));
        this.actions.add(new ExitProgram(6, "Exit Program"));
    }

    /**
     * Метод в зависимости от указанного ключа, выполняет соответсвующие действия
     *
     * @param key ключ операции
     */
    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                System.out.println(action.info());
            }
        }
    }


     class AddItem  extends BaseAction {

        public AddItem(int key, String name) {
           super(key, name);
        }


        /**
         * Метод реализует добавление новой заявки в хранилище.
         */
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Adding new item ------------");
            String name = input.ask("Please, provide item name: ");
            String desc = input.ask("Please, provide item description: ");
            Item item = new Item(name, desc);
            tracker.add(item);
            System.out.println("------------ New Item with Id : " + item.getId());
            System.out.println("------------ New Item with Name : " + item.getName());
            System.out.println("------------ New Item with Description : " + item.getDescription());
        }
    }

    private class ShowItems extends BaseAction {

        public ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Find All item :");
            tracker.findAll();
            int numberItem = 1;
            for (Item item : tracker.findAll()) {
                System.out.println(" Заявка № " + numberItem++);
                System.out.println("Name : " + item.getName());
                System.out.println("Description : " + item.getDescription());
                System.out.println("Create : " + item.getCreate());
                System.out.println("Id : " + item.getId());
                System.out.println("________________________________________");
            }
        }
    }



    private class UpdateItem extends BaseAction {

        public UpdateItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Replace item ------------");
            String id = input.ask("Please, provide item id: ");
            String name = input.ask("Please, provide item name: ");
            String desc = input.ask("Please, provide item desciption: ");
            Item item = new Item(id, name, desc);
            if (tracker.replace(id, item)) {
                System.out.println("------------ Заявка после редактирования : ");
                System.out.println(item);
            } else {
                System.out.println("Item not found");
            }
        }
    }

    private class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Delete item ------------");
            String id = input.ask("Please, provide item id: ");
            String name = input.ask("Please, provide item name: ");
            String description = input.ask("Please, provide item desciption: ");
            Item item = new Item(id, name, description);
            System.out.println("------------ Удаляемая заявка : ");
            System.out.println(item);
            tracker.delete(id);
        }
    }

    private class FindItemById extends BaseAction {

        public FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Find item by id : ");
            String id = input.ask("Please, provide item id: ");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(item);
            } else {
                System.out.println("Item not found");
            }
        }
    }

    private class FindItemByName extends BaseAction {


        public FindItemByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Find item by name : ");
            String name = input.ask("Please, provide item name: ");
            for (Item item : tracker.findByName(name)) {
                if (item != null) {
                    System.out.println(item);
                }
            }
        }
    }

    private class ExitProgram extends BaseAction {

        public ExitProgram(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Good bay ------------");
        }
    }
}
