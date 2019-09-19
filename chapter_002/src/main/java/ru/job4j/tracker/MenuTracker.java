package ru.job4j.tracker;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class MenuTracker {
    /**
     *@param хранит ссыдку на объект.
     */
    private  Input input;
    /**
     *@param хранит ссылку на объект.
     */
    private Tracker tracker;

    private Consumer<String> output;
    /**
     *@param хранит ссылку на массив типа UserAction.
     */
    private List<UserAction> actions = new ArrayList<>();

    /**
     * Конструктор.
     *
     *@param input   объект типа Input

     */
    public MenuTracker(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
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
        this.actions.get(key).execute(this.input, this.tracker, this.output);
    }

    /**
     * Метод выводит на экран меню.
     */
    public void show() {
        for (UserAction action : this.actions) {
            if (action != null) {
                output.accept(action.info());
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
        public void execute(Input input, Tracker tracker, Consumer<String> output) {
            output.accept("------------ Adding new item ------------");
            String name = input.ask("Please, provide item name: ");
            String desc = input.ask("Please, provide item description: ");
            Item item = new Item(name, desc);
            tracker.add(item);
            output.accept("------------ New Item with Id : %s| " + item.getId());
            output.accept("------------ New Item with Name : " + item.getName());
            output.accept("------------ New Item with Description : " + item.getDescription());
        }
    }

    private class ShowItems extends BaseAction {

        public ShowItems(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker, Consumer<String> output) {
            output.accept("Find All item :");
            tracker.findAll();
            int numberItem = 1;
            /*for (Item item : tracker.findAll()) {
                System.out.println(" Заявка № " + numberItem++);
                System.out.println("Name : " + item.getName());
                System.out.println("Description : " + item.getDescription());
                System.out.println("Create : " + item.getCreate());
                System.out.println("Id : " + item.getId());
                System.out.println("________________________________________");
            }*/
            for (Item item: tracker.findAll()) {
                output.accept(String.format("Name: %s| Description: %s| Create %s| id: %s",
                        item.getName(), item.getDescription(), item.getCreate(), item.getId()));
            }
        }
    }



    private class UpdateItem extends BaseAction {

        public UpdateItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker, Consumer<String> output) {
            output.accept("------------ Replace item ------------");
            String id = input.ask("Please, provide item id: ");
            String name = input.ask("Please, provide item name: ");
            String desc = input.ask("Please, provide item desciption: ");
            Item item = new Item(id, name, desc);
            if (tracker.replace(id, item)) {
                output.accept(String.format("------------ Заявка после редактирования : $s", item));
            } else {
                output.accept("Item not found");
            }
        }
    }

    private class DeleteItem extends BaseAction {

        public DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker, Consumer<String> output) {
            output.accept("------------ Delete item ------------");
            String id = input.ask("Please, provide item id: ");
            String name = input.ask("Please, provide item name: ");
            String description = input.ask("Please, provide item desciption: ");
            Item item = new Item(id, name, description);
            output.accept(String.format("------------ Удаляемая заявка : %s", item));
            tracker.delete(id);
        }
    }

    private class FindItemById extends BaseAction {

        public FindItemById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker, Consumer<String> output) {
            output.accept("------------ Find item by id : ");
            String id = input.ask("Please, provide item id: ");
            Item item = tracker.findById(id);
            if (item != null) {
                output.accept(String.format("Item: %s", item));
            } else {
                output.accept("Item not found");
            }
        }
    }

    private class FindItemByName extends BaseAction {


        public FindItemByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker, Consumer<String> output) {
            output.accept("------------ Find item by name : ");
            String name = input.ask("Please, provide item name: ");
            for (Item item : tracker.findByName(name)) {
                if (item != null) {
                    output.accept(String.format("Item: $s", item ));
                }
            }
        }
    }

    private class ExitProgram extends BaseAction {

        public ExitProgram(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker, Consumer<String> output) {
            output.accept("------------ Good bay ------------");
        }
    }
}
