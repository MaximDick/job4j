package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

import static ru.job4j.start.StartUI.*;

public class MenuTracker {
    /**
     * @param хранит ссыдку на объект.
     */
    private  Input input;
    /**
     * @param хранит ссылку на объект.
     */
    private Tracker tracker;
    /**
     * @param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     *
     * @param input   объект типа Input
     * @param tracker объект типа Tracker
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


    private class AddItem  implements UserAction {
        @Override
        public int key() {
            return ADD;
        }

        /**
         * Метод реализует добавление новой заявки в хранилище.
         */
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Adding new item ------------");
            String name = this.input.ask("Please, provide item name: ");
            String desc = this.input.ask("Please, provide item desciption: ");
            Item item = new Item(name, desc);
            this.tracker.add(item);
            System.out.println("------------ New Item with Id : " + item.getId());
            System.out.println("------------ New Item with Name : " + item.getName());
            System.out.println("------------ New Item with Description : " + item.getDescription());
        }


        @Override
        public String info() {
            return "Add new Item.";
        }

    }

    private class ShowItems implements UserAction {
        @Override
        public int key() {
            return FINDALL;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("Find All item :");
            this.tracker.findAll();
            int numberItem = 1;
            for (Item item : this.tracker.findAll()) {
                System.out.println(" Заявка № " + numberItem++);
                System.out.println("Name : " + item.getName());
                System.out.println("Description : " + item.getDescription());
                System.out.println("Create : " + item.getCreate());
                System.out.println("Id : " + item.getId());
                System.out.println("________________________________________");
            }
        }

        @Override
        public String info() {
            return "Show all items";
        }
    }


    private class UpdateItem implements UserAction {

        @Override
        public int key() {
            return EDITITEM;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Replace item ------------");
            String id = this.input.ask("Please, provide item id: ");
            String name = this.input.ask("Please, provide item name: ");
            String desc = this.input.ask("Please, provide item desciption: ");
            Item item = new Item(id, name, desc);
            if (this.tracker.replace(id, item)) {
                System.out.println("------------ Заявка после редактирования : " + item);
            } else {
                System.out.println("Item not found");
            }

        }

        @Override
        public String info() {
            return "Edit item";
        }
    }

    private class DeleteItem implements UserAction {
        @Override
        public int key() {
            return DELETE;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Delete item ------------");
            String id = this.input.ask("Please, provide item id: ");
            String name = this.input.ask("Please, provide item name: ");
            String desc = this.input.ask("Please, provide item desciption: ");
            Item item = new Item(id, name, desc);
            System.out.println("------------ Удаляемая заявка : " + item);
            this.tracker.delete(id);
        }

        @Override
        public String info() {
            return "Delete item";
        }
    }

    private class FindItemById implements UserAction {
        @Override
        public int key() {
            return FINDBYID;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Find item by id : ");
            String id = this.input.ask("Please, provide item id: ");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(item);
            } else {
                System.out.println("Item not found");
            }
        }

        @Override
        public String info() {
            return "Find item by Id";
        }
    }

    private class FindItemByName implements UserAction {
        @Override
        public int key() {
            return FINDBYNAME;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Find item by name : ");
            String name = this.input.ask("Please, provide item name: ");
            for (Item item : this.tracker.findByName(name)) {
                if (item != null) {
                    System.out.println(item);
                }
            }
        }

        @Override
        public String info() {
            return "Find item by Name";
        }
    }

    private class ExitProgram implements UserAction {
        @Override
        public int key() {
            return EXIT;
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("------------ Good bay ------------");
        }

        @Override
        public String info() {
            return "Exit Program";
        }
    }

}
