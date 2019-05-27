package ru.job4j.tracker;

import java.util.*;

/**
 * @author Maxim Dick (maxim1994barca@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Tracker {
    /***
     * Массив для хранения заявок.
     */
    //private Item[] items = new Item[100];
    private List<Item> items = new ArrayList<>();

    /**
     * Указатель ячейки для новой заявки.
     */
    private int position = 0;

    private static final Random RN = new Random();

    /**
     * Метод реализующий добавление заявки в хранилище
     *
     * @param item новая заявка
     */
    public Item add(Item item) {
        /*item.setId(this.generateId());
        this.items[this.position++] = item;*/
        this.items.add(item);
        return item;
    }


    /**
     * Метод генерирует уникальный ключ для заявки.
     * Так как у заявки нет уникальности полей, имени и описания.
     *
     * @return Уникальный ключ.
     */
    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }

    /**
     * Метод для редактирования заявок.
     * @param id идентификационный номер.
     * @param item заявка.
     * @return result
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int index = 0; index != items.size(); index++) {
            if (items.get(index).getId().equals(id)) {
                items.set(index, item);
                result = true;
                break;
            }
        }
        return result;
    }



    /**
     * Метод для удаления заявок
     * @param id
     * @return result
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int index = 0; index != items.size(); index++) {
            if (items.get(index).getId().equals(id)) {
                items.remove(index);
                result = true;
                break;
                }
            }
        return result;
    }

    /**
     * Метод для получения списка всех заявок.
     * @return result
     */
    public List<Item> findAll() {
        return items;
    }


    /**
     * Метод для получения заявки по имени.
     * @param key название передаваемое в качестве параметра для сравнения.
     * @return result
     */
    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item i : items) {
            if (i.getName().equals(key)) {
                result.add(i);
            }
        }
        return result;
    }

    /**
     * Метод для получения заявки по id.
     * @param id идентификационный номер передаваемый в качестве параметра.
     * @return result
     */
    public Item findById(String id) {
        Item result = null;
        for (Item i : items) {
            if (i.getId().equals(id)) {
                result = i;
                break;
            }
        }
        return result;
    }
}